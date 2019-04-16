package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

    private double prevTemp;
    private double prevWave;

    private JFrame weatherFrame;
    private JFrame oceanFrame;
    private JTextArea area;
    private JTextArea ocean;
    
    public StatisticsDisplay() {

        weatherFrame = new JFrame();
        weatherFrame.setSize(250, 250);
        weatherFrame.setTitle("Average Condition");
        weatherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        weatherFrame.setVisible(true);
        
        oceanFrame = new JFrame();
        oceanFrame.setSize(250, 250);
        oceanFrame.setTitle("Average Wave Height");
        oceanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oceanFrame.setVisible(true);

        area = new JTextArea(200, 200);
        weatherFrame.add(area);
        area.setBackground(Color.ORANGE);
        area.setText("Average Condition:\n");
        
        ocean = new JTextArea(200, 200);
        oceanFrame.add(ocean);
        ocean.setBackground(Color.green);
        ocean.setText("Average Wave Height:\n");

    }

    @Override
    public void update(Subject data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;

            if (prevTemp == 0)
                prevTemp = weatherData.getTemperature();
            prevTemp = (prevTemp + weatherData.getTemperature()) / 2;

            area.setBackground(Color.ORANGE);
            area.setText("Average Condition:\n");
            area.append("Temperature = " + prevTemp);
        
        }
        if (data instanceof OceanData) {
        	OceanData oceanData = (OceanData) data;
 
        	if (prevWave == 0)
        		prevWave = oceanData.getWaveHeight();
        	prevWave  = (prevWave + oceanData.getWaveHeight()) / 2;
        			
        	ocean.setBackground(Color.green);
            ocean.setText("Average Wave Height:\n");
            ocean.append("Wave Height = " + prevWave + "\n");
        }
    }
}
