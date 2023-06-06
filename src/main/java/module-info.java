module com.example.cafeshop {
	requires javafx.controls;
	requires javafx.fxml;
	
	
	opens com.example.cafeshop to javafx.fxml;
	exports com.example.cafeshop;
}