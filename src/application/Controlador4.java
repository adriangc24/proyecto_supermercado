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

public class Controlador4 implements Initializable {

	static Stage fourthStage;
	@FXML
	Text productoAEditar;

	@FXML
	TextField txtNombre;
	@FXML
	TextField txtDescripcion;
	@FXML
	TextField txtPrecioSinIva;
	@FXML
	TextField txtCantidad;
	@FXML
	TextField txtCategoria;
	@FXML
	TextField txtMarca;
	@FXML
	TextField txtFechaVencimiento;
	@FXML
	ImageView okButton;
	Producto p = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int indice = Controlador3.selecSingIndex;
		String s = Controlador3.productos.get(Controlador3.selecSingIndex);
		System.out.println(String.valueOf(indice));
		for (Producto x : Controlador3.productsList) {
			if (x.getId() == indice) {
				p = x;
			}
		}
		if (p == null) {
			System.out.println("Producto no encontrado");
		}

		productoAEditar.setText(productoAEditar.getText() + p.getNombre());
		txtNombre.setPromptText(p.getNombre());
		txtDescripcion.setPromptText(p.getDescripcion());
		txtPrecioSinIva.setPromptText(String.valueOf(p.getPrecioSinIva()));
		txtCantidad.setPromptText(String.valueOf(p.getCantidad()));
		txtCategoria.setPromptText(p.getCategoria());
		txtMarca.setPromptText(p.getMarca());
		txtFechaVencimiento.setPromptText(String.valueOf(p.getFechaVencimiento()));

	}

	@FXML
	public void changeColour() {
		try {
			okButton.setImage(new Image("file:OkIconFocused.png"));
		} catch (Exception e) {
			System.out.println("Image not loaded");
		}
	}

	@FXML
	public void changeColour2() {
		try {
			okButton.setImage(new Image("file:OkIcon.png"));
		} catch (Exception e) {
			System.out.println("Image not loaded");
		}
	}

	@FXML
	public void saveProduct() {
		if (!txtNombre.getText().isEmpty()) {
			p.setNombre(txtNombre.getText());
		}
		if (!txtMarca.getText().isEmpty()) {
			p.setMarca(txtMarca.getText());
		}
		if (!txtDescripcion.getText().isEmpty()) {
			p.setDescripcion(txtDescripcion.getText());
		}
		if (!txtPrecioSinIva.getText().isEmpty()) {
			p.setPrecioSinIva(Float.valueOf(txtPrecioSinIva.getText()));
		}
		if (!txtCantidad.getText().isEmpty()) {
			p.setCantidad(Integer.valueOf(txtCantidad.getText()));
		}
		if (!txtCategoria.getText().isEmpty()) {
			p.setCategoria(txtCategoria.getText());
		}
		if (!txtFechaVencimiento.getText().isEmpty()) {
			p.setFechaVencimiento(Date.valueOf(txtFechaVencimiento.getText()));
		}

		Controlador3.productsList.set(p.getId(), p);
		Main.cerrarVentana(4);
	}

	@FXML
	public void eraseAll() {
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtPrecioSinIva.setText("");
		txtCantidad.setText("");
		txtCategoria.setText("");
		txtMarca.setText("");
		txtFechaVencimiento.setText("");
	}

}
