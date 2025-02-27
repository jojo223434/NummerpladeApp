package com.example.nummerpladeapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NaestStoersteTal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Opret en liste til at gemme tallene
        ArrayList<Integer> talListe = new ArrayList<>();

        // Indlæs 10 tal
        System.out.println("Indtast 10 tal:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Indtast tal " + (i + 1) + ": ");
            int tal = scanner.nextInt();
            talListe.add(tal);
        }

        // Sortér listen i faldende orden
        Collections.sort(talListe, Collections.reverseOrder());

        // Find og udskriv det næststørste tal (det er nu det andet element i listen)
        System.out.println("\nDet næststørste tal er: " + talListe.get(1));

        scanner.close();
    }
}
