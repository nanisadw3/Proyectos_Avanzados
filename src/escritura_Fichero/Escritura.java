
package escritura_Fichero;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritura {
    
    public static void main(String[] args) {
        
        Escribiendo e = new Escribiendo();
        e.escrivir();
        
    }
    
}

class Escribiendo{
    public void escrivir(){
        String frace = "Esta es una frace completa que deveria de ser escrita sin pasar por un for";
        
        try {
            FileWriter e = new FileWriter("src/texto_nuevo.txt", true);//agrega en un fichero ya exixtente eso hace el true 
            BufferedWriter w = new BufferedWriter(e);
            
            w.write(frace);//escribimos la frace
            w.newLine();//salto de linea
            
            
            w.close();
        } catch (IOException ex) {
            System.out.println("Error en la escritira");
        }
    }
}