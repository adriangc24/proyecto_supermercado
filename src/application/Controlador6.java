package application;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
	@FXML
	TableColumn<Persona,Integer> idPersona;
	@FXML
	TableColumn<Persona,String> dniPersona;
	@FXML
	TableColumn<Persona,String> nombrePersona;
	@FXML
	TableColumn<Persona,String> apellidosPersona;
	@FXML
	TableColumn<Persona,String> userPersona;
	@FXML
	TableColumn<Persona,String> fechaPersona;
	@FXML
	TableColumn<Persona,String> puestoPersona;
	@FXML
	TableColumn<Persona,CheckBox> trabajandoPersona;
	
	static Producto p;
	static MultipleSelectionModel<String> seleccion;
	static ObservableList<Integer> selecIndex;
	static int selecSingIndex;
	static ArrayList<Persona> personasList = new ArrayList();
	static ObservableList<Persona> personas;
	int tam;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Persona p1 = new Persona(1,"48025635x","Pepe","Gonzalez","pepe.gonzalez","123456",getDate(3,3,2000),"cajero",Persona.setEstado(true));
		Persona p2 = new Persona(2,"46326594v","Laura","Perez","laura.perez","1524258",getDate(8,1,1998),"repartidora",Persona.setEstado(false));
		Persona p3 = new Persona(3,"46546519e","Montse","Monteagudo","montse.monteagudo","634654561",getDate(7,3,1989),"reponedora",Persona.setEstado(true));
		Persona p4 = new Persona(4,"46416541t","Julio","Aguirre","julio.aguirre","16741654",getDate(3,3,2000),"cajero",Persona.setEstado(true));
		
		personasList.add(p1);
		personasList.add(p2);
		personasList.add(p3);
		personasList.add(p4);
		
		personas = FXCollections.observableArrayList(personasList);
		
		PropertyValueFactory pvId = new PropertyValueFactory<Persona,Integer>("id");
		idPersona.setCellValueFactory(pvId);
		PropertyValueFactory pvDni = new PropertyValueFactory<Persona,String>("dni");
		dniPersona.setCellValueFactory(pvDni);
		PropertyValueFactory pvNombre = new PropertyValueFactory<Persona,String>("nombre");
		nombrePersona.setCellValueFactory(pvNombre);
		PropertyValueFactory pvApellidos = new PropertyValueFactory<Persona,String>("apellidos");
		apellidosPersona.setCellValueFactory(pvApellidos);
		PropertyValueFactory pvUser = new PropertyValueFactory<Persona,String>("user");
		userPersona.setCellValueFactory(pvUser);
		PropertyValueFactory pvFecha = new PropertyValueFactory<Persona,String>("fechaNacimiento");
		fechaPersona.setCellValueFactory(pvFecha);
		PropertyValueFactory pvPuesto = new PropertyValueFactory<Persona,String>("puestoTrabajo");
		puestoPersona.setCellValueFactory(pvPuesto);
		PropertyValueFactory pvTrabajando = new PropertyValueFactory<Persona,CheckBox>("trabajando");
		trabajandoPersona.setCellValueFactory(pvTrabajando);
		
		tabla.setItems(personas);
		
		//idPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		dniPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		nombrePersona.setCellFactory(TextFieldTableCell.forTableColumn());
		apellidosPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		apellidosPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		userPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		fechaPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		puestoPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		//trabajandoPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		tabla.setEditable(true);

	
	}

	public String getDate(int n1,int n2,int n3) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String fecha = sdf.format(new Date(n1, n2, n3));
		System.out.println(fecha);
		return fecha;
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
			personasList.remove(indice);
			personasList.remove(indice);
		}
		Main.cerrarScene(3);
		Main.abrir2Scene(3);
	}
	
}
