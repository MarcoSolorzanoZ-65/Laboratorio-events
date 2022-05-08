package Model;

import SampleClasses.Asistente;
import SampleClasses.Evento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import laboratorio1.Laboratorio1;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16
 * @time 10:13:20
 */
public class ModelEvent {
    
    //variables y lista
    ArrayList<Evento> listEventos = Laboratorio1.listEventos;
    File evnt = new File("Eventos.txt");
    int numInv = 0;
    
    //metodo para guardar por primera vez
    public void save() throws FileNotFoundException, IOException {
        FileWriter writer2 = new FileWriter(evnt);
        for (Evento evento : listEventos) {
            writer2.write(evento.toString());
        }
        writer2.close();
        System.out.println("Saved!");
    }
    
    //metodo para sobrescribir el archivo Eventos.txt
    public void rewrite() throws IOException {
        File tmp = new File("tmp.txt");
        FileWriter writer3 = new FileWriter(tmp);
        for (Evento evento : listEventos) {
            writer3.write(evento.toString());
        }
        writer3.close();
        evnt.delete();
        tmp.renameTo(evnt);
    }
    
    //metodo para cargar el archivo Eventos.txt
    public void load() throws IOException {
        ArrayList<Evento> list = listEventos;
        BufferedReader reader = new BufferedReader(new FileReader("Eventos.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] str = line.split(",");
            list.add(new Evento(str[0], Integer.parseInt(str[1])));
        }
        reader.close();
        System.out.println("Loaded!");
    }
    
    //metodo para cargar los invitados guardados a los eventos
    public void loadInvited() throws IOException {
        for (Evento evnt : listEventos) {
            int numasis = evnt.getNumAsistentes();
            switch (numasis) {
                case 10:
                    load("10inv", evnt);
                    break;
                case 15:
                    load("15inv", evnt);
                    break;
                case 20:
                    load("20inv", evnt);
                    break;
                case 0:
                    System.out.println("El evento tiene 0 invitados");
                default:
                    System.err.println("No se pudieron cargar los invitados");
            }
            numasis = 0;
        }
    }
    
    //metodo para cargar los invitados a los eventos de los archivos 10inv.txt, 15inv,txt, 20inv,txt
    public void load(String event, Evento envt) throws IOException {
        File evnt = new File(event + ".txt");
        if (evnt.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(event + ".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(",");
                numInv++;
                for (Evento ev : listEventos) {
                    if (ev.getCodigo().equals(envt.getCodigo())) {
                        addPersonaEvent(ev.getCodigo(), new Asistente(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2])));
                    }
                }
            }
            reader.close();
            System.out.println("Loaded!");
            numInv = 0;
        } else {
            System.err.println("Archivo no existe!");
        }
    }
    
    //Metodo para agregar un invitado a un evento especifico
    public void addPersonaEvent(String event, Asistente person) {
        for (Evento evnt : listEventos) {
            if (evnt.getCodigo().equals(event)) {
                evnt.getInvitadosList().add(person);
                evnt.setNumAsistentes(numInv);
                break;
            }
        }
    }
    
    //metodo para verificar si existe un evento
    public boolean searchEvent(String event) {
        boolean isPresent = listEventos.stream().anyMatch(Evento -> Evento.getCodigo().equals(event));
        return isPresent;
    }

}
