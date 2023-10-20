package AEUD2.AEUD2.src4;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Averager extends Thread {
    private Monitor monitor;

    public Averager(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Display calculo media");
        JLabel label = new JLabel();
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while(true){
            int suma = monitor.getSuma();
            int contador = monitor.getContador();
            Float media = (float) suma / contador;
            label.setText("Media: " + media);

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}