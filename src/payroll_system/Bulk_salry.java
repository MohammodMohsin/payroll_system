package payroll_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bulk_salry extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel lbl_yr_sr_in = new JLabel("Yearly salary increment of employee :");
    JLabel lbl_by = new JLabel("By ");
    JTextField txt_by = new JTextField(25);
    JLabel lbl_p = new JLabel("%");
    JButton btn_incr = new JButton("Increment");
    Connection con=null;
    Statement st;
    ResultSet rs;

    Bulk_salry() {
        super("Bulk Salary Update");
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        setSize(350, 300);
        setVisible(true);
        add(panel);
        setLocationRelativeTo(null);
        setResizable(false);
        con=DB.getConnection();
        addcomp();

    }

    private void addcomp() {
        lbl_yr_sr_in.setBounds(20, 30, 300, 30);
        panel.add(lbl_yr_sr_in);
        lbl_yr_sr_in.setFont(lbl_yr_sr_in.getFont().deriveFont(17f));

        lbl_by.setBounds(70, 110, 100, 30);
        panel.add(lbl_by);
        lbl_by.setFont(lbl_by.getFont().deriveFont(17f));

        txt_by.setBounds(100, 110, 140, 35);
        panel.add(txt_by);

        lbl_p.setBounds(245, 110, 100, 30);
        panel.add(lbl_p);
        lbl_p.setFont(lbl_p.getFont().deriveFont(17f));

        btn_incr.setBounds(130, 160, 180, 30);
        panel.add(btn_incr);
        btn_incr.addActionListener(this);
        btn_incr.setFont(btn_incr.getFont().deriveFont(17f));

    }

    public static void main(String[] args) {
        new Bulk_salry();
    }
    public void actionPerformed(ActionEvent einfo){
        if (einfo.getSource() == btn_incr){
            double incr=Double.parseDouble(txt_by.getText());
            try{
                String query="select salary from designation";
                PreparedStatement   pst = con.prepareStatement(query);
                    rs=pst.executeQuery();
                    while(rs.next()){
                      double slr=Double.parseDouble(rs.getString("salary"));
                      txt_by.setText(rs.getString("salary"));
                    }
                    
            }
            catch(Exception enc){
                JOptionPane.showMessageDialog(null, enc.toString());
            }
        }
    }

}
