package ProgramacionGenerica.ArrayList;

import java.io.File;

public class UsoArrayList {

    public static void main(String[] args) {

        ArrayList2 archivos = new ArrayList2(5);//el array tendra 4 elementos de tipo object
        //almacenamos elementos
        archivos.add("Inaki");
        archivos.add("Yaqui");
        archivos.add("Ana");
        archivos.add("Sandra");
        archivos.add(new File("src/algo.txt"));

        String nombre = (String) archivos.getDatosElemento(5);//casteamos por que son de tipo object*/
        /*/* archivos.add(new File("src/algo.txt"));
        File nombre = (File)archivos.getDatosElemento(0);//ciempre tendremos que castear*/
        System.out.println(nombre);//esto nos da error
    }
}
