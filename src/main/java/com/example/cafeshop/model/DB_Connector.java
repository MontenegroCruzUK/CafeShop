package com.example.cafeshop.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB_Connector {
	
	// Detalles de la base de datos
	private static final String DB_URL = "jdbc:mysql://localhost:3306/db_cafeshop";
	private static final String USER = "root";
	private static final String PASS = "";
	
	/**
	 * Establishes a connection to the database.
	 *
	 * @return the established database connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establish database connection
			System.out.println("Connecting to the database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// If the connection is successful, display a message
			System.out.println("Successful connection to the database.");
		} catch (SQLException | ClassNotFoundException se) {
			System.out.println(se.toString());
		}
		return conn;
	}
}
