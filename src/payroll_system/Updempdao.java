
package payroll_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Updempdao {
public static int update(String s_id,String first_name,String last_name,String gender,String email,String contact,String joine_date,String designation,double slrd){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("update employee set first_name='"+first_name+"',last_name='"+last_name+"',Gender='"+gender+"',Email='"+email+"',Contact='"+contact+"',join_date='"+joine_date+"',designation='"+designation+"',salary='"+slrd+"' where empid='"+s_id+"'");
		status=ps.executeUpdate();
		con.close();
	}
        catch(Exception e){
            System.out.println(e);
        }
	return status;
}
}
