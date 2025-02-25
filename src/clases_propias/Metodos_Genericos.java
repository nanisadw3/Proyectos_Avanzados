package clases_propias;

import java.util.GregorianCalendar;

public class Metodos_Genericos {
    public static void main(String[] args) {
        
        Matrices m = new Matrices();
        String[] nombres = {"Luis", "Yaqui","Inaki"};
        String elementos = m.regresaElemntos(nombres);//el metodo se adapto a lo que le pasamos
        System.out.println(elementos);
        
        Empleado []lista = {
                new Empleado("inaki", 21, 5000),
                new Empleado("inaki", 21, 5000),
                new Empleado("inaki", 21, 5000),
                new Empleado("inaki", 21, 5000)
                };
        
        //Matrices m1 =  new Matrices();
        System.out.println(m.regresaElemntos(lista));
        
        System.out.println(m.getMenor(nombres));
        
        GregorianCalendar fechas[] = {
            new GregorianCalendar(2020,01,07),
            new GregorianCalendar(2002, 12,18),
        };
        System.out.println(m.getMenor(fechas));
    }
}

class Matrices{
    //static metodo de clase
    public static <T> String regresaElemntos(T[]array){
        
        return "El arreglo tiene " + array.length + " Elementos ";
        
    }
    public static <T extends Comparable> T getMenor(T[]array){//todol los objetos implememntam la interfaz comparable
        
        if(array==null||array.length == 0){
            return null;
        }
        
        T elementoMenor = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (elementoMenor.compareTo(array[i])>0) {
                
                elementoMenor = array[i];
                
            }
            
        }
        
        return elementoMenor;
    }
    
}
