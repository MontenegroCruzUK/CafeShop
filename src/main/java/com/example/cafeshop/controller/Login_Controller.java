package com.example.cafeshop.controller;

import com.example.cafeshop.App;
import com.example.cafeshop.model.Messages;
import com.example.cafeshop.model.login.Employee;
import com.example.cafeshop.model.login.GivenEmployee;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class Login_Controller implements Initializable {
	GivenEmployee givenEmploye = new GivenEmployee ();
	Employee employees = new Employee ();
	Messages message = new Messages ();
	
	@FXML
	private AnchorPane anchP_FP_QuestionForm;
	
	@FXML
	private AnchorPane anchP_LC_LoginForm;
	
	@FXML
	private AnchorPane anchP_NP_NewPassForm;
	
	@FXML
	private AnchorPane anchP_RC_SingUpForm;
	
	@FXML
	private AnchorPane anchP_SideForm;
	
	@FXML
	private Button btn_Fp_Back;
	
	@FXML
	private Button btn_Fp_Proceed;
	
	@FXML
	private Button btn_Lc_Login;
	
	@FXML
	private Button btn_Np_Back;
	
	@FXML
	private Button btn_Np_ChangePass;
	
	@FXML
	private Button btn_Rc_SingUp;
	
	@FXML
	private Button btn_Side_AllReadyHave;
	
	@FXML
	private Button btn_Side_Create;
	
	@FXML
	private ComboBox<?> cb_Fp_Question;
	
	@FXML
	private ComboBox<?> cb_Rc_Question;
	
	@FXML
	private TextField txt_Fp_Answer;
	
	@FXML
	private TextField txt_Fp_Username;
	
	@FXML
	private PasswordField txt_Lc_Password;
	
	@FXML
	private TextField txt_Lc_Username;
	
	@FXML
	private TextField txt_Np_ConfirPassword;
	
	@FXML
	private TextField txt_Np_Password;
	
	@FXML
	private TextField txt_Rc_Answer;
	
	@FXML
	private TextField txt_Rc_Password;
	
	@FXML
	private TextField txt_Rc_Username;
	
	@Override
	public void initialize (URL location, ResourceBundle resources) {
		cb_Rc_Question.setItems (givenEmploye.questionList ());
		cb_Fp_Question.setItems (givenEmploye.questionList ());
		
	}
	
	@FXML
	private void backToLoginForm () {
		anchP_LC_LoginForm.setVisible (true);
		anchP_FP_QuestionForm.setVisible (false);
		
	}
	
	@FXML
	private void backToQuestionForm () {
		anchP_FP_QuestionForm.setVisible (true);
		anchP_NP_NewPassForm.setVisible (false);
		
	}
	
	
	/**
	 * Performs the login action when the login button is clicked
	 */
	@FXML
	private void login () {
		String username = txt_Lc_Username.getText ();
		String password = txt_Lc_Password.getText ();
		
		// Validate the fields
		if (validateFields (username, password)) {
			// Check if the username and password are correct
			if (givenEmploye.getLogin (username, password)) {
				try {
					// Create a new stage for the dashboard view
					Stage stage = new Stage ();
					Image icon = new Image (
						Objects.requireNonNull (App.class.getResourceAsStream ("images/coffeeBeans.png")));
					FXMLLoader fxmlLoader = new FXMLLoader (App.class.getResource ("view/Dashboard_View.fxml"));
					Scene scene = new Scene (fxmlLoader.load ());
					
					// Set the title, icon, and scene for the stage
					stage.setTitle ("Cafe Shop");
					stage.getIcons ().add (icon);
					stage.setScene (scene);
					stage.show ();
					
					// Hide the login window
					btn_Lc_Login.getScene ().getWindow ().hide ();
				} catch (IOException e) {
					System.out.println ("Error in the window"+ e.toString ());
				}
			} else {
				// Display an error message for invalid username or password
				message.error ("Error", "Invalid username or password");
				txt_Lc_Username.setText ("");
				txt_Lc_Password.setText ("");
			}
		} else {
			// Display an error message for empty fields
			message.error ("Error", "Fields cannot be empty");
		}
	}
	
	/**
	 * Handles the proceed event when a button is pressed or an action is triggered.
	 * This method gathers information from the password recovery form, checks the
	 * validity of the fields, and, if they are valid, attempts to verify the user's
	 * credentials. If the credentials are correct, it displays the new password form.
	 * If the credentials are incorrect or the fields are not completed, it displays
	 * an error message and clears the fields.
	 *
	 * @param event The event that triggered this action.
	 */
	@FXML
	private void proceed (ActionEvent event) {
		// Get the value entered the username field
		String username = txt_Fp_Username.getText ();
		// Get the selected security question from the security question ComboBox
		String question = (String) cb_Fp_Question.getSelectionModel ().getSelectedItem ();
		// Get the entered answer from the security answer field
		String answer = txt_Fp_Answer.getText ();
		// Check if all fields are completed and valid
		if (! username.isEmpty () && question != null && ! answer.isEmpty ()) {
			// Attempt to verify the user's credentials
			int employeeId = givenEmploye.verifyUserCredentials (username, question, answer);
			// If the credentials are correct
			if (employeeId != - 1) {
				// Set the employee ID and clear the fields
				employees.setId (employeeId);
				txt_Fp_Username.setText ("");
				cb_Fp_Question.getSelectionModel ().clearSelection ();
				txt_Fp_Answer.setText ("");
				// Display the new password form and hide the security question form
				Platform.runLater (() -> {
					anchP_NP_NewPassForm.setVisible (true);
					anchP_FP_QuestionForm.setVisible (false);
				});
			} else {
				// If the credentials are incorrect, display an error message and clear the fields
				Platform.runLater (() -> {
					message.error ("Error Message", "Incorrect Information");
				});
				txt_Fp_Username.setText ("");
				cb_Fp_Question.getSelectionModel ().clearSelection ();
				txt_Fp_Answer.setText ("");
			}
		} else {
			// If not all fields are completed, display an error message
			Platform.runLater (() -> {
				message.error ("Error Message", "Please fill all blank fields");
			});
		}
	}
	
	/**
	 * Handles the changePassword event when a button is pressed or an action is triggered.
	 * This method checks if the new password and confirm password fields are not empty.
	 * If both fields are non-empty and the new password matches the confirm password,
	 * it updates the employee's password in the database and clears the input fields.
	 * If the passwords do not match, it displays an error message.
	 *
	 * @param event The event that triggered this action.
	 */
	@FXML
	private void changePassword(ActionEvent event) {
		// Check if both new password and confirm password fields are not empty
		if (!txt_Np_Password.getText().isEmpty() || !txt_Np_ConfirPassword.getText().isEmpty()) {
			// Check if the new password matches the confirmation password
			if (txt_Np_Password.getText().equals(txt_Np_ConfirPassword.getText())) {
				// Check if the new password meets the minimum length requirement
				if (txt_Np_Password.getText().length() >= 8) {
					// Update the employee's password in the database
					employees.setPassword(txt_Np_Password.getText());
					givenEmploye.changePasswordDB(employees);
					// Clear the input fields
					txt_Np_Password.setText("");
					txt_Np_ConfirPassword.setText("");
					anchP_LC_LoginForm.setVisible(true);
					anchP_NP_NewPassForm.setVisible(false);
				} else {
					// Display an error message if the password is too short
					message.error("Password", "La contraseña debe tener al menos 8 caracteres.");
				}
			} else {
				// Display an error message if the passwords do not match
				message.error("Password", "Las contraseñas deben coincidir.");
			}
		}
	}
	
	@FXML
	private void register (ActionEvent event) {
		
		if (validateFields (txt_Rc_Username.getText (), txt_Rc_Password.getText (),
			(String) cb_Rc_Question.getSelectionModel ().getSelectedItem (), txt_Rc_Answer.getText ())) {
			
			employees.setUsername (txt_Rc_Username.getText ());
			employees.setPassword (txt_Rc_Password.getText ());
			employees.setQuestion ((String) cb_Rc_Question.getSelectionModel ().getSelectedItem ());
			employees.setAnswer (txt_Rc_Answer.getText ());
			
			if (givenEmploye.registerUser (employees)) {
				message.information ("Usuario", "Successfully registered Account!");
				clearFields ();
				//Carrousel
				carrousel (anchP_SideForm);
				
			} else {
				clearFields ();
			}
		} else {
			message.error ("Error Message", "Please fill all blank fields");
		}
	}
	
	private void clearFields () {
		txt_Rc_Username.setText ("");
		txt_Rc_Password.setText ("");
		cb_Rc_Question.getSelectionModel ().clearSelection ();
		txt_Rc_Answer.setText ("");
	}
	
	/**
	 * Switches the form using a translation animation.
	 *
	 * @param event The event triggered by the source object.
	 */
	@FXML
	private void switchForm (ActionEvent event) {
		// Create a TranslateTransition with a duration of 0.5 seconds
		TranslateTransition slider = new TranslateTransition (Duration.seconds (0.5));
		slider.setNode (anchP_SideForm);
		if (event.getSource () == btn_Side_Create) {
			// Move the slider to the right (300 pixels) for the "Create" form
			slider.setToX (300);
			slider.setOnFinished (e -> {
				// Show the "Already Have" button and hide the "Create" button
				btn_Side_AllReadyHave.setVisible (true);
				btn_Side_Create.setVisible (false);
				
				// Hide the question form, show the login form, and hide the new password form
				anchP_FP_QuestionForm.setVisible (false);
				anchP_LC_LoginForm.setVisible (true);
				anchP_NP_NewPassForm.setVisible (false);
			});
		} else if (event.getSource () == btn_Side_AllReadyHave) {
			// Move the slider to the left (0 pixels) for the "Already Have" form
			slider.setToX (0);
			slider.setOnFinished (e -> {
				// Hide the "Already Have" button and show the "Create" button
				btn_Side_AllReadyHave.setVisible (false);
				btn_Side_Create.setVisible (true);
				
				// Hide the question form, show the login form, and hide the new password form
				anchP_FP_QuestionForm.setVisible (false);
				anchP_LC_LoginForm.setVisible (true);
				anchP_NP_NewPassForm.setVisible (false);
			});
		}
		// Start the animation
		slider.play ();
	}
	
	
	@FXML
	private void switchForgotPass (ActionEvent actionEvent) {
		anchP_FP_QuestionForm.setVisible (true);
		anchP_LC_LoginForm.setVisible (false);
		forgotPassquestionList ();
	}
	
	private void forgotPassquestionList () {
		List<String> listQ = new ArrayList<> ();
		
		for (Object data : givenEmploye.questionList ()) {
			listQ.add ((String) data);
		}
		ObservableList listData = FXCollections.observableArrayList (listQ);
		cb_Fp_Question.setItems (listData);
		
	}
	
	private boolean validateFields (String username, String password, String question, String answer) {
		return ! username.isEmpty () && ! password.isEmpty () && question != null && ! answer.isEmpty ();
	}
	
	private boolean validateFields (String username, String password) {
		return ! username.isEmpty () && ! password.isEmpty ();
	}
	
	public void carrousel (AnchorPane anchorPane) {
		TranslateTransition slider = new TranslateTransition ();
		slider.setNode (anchorPane);
		slider.setToX (0);
		slider.setDuration (Duration.seconds (0.5));
		
		slider.setOnFinished ((ActionEvent e) -> {
			btn_Side_AllReadyHave.setVisible (false);
			btn_Side_Create.setVisible (true);
		});
		slider.play ();
	}
	
}
