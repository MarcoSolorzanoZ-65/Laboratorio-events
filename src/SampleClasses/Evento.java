package SampleClasses;

import java.util.ArrayList;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16 
 * @time 10:13:20
*/
public class Evento {
    //lista de invitados y variables
    ArrayList<Asistente> invitadosList = new ArrayList<>();
    String codigo;
    int numAsistentes;
    
    //constructores
    public Evento() {
    }
    
    public Evento(String codigo, int num) {
        this.codigo = codigo;
        this.numAsistentes = num;
    }
    
    //gets y sets
    public int getNumAsistentes() {
        return numAsistentes;
    }

    public void setNumAsistentes(int numAsistentes) {
        this.numAsistentes = numAsistentes;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Asistente> getInvitadosList() {
        return invitadosList;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setInvitadosList(ArrayList<Asistente> invitadosList) {
        this.invitadosList = invitadosList;
    }

    @Override
    public String toString() {
        return codigo + "," + numAsistentes + "\n";
    }
    
}
