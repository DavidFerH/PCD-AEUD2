package AEUD2.AEUD2.src4;

public class Producer extends Thread {
    private Monitor monitor;
    private final int maxNumber;

    public Producer(Monitor monitor, int maxNumber) {
        this.monitor = monitor;
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        while(true) {
            try {
                int number = (int) (Math.random() * maxNumber + 1);
                monitor.produce(number);

                sleep(100);
            } catch (Exception e) {}
        }
    }
}
