package edicion_de_archivos.dos;

import java.io.File;

public class Eliminar {

    public static void main(String[] args) {
        File ruta = new File("src" + File.separator + "pruevaAAAAAAAAAAAAAAAAAA.txt");//asegurar compatibilidad con otros So
        ruta.delete();//elimina el archivo 
    }

}
