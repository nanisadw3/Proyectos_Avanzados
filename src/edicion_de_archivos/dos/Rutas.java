
package edicion_de_archivos.dos;

import java.io.File;

public class Rutas {
    public static void main(String[] args) {
        
        File archivo = new File("src");//no espcificamos ruta y toma por defecto 'Edicion_texto'
        System.out.println(archivo.getAbsolutePath());//imprime la ruta en la que se encontraria el archivo
        System.out.println(archivo.exists());//no existe el archivo
        
    }
}
