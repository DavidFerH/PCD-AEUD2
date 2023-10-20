package AEUD2.AEUD2.src2;
import java.time.LocalDateTime;

public class ejercicio3 {
    public static void main(String[] args) {
        // Instancia de las clases
        Runnable ejecutable1 = new Ejecutable(5);
        Runnable ejecutable2 = new Ejecutable(10);
        Runnable ejecutable3 = new Ejecutable(15);

        Thread hilo1 = new Thread(ejecutable1);
        Thread hilo2 = new Thread(ejecutable2);
        Thread hilo3 = new Thread(ejecutable3);

        // Llamada al método de inicio
        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}

class Ejecutable implements Runnable {
    // Declaración de los atributos
    private final int numeroHilos;

    // Constructor
    public Ejecutable (int numeroHilos) {
        this.numeroHilos = numeroHilos;
    }

    // Método para crear hilos
    public void run() {
        for (int i = 0; i < numeroHilos; i++) {
            // Instancia de la clase
            Thread hilo = new Thread(() ->{
                // Muestra por pantalla los datos necesarios
                System.out.println("Hilo: " + Thread.currentThread().getName());
            }, "Hilo." + numeroHilos +"."+ i + " - " + LocalDateTime.now());
            
            // Llamada al método de inicio
            hilo.start();
        }
    }
}