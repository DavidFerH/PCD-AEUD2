package AEUD2.AEUD2.src4;

public class ejercicio5 {
    // Constantes para la definición de números a generar
    private static final int MAX_SIZE = 10;
    private static final int MAX_NUMBERS = 100;
    public static void main(String[] args) {
        Monitor monitor = new Monitor(MAX_SIZE);
        Producer producer = new Producer(monitor, MAX_NUMBERS);
        Consumer consumer = new Consumer(monitor);
        Averager averager = new Averager(monitor);

        producer.start();
        consumer.start();
        averager.start();
    }
}