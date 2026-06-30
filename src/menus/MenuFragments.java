package menus;

import data.Data;
import outils.Saisie;

/**
 * Sous-menu responsable des actions liées aux fragments.
 * Il récupère les informations saisies puis délègue le traitement aux classes Liste.
 */

public class MenuFragments {

    private Data data;
    private Saisie saisie;

    public MenuFragments(Data data) {
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
                    ajouterPenseePersonnelle();
                    break;

                case 2:
                    ajouterCitation();
                    break;

                case 3:
                    ajouterNoteLecture();
                    break;

                case 4:
                    ajouterExtraitWeb();
                    break;

                case 5:
                    data.getListeFragments().afficherFragments();
                    break;

                case 6:
                    gelerFragment();
                    break;

                case 7:
                    reactiverFragment();
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
        System.out.println("===== FRAGMENTS =====");
        System.out.println("1. Ajouter une pensee personnelle");
        System.out.println("2. Ajouter une citation");
        System.out.println("3. Ajouter une note de lecture");
        System.out.println("4. Ajouter un extrait web");
        System.out.println("5. Afficher les fragments");
        System.out.println("6. Geler un fragment");
        System.out.println("7. Reactiver un fragment");
        System.out.println("0. Retour");
    }

    private void ajouterPenseePersonnelle() {
        System.out.println("=== Ajouter une pensee personnelle ===");

        int idCreateur = saisie.lireInt("Id du createur : ");
        String texte = saisie.lireTexte("Texte : ");

        data.getListeFragments().ajouterPenseePersonnelle(texte, idCreateur);

        System.out.println("Pensee personnelle ajoutee.");
    }

    private void ajouterCitation() {
        System.out.println("=== Ajouter une citation ===");

        int idCreateur = saisie.lireInt("Id du createur : ");
        String texte = saisie.lireTexte("Texte de la citation : ");
        String auteur = saisie.lireTexte("Auteur : ");
        String oeuvre = saisie.lireTexte("Oeuvre : ");
        int annee = saisie.lireInt("Annee : ");

        data.getListeFragments().ajouterCitation(texte, idCreateur, auteur, oeuvre, annee);

        System.out.println("Citation ajoutee.");
    }

    private void ajouterNoteLecture() {
        System.out.println("=== Ajouter une note de lecture ===");

        int idCreateur = saisie.lireInt("Id du createur : ");
        String texte = saisie.lireTexte("Note personnelle : ");
        String extraitOriginal = saisie.lireTexte("Extrait original : ");
        String auteur = saisie.lireTexte("Auteur : ");
        String oeuvre = saisie.lireTexte("Oeuvre : ");
        int annee = saisie.lireInt("Annee : ");
        int page = saisie.lireInt("Page (0 si inconnue) : ");

        data.getListeFragments().ajouterNoteLecture(
                texte,
                idCreateur,
                extraitOriginal,
                auteur,
                oeuvre,
                annee,
                page
        );

        System.out.println("Note de lecture ajoutee.");
    }

    private void ajouterExtraitWeb() {
        System.out.println("=== Ajouter un extrait web ===");

        int idCreateur = saisie.lireInt("Id du createur : ");
        String texte = saisie.lireTexte("Extrait : ");
        String titrePage = saisie.lireTexte("Titre de la page : ");
        String site = saisie.lireTexte("Site : ");
        String url = saisie.lireTexte("URL : ");
        String auteur = saisie.lireTexte("Auteur (laisser vide si inconnu) : ");

        data.getListeFragments().ajouterExtraitWeb(
                texte,
                idCreateur,
                titrePage,
                site,
                url,
                auteur
        );

        System.out.println("Extrait web ajoute.");
    }

    private void gelerFragment() {
        System.out.println("=== Geler un fragment ===");

        int idFragment = saisie.lireInt("Id du fragment a geler : ");

        data.getListeFragments().gelerFragment(idFragment);

        System.out.println("Fragment gele s'il existait.");
    }

    private void reactiverFragment() {
        System.out.println("=== Reactiver un fragment ===");

        int idFragment = saisie.lireInt("Id du fragment a reactiver : ");

        data.getListeFragments().reactiverFragment(idFragment);

        System.out.println("Fragment reactive s'il existait.");
    }
}
