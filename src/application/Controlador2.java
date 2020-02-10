package application;


import java.net.URL;
import java.time.Instant;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controlador2 implements Initializable{
	
	static Stage secondStage;
	@FXML
	MenuItem cerrarSesion;
	@FXML
	public Text txtBienvenida;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String fecha=Instant.now().toString();
		txtBienvenida.setText(txtBienvenida.getText()+Controlador.usuario+" !\n\nFecha actual: "+fecha.substring(0,fecha.length()-14));
	}

	@FXML
	public void logOut() {
		System.out.println("LogOut");
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Alerta de cierre de sesion");
		alert.setHeaderText("Seguro que quieres cerrar la sesion?");
		alert.setContentText("Elige tu opción:");
		ButtonType buttonTypeOne = new ButtonType("Si");
		ButtonType buttonTypeCancel = new ButtonType("No", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne) {
			System.out.println("OK");
			Main.cerrar2Scene();
		} else {
			System.out.println("CANCEL");

		}
	}
	@FXML
	public void manageProducts() {
		Main.abrir2Scene(3);
	}
	@FXML
	public void manageWorkers() {
		Main.abrir2Scene(6);
	}
	

}
