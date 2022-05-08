package Controller;

//imports
import Model.ModelGuests;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class ControllerRequest implements Initializable {
    
    //variables y componentes de la vista
    Laboratorio1 main;
    ModelGuests model;
    @FXML
    private TextArea infoTextArea;
    @FXML
    private Button quitButton;
    @FXML
    private Button showButton;
    
    //accion al apretar un boton
    public void handleButtonClick(ActionEvent event) throws IOException {
        String codigo = Laboratorio1.cm.getArchivo();
        boolean correcto = false;
        //accion al apretar el boton mostrar
        if (event.getSource() == showButton) {
            while (correcto == false) {
                switch (codigo) {
                    case "10inv":
                        model.getListaInvitados(codigo);
                        correcto = true;
                        break;
                    case "15inv":
                        model.getListaInvitados(codigo);
                        correcto = true;
                        break;
                    case "20inv":
                        model.getListaInvitados(codigo);
                        correcto = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opcion no existe!");
                        System.err.println("La opcion no existe!");
                }
            }
            infoTextArea.setText(model.getListaInvitados(main.cm.getCodigo()));
            main.cm.model.rewrite();
        }
        //accion al apretar el boton salir
        if (event.getSource() == quitButton) {
            main.cm.stage.close();
        }
    }
    
    //initialize el cual instancia solo el modelo guest ya que no era necesario otro modelo
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new ModelGuests();
    }
}
