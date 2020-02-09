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
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modal.Producto;

public class Controlador5 implements Initializable {

	static Stage fivethStage;
	@FXML
	Text productoAEditar2;

	@FXML
	TextField txtNombre2;
	@FXML
	TextField txtDescripcion2;
	@FXML
	TextField txtPrecioSinIva2;
	@FXML
	TextField txtCantidad2;
	@FXML
	TextField txtCategoria2;
	@FXML
	TextField txtMarca2;
	@FXML
	TextField txtFechaVencimiento2;
	@FXML
	ImageView okButton2;
	Producto p = null;
	int lastId;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		productoAEditar2.setText("Producto a crear: ");
		getLastId();
		System.out.println("Last id: "+lastId);

	}
	public void getLastId() {
		lastId=-1;
		for(Producto x : Controlador3.productsList) {
			lastId++;
		}
	}

	@FXML
	public void changeColour_2() {
		try {
			okButton2.setImage(new Image("file:OkIconFocused.png"));
		} catch (Exception e) {
			System.out.println("Image not loaded");
		}
	}

	@FXML
	public void changeColour2_2() {
		try {
			okButton2.setImage(new Image("file:OkIcon.png"));
		} catch (Exception e) {
			System.out.println("Image not loaded");
		}
	}

	@FXML
	public void saveProduct2() {
		p=new Producto();
		getLastId();
		p.setId(lastId+1);
		if (!txtNombre2.getText().isEmpty()) {
			p.setNombre(txtNombre2.getText());
		}
		if (!txtMarca2.getText().isEmpty()) {
			p.setMarca(txtMarca2.getText());
		}
		if (!txtDescripcion2.getText().isEmpty()) {
			p.setDescripcion(txtDescripcion2.getText());
		}
		if (!txtPrecioSinIva2.getText().isEmpty()&&txtPrecioSinIva2.getText().matches(".*\\d.*")) {
			p.setPrecioSinIva(Float.valueOf(txtPrecioSinIva2.getText()));
		}
		if (!txtCantidad2.getText().isEmpty()&&txtCantidad2.getText().matches(".*\\d.*")) {
			p.setCantidad(Integer.valueOf(txtCantidad2.getText()));
		}
		if (!txtCategoria2.getText().isEmpty()) {
			p.setCategoria(txtCategoria2.getText());
		}
		if (!txtFechaVencimiento2.getText().isEmpty()) {
			try {
				if(txtFechaVencimiento2.getText().contains("/")) {
					txtFechaVencimiento2.getText().replaceAll("/", "-");
				}
				p.setFechaVencimiento(Date.valueOf(txtFechaVencimiento2.getText()));
			} catch (Exception e) {
				System.out.println("Default date");
				p.setFechaVencimiento(p.getFechaVencimiento());
			}
		}

		Controlador3.productsList.add(p);

		// Para recargar listView deberemos reiniciar la escena
		Main.cerrarScene(3);
		Main.abrir2Scene(3);

	}

	@FXML
	public void eraseAll2() {
		txtNombre2.setText("");
		txtDescripcion2.setText("");
		txtPrecioSinIva2.setText("");
		txtCantidad2.setText("");
		txtCategoria2.setText("");
		txtMarca2.setText("");
		txtFechaVencimiento2.setText("");
	}

}
