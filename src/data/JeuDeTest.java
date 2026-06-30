package data;

import classes.Citation;
import classes.DemandeAvis;
import classes.EntreeCollection;
import classes.ExtraitWeb;
import classes.Groupe;
import classes.NoteLecture;
import classes.PenseePersonnelle;
import classes.TypeAvis;
import classes.Utilisateur;

/**
 * Initialise des données de démonstration.
 * Cette classe est séparée de Data pour ne pas mélanger les données réelles
 * et les données de test.
 */

public class JeuDeTest {

    // Remplit les listes avec un scénario complet permettant de tester le programme.
    public static void initialiser(Data data) {
        Utilisateur francois = data.getListeUtilisateurs().ajouterUtilisateur("francois", "francois@example.com");
        Utilisateur dominique = data.getListeUtilisateurs().ajouterUtilisateur("dominique", "dominique@example.com");
        Utilisateur judith = data.getListeUtilisateurs().ajouterUtilisateur("judith", "judith@example.com");
        Utilisateur alcide = data.getListeUtilisateurs().ajouterUtilisateur("alcide", "alcide@example.com");

        Citation citation = data.getListeFragments().ajouterCitation(
                "ce qui ne me tue pas me rend plus fort",
                francois.getId(),
                "Friedrich Nietzsche",
                "Crepuscule des idoles",
                1888
        );

        PenseePersonnelle pensee = data.getListeFragments().ajouterPenseePersonnelle(
                "un fragment n'est pas seulement un texte, c'est une trace conservee",
                francois.getId()
        );

        NoteLecture note = data.getListeFragments().ajouterNoteLecture(
                "ce passage resume bien l'idee de retrait volontaire",
                francois.getId(),
                "Fuis, mon ami, dans ta solitude.",
                "Friedrich Nietzsche",
                "Ainsi parlait Zarathoustra",
                1883,
                0
        );

        ExtraitWeb extrait = data.getListeFragments().ajouterExtraitWeb(
                "un court passage trouve sur le web a propos de la memoire numerique",
                francois.getId(),
                "Memoire et traces numeriques",
                "Exemple.org",
                "https://exemple.org/memoire",
                ""
        );

        EntreeCollection entreeCitation = data.getListeEntreesCollection().ajouterEntreeCollection(
                francois.getId(),
                citation.getId(),
                data.getListeUtilisateurs(),
                data.getListeFragments()
        );

        if (entreeCitation != null) {
            entreeCitation.ajouterTheme("philosophie");
            entreeCitation.ajouterMotCle("force");
            entreeCitation.ajouterMotCle("nietzsche");
            entreeCitation.mettreEnFavori();
            entreeCitation.setCommentairePersonnel("Fragment central pour tester les favoris et les mots-cles.");
        }

        EntreeCollection entreePensee = data.getListeEntreesCollection().ajouterEntreeCollection(
                francois.getId(),
                pensee.getId(),
                data.getListeUtilisateurs(),
                data.getListeFragments()
        );

        if (entreePensee != null) {
            entreePensee.ajouterTheme("palimpseste");
            entreePensee.ajouterMotCle("trace");
            entreePensee.setCommentairePersonnel("Exemple de pensee personnelle.");
        }

        data.getListeEntreesCollection().ajouterEntreeCollection(
                francois.getId(),
                note.getId(),
                data.getListeUtilisateurs(),
                data.getListeFragments()
        );

        data.getListeEntreesCollection().ajouterEntreeCollection(
                francois.getId(),
                extrait.getId(),
                data.getListeUtilisateurs(),
                data.getListeFragments()
        );

        Groupe groupe = data.getListeGroupes().ajouterGroupe(
                "Lecteurs du soir",
                francois.getId(),
                data.getListeUtilisateurs()
        );

        if (groupe != null) {
            data.getListeGroupes().ajouterMembre(groupe.getId(), dominique.getId(), data.getListeUtilisateurs());
            data.getListeGroupes().ajouterMembre(groupe.getId(), judith.getId(), data.getListeUtilisateurs());
            data.getListeGroupes().ajouterMembre(groupe.getId(), alcide.getId(), data.getListeUtilisateurs());
        }

        DemandeAvis demande = data.getListeDemandesAvis().ajouterDemandeAvisPourGroupe(
                citation.getId(),
                francois.getId(),
                groupe.getId(),
                "Que pensez-vous de ce fragment ?",
                data.getListeUtilisateurs(),
                data.getListeFragments(),
                data.getListeGroupes()
        );

        if (demande != null) {
            data.getListeAvis().ajouterAvis(
                    demande.getId(),
                    dominique.getId(),
                    4,
                    TypeAvis.INTERESSANT,
                    "Fragment fort, mais le classement pourrait etre precise.",
                    data.getListeDemandesAvis()
            );

            data.getListeAvis().ajouterAvis(
                    demande.getId(),
                    judith.getId(),
                    5,
                    TypeAvis.PERTINENT,
                    "Tres pertinent pour une collection philosophique.",
                    data.getListeDemandesAvis()
            );
        }
    }
}