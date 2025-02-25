
package clases_propias;

public class Empleado {
    


    public Empleado(String Nombre, int edad, double salario) {
        this.Nombre = Nombre;
        this.edad = edad;
        this.salario = salario;
    }
    
    public String dame_datos(){
        return "El empleado se llama " + Nombre + " tiene " + edad + " y gana " + salario;
    }
    
    private String Nombre;
    private int edad;
    private double salario;

}
