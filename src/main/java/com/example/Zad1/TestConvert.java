package week2.Zad1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class TestConvert extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 300, 300);

        Button convert = new Button("Convert");
        convert.setOnAction(e -> {
            TextInputDialog inputDegrees = new TextInputDialog("0");
            inputDegrees.setTitle("Enter the number of degrees to convert: ");
            inputDegrees.setHeaderText("Enter the number of degrees to convert: ");
            Optional<String> sDegrees = inputDegrees.showAndWait();

            while (sDegrees.isPresent() && !isNumber(sDegrees.get())) {
                inputDegrees.setHeaderText("Error: Please enter a number!");
                sDegrees = inputDegrees.showAndWait();
            }
            if (sDegrees.isPresent()) {
                double degrees = Double.parseDouble(sDegrees.get());
                TextInputDialog inputTemperatureType = new TextInputDialog();
                inputTemperatureType.setContentText("Fahrenheit (F) or Celsius (C)?");
                Optional<String> temperatureType = inputTemperatureType.showAndWait();
                while (temperatureType.isPresent() && !temperatureType.get().equals("F") && !temperatureType.get().equals("C")) {
                    inputTemperatureType.setHeaderText("Error: Please enter either \"F\" or \"C\"\nFahrenheit (F) or Celsius (C)?");
                    temperatureType = inputTemperatureType.showAndWait();
                }
                if (temperatureType.isPresent()) {
                    String result;
                    if (temperatureType.get().equals("F")) {
                        Fahrenheit fahrenheit = new Fahrenheit(degrees);
                        result = String.format("%fF = %fC", degrees, fahrenheit.convertToCelsius());
                    } else {
                        Celsius celsius = new Celsius(degrees);
                        result = String.format("%fC = %fF", degrees, celsius.convertToFahrenheit());
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(result);
                    alert.show();
                } else {
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setHeaderText("Entered object is NULL");
                    error.show();
                }
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("Entered object is NULL");
                error.show();
            }
        });
        group.getChildren().add(convert);
        stage.setTitle("Celsius Fahrenheit Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static boolean isNumber(String sDegrees) {
        try {
            Double.parseDouble(sDegrees);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        launch();
    }
}