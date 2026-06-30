package classes;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Représente un utilisateur de l'application. Les liens vers les entrées de
 * collection et les groupes sont stockés sous forme d'identifiants pour éviter
 * une imbrication directe des objets.
 */

public class Utilisateur implements Serializable {

    private int id;
    private String pseudo;
    private String email;
    // Les relations avec les autres objets sont conservées par identifiants.
    // Les objets complets sont retrouvés via les classes Liste.
    private ArrayList<Integer> idsEntreesCollection;
    private ArrayList<Integer> idsGroupes;
    private boolean actif;

    public Utilisateur(int id, String pseudo, String email) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.idsEntreesCollection = new ArrayList<Integer>();
        this.idsGroupes = new ArrayList<Integer>();
        this.actif = true;
    }

    public void ajouterIdEntreeCollection(int idEntreeCollection) {
        if (!idsEntreesCollection.contains(idEntreeCollection)) {
            idsEntreesCollection.add(idEntreeCollection);
        }
    }

    public void ajouterIdGroupe(int idGroupe) {
        if (!idsGroupes.contains(idGroupe)) {
            idsGroupes.add(idGroupe);
        }
    }

    // Suppression par valeur et non par indice dans l'ArrayList<Integer>.
    public void retirerIdEntreeCollection(int idEntreeCollection) {
        idsEntreesCollection.remove(Integer.valueOf(idEntreeCollection));
    }

    // Integer.valueOf permet de supprimer la valeur idGroupe,
    // et non l'élément situé à l'indice idGroupe.
    public void retirerIdGroupe(int idGroupe) {
        idsGroupes.remove(Integer.valueOf(idGroupe));
    }

    public void afficher() {
        System.out.println("Utilisateur #" + id);
        System.out.println("Pseudo : " + pseudo);
        System.out.println("Email : " + email);
        System.out.println("Entrées de collection : " + idsEntreesCollection);
        System.out.println("Groupes : " + idsGroupes);
        System.out.println("Actif : " + actif);
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Integer> getIdsEntreesCollection() {
        return idsEntreesCollection;
    }

    public ArrayList<Integer> getIdsGroupes() {
        return idsGroupes;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Désactivation logique : l'utilisateur reste en mémoire mais n'est plus considéré comme actif.
    public void geler() {
        this.actif = false;
    }

    public void reactiver() {
        this.actif = true;
    }

    public boolean isActif() {
        return actif;
    }
}
