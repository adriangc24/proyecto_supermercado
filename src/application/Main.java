package application;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
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
	@Override
	public void start(Stage primaryStage) {
		try {
			stagePrincipal = primaryStage;
			clase = getClass();
			// BorderPane root = new BorderPane();
			// 1st Stage
			Parent root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));
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

	public static void abrir2Scene() {
		// 2nd Scene
		try {
			Parent root2 = FXMLLoader.load(clase.getResource("Ventana2.fxml"));
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


	public static void main(String[] args) {
		launch(args);
	}
}
