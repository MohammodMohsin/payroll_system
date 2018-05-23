package payroll_system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Allowance extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
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
    JLabel lblsalary = new JLabel("Basic salary :");
    JTextField txtsalary = new JTextField(25);
    JLabel lbl_tadv = new JLabel("Advance :");
    JTextField lbl_ttadv = new JTextField(25);
    JLabel bni = new JLabel("Bonus and incentives for the month of :");
    String mont[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    JComboBox combm = new JComboBox(mont);
    String year[] = {"2017","2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006"};
    JComboBox comby = new JComboBox(year);
    JLabel lbltyp = new JLabel("Types");
    JLabel lblamount = new JLabel("Amount");
    JLabel lblovert = new JLabel("Overtime (Hrs):");
    JTextField txtov = new JTextField(25);
    JLabel lblmadical = new JLabel("Madical :");
    JTextField txtmadical = new JTextField(25);
    JLabel lbllunch = new JLabel("Lunch (days):");
    JTextField txtlunch = new JTextField(25);
    JLabel lbladvance = new JLabel("Advance pay :");
    JTextField txtadvance = new JTextField(25);
    JLabel lbl_total = new JLabel("Total :");
    JTextField txttotal = new JTextField(25);
    //JLabel lbltxt_total = new JLabel("..............");
    JButton btnreset = new JButton("Reset");
    JButton btncalculate = new JButton("Calculate");
    JButton btnsave = new JButton("Save");
    double ndeducation,nslr,adv,nded_adv;
    double ntotal=0;
    Connection con=null;
    Statement st;
    ResultSet rs;
    Allowance() {

        super("Allowance");
        panel.setLayout(null);
        setSize(530, 650);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        add(panel);
        addcomponant();
        con=DB.getConnection();
    }

    void addcomponant() {
        lblid.setBounds(30, 15, 120, 30);
        panel.add(lblid);
        lblid.setFont(lblid.getFont().deriveFont(15f));

        txtid.setBounds(140, 15, 150, 30);
        panel.add(txtid);

        btnsearch.setBounds(380, 15, 100, 30);
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

        lblsalary.setBounds(40, 240, 120, 30);
        panel.add(lblsalary);
        lblsalary.setFont(lblsalary.getFont().deriveFont(15f));

        txtsalary.setBounds(150, 240, 150, 30);
        panel.add(txtsalary);
        
        lbl_tadv.setBounds(315, 240, 200, 30);
        panel.add(lbl_tadv);
        lbl_tadv.setFont(lbl_tadv.getFont().deriveFont(15f));
        
        lbl_ttadv.setBounds(390, 240, 100, 30);
        panel.add(lbl_ttadv);
        lbl_ttadv.setFont(lbl_ttadv.getFont().deriveFont(15f));
        
        

        bni.setBounds(10, 300, 350, 30);
        panel.add(bni);
        bni.setFont(bni.getFont().deriveFont(15f));

        combm.setBounds(290, 300, 90, 30);
        panel.add(combm);

        comby.setBounds(390, 300, 90, 30);
        panel.add(comby);

        lbltyp.setBounds(40, 340, 90, 30);
        panel.add(lbltyp);
        lbltyp.setFont(lbltyp.getFont().deriveFont(20f));

        lblamount.setBounds(160, 340, 90, 30);
        panel.add(lblamount);
        lblamount.setFont(lblamount.getFont().deriveFont(20f));

        lblovert.setBounds(20, 380, 120, 30);
        panel.add(lblovert);
        lblovert.setFont(lblovert.getFont().deriveFont(15f));

        txtov.setBounds(150, 380, 90, 30);
        panel.add(txtov);

        lblmadical.setBounds(67, 420, 90, 30);
        panel.add(lblmadical);
        lblmadical.setFont(lblmadical.getFont().deriveFont(15f));

        txtmadical.setBounds(150, 420, 90, 30);
        panel.add(txtmadical);

        lbl_total.setBounds(280, 420, 90, 30);
        panel.add(lbl_total);
        lbl_total.setFont(lbl_total.getFont().deriveFont(20f));

        txttotal.setBounds(350, 420, 110, 30);
        panel.add(txttotal);
        txttotal.setFont(txttotal.getFont().deriveFont(20f));

        lbllunch.setBounds(34, 460, 120, 30);
        panel.add(lbllunch);
        lbllunch.setFont(lbllunch.getFont().deriveFont(15f));

        txtlunch.setBounds(150, 460, 90, 30);
        panel.add(txtlunch);

        lbladvance.setBounds(28, 500, 130, 30);
        panel.add(lbladvance);
        lbladvance.setFont(lbladvance.getFont().deriveFont(15f));

        txtadvance.setBounds(150, 500, 90, 30);
        panel.add(txtadvance);
        
        btnreset.setBounds(50, 550, 120, 35);
        panel.add(btnreset);
        btnreset.addActionListener(this);
        btnreset.setFont(btnreset.getFont().deriveFont(15f));

        btncalculate.setBounds(200, 550, 120, 35);
        panel.add(btncalculate);
        btncalculate.addActionListener(this);
        btncalculate.setFont(btncalculate.getFont().deriveFont(15f));
        
        btnsave.setBounds(350, 550, 120, 35);
        panel.add(btnsave);
        btnsave.addActionListener(this);
        btnsave.setFont(btnsave.getFont().deriveFont(15f));

    }

    public static void main(String[] args) {
        new Allowance();
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
                       txtsalary.setText(rs.getString("salary"));
                       lbl_ttadv.setText(rs.getString("Advance"));
                       nded_adv = Double.parseDouble(lbl_ttadv.getText());
                       //double adv = Double.parseDouble(ad);
                      
                    }
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        }
                if (einfo.getSource() == btncalculate){
                    
                String sovt = txtov.getText();
                double novt = Double.parseDouble(sovt);
                novt=novt*100;
                String smdcl = txtmadical.getText();
                double nmdcl = Double.parseDouble(smdcl);
                String slnc = txtlunch.getText();
                double nlnc = Double.parseDouble(slnc);
                nlnc=nlnc*100;
                String sadv = txtadvance.getText();
                double nadv = Double.parseDouble(sadv);
                double nnadv=nadv+nded_adv;
                ndeducation = 0;
                ntotal =novt+nmdcl+nlnc+nadv;
               // double nnadv = adv+nadv;
                try{
                String emp_id = txtidn.getText();
                String syear = (String) comby.getSelectedItem();
                String month = (String) combm.getSelectedItem();
                
                int j = Allowancedt_dao.save(emp_id,month,syear,novt,nmdcl,nlnc,nnadv,nadv,ntotal);
                if (j > 0) {
                    txttotal.setText(Double.toString(ntotal));
                } else {
                    System.out.println(einfo.toString());
                }
                }
                catch(Exception ea){
                    System.out.println(ea.toString());
                }
                
                
                String snslr = txtsalary.getText();
                Double nnslrd = Double.parseDouble(snslr);
                nslr=ntotal+nnslrd;
                
                }
                
                if (einfo.getSource() == btnreset){
                    txtid.setText(null);
               txtidn.setText(null);
               txtf_name.setText(null);
               txtl_name.setText(null);
               txtdesigntn.setText(null);
               txtsalary.setText(null);
               lbl_ttadv.setText(null);
               txtl_name.setText(null);
               txtl_name.setText(null);
               lbl_ttadv.setText(null);
           // buttonfe.setSelected(false);
            //buttonma.setSelected(false);            
        }

                if (einfo.getSource() == btnsave){
                try {

                String emp_id = txtidn.getText();
                String syear = (String) comby.getSelectedItem();
                String month = (String) combm.getSelectedItem();
                String salary = txtsalary.getText();
                double slrd = Double.parseDouble(salary);
                Double bns=Double.parseDouble(txttotal.getText());
                Double cut=ndeducation;
                Double net_slr=nslr;
                int i = Allowancedao.save(emp_id,syear,month,slrd,bns,cut,net_slr);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } else {
                    System.out.println(einfo.toString());
                }

            } catch (Exception ee) {

                 System.out.println(ee.toString());
                //JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
                }
    }

}
