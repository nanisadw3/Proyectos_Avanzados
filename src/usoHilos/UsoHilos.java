package usoHilos;
import clases_propias.Jefe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class UsoHilos {

    public static void main(String[] args) {
        Marco m = new Marco();
        m.setVisible(true);
        m.setLocationRelativeTo(null);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Pelota_Hilos implements Runnable {
    private Pelota p;
    private Component lamina;

    public Pelota_Hilos(Pelota p, Component lamina) {
        this.p = p;
        this.lamina = lamina;
    }

    //interrumpir hilos
    public void run() {//implementamos el metodo run
        //for (int i = 0; i <=10000;i++){
        System.out.println("Estado del hilo al inicio " + Thread.currentThread().isInterrupted());
        //while (!Thread.interrupted()) {//indefinidamente

        while (!Thread.currentThread().isInterrupted()) {
            p.mueve_Pelota(lamina.getBounds());
            lamina.repaint();
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();//detenemos el hilo si se manda un error de interrupcion
            }
        }
        System.out.println("Estado del hilo al Final " + Thread.currentThread().isInterrupted());
    }
}
// Clase Pelota
class Pelota {
    public static final int TAMX = 15;
    public static final int TAMY = 15;
    private double x = 0, y = 0;
    private double dx = 1, dy = 1; // Velocidad inicial

    // Mueve la pelota y rebota en los bordes
    public void mueve_Pelota(Rectangle2D limite) {
        x += dx;
        y += dy;

        if (x < limite.getMinX()) {
            x = limite.getMinX();
            dx = -dx;
        }
        if (y < limite.getMinY()) {
            y = limite.getMinY();
            dy = -dy;
        }
        if (x + TAMX > limite.getMaxX()) {
            x = limite.getMaxX() - TAMX;
            dx = -dx;
        }
        if (y + TAMY > limite.getMaxY()) {
            y = limite.getMaxY() - TAMY;
            dy = -dy;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }
}
class Lamina extends JPanel{

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

    public void add(Pelota p){
        pelotas.add(p);

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Pelota p: pelotas){
            g2d.fill(p.getShape());
        }
    }
}
class Marco extends JFrame{

    private Lamina lamina_P;

    public Marco(){
       setSize(600,600);
       setTitle("Rebotes");

       lamina_P = new Lamina();
       add(lamina_P, BorderLayout.CENTER);

       JPanel Lamina_B = new JPanel();


       ponerBoton(Lamina_B, "Dale", e -> comienzaElJuego());
       ponerBoton(Lamina_B,"Salir", e -> System.exit(0));
        ponerBoton(Lamina_B,"Detener", e -> detener());

       add(Lamina_B, BorderLayout.SOUTH);
    }

    public void ponerBoton(Container c, String nombre, ActionListener accion){
        JButton boton = new JButton(nombre);
        boton.addActionListener(accion);
        c.add(boton);
    }
    public void comienzaElJuego(){
        Pelota p = new Pelota();
        lamina_P.add(p);
        //instancia de la classe runnable
        Pelota_Hilos hilo = new Pelota_Hilos(p, lamina_P);
        //Thread hiloThread = new Thread(hilo);//Creamos el hilo
        t = new Thread(hilo);
        t.start();

    }

    public void detener(){

        //t.stop();
        t.interrupt();
    }
    Thread t;

}