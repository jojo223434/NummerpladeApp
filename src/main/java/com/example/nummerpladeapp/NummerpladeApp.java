package com.example.nummerpladeapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class NummerpladeApp extends Application {

    // Liste til at geme nummerpladerne
    private List<String> nummerplader = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        // Oprette brugergrænsefladen
        VBox layout = new VBox(10); // Layout med 10 pixels mellem elementerne
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        // Inputfelt til nummberplade
        TextField nummerpladeInput = new TextField();
        nummerpladeInput.setPromptText("Indtast nummerplade");

        // Button til at tilføje nummerplade
        Button tilføjButton = new Button("Tilføj nummerplade");

        // TextArea til at viseR sorteret liste
        TextArea nummerpladeListe = new TextArea();
        nummerpladeListe.setEditable(false);

        // Button til at vise sorteret liste
        Button visListeButton = new Button("Vis sorteret liste");

        // Håndtering af knaptrykket på "Tilføj nummerplade"
        tilføjButton.setOnAction(e -> {
            String nummerplade = nummerpladeInput.getText().trim();
            if (!nummerplade.isEmpty()) {
                nummerplader.add(nummerplade); // Tilføj nummerpladen til listen
                nummerpladeInput.clear(); // Tøm inputfeltet
            }
        });

        // Håndtering af knaptrykket på "Vis sorteret liste"
        visListeButton.setOnAction(e -> {
            // Sorter listen
            nummerplader.sort(String::compareTo);
            // Vis den sorterede liste i TextArea
            nummerpladeListe.clear();
            for (String plade : nummerplader) {
                nummerpladeListe.appendText(plade + "\n");
            }
        });

        // Tilføj alle elementerne til layoutet
        layout.getChildren().addAll(nummerpladeInput, tilføjButton, visListeButton, nummerpladeListe);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Nummerplade App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
