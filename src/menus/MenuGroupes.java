package menus;

import data.Data;
import outils.Saisie;

/**
 * Sous-menu responsable de la gestion des groupes.
 * Il permet de créer un groupe, gérer ses membres,
 * puis geler ou réactiver un groupe.
 */

public class MenuGroupes {

    private Data data;
    private Saisie saisie;

    public MenuGroupes(Data data) {
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
                    creerGroupe();
                    break;

                case 2:
                    ajouterMembreGroupe();
                    break;

                case 3:
                    retirerMembreGroupe();
                    break;

                case 4:
                    data.getListeGroupes().afficherGroupes();
                    break;

                case 5:
                    gelerGroupe();
                    break;

                case 6:
                    reactiverGroupe();
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
        System.out.println("===== GROUPES =====");
        System.out.println("1. Creer un groupe");
        System.out.println("2. Ajouter un membre a un groupe");
        System.out.println("3. Retirer un membre d'un groupe");
        System.out.println("4. Afficher les groupes");
        System.out.println("5. Geler un groupe");
        System.out.println("6. Reactiver un groupe");
        System.out.println("0. Retour");
    }

    private void creerGroupe() {
        System.out.println("=== Creer un groupe ===");

        String nom = saisie.lireTexte("Nom du groupe : ");
        int idCreateur = saisie.lireInt("Id du createur : ");

        data.getListeGroupes().ajouterGroupe(
                nom,
                idCreateur,
                data.getListeUtilisateurs()
        );

        System.out.println("Groupe cree si le createur existe.");
    }

    private void ajouterMembreGroupe() {
        int idGroupe = saisie.lireInt("Id du groupe : ");
        int idUtilisateur = saisie.lireInt("Id de l'utilisateur a ajouter : ");

        data.getListeGroupes().ajouterMembre(
                idGroupe,
                idUtilisateur,
                data.getListeUtilisateurs()
        );

        System.out.println("Membre ajoute si les identifiants etaient valides.");
    }

    private void retirerMembreGroupe() {
        int idGroupe = saisie.lireInt("Id du groupe : ");
        int idUtilisateur = saisie.lireInt("Id de l'utilisateur a retirer : ");

        data.getListeGroupes().retirerMembre(
                idGroupe,
                idUtilisateur,
                data.getListeUtilisateurs()
        );

        System.out.println("Membre retire si les identifiants etaient valides.");
    }

    private void gelerGroupe() {
        System.out.println("=== Geler un groupe ===");

        int idGroupe = saisie.lireInt("Id du groupe a geler : ");

        data.getListeGroupes().gelerGroupe(idGroupe);

        System.out.println("Groupe gele s'il existait.");
    }

    private void reactiverGroupe() {
        System.out.println("=== Reactiver un groupe ===");

        int idGroupe = saisie.lireInt("Id du groupe a reactiver : ");

        data.getListeGroupes().reactiverGroupe(idGroupe);

        System.out.println("Groupe reactive s'il existait.");
    }
}
