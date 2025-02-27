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
    JButton btn_t1;
    JButton btn_t2;
    JButton btn_t3;

    JButton btn_d1;
    JButton btn_d2;
    JButton btn_d3;

    Thread t_1;
    Thread t_2;
    Thread t_3;

    public Marco(){
       setSize(600,600);
       setTitle("Rebotes");

       lamina_P = new Lamina();
       add(lamina_P, BorderLayout.CENTER);

       JPanel Lamina_B = new JPanel();
        //Boton para el primer hilo
        btn_t1 = new JButton("Hilo 1");
        btn_t1.addActionListener(e -> comienzaElJuego(e));
        Lamina_B.add(btn_t1);
        //boton para el segundo hilo
        btn_t2 = new JButton("Hilo 2");
        btn_t2.addActionListener(e -> comienzaElJuego(e));
        Lamina_B.add(btn_t2);
        //Boton para el tercer hilo
        btn_t3 = new JButton("Hilo 3");
        btn_t3.addActionListener(e -> comienzaElJuego(e));
        Lamina_B.add(btn_t3);

        btn_d1 = new JButton("Detener 1");
        btn_d2 = new JButton("Detener 2");
        btn_d3 = new JButton("Detener 3");


        btn_d1.addActionListener(e -> detener(e));
        btn_d2.addActionListener(e -> detener(e));
        btn_d3.addActionListener(e -> detener(e));

        Lamina_B.add(btn_d1);
        Lamina_B.add(btn_d2);
        Lamina_B.add(btn_d3);

       add(Lamina_B, BorderLayout.SOUTH);
    }


    public void comienzaElJuego(ActionEvent e){
        Pelota p = new Pelota();
        lamina_P.add(p);
        //instancia de la classe runnable
        Pelota_Hilos hilo = new Pelota_Hilos(p, lamina_P);
        //Thread hiloThread = new Thread(hilo);//Creamos el hilo

        if (e.getSource() == btn_t1){
            t_1 = new Thread(hilo);
            t_1.start();
        }else if(e.getSource() == btn_t2){
            t_2 = new Thread(hilo);
            t_2.start();
        }else if(e.getSource() == btn_t3){
            t_3 = new Thread(hilo);
            t_3.start();
        }
    }

    public void detener(ActionEvent e){

        //t.stop();
        if (e.getSource() == btn_d1){
            t_1.interrupt();
        }else if (e.getSource() == btn_d2){
            t_2.interrupt();
        }else if (e.getSource() == btn_d3){
            t_3.interrupt();
        }
        //t.interrupt();
    }

}