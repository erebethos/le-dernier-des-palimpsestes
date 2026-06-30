package listes;

import java.util.HashMap;
import classes.EntreeCollection;
import classes.Utilisateur;
import java.io.Serializable;

/**
 * Gère les entrées de collection.
 * Elle crée le lien entre un utilisateur et un fragment,
 * puis met à jour l'utilisateur concerné.
 */

public class ListeEntreesCollection implements Serializable {

    private HashMap<Integer, EntreeCollection> entreesCollection;
    private int prochainId;

    public ListeEntreesCollection() {
        this.entreesCollection = new HashMap<Integer, EntreeCollection>();
        this.prochainId = 1;
    }

    public EntreeCollection ajouterEntreeCollection(int idUtilisateur, int idFragment, ListeUtilisateurs listeUtilisateurs, ListeFragments listeFragments) {
        // Vérifie que les deux objets reliés existent avant de créer l'entrée.
        if (!listeUtilisateurs.existe(idUtilisateur)) {
            System.out.println("Impossible d'ajouter l'entrée : l'utilisateur n'existe pas.");
            return null;
        }

        if (!listeFragments.existe(idFragment)) {
            System.out.println("Impossible d'ajouter l'entrée : le fragment n'existe pas.");
            return null;
        }
        
        EntreeCollection entree = new EntreeCollection(prochainId, idUtilisateur, idFragment);
        entreesCollection.put(prochainId, entree);

        // Maintient la cohérence : l'utilisateur conserve l'id de l'entrée créée.
        Utilisateur utilisateur = listeUtilisateurs.trouverParId(idUtilisateur);
        utilisateur.ajouterIdEntreeCollection(prochainId);

        prochainId++;
        return entree;
    }

    public EntreeCollection trouverParId(int id) {
        return entreesCollection.get(id);
    }

    public boolean existe(int id) {
        return entreesCollection.containsKey(id);
    }

    public void supprimerEntreeCollection(int id, ListeUtilisateurs listeUtilisateurs) {
        EntreeCollection entree = entreesCollection.get(id);

        if (entree != null) {
            Utilisateur utilisateur = listeUtilisateurs.trouverParId(entree.getIdUtilisateur());

            if (utilisateur != null) {
                utilisateur.retirerIdEntreeCollection(id);
            }

            entreesCollection.remove(id);
        }
    }

    public void gelerEntreeCollection(int id) {
        EntreeCollection entree = entreesCollection.get(id);

        if (entree != null) {
            entree.geler();
        }
    }

    public void reactiverEntreeCollection(int id) {
        EntreeCollection entree = entreesCollection.get(id);

        if (entree != null) {
            entree.reactiver();
        }
    }

    public void afficherEntreesCollection() {
        System.out.println("=== Liste des entrees de collection ===");

        for (EntreeCollection entree : entreesCollection.values()) {
            entree.afficher();
            System.out.println("-------------------------");
        }
    }

    public void afficherEntreesUtilisateur(int idUtilisateur) {
        System.out.println("=== Entrées de collection de l'utilisateur #" + idUtilisateur + " ===");

        for (EntreeCollection entree : entreesCollection.values()) {
            if (entree.getIdUtilisateur() == idUtilisateur) {
                entree.afficher();
                System.out.println("-------------------------");
            }
        }
    }

    public HashMap<Integer, EntreeCollection> getEntreesCollection() {
        return entreesCollection;
    }
}
