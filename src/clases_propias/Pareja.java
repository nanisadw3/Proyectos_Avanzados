
package clases_propias;

public class Pareja<T>{//Se sueln usar letras mayusculas (T,U,K)

    
    public Pareja() {
        
        primero = null;
        
    }

    public void setPrimero(T primero) {
        this.primero = primero;
    }
    
    public static void imprimirEmpleado(Pareja<? extends Empleado> empleado){//recive cualquier subclase que erede de empleado
        
        Empleado primero = empleado.getPrimero();
        System.out.println(primero);
        
    }

    public T getPrimero() {//nos retorna un objeto generico
        return primero;
    }
    
    private T primero;//variable generica
    
}
