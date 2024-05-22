package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {
    @FXML
    int counter = 0;
    @FXML
    private Label counterLabel;

    public void increment() {
        counter+=1;
        counterLabel.setText(String.valueOf(counter));
    }

    public void decrement() {
        counter-=1;
        counterLabel.setText(String.valueOf(counter));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        counterLabel.setText(String.valueOf(counter));
        System.out.println("Initializing CounterController...");
    }
}
