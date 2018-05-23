
package payroll_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Update_salary extends JFrame implements ActionListener{
    
    JPanel panel=new JPanel();
     JLabel lblid = new JLabel("Employee ID :");
    JTextField txtid = new JTextField(25);
    JButton btnsearch = new JButton("Search");
    JLabel lblidn = new JLabel("Employee ID :");
    JTextField txtidn = new JTextField(25);
    JLabel f_name = new JLabel("First Name :");
    JTextField txtf_name = new JTextField(25);
    JLabel l_name = new JLabel("Last Name :");
    JTextField txtl_name = new JTextField(25);
    JLabel lbldesig = new JLabel("Designation :");
    JTextField txtdesigntn = new JTextField(25);
    JLabel lbl_currnt_salary=new JLabel("Current salary :");
    JTextField lbl_crnt_slr = new JTextField(25);
   // JLabel lbl_crnt_slr=new JLabel("..........");
    JLabel lbl_update_n_salry=new JLabel("Update new salary by :");
    String opt[] = {"Option","percent(%)", "Amount"};
    JComboBox combincr =new JComboBox(opt);
    ButtonGroup group = new ButtonGroup();
    JLabel lbl_percent=new JLabel("Percent :");
    JTextField txt_percnt=new JTextField(25);
    JLabel lbl_amount=new JLabel("Amount :");
    JTextField txt_amount=new JTextField(25);
    JButton btn_updatep=new JButton("Updated");
    JButton btn_updatem=new JButton("Updated");
    double slr;
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    Update_salary()
    {
        super("Update Salary");
        panel.setLayout(null);
        setSize(500,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        add(panel);
        addcomponant();
        con=DB.getConnection();
    }
    private void addcomponant()
    {
        lblid.setBounds(30, 15, 120, 30);
        panel.add(lblid);
        lblid.setFont(lblid.getFont().deriveFont(15f));

        txtid.setBounds(140, 15, 150, 30);
        panel.add(txtid);

        btnsearch.setBounds(350, 15, 100, 30);
        panel.add(btnsearch);
        btnsearch.addActionListener(this);
        btnsearch.setFont(btnsearch.getFont().deriveFont(15f));

        lblidn.setBounds(40, 80, 120, 30);
        panel.add(lblidn);
        lblidn.setFont(lblidn.getFont().deriveFont(15f));

        txtidn.setBounds(150, 80, 150, 30);
        panel.add(txtidn);

        f_name.setBounds(50, 120, 120, 30);
        panel.add(f_name);
        f_name.setFont(f_name.getFont().deriveFont(15f));

        txtf_name.setBounds(150, 120, 150, 30);
        panel.add(txtf_name);

        l_name.setBounds(50, 160, 120, 30);
        panel.add(l_name);
        l_name.setFont(l_name.getFont().deriveFont(15f));

        txtl_name.setBounds(150, 160, 150, 30);
        panel.add(txtl_name);

        lbldesig.setBounds(40, 200, 120, 30);
        panel.add(lbldesig);
        lbldesig.setFont(lbldesig.getFont().deriveFont(15f));

        txtdesigntn.setBounds(150, 200, 150, 30);
        panel.add(txtdesigntn);
        
        lbl_currnt_salary.setBounds(30, 260, 120, 30);
        panel.add(lbl_currnt_salary);
        lbl_currnt_salary.setFont(lbl_currnt_salary.getFont().deriveFont(15f));
        
        lbl_crnt_slr.setBounds(150, 260, 150, 30);
        panel.add(lbl_crnt_slr);
        lbl_crnt_slr.setFont(lbl_crnt_slr.getFont().deriveFont(15f));
        
       lbl_update_n_salry.setBounds(20, 320, 160, 30);
        panel.add(lbl_update_n_salry);
        lbl_update_n_salry.setFont(lbl_update_n_salry.getFont().deriveFont(15f));
        
        combincr.setBounds(200, 320, 120, 30);
        combincr.addActionListener(this);
        combincr.setSelectedIndex(0);
        combincr.setFont(combincr.getFont().deriveFont(15f));
        panel.add(combincr);
        
        lbl_percent.setBounds(90, 360, 100, 30);
        panel.add(lbl_percent);
       lbl_percent.setFont(lbl_percent.getFont().deriveFont(15f));

       txt_percnt.setBounds(170, 360, 90, 30);
       txt_percnt.show(false);
        panel.add(txt_percnt);
        
      lbl_amount.setBounds(280, 360, 100, 30);
        panel.add(lbl_amount);
       lbl_amount.setFont(lbl_amount.getFont().deriveFont(15f));

        txt_amount.setBounds(350, 360, 90, 30);
        txt_amount.show(false);
        panel.add(txt_amount);
        
        btn_updatem.setBounds(300, 430, 140, 40);
        panel.add(btn_updatem);
        btn_updatem.addActionListener(this);
        btn_updatem.show(false);
        btn_updatem.setFont(btn_updatem.getFont().deriveFont(20f));
        
        btn_updatep.setBounds(120, 430, 140, 40);
        panel.add(btn_updatep);
        btn_updatep.addActionListener(this);
        btn_updatep.show(false);
        btn_updatep.setFont(btn_updatep.getFont().deriveFont(20f));
    }
    public static void main(String[]args)
    {
        new Update_salary();
    }
    
    
    public void actionPerformed(ActionEvent einfo){
                if (einfo.getSource() == btnsearch){
         String semp_id = txtid.getText();
            try{
                String query="select * from employee where empid=?";
                PreparedStatement   pst = con.prepareStatement(query);
                    pst.setString(1, semp_id);
                    rs=pst.executeQuery();
                    while(rs.next()){
                       txtidn.setText(rs.getString("empid"));
                       txtf_name.setText(rs.getString("first_name"));
                       txtl_name.setText(rs.getString("last_name"));
                       txtdesigntn.setText(rs.getString("designation"));
                       lbl_crnt_slr.setText(rs.getString("salary"));
                       slr = Double.parseDouble(rs.getString("salary"));
                      
                    }
                    
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        }
            if (einfo.getSource() ==combincr){
            JComboBox cb = (JComboBox)einfo.getSource();
            String cmb_slr= (String) cb.getSelectedItem();
            switch(cmb_slr){
                case "percent(%)":
                    txt_percnt.show(true);
                    btn_updatep.show(true);
                    txt_amount.show(false);
                    btn_updatem.show(false);
                break;
                case "Amount":
                    txt_amount.show(true);
                    btn_updatem.show(true);
                    txt_percnt.show(false);
                    btn_updatep.show(false);
                break;
                case "Option":
                    txt_amount.show(false);
                    btn_updatem.show(false);
                    txt_percnt.show(false);
                    btn_updatep.show(false);
                break;
                
            }
            
        }
            if (einfo.getSource() == btn_updatep){
             
                double pr = Double.parseDouble(txt_percnt.getText());
                slr=slr+slr*(pr/100);
                String sslr = Double.toString(slr);
                pst=null;
                rs=null;
                try{
                String sfnm = txtidn.getText();
                String query="update employee set salary='"+slr+"' where empid='"+txtidn.getText()+"'";
                pst = con.prepareStatement(query);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Update Successfully");
                }
                catch(Exception eup){
                    JOptionPane.showMessageDialog(null, eup.toString());
                }
                    
                
            }
            if (einfo.getSource() == btn_updatem){
             
                double pr = Double.parseDouble(txt_amount.getText());
                slr=slr+pr;
                String sslr = Double.toString(slr);
                pst=null;
                rs=null;
                try{
                
                String query="update employee set salary='"+slr+"' where empid='"+txtidn.getText()+"'";
                pst = con.prepareStatement(query);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Update Successfully");
                }
                catch(Exception eum){
                    JOptionPane.showMessageDialog(null, eum.toString());
                }
                    
                
            }
    }
    
}

