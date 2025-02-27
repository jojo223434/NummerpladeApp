package com.example.nummerpladeapp;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {

    // Funktion til at checke om to ord er anagrammer
    public static boolean erAnagram(String ord1, String ord2) {
        // Fjern mellemrum og konverter til små bogstaver
        ord1 = ord1.replaceAll("\\s", "").toLowerCase();
        ord2 = ord2.replaceAll("\\s", "").toLowerCase();

        // Hvis længden er forskellig, kan de ikke være anagrammer
        if (ord1.length() != ord2.length()) {
            return false;
        }

        // Konverter ordene til arrays af tegn
        char[] ord1Array = ord1.toCharArray();
        char[] ord2Array = ord2.toCharArray();

        // Sorter begge arrays
        Arrays.sort(ord1Array);
        Arrays.sort(ord2Array);

        // Sammenlign de sorterede arrays
        return Arrays.equals(ord1Array, ord2Array);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Indlæs de to ord fra brugeren
        System.out.print("Indtast det første ord: ");
        String ord1 = scanner.nextLine();
        System.out.print("Indtast det andet ord: ");
        String ord2 = scanner.nextLine();

        // Check om ordene er anagrammer og vis resultatet
        if (erAnagram(ord1, ord2)) {
            System.out.println(ord1 + " og " + ord2 + " er anagrammer!");
        } else {
            System.out.println(ord1 + " og " + ord2 + " er ikke anagrammer.");
        }

        scanner.close();
    }
}
