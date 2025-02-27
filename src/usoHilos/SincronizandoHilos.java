package usoHilos;

public class SincronizandoHilos {
    public static void main(String[] args) {

        HilosV h = new HilosV();
        HilosV h1 = new HilosV();
        h.start();
        try {
            h.join();//ejecuta el hilo 1 hasta que se muera
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        h1.start();
        System.out.println("Hilo 0 finalizado");
        try {
            h1.join();//ejecuta el hilo 2 hasta que termine
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hilo 1 finalizado");

    }
}

class HilosV extends Thread{
    public void run(){

        for (int i =0;i<=15;i++){
            System.out.println("hilo "+getName());//se entremezclan los hilos
            try {
                Thread.sleep(500);//sleep es static
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}