package menus;

import classes.TypeAvis;
import data.Data;
import outils.Saisie;

/**
 * Sous-menu responsable des demandes d'avis et des avis.
 * Il récupère les informations saisies puis délègue les traitements
 * aux classes Liste via Data.
 */

public class MenuAvis {

    private Data data;
    private Saisie saisie;

    public MenuAvis(Data data) {
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
                    demanderAvisGroupe();
                    break;

                case 2:
                    ajouterAvis();
                    break;

                case 3:
                    data.getListeDemandesAvis().afficherDemandesAvis();
                    break;

                case 4:
                    data.getListeAvis().afficherAvis();
                    break;

                case 5:
                    gelerDemandeAvis();
                    break;

                case 6:
                    reactiverDemandeAvis();
                    break;

                case 7:
                    gelerAvis();
                    break;

                case 8:
                    reactiverAvis();
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
        System.out.println("===== AVIS =====");
        System.out.println("1. Demander un avis a un groupe");
        System.out.println("2. Ajouter un avis");
        System.out.println("3. Afficher les demandes d'avis");
        System.out.println("4. Afficher les avis");
        System.out.println("5. Geler une demande d'avis");
        System.out.println("6. Reactiver une demande d'avis");
        System.out.println("7. Geler un avis");
        System.out.println("8. Reactiver un avis");
        System.out.println("0. Retour");
    }

    private void demanderAvisGroupe() {
        System.out.println("=== Demander un avis a un groupe ===");

        int idFragment = saisie.lireInt("Id du fragment : ");
        int idDemandeur = saisie.lireInt("Id du demandeur : ");
        int idGroupe = saisie.lireInt("Id du groupe : ");
        String message = saisie.lireTexte("Message : ");

        data.getListeDemandesAvis().ajouterDemandeAvisPourGroupe(
                idFragment,
                idDemandeur,
                idGroupe,
                message,
                data.getListeUtilisateurs(),
                data.getListeFragments(),
                data.getListeGroupes()
        );

        System.out.println("Demande creee si les identifiants etaient valides.");
    }

    private void ajouterAvis() {
        System.out.println("=== Ajouter un avis ===");

        int idDemandeAvis = saisie.lireInt("Id de la demande d'avis : ");
        int idAuteur = saisie.lireInt("Id de l'auteur de l'avis : ");
        int note = saisie.lireInt("Note entre 1 et 5 : ");

        afficherTypesAvis();
        int choixType = saisie.lireInt("Choix du type d'avis : ");
        TypeAvis typeAvis = convertirChoixTypeAvis(choixType);

        String commentaire = saisie.lireTexte("Commentaire : ");

        data.getListeAvis().ajouterAvis(
                idDemandeAvis,
                idAuteur,
                note,
                typeAvis,
                commentaire,
                data.getListeDemandesAvis()
        );

        System.out.println("Avis ajoute si la demande existe et si l'utilisateur est destinataire.");
    }

    private void afficherTypesAvis() {
        System.out.println("Types d'avis :");
        System.out.println("1. PERTINENT");
        System.out.println("2. INTERESSANT");
        System.out.println("3. A_REVOIR");
        System.out.println("4. MAL_CLASSE");
        System.out.println("5. DOUBLON");
        System.out.println("6. HORS_SUJET");
    }

    private TypeAvis convertirChoixTypeAvis(int choix) {
        switch (choix) {
            case 1:
                return TypeAvis.PERTINENT;
            case 2:
                return TypeAvis.INTERESSANT;
            case 3:
                return TypeAvis.A_REVOIR;
            case 4:
                return TypeAvis.MAL_CLASSE;
            case 5:
                return TypeAvis.DOUBLON;
            case 6:
                return TypeAvis.HORS_SUJET;
            default:
                System.out.println("Type invalide, type par defaut : INTERESSANT.");
                return TypeAvis.INTERESSANT;
        }
    }

    private void gelerDemandeAvis() {
        System.out.println("=== Geler une demande d'avis ===");

        int idDemande = saisie.lireInt("Id de la demande a geler : ");

        data.getListeDemandesAvis().gelerDemandeAvis(idDemande);

        System.out.println("Demande gelee si elle existait.");
    }

    private void reactiverDemandeAvis() {
        System.out.println("=== Reactiver une demande d'avis ===");

        int idDemande = saisie.lireInt("Id de la demande a reactiver : ");

        data.getListeDemandesAvis().reactiverDemandeAvis(idDemande);

        System.out.println("Demande reactivee si elle existait.");
    }

    private void gelerAvis() {
        System.out.println("=== Geler un avis ===");

        int idAvis = saisie.lireInt("Id de l'avis a geler : ");

        data.getListeAvis().gelerAvis(idAvis);

        System.out.println("Avis gele s'il existait.");
    }

    private void reactiverAvis() {
        System.out.println("=== Reactiver un avis ===");

        int idAvis = saisie.lireInt("Id de l'avis a reactiver : ");

        data.getListeAvis().reactiverAvis(idAvis);

        System.out.println("Avis reactive s'il existait.");
    }
}
