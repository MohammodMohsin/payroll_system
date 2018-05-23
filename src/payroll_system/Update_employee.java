package payroll_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update_employee extends JFrame implements ActionListener {
    
    JPanel panel = new JPanel();
    JLabel lblid = new JLabel("Employee ID :");
    JTextField txtid = new JTextField(25);
    JButton btnsearch = new JButton("Search");
    JLabel lbl_id = new JLabel("Employee id :");
    JTextField txtid1 = new JTextField(25);
    JLabel lblf_name = new JLabel("First  Name :");
    JTextField txtf_name = new JTextField(25);
    JLabel lbll_name = new JLabel("Last  Name :");
    JTextField txtl_name = new JTextField(25);
    JLabel lbl_gender = new JLabel("Gender :");
    JTextField txt_gender = new JTextField(25);
    JLabel lbleml = new JLabel("Email :");
    JTextField txteml = new JTextField(30);
    JLabel lblcont = new JLabel("Contact :");
    JTextField txtcont = new JTextField(25);
    JLabel lbldate = new JLabel("Date of join :");
    JTextField txt_crdate =new JTextField(30);
    JLabel lbldejg = new JLabel("Designation :");
    String[] position = {"", "Manager", "Project Manager", "Developer", "Reception", "Clerk", "Gaurd"};
    JComboBox comb = new JComboBox(position);
    JLabel lbl_salary = new JLabel("Salary :");
    JLabel lbl_slr = new JLabel("........");
    JButton btnaddemp = new JButton("Update");
    JButton btnrest = new JButton("Reset");
    Connection con=null;
    Statement st;
    ResultSet rs;
    
    Update_employee() {
        super("Update Employee");
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        add(panel);
        addcomp();
        con=DB.getConnection();
    }
    
    private void addcomp() {
        lblid.setBounds(30, 30, 120, 30);
        panel.add(lblid);
        lblid.setFont(lblid.getFont().deriveFont(15f));
        
        txtid.setBounds(140, 30, 160, 30);
        panel.add(txtid);
        
        btnsearch.setBounds(350, 30, 100, 30);
        panel.add(btnsearch);
        btnsearch.addActionListener(this);
        btnsearch.setFont(btnsearch.getFont().deriveFont(15f));
        
        lbl_id.setBounds(40, 90, 120, 35);
        panel.add(lbl_id);
        lbl_id.setFont(lbl_id.getFont().deriveFont(15f));
        
        txtid1.setBounds(150, 90, 190, 35);
        panel.add(txtid1);
        
        lblf_name.setBounds(40, 140, 130, 35);
        panel.add(lblf_name);
        lblf_name.setFont(lblf_name.getFont().deriveFont(15f));
        
        txtf_name.setBounds(150, 140, 190, 35);
        panel.add(txtf_name);
        
        lbll_name.setBounds(40, 190, 120, 35);
        panel.add(lbll_name);
        lbll_name.setFont(lbll_name.getFont().deriveFont(15f));
        
        txtl_name.setBounds(150, 190, 190, 35);
        panel.add(txtl_name);
        
        lbl_gender.setBounds(63, 240, 130, 35);
        panel.add(lbl_gender);
        lbl_gender.setFont(lbl_gender.getFont().deriveFont(15f));
        
        txt_gender.setBounds(150, 240, 190, 35);
        panel.add(txt_gender);
        
        lbleml.setBounds(77, 290, 130, 35);
        panel.add(lbleml);
        lbleml.setFont(lbleml.getFont().deriveFont(15f));
        
        txteml.setBounds(150, 290, 190, 35);
        panel.add(txteml);
        
        lblcont.setBounds(60, 340, 130, 35);
        panel.add(lblcont);
        lblcont.setFont(lblcont.getFont().deriveFont(15f));
        
        txtcont.setBounds(150, 340, 190, 35);
        panel.add(txtcont);
        

        lbldate.setBounds(35, 390, 130, 35);
        txt_crdate.setBounds(150, 390, 190, 35);
        panel.add(lbldate);
        lbldate.setFont(lbldate.getFont().deriveFont(15f));
        panel.add(txt_crdate);
        txt_crdate.setFont(txt_crdate.getFont().deriveFont(15f));
        
        lbldejg.setBounds(30, 430, 120, 35);
        panel.add(lbldejg);
        lbldejg.setFont(lbldejg.getFont().deriveFont(15f));
        
        comb.setBounds(150, 430, 160, 35);
        comb.addActionListener(this);
        panel.add(comb);
        
        lbl_salary.setBounds(340, 430, 140, 35);
        panel.add(lbl_salary);
        lbl_salary.setFont(lbl_salary.getFont().deriveFont(15f));
        
        lbl_slr.setBounds(400, 430, 100, 35);
        panel.add(lbl_slr);
        lbl_slr.setFont(lbl_slr.getFont().deriveFont(15f));        
        btnaddemp.setBounds(340, 480, 140, 35);
        panel.add(btnaddemp);
        btnaddemp.addActionListener(this);
        btnaddemp.setFont(btnaddemp.getFont().deriveFont(15f));
        
        btnrest.setBounds(50, 480, 100, 35);
        panel.add(btnrest);
        btnrest.addActionListener(this);
        btnrest.setFont(btnrest.getFont().deriveFont(15f));
        
    }
    
    public static void main(String[] args) {
        new Update_employee();
    }
    
    public void actionPerformed(ActionEvent einfo) {
         String cmb_slr= (String) comb.getSelectedItem();
            try{
                String query="select * from designation where position=?";
                PreparedStatement   pst = con.prepareStatement(query);
                    pst.setString(1, cmb_slr);
                    rs=pst.executeQuery();
                    while(rs.next()){
                       String slr=rs.getString("salary");
                       lbl_slr.setText(slr);
                    }
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
           
        if (einfo.getSource() == btnsearch){
         String semp_id = txtid.getText();
            try{
                String query="select * from employee where empid=?";
                PreparedStatement   pst = con.prepareStatement(query);
                    pst.setString(1, semp_id);
                    rs=pst.executeQuery();
                    while(rs.next()){
                       txtid1.setText(rs.getString("empid"));
                       txtf_name.setText(rs.getString("first_name"));
                       txtl_name.setText(rs.getString("last_name"));
                       txt_gender.setText(rs.getString("Gender"));
                       txteml.setText(rs.getString("Email"));
                       txtcont.setText(rs.getString("Contact"));
                       txt_crdate.setText(rs.getString("join_date"));
                       lbl_slr.setText(rs.getString("salary"));
                      
                    }
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        }
        if (einfo.getSource() == btnaddemp) {

            try {

                String s_id = txtid.getText().toString();
                String first_name = txtf_name.getText();
                String last_name = txtl_name.getText();
                String gender = txt_gender.getText();
                String email= txteml.getText();
                String contact = txtcont.getText();
                String joine_date= txt_crdate.getText();
                String designation =(String) comb.getSelectedItem();
                String salary = lbl_slr.getText().toString();
                double slrd = Double.parseDouble(salary);
                int i = Updempdao.update(s_id,first_name,last_name,gender,email,contact,joine_date,designation,slrd);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully Updated!!!");
                } else {
                    System.out.println(einfo.toString());
                }

            } catch (Exception ee) {

                 System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if (einfo.getSource() == btnrest){
            txtid.setText(null);
            txt_gender.setText(null);
            txtid1.setText(null);
            txt_crdate.setText(null);
            txtf_name.setText(null);
            txtcont.setText(null);
            txteml.setText(null);
            txtl_name.setText(null);
            lbl_slr.setText(null);
           // buttonfe.setSelected(false);
            //buttonma.setSelected(false);            
        }

    }
    
}
