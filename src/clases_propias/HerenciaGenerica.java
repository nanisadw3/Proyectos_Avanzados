package clases_propias;

public class HerenciaGenerica {
    
    public static void main(String[] args) {
        //Empleado administracion = new Empleado("Elena", 45, 1500);
    //Jefe Director = new Jefe("Inaki", 22, 3500);
    //Empleado nuevo = Director;
    
    Pareja<Empleado> Administracion = new Pareja<Empleado>();
    Pareja<Jefe> Director = new Pareja<Jefe>();
    //Pareja<Empleado> nuevo = Director; <- no se puede convertir un jefe a un empleado
    
    Pareja.imprimirEmpleado(Administracion);
    Pareja.imprimirEmpleado(Director);
    }

}
