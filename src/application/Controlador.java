package application;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controlador implements Initializable{
	@FXML
	private TextField txtUser;
	@FXML
	private TextField txtPass;
	@FXML
	public Button botonLogin;
	@FXML
	private ImageView imgLogin;
	public static String usuario;
	public static Stage primaryStage;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
	}
	
	@FXML
	public void onClick() {		
		System.out.println("Clicked");
		if(!txtUser.getText().isEmpty()&&!txtPass.getText().isEmpty()) {
			usuario=txtUser.getText();
			Main.abrir2Scene(2);
		}
	}
	@FXML
	public void enter() {
		imgLogin.setImage(new Image("file:loginFocused.png"));
	}
	@FXML
	public void exit() {
		imgLogin.setImage(new Image("file:login-square-arrow-button-outline_icon-icons.com_73220.png"));
	}
	

}
