
package payroll_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Deductiondt_dao {
public static int save(String emp_id,String month,String syear,double ngrs,double nadv,double nded_adv,double nday_leaves,double nded){
	int status=0;
	try{
		Connection con=DB.getConnection();
            try{
                String sql="update employee set Advance='"+nded_adv+"' where empid='"+emp_id+"'";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(null,"Updated");
           
            }
            catch(Exception ee){
                JOptionPane.showMessageDialog(null,ee);
            }
		PreparedStatement ps=con.prepareStatement("insert into deduction(ID,Month,Year,Gross_slr,Advanced,Leaves,Deduction) values(?,?,?,?,?,?,?)");
		ps.setString(1,emp_id);
		ps.setString(2,month);
                ps.setString(3,syear);
		ps.setDouble(4,ngrs);
		ps.setDouble(5,nadv);
                ps.setDouble(6,nday_leaves);
                ps.setDouble(7,nded);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
