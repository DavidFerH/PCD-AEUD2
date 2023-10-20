// Importación de paquetes y librerías
package AEUD2.AEUD2.src;
import java.time.LocalDateTime;

public class ejercicio1 {
    public static void main(String[] args) {
        // Definimos el numero de hilos a crear
        int numThreads = 10;

        // Creación de los hilos mediante un bucle
        for (int i = 0; i < numThreads; i++) {
            // Instancia de la clase
            Thread hilo = new Thread(new Hilo(), "Hilo." + i);
            // Llamada al método de inicio
            hilo.start();
        }
    }
}

class Hilo extends Thread {
    // Constructor - void
    public Hilo() {
        
    }

    public void run() {
        // Mostrar por pantalla los datos de los hilos
        System.out.println("Hilo: " + Thread.currentThread().getName() + " - creado en: " + LocalDateTime.now());
    }
}