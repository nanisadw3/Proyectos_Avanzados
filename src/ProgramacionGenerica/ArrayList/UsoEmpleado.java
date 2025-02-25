
package ProgramacionGenerica.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {
    
    public static void main(String[] args) {
        
        //Empleado []listaEmpleados = new Empleado[3];
        //si usas array solo puedes almacenar datos de un solo tipo y tienes que definir cuantos elementos tiene 
        //listaEmpleados[0] = new Empleado("Inaki", 21, 5000);
        //listaEmpleados[1] = new Empleado("Yaqui", 20, 3000);
        //listaEmpleados[2] = new Empleado("Jose", 20, 1000);
        
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        //listaEmpleados.ensureCapacity(11); creas mas espacio para el array list delimitas el espacio del array
        listaEmpleados.add(new Empleado("erock", 21, 5000));
        listaEmpleados.add(new Empleado("Yaqui", 20, 3000));
        listaEmpleados.add(new Empleado("Jose", 20, 1000));
        
        listaEmpleados.add(new Empleado("Luis", 30, 7000));
        listaEmpleados.add(new Empleado("Miguel", 60, 3000));
        listaEmpleados.add(new Empleado("Luisa", 19, 1000));
        
        listaEmpleados.set(0, new Empleado("Inaki", 22, 700000));//este estaria en primer lugar, por el indice 
        
        //System.out.println("===================================================");
        //System.out.println(listaEmpleados.get(1).dame_datos());//obtener el que esta en la posicion 3 
        //System.out.println("===================================================");
        
        //listaEmpleados.trimToSize(); esto se hace para optimisar recursos corta y ya no deja meter mas infoemacion
        
        //aqui podemos agregar mas elementos sin hacer algun cambio
        
        //System.out.println(listaEmpleados.size());//imprimimos cuantos elementos tiene la lista 
        
        /*for (Empleado listaEmpleado : listaEmpleados) {
            System.out.println(listaEmpleado.dame_datos());
        }*/
        
        Iterator <Empleado> iterador = listaEmpleados.iterator();
        
        while (iterador.hasNext()) {
            
            System.err.println(iterador.next().dame_datos());
            
        }
        
    }
    
}
class Empleado{

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

