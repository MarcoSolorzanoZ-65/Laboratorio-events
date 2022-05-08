package Controller;

//imports
import java.net.URL;
import java.util.ResourceBundle;
import Model.ModelGuests;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;
import laboratorio1.Laboratorio1;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16
 * @time 10:13:20
 */
public class ControllerGuest implements Initializable {
    
    //variables y componentes de la vista
    Laboratorio1 main;
    ModelGuests model;
    @FXML
    private TextArea infoTextArea;
    @FXML
    private Button quitButton;
    @FXML
    private Button showButton;
    boolean correcto = false;
    //accion al apretar un boton
    public void handleButtonClick(ActionEvent event) throws IOException {
        String codigo = Laboratorio1.cm.getArchivo();
        //accion al apretar el boton mostrar
        if (event.getSource() == showButton) {
            while (correcto == false) {
                switch (codigo) {
                    case "10inv":
                        model.load(codigo);
                        JOptionPane.showMessageDialog(null, "Los invitados se han cargado con exito");
                        correcto = true;
                        break;
                    case "15inv":
                        model.load(codigo);
                        correcto = true;
                        JOptionPane.showMessageDialog(null, "Los invitados se han cargado con exito");
                        break;
                    case "20inv":
                        model.load(codigo);
                        correcto = true;
                        JOptionPane.showMessageDialog(null, "Los invitados se han cargado con exito");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opcion no existe!");
                        System.err.println("La opcion no existe!");
                }
            }
            infoTextArea.clear();
            infoTextArea.setText(model.getListaInvitados(main.cm.getCodigo()));
            main.cm.model.rewrite();
        }
        //accion al apretar salir
        if (event.getSource() == quitButton) {
            main.cm.stage.close();
        }
    }
    
    //inicialize el cual inicializa solo el modelo guest
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new ModelGuests();
    }
}
