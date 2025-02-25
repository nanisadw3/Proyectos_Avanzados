/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leer_Fichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Acceso_Fichero {

    public static void main(String[] args) {
        LeerFichero l = new LeerFichero();
        l.leer();
    }

}

class LeerFichero {

    public void leer() {
        try (FileReader r = new FileReader("src/Ejemplo.txt")) {
            BufferedReader buffer = new BufferedReader(r);//creamos un buffer y le damos el fichero
            //int c; ya no sirve esta linea de codigo
            String linea = "";
            
            while (linea!=null) {//(c = r.read()) != -1
                
                linea = buffer.readLine();//leemos las lineas del buffer lee por lineas
                if(linea !=null){//para que no nos imprima null al final
                    System.out.println(linea);
                }
                //char letra =(char)c;
                //System.out.print(letra);
                
            }
            
            r.close();//cerramos la lecrura
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }

    }
    
}
