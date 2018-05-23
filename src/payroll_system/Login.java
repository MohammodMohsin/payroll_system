package payroll_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    String color500_ = " #9e9e9e";
    String colorpanel_ = "#90A4AE";
    JPanel panel = new JPanel();
    JLabel usr_name = new JLabel("User Name :");
    JTextField usrtext = new JTextField(25);
    JLabel password = new JLabel("Password :");
    JPasswordField passf = new JPasswordField(25);
    JButton loginb = new JButton("Login");
    Font lfnt = new Font("Times New Roman", Font.PLAIN, 17);
    Connection con=null;
    Statement st;
    ResultSet rs;

    Login() {
        super("Admin Login");
        /*panel.setBackground(Color.gray);
        panel.setLayout(null);
        setSize(350, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setLocationRelativeTo(null);
        setResizable(false);*/
        //addcomp();
        panel.setLayout(null);
        add(panel);
        panel.setBackground(Color.decode(colorpanel_));
        setSize(480, 400);
        setVisible(true);
        setLocation(800, 100);
        setResizable(false);
        addcomp();
        con=DB.getConnection();
    }

    private void addcomp() {
        usr_name.setBounds(110, 55,200,60);
        usr_name.setFont(lfnt);
        panel.add(usr_name);

        usrtext.setBounds(230, 70, 130, 35);
        panel.add(usrtext);

        password.setBounds(110, 125, 200, 80);
        password.setFont(lfnt);
        panel.add(password);

        passf.setBounds(230, 150, 130, 35);
        panel.add(passf);

        loginb.setBounds(180, 250, 110, 30);
        panel.add(loginb);
        loginb.addActionListener(this);

    }

    public static void main(String[] args) {
        Login ob = new Login();

    }

        public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginb) {
            boolean c = false;
            if (usrtext.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Provide User Name");

            } else if (passf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Provide User Password");

            } else {

                
                try {
                    
                    String query="select * from registration where username='"+usrtext.getText()+"'"
                      +"&& password='"+passf.getText()+"'";
                    st = con.createStatement();
                    rs = st.executeQuery(query);
                    rs.next();
                    String name = rs.getString("username");
                    String password = rs.getString("password");

                    if (usrtext.getText().equals(name) && passf.getText().equals(password)) {
                        c = true;
                            new Pay_roll();
                            dispose();

                    } 
                    else {

                            JOptionPane.showMessageDialog(null, "Provide correct Name and password");

                    }
                    

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }

            }

        }
    }

}
