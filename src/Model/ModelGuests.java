package Model;

import SampleClasses.Evento;
import SampleClasses.Asistente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import laboratorio1.Laboratorio1;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16
 * @time 10:13:20
 */
public class ModelGuests {
    
    //contador de guests
    private int numInv;
    
    //metodo para cargar los guests
    public void load(String event) throws IOException {
        File evnt = new File(event + ".txt");
        if (evnt.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(event + ".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(",");
                numInv++;
                addPersonaEvent(Laboratorio1.cm.getCodigo(), new Asistente(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2])));
            }
            reader.close();
            numInv = 0;
            System.out.println("Loaded!");
        } else {
            System.err.println("Archivo no existe!");
        }
    }
    
    //metodo para agregar 1 solo guest a un evento especifico
    public void addPersonaEvent(String event, Asistente person) {
        for (Evento evnt : Laboratorio1.listEventos) {
            if (evnt.getCodigo().equals(event)) {
                evnt.getInvitadosList().add(person);
                evnt.setNumAsistentes(numInv);
                break;
            }
        }
    }
    
    //metodo para retornar la lista invitados sin parentesis cuadrados ni comas
    public String getListaInvitados(String event) {
        for (Evento evnt : Laboratorio1.listEventos) {
            if (evnt.getCodigo().equals(event)) {
                return evnt.getInvitadosList().toString().replace("[", "").replace("]", "").replace(",", "");
            }
        }
        return null;
    }

}
