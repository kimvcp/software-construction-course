package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class HumidityAverageDisplay implements Observer {

	private JFrame frame;
	private JTextArea area;
	private double preHumid;
	private int count;

	public HumidityAverageDisplay() {
		frame = new JFrame();
		frame.setSize(200, 200);
		frame.setTitle("Average Humidity");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		area = new JTextArea(150, 150);
		frame.add(area);
		area.setBackground(Color.blue);
		area.setText("Average Humidity:\n\n");
	}

	@Override
	public void update(double temp, double humid, double pressure) {
		count++;
		if (preHumid == 0) {
			preHumid = humid;
		} else {
			preHumid = (preHumid * (count - 1) + humid) / count;
		}
		area.setBackground(Color.blue);
		area.setText("Average Humidity:\n");
		area.append("Avg = " + preHumid + "\n");
	}
}