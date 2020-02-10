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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

public class Controlador6 implements Initializable {

	static Stage thirdStage;
	@FXML
	ImageView backButton;
	@FXML
	TableView<Persona> tabla;
	static Producto p;
	static MultipleSelectionModel<String> seleccion;
	static ObservableList<Integer> selecIndex;
	static int selecSingIndex;
	static ArrayList<Producto> productsList = new ArrayList();
	static ObservableList<String> productos = FXCollections.observableArrayList();
	int tam;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
	public void addWorker() {
		Main.abrirVentana(5);
	}

	@FXML
	public void editWorker() {
		tabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		selecSingIndex = seleccion.getSelectedIndex();
		Main.abrirVentana(4);

	}

	@FXML
	public void deleteWorker() {
		tabla.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		selecIndex = seleccion.getSelectedIndices();
		tam = selecIndex.size();
		int indice = 0;
		for (int i = tam - 1; i >= 0; i--) {
			indice = selecIndex.get(i);
			productsList.remove(indice);
			productos.remove(indice);
		}
		Main.cerrarScene(3);
		Main.abrir2Scene(3);
	}
}
