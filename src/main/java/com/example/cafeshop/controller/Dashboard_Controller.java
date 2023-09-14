package com.example.cafeshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard_Controller implements Initializable {
	@FXML
	private AnchorPane AchPan_Custemers;
	
	@FXML
	private AnchorPane AchPan_Dashboard;
	
	@FXML
	private AnchorPane AchPan_Menu;
	
	@FXML
	private AnchorPane AchPan_Stock;
	
	@FXML
	private TableView<?> Table_customers;
	
	@FXML
	private Button btn_Customers;
	
	@FXML
	private Button btn_Dashboard;
	
	@FXML
	private Button btn_Logout;
	
	@FXML
	private Button btn_Menu;
	
	@FXML
	private Button btn_Menu_Pay;
	
	@FXML
	private Button btn_Menu_Recipt;
	
	@FXML
	private Button btn_Menu_Remove;
	
	@FXML
	private Button btn_Stock;
	
	@FXML
	private Button btn_Stock_Add;
	
	@FXML
	private Button btn_Stock_Clear;
	
	@FXML
	private Button btn_Stock_Delete;
	
	@FXML
	private Button btn_Stock_Import;
	
	@FXML
	private Button btn_Stock_Update;
	
	@FXML
	private ComboBox<?> cbx_Stock_Status;
	
	@FXML
	private ComboBox<?> cbx_Stock_Type;
	
	@FXML
	private TableColumn<?, ?> col_Menu_Price;
	
	@FXML
	private TableColumn<?, ?> col_Menu_ProductName;
	
	@FXML
	private TableColumn<?, ?> col_Menu_Quantity;
	
	@FXML
	private TableColumn<?, ?> col_Stock_Date;
	
	@FXML
	private TableColumn<?, ?> col_Stock_Price;
	
	@FXML
	private TableColumn<?, ?> col_Stock_ProductID;
	
	@FXML
	private TableColumn<?, ?> col_Stock_ProductName;
	
	@FXML
	private TableColumn<?, ?> col_Stock_Status;
	
	@FXML
	private TableColumn<?, ?> col_Stock_Stock;
	
	@FXML
	private TableColumn<?, ?> col_Stock_Type;
	
	@FXML
	private TableColumn<?, ?> customers_Col_Cashier;
	
	@FXML
	private TableColumn<?, ?> customers_Col_Date;
	
	@FXML
	private TableColumn<?, ?> customers_Col_ID;
	
	@FXML
	private TableColumn<?, ?> customers_Col_Total;
	
	@FXML
	private BarChart<?, ?> dashboard_CustomerChart;
	
	@FXML
	private AreaChart<?, ?> dashboard_IncomeChart;
	
	@FXML
	private ImageView imaV_Stock_Image;
	
	@FXML
	private Label labe_Dashb_CostumerNumber;
	
	@FXML
	private Label labe_Dashb_NumberSoldProd;
	
	@FXML
	private Label labe_Dashb_TodayIncome;
	
	@FXML
	private Label labe_Dashb_TotalIncome;
	
	@FXML
	private Label label_Username;
	
	@FXML
	private TextField menu_Amount;
	
	@FXML
	private Label menu_Change;
	
	@FXML
	private ScrollPane menu_ScrollPane;
	
	@FXML
	private Label menu_Total;
	
	@FXML
	private TableView<?> table_Menu;
	
	@FXML
	private TableView<?> table_Stock;
	
	@FXML
	private TextField txt_Stock_Price;
	
	@FXML
	private TextField txt_Stock_ProductID;
	
	@FXML
	private TextField txt_Stock_ProductName;
	
	@FXML
	private TextField txt_Stock_Stock;
	@Override
	public void initialize (URL location, ResourceBundle resources) {
	
	}
	public void closeWindows () {
		Stage myStage = new Stage ();
		myStage.close ();
	}
	@FXML
	public void Logout (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void addStock (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void clearStock (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void deleteStock (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void importImage (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void menuAmount (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void payMenu (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void recipt_Menu (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void removeMenu (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void switchForm (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
		
	}
	
	@FXML
	public void updateStock (ActionEvent event) {
		System.out.println ("Estamos trabajando en ello");
	}
}
