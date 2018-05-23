package payroll_system;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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

public class Payment extends JFrame implements ActionListener,Printable{

    JPanel panel = new JPanel();
    JLabel lblid = new JLabel("Employee ID :");
    JTextField txtid = new JTextField(25);
    JLabel lbl_month = new JLabel("Month :");
    String mont[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    JComboBox combm = new JComboBox(mont);
    JLabel lblyear = new JLabel("Year :");
    String year[] = {"2017","2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006"};
    JComboBox comby = new JComboBox(year);
    JButton btn_ok = new JButton("Ok");
    JLabel lbl_company=new JLabel("XYZ Technology LTD");
    JLabel lbl_id1 = new JLabel("Employee id :");
    JLabel lbl_id_un = new JLabel("_ _ _ _ _ _ ");
    JLabel lblf_name = new JLabel("First  Name :");
    JLabel lblf_name_un = new JLabel("_ _ _ _ _ _");
    JLabel lbll_name = new JLabel("Last  Name :");
    JLabel lbll_name_un = new JLabel("_ _ _ _ _ _");
    JLabel lbl_paymnt = new JLabel("Payment of :");
    JLabel lbl_paymnt_un = new JLabel("_ _ _ _ _ _");
    JLabel lbl_basic_salary = new JLabel("Basic salary :");
    JLabel lbl_basic_salary_un = new JLabel("_ _ _ _ _ _");
    JLabel lbl_allwnc = new JLabel("Allowances :");
    JLabel lbl_allwnc_un = new JLabel("_ _ _ _ _ _ _");
    JLabel lbl_deductn = new JLabel("Deduction :");
    JLabel lbl_deductn_un = new JLabel("_ _ _ _ _ _ _");
    JLabel lbl_net_salary = new JLabel("Net salary :");
    JLabel lbl_net_salary_un = new JLabel("_ _ _ _ _ _ _ _");
    JButton btn_reset=new JButton("Reset");
    JButton btn_slip=new JButton("Slip");
    JButton btn_pay=new JButton("Make Payment");
    Connection con=null;
    Statement st;
    ResultSet rs;
    
    Payment() {
        super("Payment");
        panel.setLayout(null);
        setSize(450, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        add(panel);
        setResizable(false);
        addcomp();
        con=DB.getConnection();
    }

    private void addcomp() {
        lblid.setBounds(20, 20, 120, 35);
        panel.add(lblid);
        lblid.setFont(lblid.getFont().deriveFont(15f));

        txtid.setBounds(120, 20, 200, 35);
        panel.add(txtid);

        lbl_month.setBounds(20, 80, 120, 35);
        panel.add(lbl_month);
        lbl_month.setFont(lbl_month.getFont().deriveFont(15f));

        combm.setBounds(90, 80, 90, 35);
        panel.add(combm);

        lblyear.setBounds(200, 80, 120, 35);
        panel.add(lblyear);
        lblyear.setFont(lblyear.getFont().deriveFont(15f));

        comby.setBounds(250, 80, 90, 35);
        panel.add(comby);

        btn_ok.setBounds(360, 80, 60, 35);
        panel.add(btn_ok);
        btn_ok.addActionListener(this);
        btn_ok.setFont(btn_ok.getFont().deriveFont(15f));

       lbl_company.setBounds(150, 140, 300, 35);
        panel.add(lbl_company);
        lbl_company.setFont(lbl_company.getFont().deriveFont(15f));
        
       /* lbl_contact.setBounds(150, 135, 300, 35);
        panel.add(lbl_contact);
        lbl_contact.setFont(lbl_contact.getFont().deriveFont(15f));*/
        
         lbl_id1.setBounds(40, 180, 120, 35);
        panel.add(lbl_id1);
        lbl_id1.setFont(lbl_id1.getFont().deriveFont(15f));

        lbl_id_un.setBounds(140, 180, 120, 35);
        panel.add(lbl_id_un);

        lblf_name.setBounds(40, 220, 120, 35);
        panel.add(lblf_name);
        lblf_name.setFont(lblf_name.getFont().deriveFont(15f));

        lblf_name_un.setBounds(140, 220, 120, 35);
        panel.add(lblf_name_un);

        lbll_name.setBounds(40, 260, 120, 35);
        panel.add(lbll_name);
        lbll_name.setFont(lbll_name.getFont().deriveFont(15f));

        lbll_name_un.setBounds(140, 260, 120, 35);
        panel.add(lbll_name_un);

        lbl_paymnt.setBounds(40, 300, 120, 35);
        panel.add(lbl_paymnt);
        lbl_paymnt.setFont(lbl_paymnt.getFont().deriveFont(15f));

        lbl_paymnt_un.setBounds(140, 300, 120, 35);
        panel.add(lbl_paymnt_un);

        lbl_basic_salary.setBounds(40, 340, 120, 35);
        panel.add(lbl_basic_salary);
        lbl_basic_salary.setFont(lbl_basic_salary.getFont().deriveFont(15f));

        lbl_basic_salary_un.setBounds(140, 340, 120, 35);
        panel.add(lbl_basic_salary_un);

        lbl_allwnc.setBounds(40, 380, 120, 35);
        panel.add(lbl_allwnc);
        lbl_allwnc.setFont(lbl_allwnc.getFont().deriveFont(15f));

        lbl_allwnc_un.setBounds(140, 380, 120, 35);
        panel.add(lbl_allwnc_un);

        lbl_deductn.setBounds(40, 420, 120, 35);
        panel.add(lbl_deductn);
        lbl_deductn.setFont(lbl_deductn.getFont().deriveFont(15f));

        lbl_deductn_un.setBounds(140, 420, 120, 35);
        panel.add(lbl_deductn_un);

        lbl_net_salary.setBounds(40, 480, 120, 35);
        panel.add(lbl_net_salary);
        lbl_net_salary.setFont(lbl_net_salary.getFont().deriveFont(15f));

        lbl_net_salary_un.setBounds(140, 480, 120, 35);
        panel.add(lbl_net_salary_un);
        
        btn_reset.setBounds(30, 540, 100, 35);
        panel.add(btn_reset);
        btn_reset.addActionListener(this);
       btn_reset.setFont(btn_reset.getFont().deriveFont(15f));
       
       btn_slip.setBounds(160, 540, 100, 35);
        panel.add(btn_slip);
        btn_slip.addActionListener(this);
       btn_slip.setFont(btn_slip.getFont().deriveFont(15f));
       
        btn_pay.setBounds(290, 540, 150, 35);
        panel.add(btn_pay);
        btn_pay.addActionListener(this);
       btn_pay.setFont(btn_pay.getFont().deriveFont(15f));
       
        
        

    }

    public static void main(String[] args) {
        new Payment();
    }
    
        public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()== btn_ok){
            String sempid= txtid.getText();
            String syear= (String) comby.getSelectedItem();
            String smonth= (String) combm.getSelectedItem();
            try{
                String query="select * from employee where empid=?";
                PreparedStatement   pst = con.prepareStatement(query);
                    pst.setString(1, sempid);
                    rs=pst.executeQuery();
                    while(rs.next()){
                       lblf_name_un.setText(rs.getString("first_name"));
                       lbll_name_un.setText(rs.getString("last_name"));
                       
                    }
            }
            catch (Exception emp){
                System.out.println(emp.toString());
            }
            try{
                String query="select * from net_salary where empid=? and year=? and month=?";
                PreparedStatement   pst = con.prepareStatement(query);
                    pst.setString(1, sempid);
                    pst.setString(2, syear);
                    pst.setString(3, smonth);
                    rs=pst.executeQuery();
                    while(rs.next()){
                       lbl_id_un.setText(rs.getString("empid"));
                       lbl_paymnt_un.setText(rs.getString("month"));
                       lbl_basic_salary_un.setText(rs.getString("salary"));
                       lbl_allwnc_un.setText(rs.getString("allowance"));
                       lbl_deductn_un.setText(rs.getString("deducation"));
                       lbl_net_salary_un.setText(rs.getString("net_salary"));
                       
                    }
            }
            catch (Exception ek){
                System.out.println(ek.toString());
            }
        }
        if(e.getSource()==btn_pay){
try {

                String emp_id = lbl_id_un.getText();
                String syear = (String) comby.getSelectedItem();
                String month = (String) combm.getSelectedItem();
                String pay = new String("paid");
                int i = Paiddoa.save(emp_id,month,syear,pay);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } else {
                    System.out.println(e.toString());
                }

            } catch (Exception ee) {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if (e.getSource() == btn_reset){
                    txtid.setText(null);
               lbl_id_un.setText(null);
               lbl_paymnt_un.setText(null);
               lbl_basic_salary_un.setText(null);
               lbl_allwnc_un.setText(null);
               lbl_deductn_un.setText(null);
               lbl_net_salary_un.setText(null);
               lblf_name_un.setText(null);
               lbll_name_un.setText(null);
               //lbl_ttadv.setText(null);
           // buttonfe.setSelected(false);
            //buttonma.setSelected(false);            
        }

        if(e.getSource()==btn_slip) 
           {
               PrinterJob printJob = PrinterJob.getPrinterJob();
               printJob.setPrintable(this);
               if(printJob.printDialog())
                {
                   try
                     {
                          printJob.print();
                      }
                   catch(Exception ex)
                      {
                         throw new RuntimeException(ex);
                      }
                                  
                  }
               
                }
        

        
    }
    
     public int print(Graphics g, PageFormat pf, int index) throws PrinterException
      {
        Graphics2D g2 = (Graphics2D)g;
        if (index >= 1)
           {
             return Printable.NO_SUCH_PAGE;
           }
       else     
          {
              //ok.printAll(g2);
        this.printAll(g2);
        return Printable.PAGE_EXISTS;
          }
    }

}
