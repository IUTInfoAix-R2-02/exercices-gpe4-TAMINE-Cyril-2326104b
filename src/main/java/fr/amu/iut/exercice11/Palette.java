package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private IntegerProperty nbFois;
    private StringProperty message ;
    private StringProperty couleurPanneau;
    private Label texteDuHaut;
    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    public Palette(){
        this.message= new SimpleStringProperty("");
        this.nbFois = new SimpleIntegerProperty(0);
        this.couleurPanneau= new SimpleStringProperty("#000000");
    }
    public void handleVertClick(){
        panneau.setStyle("-fx-background-color: green");
        nbFois.set(++nbVert);
        texteDuBas.setText("Le vert est une jolie couleur !");
    }

    public void handleRougeClick(){
        panneau.setStyle("-fx-background-color: red");
        nbFois.set(++nbRouge);

        texteDuBas.setText("Le rouge est une jolie couleur !");
    }

    public void handleBleuClick(){
        panneau.setStyle("-fx-background-color: blue");
        nbFois.set(++nbBleu);
        texteDuBas.setText("Le bleu est une jolie couleur !");
    }

    public void handleClick(String couleur, String hex){

    }

    private void createBindings(){
        StringProperty texteDeBase = new SimpleStringProperty("Cliquez sur un bouton.");
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty(nbFois.isEqualTo(0), "Pas encore de clic.");

    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

       texteDuHaut.textProperty().bind(message.concat("Choisi ").concat(nbFois.asString().concat("fois")));

        this.vert.setOnAction(actionEvent -> handleClick("Vert", "green"));
        this.bleu.setOnAction(actionEvent -> handleClick("Bleu", "blue"));
        this.rouge.setOnAction(actionEvent -> handleClick("Rouge", "red"));


        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

