package laboratorio1;

import Controller.ControllerMain;
import SampleClasses.Evento;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16
 * @time 10:13:20
 */
public class Laboratorio1 extends Application {
    
    //lista y controlador
    public static ArrayList<Evento> listEventos = new ArrayList<>();
    public static ControllerMain cm;
    
    //metodo start para iniciar la vista principal
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Basic Calc MVC JavaFX");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/mainMneu.fxml"));
        Parent root = loader.load();
        cm = (ControllerMain)loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    //main
    public static void main(String[] args) throws IOException {
        launch(args);
    }

}
