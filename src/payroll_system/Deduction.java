package payroll_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Deduction extends JFrame implements ActionListener {

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
    JLabel lbl_adv = new JLabel(" Advance :");
    JTextField lbl_tadv = new JTextField(25);
    //JLabel lbl_tadv = new JLabel("...............");
    JLabel bni = new JLabel("Deduction for the month of :");
    String mont[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    JComboBox combm = new JComboBox(mont);
    String year[] = {"2017","2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006"};
    JComboBox comby = new JComboBox(year);
    JButton btn_ok = new JButton("Ok");
    JLabel lbl_gross = new JLabel("Total salary :");
    JTextField txtgross = new JTextField(25);
    //JLabel lbl_grs = new JLabel("...............");
    JLabel lbl_total_ded = new JLabel("Total deduction ");
    JTextField txt_total_ded = new JTextField(25);
    JLabel lbl_advnce_pay = new JLabel("Advance pay :");
    JTextField txt_advnce_pay = new JTextField(25);
    JLabel lbl_leaves = new JLabel("Leaves :");
    JTextField txt_leaves = new JTextField(25);
    JLabel lbl_days = new JLabel("days");
    JLabel lbl_net_salary = new JLabel("Net salary ");
    JTextField txt_net_salary = new JTextField(25);
    JButton btn_calculate = new JButton("Calculate");
    JButton btn_deduct = new JButton("Deduct");
    double ntotal,nded,nded_adv;
    String slr,alls;
    Connection con=null;
    Statement st;
    ResultSet rs;
    Deduction() {
        super("Deduction");
        panel.setLayout(null);
        setSize(500, 580);
        setVisible(true);
        add(panel);
        setLocationRelativeTo(null);
        setResizable(false);
        addcomponant();
        con=DB.getConnection();
    }

    private void addcomponant() {
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

        lbl_adv.setBounds(60, 240, 120, 30);
        panel.add(lbl_adv);
        lbl_adv.setFont(lbl_adv.getFont().deriveFont(15f));

        lbl_tadv.setBounds(150, 240, 150, 30);
        panel.add(lbl_tadv);
        lbl_tadv.setFont(lbl_tadv.getFont().deriveFont(15f));

        bni.setBounds(10, 300, 350, 30);
        panel.add(bni);
        bni.setFont(bni.getFont().deriveFont(15f));

        combm.setBounds(220, 300, 90, 30);
        panel.add(combm);

        comby.setBounds(320, 300, 90, 30);
        panel.add(comby);

        btn_ok.setBounds(420, 300, 60, 30);
        btn_ok.addActionListener(this);
        panel.add(btn_ok);

        lbl_gross.setBounds(50, 350, 120, 30);
        panel.add(lbl_gross);
        lbl_gross.setFont(lbl_gross.getFont().deriveFont(15f));
        
        txtgross.setBounds(150, 350, 120, 30);
        panel.add(txtgross);
        txtgross.setFont(txtgross.getFont().deriveFont(15f));

        lbl_total_ded.setBounds(320, 350, 130, 30);
        panel.add(lbl_total_ded);
        lbl_total_ded.setFont(lbl_total_ded.getFont().deriveFont(15f));

        txt_total_ded.setBounds(320, 380, 120, 30);
        panel.add(txt_total_ded);
        txt_total_ded.setFont(txt_total_ded.getFont().deriveFont(15f));

        lbl_advnce_pay.setBounds(40, 400, 120, 30);
        panel.add(lbl_advnce_pay);
        lbl_advnce_pay.setFont(lbl_advnce_pay.getFont().deriveFont(15f));
        
        txt_advnce_pay.setBounds(150, 400, 120, 30);
        panel.add(txt_advnce_pay);
        
        lbl_leaves.setBounds(80, 450, 120, 30);
        panel.add(lbl_leaves);
        lbl_leaves.setFont(lbl_leaves.getFont().deriveFont(15f));
        
        txt_leaves.setBounds(150, 450, 60, 30);
        panel.add(txt_leaves);
        
        lbl_days.setBounds(220, 450, 80, 30);
        panel.add(lbl_days);
        
        lbl_net_salary.setBounds(330, 410, 120, 30);
        panel.add(lbl_net_salary);
        lbl_net_salary.setFont(lbl_net_salary.getFont().deriveFont(15f));
        
        txt_net_salary.setBounds(320, 440, 120, 30);
        panel.add(txt_net_salary);
        txt_net_salary.setFont(txt_net_salary.getFont().deriveFont(15f));
        
        
        btn_calculate.setBounds(150, 500, 100, 30);
        btn_calculate.addActionListener(this);
        panel.add(btn_calculate );
        
        btn_deduct  .setBounds(380, 500, 90, 30);
        btn_deduct.addActionListener(this);
        panel.add(btn_deduct  );
        

    }

    public static void main(String[] args) {
        new Deduction();
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
                       lbl_tadv.setText(rs.getString("Advance"));
                       nded_adv = Double.parseDouble(lbl_tadv.getText());
                      
                    }
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        }
                if (einfo.getSource() == btn_ok){
                    String semp=txtid.getText();
                    String cmb_m= (String) combm.getSelectedItem();
                    String cmb_y= (String) comby.getSelectedItem();
            try{
                String query="select * from net_salary where empid=? && year=? && month=?";
                PreparedStatement   pst = con.prepareStatement(query);
                    pst.setString(1, semp);
                    pst.setString(2, cmb_y);
                    pst.setString(3, cmb_m);
                    rs=pst.executeQuery();
                    while(rs.next()){
                       slr=rs.getString("salary");
                       alls=rs.getString("allowance");
                       String nslr=rs.getString("net_salary");
                       txtgross.setText(nslr);

                    }
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
                }
                if (einfo.getSource() == btn_calculate){
                    
                String sadv = txt_advnce_pay.getText();
                double nadv = Double.parseDouble(sadv);
                nded_adv=nded_adv-nadv;
                String sday_leaves = txt_leaves.getText();
                double nday_leaves = Double.parseDouble(sday_leaves);
                String sgrs = txtgross.getText();
                double ngrs = Double.parseDouble(sgrs);
                nday_leaves=nday_leaves*200;
                nded =nadv+nday_leaves;
                ntotal=ngrs-nded;
                
                try{
                String emp_id = txtidn.getText();
                String syear = (String) comby.getSelectedItem();
                String month = (String) combm.getSelectedItem();
                
                int j = Deductiondt_dao.save(emp_id,month,syear,ngrs,nadv,nded_adv,nday_leaves,nded);
                if (j > 0) {
                    txt_total_ded.setText(Double.toString(nded));
                    txt_net_salary.setText(Double.toString(ntotal));
                } else {
                    System.out.println(einfo.toString());
                }
                }
                catch(Exception ea){
                    System.out.println(ea.toString());
                }
                
                
                

                
                }
                if (einfo.getSource() == btn_deduct){
                try {

                String emp_id = txtidn.getText();
                String syear = (String) comby.getSelectedItem();
                String month = (String) combm.getSelectedItem();
                String salary = slr;
                double slrd = Double.parseDouble(salary);
                String allons = alls;
                double bns = Double.parseDouble(allons);
                double cut=nded;
                double net_slr=ntotal;
                int i = Deductationdao.save(emp_id,syear,month,slrd,bns,cut,net_slr);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } else {
                    System.out.println(einfo.toString());
                }

            } catch (Exception ee) {

                 //System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
                }
    }
}
