package classes;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Représente un groupe d'utilisateurs.
 * Les membres sont stockés sous forme d'identifiants pour rester cohérent
 * avec la logique des HashMap utilisées dans les classes Liste.
 */

public class Groupe implements Serializable {

    private int id;
    private String nom;
    private int idCreateur;
    private ArrayList<Integer> idsMembres;
    private boolean actif;

    public Groupe(int id, String nom, int idCreateur) {
        this.id = id;
        this.nom = nom;
        this.idCreateur = idCreateur;
        this.idsMembres = new ArrayList<Integer>();
        ajouterMembre(idCreateur);
        this.actif = true;
    }

    public void ajouterMembre(int idUtilisateur) {
        if (!idsMembres.contains(idUtilisateur)) {
            idsMembres.add(idUtilisateur);
        }
    }

    public void retirerMembre(int idUtilisateur) {
        idsMembres.remove(Integer.valueOf(idUtilisateur));
    }

    public boolean contientMembre(int idUtilisateur) {
        return idsMembres.contains(idUtilisateur);
    }

    public ArrayList<Integer> getIdsMembresSauf(int idUtilisateurAExclure) {
        ArrayList<Integer> resultat = new ArrayList<Integer>();

        for (int idMembre : idsMembres) {
            if (idMembre != idUtilisateurAExclure) {
                resultat.add(idMembre);
            }
        }

        return resultat;
    }

    public void afficher() {
        System.out.println("Groupe #" + id);
        System.out.println("Nom : " + nom);
        System.out.println("Créateur : utilisateur #" + idCreateur);
        System.out.println("Membres : " + idsMembres);
        System.out.println("Actif : " + actif);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public ArrayList<Integer> getIdsMembres() {
        return idsMembres;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

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
