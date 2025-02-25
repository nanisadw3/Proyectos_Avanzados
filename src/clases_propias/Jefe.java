
package clases_propias;

public class Jefe extends Empleado{
    
    public Jefe(String Nombre, int edad, double salario) {
        super(Nombre, edad, salario);
    }
    
    double incentivo(double inc){
        return inc;
    }
    
}
