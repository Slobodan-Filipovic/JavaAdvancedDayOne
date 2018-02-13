package basic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
/**
 * break with the World db in MySql
 * @author Slobodan
 *
 */
public class SuperSimpleStuff {
	public static java.sql.Statement stmt = null;
	public static ResultSet rs = null;

	public static void main(String[] args) {
		
		Connection conn = null;
		 
		try {
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/world?" +
		                                   "user=root&password=quest123");
		    Statement stmt = conn.createStatement(); 
		    
		    rs = stmt.executeQuery("SELECT * FROM world.country WHERE Code = 'ABW'");
		    
		    while(rs.next())
		    {
		    	String countryCode = rs.getString("Code");
		    	String name = rs.getString("Name");
		    	String continent = rs.getString("Continent");
		    	String region = rs.getString("Region");
		    	double surfaceArea = rs.getDouble("SurfaceArea");
		    	int indepYear = rs.getInt("IndepYear");
		    	long population = rs.getLong("Population");
		    	double lifeExpectancy = rs.getDouble("LifeExpectancy");
		    	double gNP = rs.getDouble("GNP");
		    	double gNPOld = rs.getDouble("GNPOld");
		    	String localName = rs.getString("LocalName");
		    	String governmentForm = rs.getString("GovernmentForm");
		    	String headOfState = rs.getString("HeadOfState");
		    	String code2 = rs.getString("Code2");		    	
		    }
	 

		   
		} catch (SQLException ex) {
		  
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
