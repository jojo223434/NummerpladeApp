package com.example.nummerpladeapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CircularQueue extends Application {

    // Node klasse for at skabe noderne i hæftet listen
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // CircularQueue klasse
    static class circularQueue {
        private Node front, rear;
        private int size;

        public circularQueue() {
            front = rear = null;
            size = 0;
        }

        // Tilføj element til køen
        public void enqueue(int data) {
            Node newNode = new Node(data);

            // Hvis køen er tom, opret den første node
            if (front == null) {
                front = rear = newNode;
                rear.next = front; // Cirkulær forbindelse
            } else {
                rear.next = newNode;
                rear = newNode;
                rear.next = front; // Cirkulær forbindelse
            }

            size++;
        }

        // Fjern element fra køen
        public void dequeue() {
            if (front == null) {
                System.out.println("Køen er tom!");
                return;
            }

            // Hvis der kun er én node
            if (front == rear) {
                front = rear = null;
            } else {
                front = front.next;
                rear.next = front; // Cirkulær forbindelse
            }

            size--;
        }

        // Vise alle elementerne i køen
        public String displayQueue() {
            if (front == null) {
                return "Køen er tom!";
            }

            StringBuilder queueContents = new StringBuilder("Køen indeholder: ");
            Node current = front;
            do {
                queueContents.append(current.data).append(" ");
                current = current.next;
            } while (current != front); // Hvis vi er tilbage ved starten af køen
            return queueContents.toString();
        }

        // Tjek om køen er tom
        public boolean isEmpty() {
            return size == 0;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // Opretter en ny cirkulær kø
        circularQueue queue = new circularQueue();

        // Opretter GUI-komponenter
        TextField inputField = new TextField();
        inputField.setPromptText("Indtast et tal");

        Button enqueueButton = new Button("Tilføj til Kø");
        Button dequeueButton = new Button("Fjern fra Kø");
        Button displayButton = new Button("Vis Kø");

        Label resultLabel = new Label("Køen er tom.");

        // Handler for at tilføje element til køen
        enqueueButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                queue.enqueue(value);
                inputField.clear();
                resultLabel.setText("Element tilføjet: " + value);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Indtast venligst et gyldigt tal.");
            }
        });

        // Handler for at fjerne element fra køen
        dequeueButton.setOnAction(e -> {
            if (!queue.isEmpty()) {
                queue.dequeue();
                resultLabel.setText("Element fjernet fra køen.");
            } else {
                resultLabel.setText("Køen er tom!");
            }
        });

        // Handler for at vise køens indhold
        displayButton.setOnAction(e -> {
            resultLabel.setText(queue.displayQueue());
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(inputField, enqueueButton, dequeueButton, displayButton, resultLabel);

        // Scene og Stage
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Cirkulær Kø");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
