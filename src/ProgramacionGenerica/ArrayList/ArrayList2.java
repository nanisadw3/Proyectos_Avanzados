
package ProgramacionGenerica.ArrayList;

public class ArrayList2 {
    
    public ArrayList2(int z){
        
        datosElemento = new Object[z];//le decimoss cuantos elementos abran en la lista
        
    }

    public Object getDatosElemento(int i) {
        return datosElemento[i]; //devuelbe lo que hay en el arreglo en la posicion que indiques 
    }
    
    public void add(Object o){
        
        datosElemento[i] = o;//agregamos un objeto
        i++;
        
    }
    
    private Object[] datosElemento;
    private int i = 0;
}
