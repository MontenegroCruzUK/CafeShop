package com.example.cafeshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
	@Override
	public void start (Stage stage) {
		try {
			Image icon = new Image (
				Objects.requireNonNull (App.class.getResourceAsStream ("images/coffeeBeans.png")));
			FXMLLoader fxmlLoader = new FXMLLoader (App.class.getResource ("view/Login_View.fxml"));
			Scene scene = new Scene (fxmlLoader.load ());
			stage.setTitle ("Cafe Shop");
			stage.setResizable (false);
			stage.getIcons ().add (icon);
			stage.setScene (scene);
			stage.show ();
		} catch (IOException e) {
			System.out.println ("Error en la ventana");
		}
	}
	
	public static void main (String[] args) {
		launch ();
	}
}