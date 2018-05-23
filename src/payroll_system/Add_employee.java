package payroll_system;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;

public class Add_employee extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel lbl_id = new JLabel("Employee id :");
    JTextField txtid = new JTextField(25);
    JLabel lblf_name = new JLabel("First  Name :");
    JTextField txtf_name = new JTextField(25);
    JLabel lbll_name = new JLabel("Last  Name :");
    JTextField txtl_name = new JTextField(25);
    JLabel lblgndr = new JLabel("Gender :");
    JRadioButton buttonma = new JRadioButton("Male", false);
    JRadioButton buttonfe = new JRadioButton("Female", false);
    ButtonGroup group = new ButtonGroup();
    JLabel lbleml = new JLabel("Email :");
    JTextField txteml = new JTextField(30);
    JLabel lblcont = new JLabel("Contact :");
    JTextField txtcont = new JTextField(25);
    JLabel lbldate = new JLabel("Date of join :");
    JLabel lbl_crdate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    JLabel lbldejg = new JLabel("Designation :");
    String[] position = {"","Manager", "Project Manager", "Senior Programmer","Junior Programmer","Chief Accounter","Account officer", "Clerk", "Gaurd"};
    JComboBox comb = new JComboBox(position);
    JLabel lbl_salary=new JLabel("Salary :");
    //JLabel lbl_slr=new JLabel("........");;
     JTextField txt_salary = new JTextField(25);
    JButton btnaddemp = new JButton("Add Employee");
    JButton btnrest = new JButton("Reset");
    Connection con=null;
    Statement st;
    ResultSet rs;

    Add_employee() {
        super("Add New Employee");
        panel.setLayout(null);
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        add(panel);
        addcomp();
        con=DB.getConnection();

    }

     void addcomp() {
        lbl_id.setBounds(40, 20, 120, 35);
        panel.add(lbl_id);
        lbl_id.setFont(lbl_id.getFont().deriveFont(15f));

        txtid.setBounds(150, 20, 190, 35);
        panel.add(txtid);

        lblf_name.setBounds(40, 70, 130, 35);
        panel.add(lblf_name);
         lblf_name.setFont( lblf_name.getFont().deriveFont(15f));

        txtf_name.setBounds(150, 70, 190, 35);
        panel.add(txtf_name);

        lbll_name.setBounds(40, 120, 120, 35);
        panel.add(lbll_name);
         lbll_name.setFont(lbll_name.getFont().deriveFont(15f));

        txtl_name.setBounds(150, 120, 190, 35);
        panel.add(txtl_name);

        lblgndr.setBounds(60, 170, 130, 35);
        panel.add(lblgndr);
        lblgndr.setFont(lblgndr.getFont().deriveFont(15f));

        buttonma.setBounds(150, 170, 120, 35);
        buttonma.addActionListener(this);
        group.add(buttonma);
        panel.add(buttonma);

        buttonfe.setBounds(270, 170, 120, 35);
        buttonfe.addActionListener(this);
        group.add(buttonfe);
        panel.add(buttonfe);

        lbleml.setBounds(80, 220, 130, 35);
        panel.add(lbleml);
         lbleml.setFont(lbleml.getFont().deriveFont(15f));

        txteml.setBounds(150, 220, 190, 35);
        panel.add(txteml);

        lblcont.setBounds(70, 270, 130, 35);
        panel.add(lblcont);
          lblcont.setFont( lblcont.getFont().deriveFont(15f));

        txtcont.setBounds(150, 270, 190, 35);
        panel.add(txtcont);

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yyyy");////
        String string_date=sdf.format(date);
        lbl_crdate=new JLabel(string_date);
        lbldate.setBounds(50, 320, 130, 35);
        lbl_crdate.setBounds(150, 320, 190, 35);
        panel.add(lbldate);
        lbldate.setFont(lbldate.getFont().deriveFont(15f));
        panel.add(lbl_crdate);
        lbl_crdate.setFont(lbl_crdate.getFont().deriveFont(15f));

        lbldejg.setBounds(40, 370, 130, 35);
        panel.add(lbldejg);
         lbldejg.setFont(lbldejg.getFont().deriveFont(15f));

        comb.setBounds(150, 370, 190, 35);
        comb.addActionListener(this);
        panel.add(comb);

        btnaddemp.setBounds(340, 440, 140, 35);
        btnaddemp.addActionListener(this);
        panel.add(btnaddemp);
        btnaddemp.setFont(btnaddemp.getFont().deriveFont(15f));

        btnrest.setBounds(50, 440, 100, 35);
        btnrest.addActionListener(this);
        panel.add(btnrest);
         btnrest.setFont( btnrest.getFont().deriveFont(15f));
        
        lbl_salary.setBounds(370, 370, 120, 35);
        panel.add(lbl_salary);
         lbl_salary.setFont(lbl_salary.getFont().deriveFont(15f));
         txt_salary.setBounds(430, 370, 100, 35);
        panel.add(txt_salary);
         txt_salary.setFont(txt_salary.getFont().deriveFont(15f));
         //lbl_slr.setVisible(false);
         

    }
     String getGender()
{
    if(buttonma.isSelected())
    {
        return "Male";
    }
    else if(buttonfe.isSelected())
    {
        return "Female";
    }
    else
    {
        return null;
    }
}

    public static void main(String[] args) {
        Add_employee ob = new Add_employee();
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
                       txt_salary.setText(slr);
                    }
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        if (einfo.getSource() == btnaddemp) {
            
            try {

                String emp_id = txtid.getText();
                String first_name = txtf_name.getText();
                String last_name = txtl_name.getText();
                String gender = getGender();
                String email= txteml.getText();
                String contact = txtcont.getText();
                String joine_date= lbl_crdate.getText();
                String designation =(String) comb.getSelectedItem();
                String salary = txt_salary.getText();
                double slrd = Double.parseDouble(salary);
                int i = Employeedao.save(emp_id,first_name,last_name,gender,email,contact,joine_date,designation,slrd);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } else {
                    System.out.println(einfo.toString());
                }

            } catch (Exception ee) {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if (einfo.getSource() == btnrest){
            txtid.setText(null);
            txtf_name.setText(null);
            txtcont.setText(null);
            txteml.setText(null);
            txtl_name.setText(null);
            buttonfe.setSelected(false);
            buttonma.setSelected(false);            
        }

    }
}
