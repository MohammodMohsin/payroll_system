
package payroll_system;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Allowancedao {
public static int save(String emp_id,String syear,String month,double slrd,double bns,double cut,double net_slr){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into net_salary(empid,year,month,salary,allowance,deducation,net_salary) values(?,?,?,?,?,?,?)");
		ps.setString(1,emp_id);
                ps.setString(2,syear);
		ps.setString(3,month);
		ps.setDouble(4,slrd);
		ps.setDouble(5,bns);
                ps.setDouble(6,cut);
                ps.setDouble(7,net_slr);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
