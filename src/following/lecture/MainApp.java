package following.lecture;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.PrezimeComparator;
import model.Usluga;
import model.UslugaTransaction;
import model.Veterinar;

public class MainApp {

	public static java.sql.Statement stmt = null;
	public static ResultSet rs = null;
	public static ResultSet rsUsluga = null;
	
	public static void main(String[] args) throws SQLException {	
		
		 Connection conn = new Baza().getConnection();
		 
		try {
		   
		    Statement stmt = conn.createStatement(); 
		    
		   rs = stmt.executeQuery("SELECT * FROM veterinardb.veterinar");
		   
		   ArrayList<Veterinar> veterinarList = new ArrayList<Veterinar>();
		   
		    while(rs.next())
		    {
		    	//idVeterinar, ime, prezime, telefon
		    	/*int idVeterinar = rs.getInt("idVeterinar");
		    	String ime = rs.getString("ime");
		    	String prezime = rs.getString("prezime");
		    	int telefon = rs.getInt("telefon");
		    	System.out.println("idVeterinar: " + idVeterinar + " ime:" + ime + " prezime: " + prezime + " telefon: " + telefon);*/
		    	
		    
		    	Veterinar veterinar = new Veterinar();
		    	veterinar.setIdVeterinar(rs.getInt("idVeterinar"));
		    	veterinar.setIme(rs.getString("ime"));
		    	veterinar.setPrezime(rs.getString("prezime"));
		    	veterinar.setTelefon(rs.getInt("telefon"));
		    	//System.out.println(veterinar.toString());
		    	veterinarList.add(veterinar);		    	
		    } 
		    //System.out.println(veterinarList.toString());
		    /*Difference betweeen Comparator sort and map sort. Comparator is what I have wrote and TreeMap*/
		    Collections.sort(veterinarList, new PrezimeComparator());
		    Map<Integer, Veterinar> mapVeterinars = new TreeMap<Integer, Veterinar>();
		    for(Veterinar vet : veterinarList) {
		    	System.out.println(vet);
		    	mapVeterinars.put(vet.getIdVeterinar(), vet);
		    }
		    System.out.println("Tree map: " + mapVeterinars.toString());
		    
		    UslugaTransaction test = new UslugaTransaction();
		    test.jdbcTransaction();
		    
		    /*Code for working with the Usluga table.*/
		    
		    /*rsUsluga = stmt.executeQuery("SELECT * FROM veterinardb.usluga");
		    
		    ArrayList <Usluga> uslugaList = new ArrayList<Usluga>();
		    while(rsUsluga.next()) {
		    	Usluga usl = new Usluga();
		    	usl.setId(rsUsluga.getInt("idUsluga"));
		    	usl.setNaziv(rsUsluga.getString("naziv"));
		    	usl.setCena(rsUsluga.getDouble("cena"));
		    	//System.out.println(usl.toString());
		    	uslugaList.add(usl);
		    	
		    	
		    	 
		    }
		    System.out.println(uslugaList.toString());*/
		    
		    /*Inserting into usluga table, */
		    insertUsluga(conn, "test", 10230); 
		    
		    /*Deleting row with id 12*/
		   //deleteFromUsluga(conn, 12);
		    /*Updating veterinar*/
			/*Veterinar vet = new Veterinar("Nebojsa", "Milicic", 06453262);
		    updateVeterinar(conn, vet, 4);*/
	}
		catch (SQLException ex) {
			  
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally
		{
			conn.close();
		}
		 

				
	}
	/**
	 * Inserting a row into usluga table
	 * @param conn connection to the db
	 * @param naziv column that holds names of treatments
	 * @param cena price
	 * @throws SQLException selfexplanatory 
	 */
	public static void insertUsluga(Connection conn, String naziv, float cena) throws SQLException {
		PreparedStatement prepStm = conn.prepareStatement("INSERT INTO `veterinardb`.`usluga` ( `naziv`, `cena`) VALUES (?, ?);");
		prepStm.setString(1, naziv);
		prepStm.setDouble(2, cena);
		prepStm.executeUpdate();
		
		/*stm.executeUpdate("INSERT INTO `veterinardb`.`usluga` (`idUsluga`, `naziv`, `cena`) VALUES ();\r\n" + 
				"");*/
		 
	}
	/**
	 * Deleting from Usluga table
	 * @param conn connection to the db
	 * @param id the id of the row to delete. To make life simple. In case you forget change settings in MySQL from safe to allowing these kind of changes based on
	 * other params. Since you were lazy to set it up for name.
	 * @throws SQLException
	 */
	public static void deleteFromUsluga(Connection conn, int id) throws SQLException {
		PreparedStatement prepStm = conn.prepareStatement("DELETE FROM usluga WHERE idUsluga = ?");
		prepStm.setInt(1, id);
		prepStm.executeUpdate();
		
	}

	/**
	 * Updating a row in table Veterinar with passed values (object of class Veteran)
	 * @param conn connection
	 * @param vet the veterinar whose data we are changing
	 * @param id his ID for making life easier
	 */
	public static void updateVeterinar (Connection conn,Veterinar vet, int id) {
		String query = "UPDATE veterinar SET ime = ?, prezime = ?, telefon = ? WHERE idVeterinar = ?";
		
		try {
			PreparedStatement prepStm = conn.prepareStatement(query);
			prepStm.setString(1, vet.getIme());
			prepStm.setString(2, vet.getPrezime());
			prepStm.setInt(3, vet.getTelefon());
			prepStm.setInt(4, id);
			prepStm.execute();//You forgot about this line, time wasted
			 
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
	}
	/**
	 * ArrayList to File
	 * @param fileName name of our file where we are going to save stuff
	 * @param vet our veterinar arrayList
	 * @throws IOException
	 */
	public static void arrayListToFile (String fileName, ArrayList<Veterinar> vetList) throws IOException {
        StringBuilder sb = new StringBuilder();
        File fileVet = new File(fileName);
        
        for (int i = 0; i < vetList.size(); i++) {
            System.out.println(vetList.get(i).toString());
            sb.append(vetList.get(i).toString()).append("|");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileVet));
        writer.write(sb.toString());

        writer.close();
    }
 

}
