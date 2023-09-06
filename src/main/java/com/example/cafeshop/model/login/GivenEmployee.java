package com.example.cafeshop.model.login;

import com.example.cafeshop.model.DB_Connector;
import com.example.cafeshop.model.Messages;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author MONTENEGRO
 */
public class GivenEmployee {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private final Messages message = new Messages ();
	Employee employee = new Employee ();
	
	public ObservableList questionList () {
		String[] questions = {"What is your favorite Color?", "What is your favorite food?", "What is your birth date?"};
		List<String> listQuestions = new ArrayList<> (Arrays.asList (questions));
		return FXCollections.observableArrayList (listQuestions);
		
	}
	
	/**
	 * @param employee
	 * @return
	 */
	public boolean registerUser (Employee employee) {
		try {
			Date date = new Date ();
			java.sql.Date sqlDate = new java.sql.Date (date.getTime ());
			
			// CHECK IF THE USERNAME IS ALREADY RECORDED
			String checkUsername =
				"SELECT username FROM employees WHERE username = '" + employee.getUsername () + "'";
			
			connection = DB_Connector.getConnection ();
			ps = connection.prepareStatement (checkUsername);
			rs = ps.executeQuery ();
			
			if (rs.next ()) {
				message.error ("Error Message", employee.getUsername () + " is already taken");
				return false;
				
			} else if (employee.getPassword ().length () < 8) {
				message.error ("Error Message", "Invalid Password, atleast 8 characters are needed");
				return false;
			} else {
				String query = "INSERT INTO employees (username, password, question, answer, date) VALUES (?, ?, ?, ?, ?)";
				ps = connection.prepareStatement (query);
				
				ps.setString (1, employee.getUsername ());
				ps.setString (2, employee.getPassword ());
				ps.setString (3, employee.getQuestion ());
				ps.setString (4, employee.getAnswer ());
				ps.setString (5, String.valueOf (sqlDate));
				ps.executeUpdate ();
				System.out.println ("Se creó el usuario");
				return true;
				
			}
			
		} catch (SQLException e) {
			System.out.println ("Error al registrar el usuario: " + e.toString ());
			return false;
		}
		
	}
	
	public boolean getLogin (String username, String password) {
		String sql = "SELECT * FROM  employees WHERE username = ? AND password= ? ";
		try {
			connection = DB_Connector.getConnection ();
			ps = connection.prepareStatement (sql);
			
			ps.setString (1, username);
			ps.setString (2, password);
			
			rs = ps.executeQuery ();
			
			if (rs.next ()) {
				employee.setUsername (rs.getString ("username"));
				employee.setPassword (rs.getString ("password"));
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println ("Problemas con la base de datos\n" + e.getMessage ());
			return false;
		}
	}
	
	public int verifyUserCredentials (String username, String question, String answer) {
		String query = "SELECT id FROM employees WHERE username = ? AND question = ? AND answer = ?";
		int employeeId = - 1; // Valor predeterminado en caso de que no se encuentre una coincidencia
		
		try (
			Connection connection = DB_Connector.getConnection (); PreparedStatement ps = connection.prepareStatement (
			query)) {
			ps.setString (1, username);
			ps.setString (2, question);
			ps.setString (3, answer);
			
			try (ResultSet rs = ps.executeQuery ()) {
				if (rs.next ()) {
					// Se encontró una coincidencia, se obtiene el ID del empleado
					employeeId = rs.getInt ("id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}
		
		return employeeId;
	}
	
	public void changePasswordDB (Employee employees) {
		String sql = "UPDATE employees SET password=? WHERE id=?";
		try {
			Connection connection = DB_Connector.getConnection ();
			ps = connection.prepareStatement (sql);
			
			ps.setString (1, employees.getPassword ());
			ps.setInt (2, employees.getId ());
			ps.execute ();
			message.information ("Password","Password changed");
		} catch (SQLException e) {
			message.error ("Error DB","The password could not be changed, database error.");
			System.out.println (e.getMessage ());
		}
		
	}
}

