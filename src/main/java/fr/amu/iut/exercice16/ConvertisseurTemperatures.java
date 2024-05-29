package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox panneauCelsius = new VBox(30);
        VBox panneauFahrenheit = new VBox(30);

        Label labelCelsius = new Label("°C");
        Label labelFahrenheit = new Label("°F");

        Slider sliderCelsius = new Slider(0.0, 100, 0.0);
        Slider sliderFahrenheit = new Slider(0.0, 212, 32.0);
        sliderCelsius.setOrientation(Orientation.VERTICAL);
        sliderFahrenheit.setOrientation(Orientation.VERTICAL);


        sliderCelsius.setShowTickLabels(true);
        sliderCelsius.setShowTickMarks(true);
        sliderCelsius.setMajorTickUnit(10);
        sliderCelsius.setBlockIncrement(5);
        sliderCelsius.setPrefHeight(400);


        sliderFahrenheit.setShowTickLabels(true);
        sliderFahrenheit.setShowTickMarks(true);
        sliderFahrenheit.setMajorTickUnit(10);
        sliderFahrenheit.setBlockIncrement(5);
        sliderFahrenheit.setPrefHeight(400);


        TextField textFieldCelsius = new TextField();
        TextField textFieldFahrenheit = new TextField();


        DoubleProperty celsiusProperty = new SimpleDoubleProperty();
        DoubleProperty fahrenheitProperty = new SimpleDoubleProperty();


        celsiusProperty.bindBidirectional(sliderCelsius.valueProperty());
        fahrenheitProperty.bindBidirectional(sliderFahrenheit.valueProperty());


        Bindings.bindBidirectional(textFieldCelsius.textProperty(), celsiusProperty, new javafx.util.converter.NumberStringConverter());
        Bindings.bindBidirectional(textFieldFahrenheit.textProperty(), fahrenheitProperty, new javafx.util.converter.NumberStringConverter());


        celsiusProperty.addListener((obs, ancienneVal, nouvelleVal) -> {
            double celsius = nouvelleVal.doubleValue();
            double fahrenheit = celsius * 9 / 5 + 32;
            if (fahrenheitProperty.get() != fahrenheit) {
                fahrenheitProperty.set(fahrenheit);
            }
        });

        fahrenheitProperty.addListener((obs, ancienneVal, nouvelleVal) -> {
            double fahrenheit = nouvelleVal.doubleValue();
            double celsius = (fahrenheit - 32) * 5 / 9;
            if (celsiusProperty.get() != celsius) {
                celsiusProperty.set(celsius);
            }
        });

        panneauCelsius.getChildren().addAll(labelCelsius, sliderCelsius, textFieldCelsius);
        panneauFahrenheit.getChildren().addAll(labelFahrenheit, sliderFahrenheit, textFieldFahrenheit);

        HBox root = new HBox(35, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Convertisseur de températures");
        primaryStage.show();
    }
}

