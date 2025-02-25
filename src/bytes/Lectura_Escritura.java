
package bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.security.auth.login.CredentialException;

public class Lectura_Escritura {
    public static void main(String[] args) {
        
        int contador = 0;
        int datos[] = new int[121691];
        
        try {
            
            FileInputStream lectura = new FileInputStream("src/Umbreon.png");
            boolean final_ar = false;
            
            while (!final_ar) {//mientras ar sea falso
                
                int byte_entrada = lectura.read();//va a almacenar la infromacion del fichero
                
                if (byte_entrada != -1) {
                    datos[contador] = byte_entrada;
                }else{
                    final_ar =  true;//salimos del while
                    break;
                }
                System.out.println(datos[contador]);//que nos muestre la informacion
                contador ++ ;
            }
            //la informacion es demaciado grande 
            lectura.close();
        } catch (IOException e) {
        }
        System.out.println("existen " + contador + " bytes");
        
        crear_fichero(datos);
        
    }
    
    
    
    private static void crear_fichero(int fichero[]){
        
        try {
            
            FileOutputStream c = new FileOutputStream("src/Copia.png");//creamos la nueva imagen que es identica a la leida
            
            for (int i = 0; i < fichero.length; i++) {
                
                c.write(fichero[i]);
                
            }
            c.close();
            
        } catch (Exception e) {
            
            System.out.println("Error en la creacion del fichero");
            
        }
        
    }
    
}
