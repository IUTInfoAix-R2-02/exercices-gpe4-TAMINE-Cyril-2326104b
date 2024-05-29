package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    public Button okBtn;
    public Button cancelBtn;
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    private void createBindings() {
        BooleanBinding isUsernameValid = Bindings.createBooleanBinding(() ->
                        userId.getText().length() >= 6,
                userId.textProperty()
        );

        pwd.editableProperty().bind(isUsernameValid);


        BooleanBinding  okNotClickable = Bindings.createBooleanBinding(() -> {
            String password = pwd.getText();
            boolean hasUpperCase = false;
            boolean hasDigit = false;
            for (char c : pwd.getText().toCharArray()) {
                if (Character.isUpperCase(c))
                    hasUpperCase = true;
                if (Character.isDigit(c))
                    hasDigit = true;
            }
            return password.length()>= 8 && hasDigit && hasUpperCase;
            pwd.textProperty());

        }
    }



    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}
