package com.example.nummerpladeapp;

import java.util.Stack;

public class Kortbunke {

    public static void main(String[] args) {
        // Opretter en stack til at gemme kortene
        Stack<String> bunke = new Stack<>();

        // Lægge kort på bunken (push operation)
        bunke.push("2H"); // 2 af hjerter
        bunke.push("KS"); // Konge af spar
        bunke.push("10D"); // 10 af diamants
        bunke.push("AC"); // Es af klør

        // Udskriver kortene på bunken
        System.out.println("Kort på bunken: " + bunke);

        // Tag kort fra bunken (pop operation)
        String kortTaget = bunke.pop(); // Vi tager det øverste kort
        System.out.println("Kort taget fra bunken: " + kortTaget);

        // Udskriver de resterende kort på bunken
        System.out.println("Resterende kort på bunken: " + bunke);

        // Kikker på det øverste kort uden at tage det af bunken (peek operation)
        String oeverstKort = bunke.peek();
        System.out.println("Øverste kort på bunken: " + oeverstKort);
    }
}
