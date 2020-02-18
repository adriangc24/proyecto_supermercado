package application;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	static Stage stagePrincipal;
	static Class clase;
	static Scene scene;
	static Stage stage;
	static Parent root;
	static int contador = 0;

	@Override
	public void start(Stage primaryStage) {
		try {
			stagePrincipal = primaryStage;
			clase = getClass();
			// BorderPane root = new BorderPane();
			root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));
			scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stagePrincipal.setScene(scene);
			stagePrincipal.setMaximized(true);
			stagePrincipal.show();
			stagePrincipal.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					System.out.println("closing");
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Alerta de cierre");
					alert.setHeaderText("Seguro que quieres cerrar la ventana?");
					alert.setContentText("Elige tu opción:");
					ButtonType buttonTypeOne = new ButtonType("Si");
					ButtonType buttonTypeCancel = new ButtonType("No", ButtonData.CANCEL_CLOSE);
					alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == buttonTypeOne) {
						System.out.println("OK");
						primaryStage.close();
						// debemos cerrar el programa entero para que en caso de que haya otros stages
						// abiertos se cierren
						Platform.exit();
						System.exit(0);

					} else {
						System.out.println("CANCEL");

					}
					event.consume();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void abrir2Scene(int numeroVentana) {
		try {
			Parent root2 = FXMLLoader.load(clase.getResource("Ventana" + numeroVentana + ".fxml"));
			Scene scene2 = new Scene(root2, 1920, 1080);
			scene2.getStylesheets().add(clase.getResource("application.css").toExternalForm());
			stagePrincipal.setScene(scene2);
			stagePrincipal.setMaximized(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void cerrar2Scene() {
		Parent root;
		try {
			root = FXMLLoader.load(clase.getResource("Ventana.fxml"));
			Scene scene = new Scene(root, 1920, 1080);
			scene.getStylesheets().add(clase.getResource("application.css").toExternalForm());
			stagePrincipal.setScene(scene);
			stagePrincipal.setMaximized(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void cerrarScene(int numeroVentana) {
		Parent root;
		try {
			root = FXMLLoader.load(clase.getResource("Ventana" + numeroVentana + ".fxml"));
			Scene scene = new Scene(root, 1920, 1080);
			scene.getStylesheets().add(clase.getResource("application.css").toExternalForm());
			stagePrincipal.setScene(scene);
			stagePrincipal.setMaximized(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void abrirVentana(int numeroVentana) {
		try {
			root = FXMLLoader.load(clase.getResource("Ventana" + numeroVentana + ".fxml"));
			stage = new Stage();
			stage.setResizable(false);
			if (numeroVentana == 7) {
				stage.setScene(new Scene(root, 875, 650));
			} else {
				stage.setScene(new Scene(root, 875, 680));
			}
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void cerrarVentana(int numeroVentana) {
		try {
			root = FXMLLoader.load(clase.getResource("Ventana" + numeroVentana + ".fxml"));
			stage.setScene(new Scene(root, 875, 680));
			stage.close();
		} catch (Exception e) {
			System.out.println("No se pudo cerrar la ventana");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
