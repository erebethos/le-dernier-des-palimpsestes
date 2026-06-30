package outils;

import java.util.Scanner;

/**
 * Centralise les saisies clavier utilisées par les menus.
 * Cela évite de dupliquer le code de lecture dans chaque menu.
 */

public class Saisie {
    private Scanner scanner;

    public Saisie() {
        scanner = new Scanner(System.in);
    }

    public String lireTexte(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Tant que l'utilisateur n'entre pas un entier, la saisie est redemandée.
    public int lireInt(String message) {
        System.out.print(message);

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre entier.");
            scanner.nextLine();
            System.out.print(message);
        }

        int valeur = scanner.nextInt();
        scanner.nextLine();

        return valeur;
    }
}