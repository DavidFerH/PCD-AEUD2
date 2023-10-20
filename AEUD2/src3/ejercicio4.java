package AEUD2.AEUD2.src3;

public class ejercicio4 {
    public static void main(String[] args) {
        // Instancia de clase candado
        Object lock = new Object();

        // Instancia de las clases
        Thread hilo1 = new Thread(new LockedThread(lock), "Hilo 1");
        Thread hilo2 = new Thread(new LockedThread(lock), "Hilo 2");
        Thread hilo3 = new Thread(new UnlockThread(lock), "Hilo 3");

        // Inicialización de los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}

// Clase hilo bloqueado
class LockedThread extends Thread {
    // Instancia del objeto lock
    private final Object lock;

    // Constructor
    LockedThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock) {
            System.out.println(Thread.currentThread().getName() + " bloqueado, en espera de señal de activación...");
            
            try {
                // Espera de la señal de desbloqueo
                lock.wait();

                System.out.println(Thread.currentThread().getName() + " desbloqueado");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// Clase hilo de desbloqueo
class UnlockThread extends Thread {
    // Instancia del objeto lock
    private final Object lock;

    // Constructor
    UnlockThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            // Dormir el hilo durante 1000ms
            Thread.sleep(5000);

            // Despertamos los hilos 1 y 2
            synchronized(lock) {
                System.out.println(Thread.currentThread().getName() + " enviando señal para despertar los hilos 2 y 3");
                lock.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
