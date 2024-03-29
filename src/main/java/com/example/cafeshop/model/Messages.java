package com.example.cafeshop.model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * @author MONTENEGRO
 */
public class Messages {
	
	public void confirmation (String titulo, String mensaje) {
		Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
		alert.setTitle (titulo);
		alert.setHeaderText (null);
		alert.setContentText (mensaje);
		alert.showAndWait ();
	}
	
	public void warning (String titulo, String mensaje) {
		Alert alert = new Alert (Alert.AlertType.WARNING);
		alert.setTitle (titulo);
		alert.setHeaderText (null);
		alert.setContentText (mensaje);
		alert.showAndWait ();
	}
	
	public void error (String titulo, String mensaje) {
		Alert alert = new Alert (Alert.AlertType.ERROR);
		alert.setTitle (titulo);
		alert.setHeaderText (null);
		alert.setContentText (mensaje);
		alert.showAndWait ();
	}
	
	public Boolean information (String titulo, String mensaje) {
		Alert alert = new Alert (Alert.AlertType.INFORMATION);
		alert.setTitle (titulo);
		alert.setHeaderText (null);
		alert.setContentText (mensaje);
		Optional<ButtonType> result = alert.showAndWait ();
		return result.isPresent () && result.get () == ButtonType.OK;
	}
	
}
