package application;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

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

public class Controlador3 implements Initializable {

	static Stage thirdStage;
	@FXML
	ImageView backButton;
	@FXML
	ListView listaProductos;
	static Producto p;
	static MultipleSelectionModel<String> seleccion;
	static ObservableList<Integer> selecIndex;
	static int selecSingIndex;
	static ArrayList<Producto> productsList = new ArrayList();
	static ObservableList<String> productos = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listaProductos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		if (productsList.isEmpty()) {
			// creamos objetos productos
			Producto p0 = new Producto(0, "Atún calvo", "Atún con aceite de girasol", 2.50f, 3, "pescados", "calvo",
					Date.valueOf("2020-05-23"));
			productsList.add(p0);
			Producto p1 = new Producto(1, "Ganchitos", "Snack de queso", 1.2f, 1, "snacks", "cheetos",
					Date.valueOf("2020-09-08"));
			productsList.add(p1);
			Producto p2 = new Producto(2, "Gambas", "Kilo de gambas de huelva", 12f, 1, "pescados y mariscos",
					"pescanova", Date.valueOf("2020-02-19"));
			productsList.add(p2);
			Producto p3 = new Producto(3, "Nutella", "Crema de chocolate", 2.0f, 1, "snacks", "ferrero",
					Date.valueOf("2025-11-03"));
			productsList.add(p3);
			Producto p4 = new Producto(4, "Banana", "Kilo Banana canaria", 0.8f, 1, "frutas y verduras",
					"platano de canarias", Date.valueOf("2020-02-30"));
			productsList.add(p4);
		}
		else {
			productos.clear();
		}
			for (Producto x : productsList) {
				productos.add(x.toString());
			}
		
		listaProductos.setItems(productos);


	}

	@FXML
	public void volverAtras() {
		Main.abrir2Scene(2);
	}

	@FXML
	public void changeColour() {
		try {
			backButton.setImage(new Image("file:buttonFocused.png"));
		} catch (Exception e) {
			System.out.println("Image not loaded");
		}
	}

	@FXML
	public void changeColour2() {
		try {
			backButton.setImage(new Image("file:go-back-button-png.png"));
		} catch (Exception e) {
			System.out.println("Image not loaded");
		}
	}

	@FXML
	public void addProduct() {
		Main.abrirVentana(4);
	}

	@FXML
	public void editProduct() {
		listaProductos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		seleccion = listaProductos.getSelectionModel();
		selecSingIndex = seleccion.getSelectedIndex();
		Main.abrirVentana(4);

	}

	@FXML
	public void deleteProduct() {
		listaProductos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		seleccion = listaProductos.getSelectionModel();
		selecIndex = seleccion.getSelectedIndices();

	}
}
