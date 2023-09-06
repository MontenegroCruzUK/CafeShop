package com.example.cafeshop.controller;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard_Controller implements Initializable {
	@Override
	public void initialize (URL location, ResourceBundle resources) {
	
	}
	
	
	public Dashboard_Controller (Stage stage) {
	
	}
	
	public void closeWindows () {
		Stage myStage = new Stage ();
		myStage.close ();
	}
	
	
}
