package menus;

import classes.EntreeCollection;
import data.Data;
import outils.Saisie;

/**
 * Sous-menu responsable des entrées de collection.
 * Il permet d'ajouter, classer, geler ou réactiver une entrée.
 */

public class MenuCollections {

    private Data data;
    private Saisie saisie;

    public MenuCollections(Data data) {
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
                    ajouterEntreeCollection();
                    break;

                case 2:
                    ajouterTheme();
                    break;

                case 3:
                    ajouterMotCle();
                    break;

                case 4:
                    mettreEnFavori();
                    break;

                case 5:
                    data.getListeEntreesCollection().afficherEntreesCollection();
                    break;

                case 6:
                    afficherEntreesUtilisateur();
                    break;

                case 7:
                    gelerEntreeCollection();
                    break;

                case 8:
                    reactiverEntreeCollection();
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
        System.out.println("===== COLLECTIONS =====");
        System.out.println("1. Ajouter une entree dans une collection");
        System.out.println("2. Ajouter un theme a une entree");
        System.out.println("3. Ajouter un mot-cle a une entree");
        System.out.println("4. Mettre une entree en favori");
        System.out.println("5. Afficher toutes les entrees");
        System.out.println("6. Afficher les entrees d'un utilisateur");
        System.out.println("7. Geler une entree de collection");
        System.out.println("8. Reactiver une entree de collection");
        System.out.println("0. Retour");
    }

    private void ajouterEntreeCollection() {
        System.out.println("=== Ajouter une entree dans une collection ===");

        int idUtilisateur = saisie.lireInt("Id de l'utilisateur : ");
        int idFragment = saisie.lireInt("Id du fragment : ");

        data.getListeEntreesCollection().ajouterEntreeCollection(
                idUtilisateur,
                idFragment,
                data.getListeUtilisateurs(),
                data.getListeFragments()
        );

        System.out.println("Entree ajoutee si les identifiants etaient valides.");
    }

    private void ajouterTheme() {
        int idEntree = saisie.lireInt("Id de l'entree : ");
        String theme = saisie.lireTexte("Theme : ");

        EntreeCollection entree = data.getListeEntreesCollection().trouverParId(idEntree);

        if (entree != null) {
            entree.ajouterTheme(theme);
            System.out.println("Theme ajoute.");
        } else {
            System.out.println("Entree introuvable.");
        }
    }

    private void ajouterMotCle() {
        int idEntree = saisie.lireInt("Id de l'entree : ");
        String motCle = saisie.lireTexte("Mot-cle : ");
        int important = saisie.lireInt("Important ? 1 = oui, 0 = non : ");

        EntreeCollection entree = data.getListeEntreesCollection().trouverParId(idEntree);

        if (entree != null) {
            entree.ajouterMotCle(motCle, important == 1);
            System.out.println("Mot-cle ajoute.");
        } else {
            System.out.println("Entree introuvable.");
        }
    }

    private void mettreEnFavori() {
        int idEntree = saisie.lireInt("Id de l'entree : ");

        EntreeCollection entree = data.getListeEntreesCollection().trouverParId(idEntree);

        if (entree != null) {
            entree.mettreEnFavori();
            System.out.println("Entree mise en favori.");
        } else {
            System.out.println("Entree introuvable.");
        }
    }

    private void afficherEntreesUtilisateur() {
        int idUtilisateur = saisie.lireInt("Id de l'utilisateur : ");
        data.getListeEntreesCollection().afficherEntreesUtilisateur(idUtilisateur);
    }

    private void gelerEntreeCollection() {
        System.out.println("=== Geler une entree de collection ===");

        int idEntree = saisie.lireInt("Id de l'entree a geler : ");

        data.getListeEntreesCollection().gelerEntreeCollection(idEntree);

        System.out.println("Entree gelee si elle existait.");
    }

    private void reactiverEntreeCollection() {
        System.out.println("=== Reactiver une entree de collection ===");

        int idEntree = saisie.lireInt("Id de l'entree a reactiver : ");

        data.getListeEntreesCollection().reactiverEntreeCollection(idEntree);

        System.out.println("Entree reactivee si elle existait.");
    }
}
