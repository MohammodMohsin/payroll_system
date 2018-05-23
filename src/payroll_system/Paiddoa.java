
package payroll_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Paiddoa {
public static int save(String emp_id,String month,String syear,String pay){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into payment(empid,month,year,status) values(?,?,?,?)");
		ps.setString(1,emp_id);
                ps.setString(2,month);
		ps.setString(3,syear);
		ps.setString(4,pay);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
