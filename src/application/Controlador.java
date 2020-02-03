package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controlador implements Initializable{
	@FXML
	private TextField txtUser;
	@FXML
	private TextField txtPass;
	@FXML
	public Button botonLogin;
	@FXML
	private ImageView imgLogin;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	public void onClick() {
		imgLogin.setOpacity(0);
	}
	public void onRelease() {
		imgLogin.setOpacity(100);
	}
	

}
