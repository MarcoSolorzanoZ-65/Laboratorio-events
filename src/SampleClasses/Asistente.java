package SampleClasses;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16 
 * @time 10:13:20
*/
public class Asistente {
    //variables
    int id;
    String name;
    int phoneNumber;

    //constructores
    public Asistente() {
    }

    public Asistente(int id, String name, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    //set y get
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Cedula: " + id + " Nombre: " + name + " Numero: " + phoneNumber + "\n";
    }
    
    
    
}
