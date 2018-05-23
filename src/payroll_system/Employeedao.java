
package payroll_system;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Employeedao {
public static int save(String emp_id,String first_name,String last_name,String gender,String email,String contact,String joine_date,String designation,double slrd){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee(empid,first_name,last_name,Gender,Email,Contact,join_date,designation,salary) values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,emp_id);
                ps.setString(2,first_name);
		ps.setString(3,last_name);
		ps.setString(4,gender);
		ps.setString(5,email);
                ps.setString(6,contact);
                ps.setString(7,joine_date);
                ps.setString(8,designation);
		ps.setDouble(9,slrd);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
