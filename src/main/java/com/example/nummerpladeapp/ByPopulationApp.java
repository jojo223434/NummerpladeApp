package com.example.nummerpladeapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ByPopulationApp extends Application {

    // HashMap til at gemme byer og deres populationer
    private HashMap<String, List<Integer>> byer = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Opretter UI-komponenter
        TextField byNavnInput = new TextField();
        byNavnInput.setPromptText("Indtast byens navn");

        TextField populationInput = new TextField();
        populationInput.setPromptText("Indtast population");

        Button tilføjButton = new Button("Tilføj By");
        Button søgButton = new Button("Søg Efter By");

        Label resultLabel = new Label();

        // Handler for at tilføje by og population
        tilføjButton.setOnAction(e -> {
            String byNavn = byNavnInput.getText();
            try {
                int population = Integer.parseInt(populationInput.getText());
                if (!byNavn.isEmpty() && population > 0) {
                    // Hvis byen allerede findes, tilføj populationen til listen
                    if (!byer.containsKey(byNavn)) {
                        byer.put(byNavn, new ArrayList<>());
                    }
                    byer.get(byNavn).add(population);

                    // Ryd inputfelterne
                    byNavnInput.clear();
                    populationInput.clear();

                    resultLabel.setText("Byen " + byNavn + " blev tilføjet med population " + population);
                } else {
                    resultLabel.setText("Indtast en gyldig by og population!");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Indtast venligst en gyldig numerisk population!");
            }
        });

        // Handler for at søge efter en bys population
        søgButton.setOnAction(e -> {
            String byNavn = byNavnInput.getText();
            if (byer.containsKey(byNavn)) {
                List<Integer> populationer = byer.get(byNavn);
                resultLabel.setText("Populationer for " + byNavn + ": " + populationer);
            } else {
                resultLabel.setText("Byen findes ikke i databasen.");
            }

            // Ryd inputfeltet
            byNavnInput.clear();
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(byNavnInput, populationInput, tilføjButton, søgButton, resultLabel);

        // Scene og Stage
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("By Population App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
