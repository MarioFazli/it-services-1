package com.example.demo2;

import com.example.demo2.Stock;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StockTest extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);
        List<Stock> stocks = new ArrayList<Stock>();
        Button createStock = new Button("Create Stock");
        createStock.setOnAction(actionEvent -> {
            TextInputDialog inputSymbol = new TextInputDialog("$");
            inputSymbol.setTitle("Symbol of Stock");
            inputSymbol.setHeaderText("Enter the symbol of the Stock: ");
            Optional<String> stockSymbol = inputSymbol.showAndWait();
            while(stockSymbol.isPresent() && stockSymbol.get().equals("")){
                stockSymbol = inputSymbol.showAndWait();
            }

            TextInputDialog inputName = new TextInputDialog("Apple");
            inputSymbol.setTitle("Name of Stock");
            inputSymbol.setHeaderText("Enter the name of the Stock: ");
            Optional<String> stockName = inputName.showAndWait();
            while(stockName.isPresent() && stockName.get().equals("")){
                stockName = inputName.showAndWait();
            }

            if(stockName.isPresent() && stockSymbol.isPresent()){
                Stock stock = new Stock(stockSymbol.get(), stockName.get());
                TextInputDialog inputCurrentPrice = new TextInputDialog("10");
                inputCurrentPrice.setTitle("Current price of Stock");
                inputCurrentPrice.setHeaderText("Enter the current price of the Stock: ");
                Optional<String> stockCurrentPrice = inputCurrentPrice.showAndWait();
                if(stockCurrentPrice.isPresent()){
                    double currentPrice = convertNumber(stockCurrentPrice.get());
                    stock.setCurrentPrice(currentPrice);
                    stock.setPreviousClosingPrice(currentPrice);
                    stocks.add(stock);
                    Alert successfullyCreated = new Alert(Alert.AlertType.INFORMATION);
                    successfullyCreated.setContentText(String.format("Stock %s was successfully created", stockName.get()));
                    successfullyCreated.show();
                }
            }
        });

        Button changePrice = new Button("Change Stock's price");
        changePrice.setOnAction(actionEvent -> {
            TextInputDialog getName = new TextInputDialog("Apple");
            getName.setHeaderText("What is the name of the Stock: ");
            Optional<String> name = getName.showAndWait();
            Stock findStock = new Stock("","");
            if(name.isPresent()){
                for (Stock stock: stocks) {
                    if(name.get().equals(stock.getName())){
                        findStock = stock;
                    }
                }
                if(!findStock.getName().equals("")){
                    TextInputDialog changeCurrentPrice = new TextInputDialog(String.valueOf(findStock.getCurrentPrice()));
                    changeCurrentPrice.setTitle("Change Price");
                    changeCurrentPrice.setHeaderText("Enter current price: ");
                    Optional<String> currentPrice = changeCurrentPrice.showAndWait();
                    while(currentPrice.isPresent() && currentPrice.get().equals("")){
                        currentPrice = changeCurrentPrice.showAndWait();
                    }
                    if(currentPrice.isPresent()){
                        findStock.setPreviousClosingPrice(findStock.getCurrentPrice());
                        findStock.setCurrentPrice(convertNumber(currentPrice.get()));
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setContentText("Successfully changed the price");
                        success.show();
                    }
                }
            }
        });

        Button checkPrice = new Button("Check Stock's price");
        checkPrice.setOnAction(actionEvent -> {
            TextInputDialog getName = new TextInputDialog("Apple");
            getName.setHeaderText("What is the name of the Stock: ");
            Optional<String> name = getName.showAndWait();
            Stock findStock = new Stock("","");
            if(name.isPresent()){
                for (Stock stock: stocks) {
                    if(name.get().equals(stock.getName())){
                        findStock = stock;
                    }
                }
                if(!findStock.getName().equals("")){
                    Alert change = new Alert(Alert.AlertType.INFORMATION);
                    change.setContentText(String.format("Price Change: %.1f%%", findStock.changePercent()));
                    change.show();

                }
            }
        });
        createStock.setLayoutX(0);
        createStock.setLayoutY(0);
        group.getChildren().add(createStock);
        changePrice.setLayoutX(100);
        changePrice.setLayoutY(0);
        group.getChildren().add(changePrice);
        checkPrice.setLayoutX(250);
        checkPrice.setLayoutY(0);
        group.getChildren().add(checkPrice);
        stage.setTitle("Stock");
        stage.setScene(scene);
        stage.show();
    }

    private double convertNumber(String n) {
        double currentPrice = 0;
        boolean isNotNumber = true;
        while(isNotNumber){
            try{
                currentPrice = Double.parseDouble(n);
                isNotNumber = false;
            }catch (NumberFormatException e){
                Alert notANumber = new Alert(Alert.AlertType.ERROR);
                notANumber.setContentText("Please enter a number!");
                notANumber.show();
            }
        }
        return currentPrice;
    }

    public static void main(String[] args) {
        launch();
    }
}
