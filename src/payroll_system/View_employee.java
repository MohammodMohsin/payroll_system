
package payroll_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View_employee extends JFrame implements ActionListener {

    View_employee() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        disPlayData();
    }

    void disPlayData() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        Vector data = new Vector();
        JPanel panel = new JPanel();
        JTable table;

        try {
            con = DB.getConnection();

           
            pst = con.prepareStatement("select * from employee");
            pst.execute();
            rs = pst.getResultSet();
            ResultSetMetaData rsmt = rs.getMetaData();
            int c = rsmt.getColumnCount();
            Vector column = new Vector(c);
            for (int i = 1; i <= c; i++) {
                column.add(rsmt.getColumnName(i));
            }
            Vector row = new Vector();
            while (rs.next()) {
                row = new Vector(c);
                for (int i = 1; i <= c; i++) {
                    row.add(rs.getString(i));
                }
                
                
                data.add(row);
            }
            Vector columnNames = new Vector();
            columnNames.addElement("ID");
            columnNames.addElement("First Name");
            columnNames.addElement("Last Name");
            columnNames.addElement("Gender");
            columnNames.addElement("Email");
            columnNames.addElement("Contact");
            columnNames.addElement("Joined");
            columnNames.addElement("Designation");
            columnNames.addElement("Salary");
            
            table = new JTable(data, columnNames);
            
            JFrame frame = new JFrame("Employee Details");
            frame.setSize(1200, 500);
            frame.setLocationRelativeTo(null);
            JScrollPane pane = new JScrollPane(table);
        //    panel.add(add_b);
        //    panel.add(del);
            panel.setLayout(new BorderLayout());
            panel.add(pane, BorderLayout.CENTER);
            
            frame.setContentPane(panel);
            
            frame.setVisible(true);
        }
        catch (Exception e) 
        {
            // JOptionPane.showMessageDialog(null, e.toString());
            System.out.println(e.toString());
        }

    }

    

    public void actionPerformed(ActionEvent e) {
            

    }

}
