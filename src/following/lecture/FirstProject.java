package following.lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/*import java.sql.SQLException;
import java.sql.Statement;*/
/**
 * Warm up
 * Before I started following the lecture.
 */
/*
public class FirstProject {

	public static java.sql.Statement stmt = null;
	public static ResultSet rs = null;

	public static void main(String[] args) {		 
			
			Connection conn = null;
			 
			try {
			    conn = DriverManager.getConnection("jdbc:mysql://localhost/veterinardb?" +
			                                   "user=root&password=quest123");
			    Statement stmt = conn.createStatement(); 
			    
			    rs = stmt.executeQuery("SELECT * FROM veterinardb.pregled");	 
			    while(rs.next())
			    {
			    	//idPregled, Usluga_idUsluga, Veterinar_idVeterinar, vremeOd, vremeDo, zauzet
			    	int idPregled = rs.getInt("idPregled");
			    	int usluga_idUsluga = rs.getInt("Usluga_idUsluga");
			    	int veterinar_idVeterinar = rs.getInt("Veterinar_idVeterinar");
			    	String vremeOd = rs.getString("vremeOd");
			    	String vremeDo = rs.getString("vremeDo");
			    	int zauzet = rs.getInt("zauzet");
			    	
			    	System.out.println(" idPregled: " + idPregled +  " usluga_idUsluga: " + usluga_idUsluga + " veterinar_idVeterinar: " + veterinar_idVeterinar +
			    			" vremeOd: "+ vremeOd + " vremeDo:  " + vremeDo + " zauzet: " + zauzet);
			    	
			    }
			}
			 catch (SQLException ex) {
				  
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());
			}
			 

}
}*/
