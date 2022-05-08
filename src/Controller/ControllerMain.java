package Controller;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16
 * @time 10:13:20
 */

//imports
import java.net.URL;
import java.util.ResourceBundle;
import Model.ModelEvent;
import SampleClasses.Evento;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import laboratorio1.Laboratorio1;

public class ControllerMain implements Initializable {
    
    //Componentes de la vista y variables
    public ModelEvent model;
    @FXML
    private Button addButton;
    @FXML
    private Button quitButton;
    @FXML
    private Button requestButton;
    @FXML
    private TextField textoField;
    private String codigo;
    private String archivo;
    FXMLLoader loader;
    Parent root;
    Scene scene;
    Stage stage;
    
    //accion al apretar un boton
    public void handleButtonClick(ActionEvent event) throws IOException {
        //accion al apretar boton añadir
        if (event.getSource() == addButton) {
            loader = new FXMLLoader(getClass().getResource("/views/guestView.fxml"));
            root = loader.load();
            scene = new Scene(root);
            stage = new Stage();
            stage.setTitle("Add Guest");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(addButton.getScene().getWindow());
            if (textoField.getText().length() == 7) {
                if (model.searchEvent(textoField.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Este evento ya existe, porfavor ingrese uno nuevo.");
                } else {
                    Laboratorio1.listEventos.add(new Evento(textoField.getText(), 0));
                    model.rewrite();
                    codigo = textoField.getText();
                    boolean opcion = false;
                    while (opcion == false) {
                        archivo = JOptionPane.showInputDialog("Ingrese el nombre de la lista que desea escoger: \n  20inv \n  10inv \n  15inv");
                        switch (archivo) {
                            case "20inv":
                                opcion = true;
                                break;
                            case "15inv":
                                opcion = true;
                                break;
                            case "10inv":
                                opcion = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Esa opcion no existe!");
                        }
                    }
                    stage.show();
                }
            } else {
                JOptionPane.showMessageDialog(null, "El codigo del evento debe de ser de 7 caracteres.");
            }
        }
        //accion al apretar Consultar
        if (event.getSource() == requestButton) {
            loader = new FXMLLoader(getClass().getResource("/views/requestView.fxml"));
            root = loader.load();
            scene = new Scene(root);
            stage = new Stage();
            stage.setTitle("Add Guest");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(addButton.getScene().getWindow());
            if (textoField.getText().length() == 7) {
                codigo = textoField.getText();
                for (Evento evnt : Laboratorio1.listEventos) {
                    if (evnt.getCodigo().equals(codigo)) {
                        archivo = evnt.getNumAsistentes() + "inv";
                    }
                }
                stage.show();
            } else {
                JOptionPane.showMessageDialog(null, "El codigo del evento debe de ser de 7 caracteres.");
            }
        }
        //accion al apretar salir
        if (event.getSource() == quitButton) {
            System.exit(0);
        }
    }
    
    //gets
    public String getCodigo() {
        return codigo;
    }

    public String getArchivo() {
        return archivo;
    }
    
    //inizialize el cual carga los datos al igual que instancia el modelo
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new ModelEvent();
        try {
            model.load();
            model.loadInvited();
        } catch (IOException ex) {
            System.err.println("No hay archivo ");
            try {
                model.save();
            } catch (IOException er) {
                System.err.println("No se pudo crear el archivo");
            }
        }
    }
}
