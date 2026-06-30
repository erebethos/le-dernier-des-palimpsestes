package menus;

import data.Data;
import outils.Saisie;

/**
 * Sous-menu responsable de la gestion des utilisateurs.
 * Il permet d'ajouter, afficher, geler ou réactiver un utilisateur.
 */

public class MenuUtilisateurs {

    private Data data;
    private Saisie saisie;

    public MenuUtilisateurs(Data data) {
        this.data = data;
        this.saisie = new Saisie();
    }

    public void lancer() {
        int choix;

        do {
            afficherMenu();
            choix = saisie.lireInt("Votre choix : ");

            switch (choix) {
                case 1:
                    ajouterUtilisateur();
                    break;

                case 2:
                    data.getListeUtilisateurs().afficherUtilisateurs();
                    break;

                case 3:
                    gelerUtilisateur();
                    break;

                case 4:
                    reactiverUtilisateur();
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
    }

    private void afficherMenu() {
        System.out.println("===== UTILISATEURS =====");
        System.out.println("1. Ajouter un utilisateur");
        System.out.println("2. Afficher les utilisateurs");
        System.out.println("3. Geler un utilisateur");
        System.out.println("4. Reactiver un utilisateur");
        System.out.println("0. Retour");
    }

    private void ajouterUtilisateur() {
        System.out.println("=== Ajouter un utilisateur ===");

        String pseudo = saisie.lireTexte("Pseudo : ");
        String email = saisie.lireTexte("Email : ");

        data.getListeUtilisateurs().ajouterUtilisateur(pseudo, email);

        System.out.println("Utilisateur ajoute.");
    }

    private void gelerUtilisateur() {
        System.out.println("=== Geler un utilisateur ===");

        int idUtilisateur = saisie.lireInt("Id de l'utilisateur a geler : ");

        data.getListeUtilisateurs().gelerUtilisateur(idUtilisateur);

        System.out.println("Utilisateur gele s'il existait.");
    }

    private void reactiverUtilisateur() {
        System.out.println("=== Reactiver un utilisateur ===");

        int idUtilisateur = saisie.lireInt("Id de l'utilisateur a reactiver : ");

        data.getListeUtilisateurs().reactiverUtilisateur(idUtilisateur);

        System.out.println("Utilisateur reactive s'il existait.");
    }
    
}
