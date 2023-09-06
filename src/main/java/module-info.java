module com.example.cafeshop {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	
	opens com.example.cafeshop to javafx.fxml;
	exports com.example.cafeshop;
	exports com.example.cafeshop.controller;
	opens com.example.cafeshop.controller to javafx.fxml;
}