package data;

import java.io.Serializable;
import listes.ListeAvis;
import listes.ListeDemandesAvis;
import listes.ListeEntreesCollection;
import listes.ListeFragments;
import listes.ListeGroupes;
import listes.ListeUtilisateurs;

/**
 * Classe centrale contenant toutes les listes de l'application.
 * Elle représente l'état complet du programme en mémoire.
 */ 

public class Data implements Serializable {
    private ListeUtilisateurs listeUtilisateurs;
    private ListeFragments listeFragments;
    private ListeEntreesCollection listeEntreesCollection;
    private ListeGroupes listeGroupes;
    private ListeDemandesAvis listeDemandesAvis;
    private ListeAvis listeAvis;

    public Data() {
        // Chaque liste gère une catégorie d'objets du projet.
        this.listeUtilisateurs = new ListeUtilisateurs();
        this.listeFragments = new ListeFragments();
        this.listeEntreesCollection = new ListeEntreesCollection();
        this.listeGroupes = new ListeGroupes();
        this.listeDemandesAvis = new ListeDemandesAvis();
        this.listeAvis = new ListeAvis();
    }

    // Méthode pratique pour démontrer rapidement l'état complet de l'application.
    public void afficherToutesLesDonnees() {
        listeUtilisateurs.afficherUtilisateurs();
        System.out.println();

        listeFragments.afficherFragments();
        System.out.println();

        listeEntreesCollection.afficherEntreesCollection();
        System.out.println();

        listeGroupes.afficherGroupes();
        System.out.println();

        listeDemandesAvis.afficherDemandesAvis();
        System.out.println();

        listeAvis.afficherAvis();
    }

    public ListeUtilisateurs getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public ListeFragments getListeFragments() {
        return listeFragments;
    }

    public ListeEntreesCollection getListeEntreesCollection() {
        return listeEntreesCollection;
    }

    public ListeGroupes getListeGroupes() {
        return listeGroupes;
    }

    public ListeDemandesAvis getListeDemandesAvis() {
        return listeDemandesAvis;
    }

    public ListeAvis getListeAvis() {
        return listeAvis;
    }
}