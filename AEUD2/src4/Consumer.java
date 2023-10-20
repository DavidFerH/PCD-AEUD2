package AEUD2.AEUD2.src4;

public class Consumer extends Thread {
    private Monitor monitor;

    public Consumer(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while(true){
            monitor.consumeAndAdd();

            try {
                Thread.sleep(150);
            } catch (Exception e) {}
        }
    }
}
