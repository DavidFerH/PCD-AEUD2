package AEUD2.AEUD2.src4;

public class Monitor {
    // Declaración de las variables
    private int[] numbers;
    private int pointer;
    private int suma;
    private int contador;
    private boolean isVoid;
    private boolean isFull;

    // Constructor de la clase
    public Monitor(int maxSize) {
        this.numbers = new int[maxSize];
        this.pointer = 0;
        this.suma = 0;
        this.contador = 0;
        this.isVoid = true;
        this.isFull = false;
    }

    public synchronized void produce(int num) {
        // Mientras el array esté lleno, paramos la ejecución del hilo
        while (isFull) {
            try {
                wait();
            } catch (Exception e) {}
        }

        // Adición de un valor al array de enteros e incremento del puntero
        numbers[pointer] = num;
        pointer ++;
        contador++;

        if(pointer == numbers.length) {
            isFull = true;
        }

        isVoid = false;

        notifyAll();
    }

    public synchronized void consumeAndAdd() {
        // Mientras el array de números esté vacío, paramos la ejecución del hilo
        while(isVoid) {
            try {
                wait();
            } catch (Exception e) {}
        }

        // Decremento de la variable puntero
        pointer --;

        // Si el puntero llega a 0 significa que se han consumido todos los valores del array de numeros
        if(pointer == 0) {
            isVoid = true;
        }

        isFull = false;

        notifyAll();

        suma = suma +  numbers[pointer];
    }

    public int getContador() {
        return contador;
    }

    public int getSuma() {
        return suma;
    }
}
