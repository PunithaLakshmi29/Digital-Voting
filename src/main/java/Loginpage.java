import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Loginpage{

public static boolean validate(String username,String Password) 
{
boolean status= false;
// TODO Auto-generated method stub
// return status;
try
{
	Connection con=DriverManager.getConnection("jdbc:mysql:///sys","root","root");
PreparedStatement ps =con.prepareStatement("select * from registrationform1 where username=? and Password=? ");


ps.setString(1, username);
ps.setString(2, Password);

ResultSet rs=ps.executeQuery();
status =rs.next();
}
catch(SQLException se) {
// pw.println(se.getMessage());
se.printStackTrace();
}catch(Exception e) {
// pw.println(e.getMessage());
e.printStackTrace();
}
return status;
}
}