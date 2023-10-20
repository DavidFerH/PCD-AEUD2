// Importación de paquetes y librerías
package AEUD2.AEUD2.src1;
import java.time.LocalDateTime;

public class ejercicio2 {
    public static void main(String[] args) {
        // Instancia de las clases
        Thread hilo1 = new Thread(new Hilo(500), "Hilo.1");
        Thread hilo2 = new Thread(new Hilo(1500), "Hilo.2");
        Thread hilo3 = new Thread(new Hilo(10000), "Hilo.3");

        // Llamada al método de inicio
        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}

class Hilo extends Thread {
    private final int tiempoEspera;

    // Constructor de la clase
    public Hilo(int sleepTime) {
        this.tiempoEspera = sleepTime;
    }

    public void run() {
        try {
            // Almacenado nombre del hilo creado
            String threadName = Thread.currentThread().getName();

            // Muestra por pantalla los valores requeridos
            System.out.println("Inicio del hilo " + threadName + " " + LocalDateTime.now());
            // Tiempo de espera solicitado
            Thread.sleep(tiempoEspera);
            System.out.println("Fin del hilo " + threadName + " " + LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
