package following.lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Mimicing lecturer
 * @author Slobodan
 *
 */
public class Baza {
	  public Connection conn;
	  
	public Baza() throws SQLException {
		/*
		 * The following error occured:
		 * SQLException: The connection property 'useSSL' only accepts values of the form: 'true', 'false', 'yes' or 'no'. The value 'falseuser=root' is not in this set.
SQLState: S1009
VendorError: 0

I wrote return this.getConnection() which lead to another error, Stack Overflow since the method
is calling itself. And the useSSL was fixed when url username and password got separated, made an error in concatenation but you couldn't see it so you just did it 
in some other way. And it works, when bored check what's going on.	

*/
		String url = "jdbc:mysql://localhost/veterinardb?useSSL=false";
		String username = "root";
		String password = "quest123"; 
		
		conn = DriverManager.getConnection(url, username, password);
	}	
	public Connection getConnection() {
		return this.conn;
	}
	
	public void closeConnection() {
		try {
			this.conn.close();
		}
		catch(Exception exp)
		{
			System.out.println(exp.toString());
		}
		
	}

}
