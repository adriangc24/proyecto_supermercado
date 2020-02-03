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
	Stage primaryStage;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
	}
	
	@FXML
	public void onClick() {
		imgLogin.setOpacity(0);
		
		System.out.println("Clicked");
	}
	@FXML
	public void onReleased() {
		imgLogin.setOpacity(100);
		System.out.println("released");

	}
	private void closeWindowEvent(WindowEvent event) {
     if(event.equals(WindowEvent.WINDOW_CLOSE_REQUEST)) {
    	 System.out.println("Window closing");
    	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.getButtonTypes().remove(ButtonType.OK);
         alert.getButtonTypes().add(ButtonType.CANCEL);
         alert.getButtonTypes().add(ButtonType.YES);
         alert.setTitle("Quit application");
         alert.setContentText(String.format("Close without saving?"));
         Optional<ButtonType> res = alert.showAndWait();

         if(res.isPresent()) {
             if(res.get().equals(ButtonType.CANCEL))
                 event.consume();
         }
     }
     
	}
	

}
