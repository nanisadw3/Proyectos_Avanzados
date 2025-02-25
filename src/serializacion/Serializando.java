
package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {
    
    public static void main(String[] args) {
        
        Administrador jefe = new Administrador("Inaki", 5000, 2002, 12, 18);
        jefe.setInsentivo(800);
        
        Empleado []personal = new Empleado[3];
        personal[0] = jefe;
        personal[1] = new Empleado("Luis", 3000, 2001, 4, 10);
        personal[2] = new Empleado("Yaqui", 4000, 2000, 2, 3);
        
        try {
            
            ObjectOutputStream crear = new ObjectOutputStream(new FileOutputStream("src/objetos/Empleados.txt"));
            crear.writeObject(personal);//escribimos el objeto al esterior 
            crear.close();
            
            ObjectInputStream recuperar =  new ObjectInputStream(new FileInputStream("src/objetos/Empleados.txt"));
            
            Empleado [] r_Personal = (Empleado [])recuperar.readObject();
            
            recuperar.close();
            
            
            for (Empleado empleado : r_Personal) {
                System.out.println(empleado);
            }
            
        } catch (Exception e) {
            System.out.println("Error");
        }
        
    }
    
}

class Empleado implements Serializable{//permitimos que los objetos de esta clase se puedan convertuir en bayts 

    private static final long serialVersionUID=1L; 
    
    public Empleado(String Nombre, double sueldo,int ano, int mes, int dia ) {
        
        this.Nombre = Nombre;
        this.sueldo = sueldo;
        
        GregorianCalendar calendario = new GregorianCalendar(ano, mes,dia);
        
        fechaContrato = calendario.getTime();
    }
    
    public String getNombre() {
        return Nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    @Override
    public String toString() {
        return "Empleado{" + "Nombre=" + Nombre + ", Suemlo=" + sueldo + ", fechaContrato=" + fechaContrato + '}';
    }

 
    private String Nombre;

    public void subir_Suemlo(double Porsentaje) {
        double aumento = sueldo*Porsentaje/100;
        sueldo = sueldo+=aumento;
    }
    private double sueldo;
    private Date fechaContrato;
}

class Administrador extends Empleado{
    
    private static final long serialVersionUID=1L;
    
    public Administrador(String Nombre, double sueldo, int ano, int mes, int dia) {
        super(Nombre, sueldo, ano, mes, dia);
        insentivo = 0;
    }
    public double getSueldo(){
        double sueldoBase = super.getSueldo();
        return sueldoBase + insentivo;
    }

    public void setInsentivo(double insentivo) {
        this.insentivo = insentivo;
    }

    @Override
    public String toString() {
        return "Administrador{" + "insentivo=" + insentivo + '}';
    }
    
    
    
    private double insentivo;
}