package Zadacha1;

import javax.swing.*;

public class TestTemperature {
    public static boolean isNumber(String sDegrees) {
        try {
            Double.parseDouble(sDegrees);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Celsius Fahrenheit Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JButton convert = new JButton("Convert");
        convert.addActionListener(e -> {
            String sDegrees = JOptionPane.showInputDialog("Enter the number of degrees to convert: ");
            if (sDegrees != null) {
                while (!isNumber(sDegrees)) {
                    sDegrees = JOptionPane.showInputDialog("Error: Input is not a number!\nEnter the number of degrees to convert: ");
                }
                double degrees = Double.parseDouble(sDegrees);
                String temperatureType = JOptionPane.showInputDialog("Fahrenheit (F) or Celsius (C)?");
                while (!temperatureType.equals("F") && !temperatureType.equals("C")) {
                    temperatureType = JOptionPane.showInputDialog("Error: Please enter either \"F\" or \"C\"\nFahrenheit (F) or Celsius (C)?");
                }
                Temperature temperature = new Temperature();
                String result;
                if (temperatureType.equals("F")) {
                    result = String.format("%fF = %fC", degrees, temperature.convertToCelsius(degrees));
                } else {
                    result = String.format("%fC = %fF", degrees, temperature.convertToFahrenheit(degrees));
                }
                JOptionPane.showMessageDialog(null, result);
            }

        });
        frame.getContentPane().add(convert);
        frame.setVisible(true);


    }
}
