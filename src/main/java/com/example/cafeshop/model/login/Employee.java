package com.example.cafeshop.model.login;

/**
 * @author MONTENEGRO
 */
public class Employee {
	
	private int id;
	private String username;
	private String password;
	private String question;
	private String answer;
	
	public Employee () {
	}
	
	public Employee (int id, String username, String password, String question, String answer) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
	}
	
	public int getId () {
		return id;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public String getUsername () {
		return username;
	}
	
	public void setUsername (String username) {
		this.username = username;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public String getQuestion () {
		return question;
	}
	
	public void setQuestion (String question) {
		this.question = question;
	}
	
	public String getAnswer () {
		return answer;
	}
	
	public void setAnswer (String answer) {
		this.answer = answer;
	}
	
}
