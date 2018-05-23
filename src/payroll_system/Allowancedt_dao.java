
package payroll_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Allowancedt_dao {
public static int save(String emp_id,String month,String syear,double novt,double nmdcl,double nlnc,double nnadv,double nadv,double ntotal){
	int status=0;
	try{
		Connection con=DB.getConnection();
            try{
                String sql="update employee set Advance='"+nnadv+"' where empid='"+emp_id+"'";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(null,"Updated");
           
            }
            catch(Exception ee){
                JOptionPane.showMessageDialog(null,ee);
            }
		PreparedStatement ps=con.prepareStatement("insert into allowance(ID,Month,Year,Overtime,Medical,Lunch,Advance,Allowance) values(?,?,?,?,?,?,?,?)");
		ps.setString(1,emp_id);
		ps.setString(2,month);
                ps.setString(3,syear);
		ps.setDouble(4,novt);
		ps.setDouble(5,nmdcl);
                ps.setDouble(6,nlnc);
                ps.setDouble(7,nadv);
                ps.setDouble(8,ntotal);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
