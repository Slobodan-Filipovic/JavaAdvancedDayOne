package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import following.lecture.Baza;

public class UslugaTransaction {
	
	Connection conn;
	/**
	 * Constructor to the database, 
	 * @throws SQLException
	 */	/* you fcked up, you already have a Baza class that does most of this shit for you. Duplicating code for nothing.
	public UslugaTransaction() throws SQLException {
		String url = "jdbc:mysql://localhost/veterinardb?useSSL=false";
		String username = "root";
		String password = "quest123"; 
		
		conn = DriverManager.getConnection(url, username, password);
	}
	*/
	public UslugaTransaction() throws SQLException {
		conn = new Baza().getConnection();
	}
	
	/**
	 * A lazy sulution for the problem given. But accepted.
	 * @throws SQLException
	 */
	public void jdbcTransaction() throws SQLException {
		try {
			conn.setAutoCommit(false);
			String query = "UPDATE `veterinardb`.`veterinar` SET `ime`='George', `prezime`='Smith', `telefon`='019782031' WHERE `idVeterinar`= 8;";
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
	}
	

}
