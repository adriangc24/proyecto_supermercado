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
import javafx.geometry.Pos;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
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
import javafx.util.Callback;
import modal.Persona;
import modal.Producto;

public class Controlador6 implements Initializable {

	static Stage thirdStage;
	@FXML
	ImageView backButton;
	@FXML
	TableView<Persona> tabla;
	@FXML
	TableColumn<Persona, Integer> idPersona;
	@FXML
	TableColumn<Persona, String> dniPersona;
	@FXML
	TableColumn<Persona, String> nombrePersona;
	@FXML
	TableColumn<Persona, String> apellidosPersona;
	@FXML
	TableColumn<Persona, String> userPersona;
	@FXML
	TableColumn<Persona, Date> fechaPersona;
	@FXML
	TableColumn<Persona, String> puestoPersona;
	@FXML
	TableColumn<Persona, CheckBox> trabajandoPersona;
	
	boolean aux=false;
	static Producto p;
	static MultipleSelectionModel<Persona> seleccion;
	static ObservableList<Integer> selecIndex;
	static int selecSingIndex;
	static ArrayList<Persona> personasList = new ArrayList();
	static ObservableList<Persona> personas;
	int tam;
	CheckBox si = new CheckBox();
	CheckBox no = new CheckBox();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		si.setSelected(true);
		no.setSelected(false);
		
		
		if (Main.contador2 == 0) {
			System.out.println(Main.contador);
			cargarDatosDefault();
		} else
			cargarDatos();

		nombrePersona.setOnEditCommit(new EventHandler<CellEditEvent<Persona, String>>() {
			public void handle(CellEditEvent<Persona, String> t) {
				((Persona) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNombre(t.getNewValue());
			}
		});
		dniPersona.setOnEditCommit(new EventHandler<CellEditEvent<Persona, String>>() {
			public void handle(CellEditEvent<Persona, String> t) {
				((Persona) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDni(t.getNewValue());
			}
		});
		apellidosPersona.setOnEditCommit(new EventHandler<CellEditEvent<Persona, String>>() {
			public void handle(CellEditEvent<Persona, String> t) {
				((Persona) t.getTableView().getItems().get(t.getTablePosition().getRow())).setApellidos(t.getNewValue());
			}
		});
		userPersona.setOnEditCommit(new EventHandler<CellEditEvent<Persona, String>>() {
			public void handle(CellEditEvent<Persona, String> t) {
				((Persona) t.getTableView().getItems().get(t.getTablePosition().getRow())).setUser(t.getNewValue());
			}
		});
		fechaPersona.setOnEditCommit(new EventHandler<CellEditEvent<Persona, Date>>() {
			public void handle(CellEditEvent<Persona, Date> t) {
				((Persona) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFechaNacimiento(t.getNewValue());
			}
		});
		puestoPersona.setOnEditCommit(new EventHandler<CellEditEvent<Persona, String>>() {
			public void handle(CellEditEvent<Persona, String> t) {
				for(String s : Controlador7.puestosTrabajo) {
					if(s.equalsIgnoreCase(t.getNewValue())) {
						aux=true;
					}
				}
				if(aux) {
					((Persona) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPuestoTrabajo(t.getNewValue());
				}
				else {
					((Persona) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPuestoTrabajo(t.getOldValue());
				}
				aux=false;
			}
		});
		trabajandoPersona.setOnEditCommit(new EventHandler<CellEditEvent<Persona, CheckBox>>() {
			public void handle(CellEditEvent<Persona, CheckBox> t) {
				((Persona) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTrabajando(true);
			}
		});
		

	}

	public void cargarDatos() {
		personas = FXCollections.observableArrayList(personasList);

		PropertyValueFactory pvId = new PropertyValueFactory<Persona, Integer>("id");
		idPersona.setCellValueFactory(pvId);
		PropertyValueFactory pvDni = new PropertyValueFactory<Persona, String>("dni");
		dniPersona.setCellValueFactory(pvDni);
		PropertyValueFactory pvNombre = new PropertyValueFactory<Persona, String>("nombre");
		nombrePersona.setCellValueFactory(pvNombre);
		PropertyValueFactory pvApellidos = new PropertyValueFactory<Persona, String>("apellidos");
		apellidosPersona.setCellValueFactory(pvApellidos);
		PropertyValueFactory pvUser = new PropertyValueFactory<Persona, String>("user");
		userPersona.setCellValueFactory(pvUser);
		PropertyValueFactory pvFecha = new PropertyValueFactory<Persona, Date>("fechaNacimiento");
		fechaPersona.setCellValueFactory(pvFecha);
		PropertyValueFactory pvPuesto = new PropertyValueFactory<Persona, String>("puestoTrabajo");
		puestoPersona.setCellValueFactory(pvPuesto);
		PropertyValueFactory pvTrabajando = new PropertyValueFactory<Persona, CheckBox>("trabajando");
		trabajandoPersona.setCellValueFactory(pvTrabajando);

		tabla.setItems(personas);

		// idPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		dniPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		nombrePersona.setCellFactory(TextFieldTableCell.forTableColumn());
		apellidosPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		apellidosPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		userPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		//fechaPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		puestoPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		/*trabajandoPersona.setCellFactory(new Callback<TreeTableColumn<Persona,CheckBox>,TreeTableCell<Persona,CheckBox>>() {
		    @Override 
		    public TreeTableCell<Persona,CheckBox> call( TreeTableColumn<Persona,CheckBox> p ) {
		        CheckBoxTreeTableCell<Persona,CheckBox> cell = new CheckBoxTreeTableCell<Persona,CheckBox>();
		        cell.setAlignment(Pos.CENTER);
		        return cell;
		    }
		});*/

		tabla.setEditable(true);
	}

	private void cargarDatosDefault() {
		Main.contador2 += 1;
		Persona p1 = new Persona(1, "48025635x", "Pepe", "Gonzalez", "pepe.gonzalez", "123456",
				Date.valueOf("1998-11-09"), "caja",new CheckBox());
		Persona p2 = new Persona(2, "46326594v", "Laura", "Perez", "laura.perez", "1524258", Date.valueOf("2000-09-08"),
				"reparticion",new CheckBox());
		Persona p3 = new Persona(3, "46546519e", "Montse", "Monteagudo", "montse.monteagudo", "634654561",
				Date.valueOf("1978-02-15"), "reposicion",new CheckBox());
		Persona p4 = new Persona(4, "46416541t", "Julio", "Aguirre", "julio.aguirre", "16741654",
				Date.valueOf("1995-01-18"), "caja",new CheckBox());

		personasList.add(p1);
		personasList.add(p2);
		personasList.add(p3);
		personasList.add(p4);

		personas = FXCollections.observableArrayList(personasList);

		PropertyValueFactory pvId = new PropertyValueFactory<Persona, Integer>("id");
		idPersona.setCellValueFactory(pvId);
		PropertyValueFactory pvDni = new PropertyValueFactory<Persona, String>("dni");
		dniPersona.setCellValueFactory(pvDni);
		PropertyValueFactory pvNombre = new PropertyValueFactory<Persona, String>("nombre");
		nombrePersona.setCellValueFactory(pvNombre);
		PropertyValueFactory pvApellidos = new PropertyValueFactory<Persona, String>("apellidos");
		apellidosPersona.setCellValueFactory(pvApellidos);
		PropertyValueFactory pvUser = new PropertyValueFactory<Persona, String>("user");
		userPersona.setCellValueFactory(pvUser);
		PropertyValueFactory pvFecha = new PropertyValueFactory<Persona, Date>("fechaNacimiento");
		fechaPersona.setCellValueFactory(pvFecha);
		PropertyValueFactory pvPuesto = new PropertyValueFactory<Persona, String>("puestoTrabajo");
		puestoPersona.setCellValueFactory(pvPuesto);
		PropertyValueFactory pvTrabajando = new PropertyValueFactory<Persona, CheckBox>("trabajando");
		trabajandoPersona.setCellValueFactory(pvTrabajando);

		tabla.setItems(personas);

		// idPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		dniPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		nombrePersona.setCellFactory(TextFieldTableCell.forTableColumn());
		apellidosPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		apellidosPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		userPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		//fechaPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		puestoPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		// trabajandoPersona.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		tabla.setEditable(true);
	}

	public void recargarTabla() {
		if (personasList.isEmpty()) {
			System.out.println("Array personas vacio");
		} else {
			for (Persona x : personasList) {
				personas.add(x);
			}

			tabla.setItems(personas);
		}
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
		Main.abrirVentana(7);
	}

	@FXML
	public void deleteWorker() {
		tabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		seleccion = tabla.getSelectionModel();
		selecSingIndex = seleccion.getSelectedIndex();
		personasList.remove(selecSingIndex);
		personas.remove(selecSingIndex);
		recargarTabla();

		Main.cerrarScene(6);
		Main.abrir2Scene(6);

		// **** MULTIPLE ROW DELETE ????
		/*
		 * tabla.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); seleccion
		 * = tabla.getSelectionModel(); selecIndex = seleccion.getSelectedIndices(); tam
		 * = selecIndex.size(); int indice = 0; for (int i = tam - 1; i >= 0; i--) {
		 * indice = selecIndex.get(i); personasList.remove(indice);
		 * personas.remove(indice); } recargarTabla();
		 * 
		 * Main.cerrarScene(6); Main.abrir2Scene(6);
		 */

	}

}
