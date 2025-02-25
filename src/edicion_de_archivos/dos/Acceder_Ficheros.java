
package edicion_de_archivos.dos;

import java.io.File;

public class Acceder_Ficheros {
    public static void main(String[] args) {
        
        File ruta = new File(File.pathSeparator + "src");//asegurar compatibilidad con otros So
        
        System.out.println(ruta.getAbsolutePath());
        
        String []nombres_archivos = ruta.list();//almacenamos todo lo que se encuentra en la ruta 
        //como si fuera un ls en linux en la ruta especificada 
        for (int i = 0; i < nombres_archivos.length; i++) {

            System.out.println(nombres_archivos[i]);
            
            File f = new File(ruta.getAbsolutePath(), nombres_archivos[i]);//obtenemos el nombre de el archivo que enciontro
            
            if(f.isDirectory()){//si es un directorio
                System.out.println("");
                String[] subcarpeta = f.list();//obtenemos en un arreglo el nombre de los sub directorios
                
                for (int j = 0; j < subcarpeta.length; j++) {
                    System.out.println(subcarpeta[j]);
                }
            }
            
        }
        
    }
}
