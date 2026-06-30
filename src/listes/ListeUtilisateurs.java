package listes;

import java.util.HashMap;
import java.io.Serializable;
import classes.Utilisateur;

/**
 * Gère l'ensemble des utilisateurs. La HashMap permet de retrouver directement
 * un utilisateur grâce à son identifiant.
 */

public class ListeUtilisateurs implements Serializable {

    // L'identifiant de l'utilisateur sert de clé dans la HashMap.
    private HashMap<Integer, Utilisateur> utilisateurs;
    private int prochainId;

    public ListeUtilisateurs() {
        this.utilisateurs = new HashMap<Integer, Utilisateur>();
        this.prochainId = 1;
    }

    // Crée un utilisateur, l'ajoute à la HashMap et prépare l'identifiant suivant.
    public Utilisateur ajouterUtilisateur(String pseudo, String email) {
        Utilisateur utilisateur = new Utilisateur(prochainId, pseudo, email);
        utilisateurs.put(prochainId, utilisateur);
        prochainId++;
        return utilisateur;
    }

    public Utilisateur trouverParId(int id) {
        return utilisateurs.get(id);
    }

    public boolean existe(int id) {
        return utilisateurs.containsKey(id);
    }

    public void supprimerUtilisateur(int id) {
        utilisateurs.remove(id);
    }

    // Désactive l'utilisateur sans le retirer physiquement de la collection.
    public void gelerUtilisateur(int id) {
        Utilisateur utilisateur = utilisateurs.get(id);

        if (utilisateur != null) {
            utilisateur.geler();
        }
    }

    public void reactiverUtilisateur(int id) {
        Utilisateur utilisateur = utilisateurs.get(id);

        if (utilisateur != null) {
            utilisateur.reactiver();
        }
    }

    public void afficherUtilisateurs() {
        System.out.println("=== Liste des utilisateurs ===");

        for (Utilisateur utilisateur : utilisateurs.values()) {
            utilisateur.afficher();
            System.out.println("-------------------------");
        }
    }

    public HashMap<Integer, Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
}
