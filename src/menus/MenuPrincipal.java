package menus;

import data.Data;
import outils.Saisie;

/**
 * Menu principal de l'application.
 * Il oriente l'utilisateur vers les sous-menus spécialisés.
 */
// Le menu ne contient pas la logique métier : il appelle les méthodes des classes Liste via Data.

public class MenuPrincipal {
    private Data data;
    private Saisie saisie;

    public MenuPrincipal(Data data) {
        this.data = data;
        this.saisie = new Saisie();
    }

    public void lancer() {
        int choix;

        do {
            afficherMenu();
            choix = saisie.lireInt("Votre choix : ");
            
            // Chaque choix redirige vers un sous-menu spécialisé.
            switch (choix) {
                case 1:
                    new MenuUtilisateurs(data).lancer();
                    break;

                case 2:
                    new MenuFragments(data).lancer();
                    break;

                case 3:
                    new MenuCollections(data).lancer();
                    break;

                case 4:
                    new MenuGroupes(data).lancer();
                    break;

                case 5:
                    new MenuAvis(data).lancer();
                    break;

                case 6:
                    MenuDonnees menuDonnees = new MenuDonnees(data);
                    data = menuDonnees.lancer();
                    break;

                case 0:
                    System.out.println("Fermeture de Palimpseste.");
                    break;

                default:
                    System.out.println("Choix invalide.");
                    break;
            }

            System.out.println();

        } while (choix != 0);
    }

    private void afficherMenu() {
        System.out.println("===== PALIMPSESTE =====");
        System.out.println("1. Gestion des utilisateurs");
        System.out.println("2. Gestion des fragments");
        System.out.println("3. Gestion des collections");
        System.out.println("4. Gestion des groupes");
        System.out.println("5. Gestion des avis");
        System.out.println("6. Gestion des donnees");
        System.out.println("0. Quitter");
    }
}