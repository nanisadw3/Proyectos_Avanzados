package clases_propias;

public class UsoPareja {

    public static void main(String[] args) {

        Pareja<String> p = new Pareja<String>();//asi se llama a una clase que es de este tipo
        //en lugar de ser generica va a ser String
        p.setPrimero("Inaki");//se adapto la clase para resivir un string ya que le dijimos en la llamada que fuera de ese tipo

        System.out.println(p.getPrimero());
        
        Persona pers= new Persona("Yaqui");
        Pareja <Persona> persona = new Pareja<Persona>();
        
        persona.setPrimero(pers);
        System.out.println(persona.getPrimero());//nos esta devolviendo un objeto de la clase Persona
        //Despues de agregar el metodo to string nos devuelbe el nombre
    }

}

class Persona {

    public Persona(String nombre) {

        this.nombre = nombre;

    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + '}';
    }
    
    

    private String nombre;

}
