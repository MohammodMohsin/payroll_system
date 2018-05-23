package payroll_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NSearch extends JFrame implements ActionListener{

    JPanel panel = new JPanel();
    JTable table = new JTable();
    JLabel lbl_search = new JLabel("Search For:");
    String opt[] = {"Option","Employee", "Net Salary", "Pay status", "Allowance", "Deduction"};
    JComboBox combs = new JComboBox(opt);
    JLabel lblf_name = new JLabel("First  Name :");
    JTextField txtf_name = new JTextField(25);
    JButton btnf_name=new JButton("Search");
    JLabel lbl_month = new JLabel("Net Month :");
    JTextField txt_month = new JTextField(25);
    JButton btn_month=new JButton("Search");
    JLabel lbl_id = new JLabel("Employee id :");
    JTextField txtid1 = new JTextField(25);
    JButton btne_id=new JButton("Search");
    JLabel lbl_allowance = new JLabel("Employee id :");
    JTextField txtallowance = new JTextField(25);
    JButton btn_allns=new JButton("Search");
    JLabel lbl_ded = new JLabel("Employee id :");
    JTextField txtded = new JTextField(25);
    JButton btn_ded=new JButton("Search");
    JButton btn_show_all = new JButton("Show all");
    Object[] clms = {"ID","First name","Last Name","Gender","Email","Contact","Join","designation","salary"};
    DefaultTableModel mdl = new DefaultTableModel();
    Vector data =new Vector();
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
    
    NSearch() {
        super("Search Employee");
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        setSize(1200, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        add(panel);
        addcomp();
        con=DB.getConnection();
    }

    private void addcomp() {
        
        lbl_search.setBounds(450, 12, 160, 34);
        panel.add(lbl_search);
        lbl_search.setFont(lbl_search.getFont().deriveFont(15f));
        combs.setBounds(545, 15, 120, 32);
        panel.add(combs);
        combs.setSelectedIndex(0);
        combs.addActionListener(this);
        combs.setFont(combs.getFont().deriveFont(15f));
        
        lblf_name.setBounds(10, 60, 100, 35);
        panel.add(lblf_name);
        lblf_name.setFont(lblf_name.getFont().deriveFont(15f));

        txtf_name.setBounds(100, 60, 100, 35);
        txtf_name.show(false);
        panel.add(txtf_name);
        
        btnf_name.setBounds(70, 100, 100, 30);
        btnf_name.show(false);
        btnf_name.addActionListener(this);
        panel.add(btnf_name);
        btnf_name.setFont(btnf_name.getFont().deriveFont(15f));

        lbl_month.setBounds(225, 60, 100, 35);
        panel.add(lbl_month);
        lbl_month.setFont(lbl_month.getFont().deriveFont(15f));

        txt_month.setBounds(310, 60, 100, 35);
        txt_month.show(false);
        panel.add(txt_month);
        
        btn_month.setBounds(280, 100, 100, 30);
        btn_month.show(false);
        btn_month.addActionListener(this);
        panel.add(btn_month);
        btn_month.setFont(btn_month.getFont().deriveFont(15f));

        lbl_id.setBounds(445, 60, 100, 35);
        panel.add(lbl_id);
        lbl_id.setFont(lbl_id.getFont().deriveFont(15f));

        txtid1.setBounds(540, 60, 100, 35);
        txtid1.show(false);
        panel.add(txtid1);
        
        btne_id.setBounds(500, 100, 100, 30);
        btne_id.show(false);
        btne_id.addActionListener(this);
        panel.add(btne_id);
        btne_id.setFont(btne_id.getFont().deriveFont(15f));
        //
        

        lbl_allowance.setBounds(695, 60, 100, 35);
        panel.add(lbl_allowance);
        lbl_allowance.setFont(lbl_allowance.getFont().deriveFont(15f));

        txtallowance.setBounds(790, 60, 100, 35);
        txtallowance.show(false);
        panel.add(txtallowance);
        
        btn_allns.setBounds(760, 100, 100, 30);
        btn_allns.show(false);
        btn_allns.addActionListener(this);
        panel.add(btn_allns);
        btn_allns.setFont(btn_allns.getFont().deriveFont(15f));
//
        lbl_ded.setBounds(935, 60, 100, 35);
        panel.add(lbl_ded);
        lbl_ded.setFont(lbl_ded.getFont().deriveFont(15f));

        txtded.setBounds(1030, 60, 100, 35);
        txtded.show(false);
        panel.add(txtded);
        
        btn_ded.setBounds(990, 100, 100, 30);
        btn_ded.show(false);
        btn_ded.addActionListener(this);
        panel.add(btn_ded);
        btn_ded.setFont(btn_ded.getFont().deriveFont(15f));
//
       //
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(1, 140, 1190, 230);
        panel.add(pane);
        
        mdl.setColumnIdentifiers(clms);
        table.setModel(mdl);
        
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.BLACK);
        table.setFont(table.getFont().deriveFont(10f));
        table.setRowHeight(30);

    }

    public static void main(String[] args) {
        new NSearch();
    }
    public void actionPerformed(ActionEvent einfo){
        
        if (einfo.getSource() ==combs){
            JComboBox cb = (JComboBox)einfo.getSource();
            String cmb_slr= (String) cb.getSelectedItem();
            switch(cmb_slr){
                case "Employee":
                    txtf_name.show(true);
                    btnf_name.show(true);
                    txt_month.show(false);
                    btn_month.show(false);
                    txtid1.show(false);
                    btne_id.show(false);
                    txtallowance.show(false);
                    btn_allns.show(false);
                    txtded.show(false);
                    btn_ded.show(false);
                break;
                case "Net Salary":
                    txt_month.show(true);
                    btn_month.show(true);
                    txtf_name.show(false);
                    btnf_name.show(false);
                    btne_id.show(false);
                    txtid1.show(false);
                    txtallowance.show(false);
                    btn_allns.show(false);
                    txtded.show(false);
                    btn_ded.show(false);
                break;
                case "Pay status":
                    txtid1.show(true);
                    btne_id.show(true);
                    txtf_name.show(false);
                    btnf_name.show(false);
                    txt_month.show(false);
                    btn_month.show(false);
                    txtallowance.show(false);
                    btn_allns.show(false);
                    txtded.show(false);
                    btn_ded.show(false);
                break;
                case "Allowance":
                    txtallowance.show(true);
                    btn_allns.show(true);
                    txtf_name.show(false);
                    btnf_name.show(false);
                    txt_month.show(false);
                    btn_month.show(false);
                    txtded.show(false);
                    btn_ded.show(false);
                    txtid1.show(false);
                    btne_id.show(false);
                break;
                case "Deduction":
                    txtded.show(true);
                    btn_ded.show(true);
                    txtf_name.show(false);
                    btnf_name.show(false);
                    txt_month.show(false);
                    btn_month.show(false);
                    txtallowance.show(false);
                    btn_allns.show(false);
                    txtid1.show(false);
                    btne_id.show(false);
                break;
                
            }
        }
        if (einfo.getSource() ==btnf_name){
            pst=null;
            rs=null;
            try{
                String sfnm = txtf_name.getText();
                String query="select * from employee where first_name=?";
                pst = con.prepareStatement(query);
                pst.setString(1, sfnm);
                rs = pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception efnm){
                JOptionPane.showMessageDialog(null, efnm.toString());
            }
        }
        if (einfo.getSource() ==btn_month){
            pst=null;
            rs=null;
            try{
                String sfnm = txt_month.getText();
                String query="select * from net_salary where month=?";
                pst = con.prepareStatement(query);
                pst.setString(1, sfnm);
                rs = pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception efnm){
                JOptionPane.showMessageDialog(null, efnm.toString());
            }
        }
        if (einfo.getSource() ==btne_id){
            pst=null;
            rs=null;
            try{
                String sfnm = txtid1.getText();
                String query="select * from payment where empid=?";
                pst = con.prepareStatement(query);
                pst.setString(1, sfnm);
                rs = pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception efnm){
                JOptionPane.showMessageDialog(null, efnm.toString());
            }
        }
        if (einfo.getSource() ==btn_allns){
            pst=null;
            rs=null;
            try{
                String sfnm = txtallowance.getText();
                String query="select * from allowance where ID=?";
                pst = con.prepareStatement(query);
                pst.setString(1, sfnm);
                rs = pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception efnm){
                JOptionPane.showMessageDialog(null, efnm.toString());
            }
        }
        if (einfo.getSource() ==btn_ded){
            pst=null;
            rs=null;
            try{
                String sfnm = txtded.getText();
                String query="select * from deduction where ID=?";
                pst = con.prepareStatement(query);
                pst.setString(1, sfnm);
                rs = pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception efnm){
                JOptionPane.showMessageDialog(null, efnm.toString());
            }
        }
        
    }

}
