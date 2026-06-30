package listes;

import java.util.HashMap;
import java.io.Serializable;
import classes.Groupe;
import classes.Utilisateur;

/**
 * Gère l'ensemble des groupes.
 * Elle centralise la création des groupes et la gestion des membres.
 */

public class ListeGroupes implements Serializable {

    private HashMap<Integer, Groupe> groupes;
    private int prochainId;

    public ListeGroupes() {
        this.groupes = new HashMap<Integer, Groupe>();
        this.prochainId = 1;
    }

    public Groupe ajouterGroupe(String nom, int idCreateur, ListeUtilisateurs listeUtilisateurs) {
        if (!listeUtilisateurs.existe(idCreateur)) {
            System.out.println("Impossible de créer le groupe : le créateur n'existe pas.");
            return null;
        }

        Groupe groupe = new Groupe(prochainId, nom, idCreateur);
        groupes.put(prochainId, groupe);

        Utilisateur createur = listeUtilisateurs.trouverParId(idCreateur);
        createur.ajouterIdGroupe(prochainId);

        prochainId++;
        return groupe;
    }
    
    // Le groupe et l'utilisateur sont mis à jour pour garder une relation cohérente.
    public void ajouterMembre(int idGroupe, int idUtilisateur, ListeUtilisateurs listeUtilisateurs) {
        if (!groupes.containsKey(idGroupe)) {
            System.out.println("Impossible d'ajouter le membre : le groupe n'existe pas.");
            return;
        }

        if (!listeUtilisateurs.existe(idUtilisateur)) {
            System.out.println("Impossible d'ajouter le membre : l'utilisateur n'existe pas.");
            return;
        }

        Groupe groupe = groupes.get(idGroupe);
        groupe.ajouterMembre(idUtilisateur);

        Utilisateur utilisateur = listeUtilisateurs.trouverParId(idUtilisateur);
        utilisateur.ajouterIdGroupe(idGroupe);
    }

    public void retirerMembre(int idGroupe, int idUtilisateur, ListeUtilisateurs listeUtilisateurs) {
        if (!groupes.containsKey(idGroupe)) {
            System.out.println("Impossible de retirer le membre : le groupe n'existe pas.");
            return;
        }

        if (!listeUtilisateurs.existe(idUtilisateur)) {
            System.out.println("Impossible de retirer le membre : l'utilisateur n'existe pas.");
            return;
        }

        Groupe groupe = groupes.get(idGroupe);
        groupe.retirerMembre(idUtilisateur);

        Utilisateur utilisateur = listeUtilisateurs.trouverParId(idUtilisateur);
        utilisateur.retirerIdGroupe(idGroupe);
    }

    public Groupe trouverParId(int id) {
        return groupes.get(id);
    }

    public boolean existe(int id) {
        return groupes.containsKey(id);
    }

    public void supprimerGroupe(int idGroupe, ListeUtilisateurs listeUtilisateurs) {
        Groupe groupe = groupes.get(idGroupe);

        if (groupe != null) {
            for (int idMembre : groupe.getIdsMembres()) {
                Utilisateur utilisateur = listeUtilisateurs.trouverParId(idMembre);

                if (utilisateur != null) {
                    utilisateur.retirerIdGroupe(idGroupe);
                }
            }

            groupes.remove(idGroupe);
        }
    }

    public void gelerGroupe(int id) {
        Groupe groupe = groupes.get(id);

        if (groupe != null) {
            groupe.geler();
        }
    }

    public void reactiverGroupe(int id) {
        Groupe groupe = groupes.get(id);

        if (groupe != null) {
            groupe.reactiver();
        }
    }

    public void afficherGroupes() {
        System.out.println("=== Liste des groupes ===");

        for (Groupe groupe : groupes.values()) {
            groupe.afficher();
            System.out.println("-------------------------");
        }
    }

    public HashMap<Integer, Groupe> getGroupes() {
        return groupes;
    }
}
