package application;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modal.Persona;
import modal.Producto;

public class Controlador7 implements Initializable {

	static Stage fivethStage;
	@FXML
	Text trabajadorAEditar;
	@FXML
	TextField txtNombre3;
	@FXML
	TextField txtApellidos;
	@FXML
	TextField txtDni;
	@FXML
	TextField txtUser;
	@FXML
	TextField txtPass;
	@FXML
	TextField txtFechaNacimiento;
	@FXML
	ComboBox puestoTrabajo;
	@FXML
	RadioButton rbHombre;
	@FXML
	RadioButton rbMujer;
	static String[] puestosTrabajo = {"caja",
			"reposicion",
			"reparticion"};
	@FXML
	ImageView okButton3;
	Persona p = null;
	int lastId;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for(String s : puestosTrabajo) {
			puestoTrabajo.getItems().add(s);
		}
		getLastId();
		System.out.println("Last id: " + lastId);

	}

	public void getLastId() {
		lastId = 0;
		for (Persona x : Controlador6.personasList) {
			lastId=x.getId();
		}
	}

	@FXML
	public void changeColour_2() {
		try {
			okButton3.setImage(new Image("file:OkIconFocused.png"));
		} catch (Exception e) {
			System.out.println("Image not loaded");
		}
	}

	@FXML
	public void changeColour2_2() {
		try {
			okButton3.setImage(new Image("file:OkIcon.png"));
		} catch (Exception e) {
			System.out.println("Image not loaded");
		}
	}

	@FXML
	public void saveWorker() {
		p = new Persona();
		getLastId();
		p.setId(lastId + 1);
		if (!txtNombre3.getText().isEmpty()) {
			p.setNombre(txtNombre3.getText());
		}
		if (!txtApellidos.getText().isEmpty()) {
			p.setApellidos(txtApellidos.getText());
		}
		if (!txtDni.getText().isEmpty()) {
			p.setDni(txtDni.getText());
		}
		if (!txtUser.getText().isEmpty()) {
			p.setUser(txtUser.getText());
		}
		if (!txtPass.getText().isEmpty()) {
			p.setPass(txtPass.getText());
		}
		if (!txtFechaNacimiento.getText().isEmpty()) {
			try {
				if(txtFechaNacimiento.getText().contains("/")) {
					txtFechaNacimiento.getText().replaceAll("/", "-");
				}
				p.setFechaNacimiento(Date.valueOf(txtFechaNacimiento.getText()));
			} catch (Exception e) {
				System.out.println("Default date");
				p.setFechaNacimiento(p.getFechaNacimiento());
			}
		}
		if(puestoTrabajo.getValue()!=null) {
			p.setPuestoTrabajo(puestoTrabajo.getValue().toString());
		}
		if(rbHombre.isSelected()) {
			p.setSexo("Hombre");
		}
		else if(rbMujer.isSelected()){
			p.setSexo("Mujer");
		}
		else if(!rbHombre.isSelected()&&!rbMujer.isSelected()) {
			p.setSexo("No definido");
		}

		Controlador6.personasList.add(p);

		// Para recargar tableView deberemos reiniciar la escena
		Main.cerrarScene(6);
		Main.abrir2Scene(6);

	}

	@FXML
	public void eraseAll3() {
		txtNombre3.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtUser.setText("");
		txtPass.setText("");
		txtFechaNacimiento.setText("");
		puestoTrabajo.setValue("");
	}

}
