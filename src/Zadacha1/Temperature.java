package Zadacha1;

public class Temperature {
    public double convertToCelsius(double fahrenheit){
        return 5.0 / 9.0 * (fahrenheit - 32);
    }

    public double convertToFahrenheit(double celsius){
        return 9.0 / 5.0 * celsius + 32;
    }
}
