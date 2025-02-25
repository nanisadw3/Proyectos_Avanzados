
package edicion_de_archivos.dos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Creando {
    
    public static void main(String[] args) {
       
        File ruta = new File("src" + File.separator + "pruevaAAAAAAAAAAAAAAAAAA.txt");//asegurar compatibilidad con otros So

        try {
            
            //ruta.mkdir();//crea un nuevo directorio en la ruta con el nombre que no encontro
            ruta.createNewFile();//crea un nuevo Fichero
        
        } catch (IOException ex) {
            System.out.println("Error");
        }
        
        
        Escribiendo e = new Escribiendo();
        
        e.escribir(ruta.getAbsolutePath());
        
        
    }
    
}
class Escribiendo{
        
    public void escribir(String rutaArchivo){
        
        String frace = "Esto es un ejemplo 2.0";
        try {
            
            FileWriter w = new FileWriter(rutaArchivo);
            
            for (int i = 0; i < frace.length(); i++) {
                
                w.write(frace.charAt(i));//escribe caracter a caracter
                
            }
            
            w.close();
            
        } catch (IOException ex) {
            System.out.println("Error");
        }
        
    }
    
}
