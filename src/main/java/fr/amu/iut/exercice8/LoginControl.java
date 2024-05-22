package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
public class LoginControl extends GridPane {

    @FXML
    private TextField uid;
    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        System.out.println("Identifiant : " + uid.getText());
        System.out.println("Mot de passe : " + pwd.getText().replaceAll("[abcdefghijklmopqrstuwyz123456789?!@#]", "*"));

    }

    @FXML
    private void cancelClicked() {
        uid.clear();
        pwd.clear();
    }
}