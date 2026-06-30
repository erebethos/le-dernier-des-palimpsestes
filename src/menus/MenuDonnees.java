package menus;

import data.Data;
import data.Fichier;
import outils.Saisie;
import data.JeuDeTest;

/**
 * Sous-menu responsable de l'affichage global, de la sauvegarde,
 * du chargement et de l'initialisation des données de test.
 */

public class MenuDonnees {
    private Data data;
    private Saisie saisie;

    public MenuDonnees(Data data) {
        this.data = data;
        this.saisie = new Saisie();
    }

    public Data lancer() {
        int choix;

        do {
            afficherMenu();
            choix = saisie.lireInt("Votre choix : ");

            switch (choix) {
                case 1:
                    data.afficherToutesLesDonnees();
                    break;

                case 2:
                    Fichier.sauvegarder(data);
                    break;

                case 3:
                    data = Fichier.charger();
                    break;

                case 4:
                    JeuDeTest.initialiser(data);
                    System.out.println("Donnees de test initialisees.");
                    break;

                case 0:
                    System.out.println("Retour au menu principal.");
                    break;

                default:
                    System.out.println("Choix invalide.");
                    break;
            }

            System.out.println();

        } while (choix != 0);

        return data;
    }

    private void afficherMenu() {
        System.out.println("===== DONNEES =====");
        System.out.println("1. Afficher toutes les donnees");
        System.out.println("2. Sauvegarder");
        System.out.println("3. Charger");
        System.out.println("4. Initialiser des donnees de test");
        System.out.println("0. Retour");
    }
}