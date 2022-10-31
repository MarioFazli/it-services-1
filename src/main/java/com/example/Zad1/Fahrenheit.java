package week2.Zad1;

public class Fahrenheit {
    private double fahrenheit;

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public Fahrenheit(double fahrenheit){
        setFahrenheit(fahrenheit);
    }

    public double convertToCelsius(){
        return 5.0 / 9.0 * (fahrenheit - 32);
    }
}
