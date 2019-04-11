package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class ForecastDisplay implements Observer {

    private JFrame frame;
    private JTextArea area;
    private double preHumid;

    public ForecastDisplay() {
        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Forecast Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.green);
        area.setText("Forecast Condition:\n\n");
    }

    @Override
    public void update(double temp, double humid, double pressure) {
        if (preHumid == 0) {
            preHumid = humid;
        }
        area.setBackground(Color.green);
    }
}