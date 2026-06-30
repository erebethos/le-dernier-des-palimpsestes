package classes;

import java.io.Serializable;

/**
 * Représente l'avis donné par un utilisateur sur une demande d'avis.
 * La note est contrôlée par encapsulation afin de rester comprise entre 1 et 5.
 */

public class Avis implements Serializable {

    private int id;
    private int idDemandeAvis;
    private int idAuteur;
    private int note;
    private TypeAvis typeAvis;
    private String commentaire;
    private InfoCreation infoCreation;
    private boolean actif;

    public Avis(int id, int idDemandeAvis, int idAuteur, int note, TypeAvis typeAvis, String commentaire) {
        this.id = id;
        this.idDemandeAvis = idDemandeAvis;
        this.idAuteur = idAuteur;
        // On passe par le setter pour appliquer le contrôle de validité dès la création.
        setNote(note);
        this.typeAvis = typeAvis;
        this.commentaire = commentaire;
        this.infoCreation = new InfoCreation();
        this.actif = true;
    }

    public void afficher() {
        System.out.println("Avis #" + id);
        System.out.println("Demande d'avis : #" + idDemandeAvis);
        System.out.println("Auteur de l'avis : utilisateur #" + idAuteur);
        System.out.println("Note : " + note + "/5");
        System.out.println("Type d'avis : " + typeAvis);
        System.out.println("Commentaire : " + commentaire);
        infoCreation.afficher();
        System.out.println("Actif : " + actif);
    }

    public int getId() {
        return id;
    }

    public int getIdDemandeAvis() {
        return idDemandeAvis;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public int getNote() {
        return note;
    }

    public TypeAvis getTypeAvis() {
        return typeAvis;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public InfoCreation getInfoCreation() {
        return infoCreation;
    }

    // Encapsulation : la note est contrôlée pour rester entre 1 et 5.
    public void setNote(int note) {
        if (note < 1) {
            this.note = 1;
        } else if (note > 5) {
            this.note = 5;
        } else {
            this.note = note;
        }
    }

    public void setTypeAvis(TypeAvis typeAvis) {
        this.typeAvis = typeAvis;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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
