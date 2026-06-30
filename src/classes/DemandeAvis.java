package classes;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Représente une demande d'avis concernant un fragment. Elle conserve les
 * identifiants du fragment, du demandeur, des destinataires et des avis reçus.
 */

public class DemandeAvis implements Serializable {

    private int id;
    private int idFragment;
    private int idDemandeur;
    private ArrayList<Integer> idsDestinataires;
    private ArrayList<Integer> idsAvis;
    private String message;
    private StatutDemande statut;
    private InfoCreation infoCreation;
    private boolean actif;

    public DemandeAvis(int id, int idFragment, int idDemandeur, ArrayList<Integer> idsDestinataires, String message) {
        this.id = id;
        this.idFragment = idFragment;
        this.idDemandeur = idDemandeur;
        this.idsDestinataires = idsDestinataires;
        this.idsAvis = new ArrayList<Integer>();
        this.message = message;
        this.statut = StatutDemande.EN_ATTENTE;
        this.infoCreation = new InfoCreation();
        this.actif = true;
    }

    public void ajouterIdAvis(int idAvis) {
        if (!idsAvis.contains(idAvis)) {
            idsAvis.add(idAvis);
            mettreAJourStatut();
        }
    }
    
    // Suppression de la valeur idAvis, pas de l'indice dans l'ArrayList.
    public void retirerIdAvis(int idAvis) {
        idsAvis.remove(Integer.valueOf(idAvis));
        mettreAJourStatut();
    }

    public boolean estDestinataire(int idUtilisateur) {
        return idsDestinataires.contains(idUtilisateur);
    }

    public boolean estDemandeur(int idUtilisateur) {
        return idDemandeur == idUtilisateur;
    }

    public boolean tousLesDestinatairesOntRepondu() {
        return idsAvis.size() >= idsDestinataires.size();
    }

    public void annuler() {
        statut = StatutDemande.ANNULEE;
    }

    // Met à jour automatiquement le statut selon le nombre d'avis reçus.
    private void mettreAJourStatut() {
        if (statut == StatutDemande.ANNULEE) {
            return;
        }

        if (idsAvis.isEmpty()) {
            statut = StatutDemande.EN_ATTENTE;
        } else if (tousLesDestinatairesOntRepondu()) {
            statut = StatutDemande.TRAITEE;
        } else {
            statut = StatutDemande.EN_COURS;
        }
    }

    public void afficher() {
        System.out.println("Demande d'avis #" + id);
        System.out.println("Fragment concerné : #" + idFragment);
        System.out.println("Demandeur : utilisateur #" + idDemandeur);
        System.out.println("Destinataires : " + idsDestinataires);
        System.out.println("Avis reçus : " + idsAvis);
        System.out.println("Message : " + message);
        System.out.println("Statut : " + statut);
        infoCreation.afficher();
        System.out.println("Actif : " + actif);
    }

    public int getId() {
        return id;
    }

    public int getIdFragment() {
        return idFragment;
    }

    public int getIdDemandeur() {
        return idDemandeur;
    }

    public ArrayList<Integer> getIdsDestinataires() {
        return idsDestinataires;
    }

    public ArrayList<Integer> getIdsAvis() {
        return idsAvis;
    }

    public String getMessage() {
        return message;
    }

    public StatutDemande getStatut() {
        return statut;
    }

    public InfoCreation getInfoCreation() {
        return infoCreation;
    }

    public void setMessage(String message) {
        this.message = message;
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
