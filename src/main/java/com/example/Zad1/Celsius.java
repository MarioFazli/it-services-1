package week2.Zad1;

public class Celsius {
    private double celsius;

    public double getCelsius(){
        return celsius;
    }
    public void setCelsius(double celsius){
        this.celsius = celsius;
    }
    public Celsius(double celsius){
        setCelsius(celsius);
    }
    public double convertToFahrenheit(){
        return 9.0 / 5.0 * celsius + 32;
    }
}
