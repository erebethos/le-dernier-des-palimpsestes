package listes;

import java.util.HashMap;
import classes.Avis;
import classes.DemandeAvis;
import classes.TypeAvis;
import java.io.Serializable;

/**
 * Gère l'ensemble des avis.
 * Lorsqu'un avis est créé, son identifiant est ajouté à la demande concernée.
 */

public class ListeAvis implements Serializable {

    private HashMap<Integer, Avis> avis;
    private int prochainId;

    public ListeAvis() {
        this.avis = new HashMap<Integer, Avis>();
        this.prochainId = 1;
    }

    public Avis ajouterAvis(int idDemandeAvis, int idAuteur, int note, TypeAvis typeAvis, String commentaire, ListeDemandesAvis listeDemandesAvis) {
        
        if (!listeDemandesAvis.existe(idDemandeAvis)) {
            System.out.println("Impossible d'ajouter l'avis : la demande d'avis n'existe pas.");
            return null;
        }
        //On sait que la demande exite alors on la récupère
        DemandeAvis demande = listeDemandesAvis.trouverParId(idDemandeAvis);

        // Un utilisateur ne peut donner un avis que s'il est destinataire de la demande.
        if (!demande.estDestinataire(idAuteur)) {
            System.out.println("Impossible d'ajouter l'avis : cet utilisateur n'est pas destinataire de la demande.");
            return null;
        }

        Avis nouvelAvis = new Avis(prochainId, idDemandeAvis, idAuteur, note, typeAvis, commentaire);
        avis.put(prochainId, nouvelAvis);

        demande.ajouterIdAvis(prochainId);

        prochainId++;
        return nouvelAvis;
    }

    public Avis trouverParId(int id) {
        return avis.get(id);
    }

    public boolean existe(int id) {
        return avis.containsKey(id);
    }

    public void supprimerAvis(int id) {
        avis.remove(id);
    }

    public void gelerAvis(int id) {
        Avis unAvis = avis.get(id);

        if (unAvis != null) {
            unAvis.geler();
        }
    }

    public void reactiverAvis(int id) {
        Avis unAvis = avis.get(id);

        if (unAvis != null) {
            unAvis.reactiver();
        }
    }

    public void afficherAvis() {
        System.out.println("=== Liste des avis ===");

        for (Avis unAvis : avis.values()) {
            unAvis.afficher();
            System.out.println("-------------------------");
        }
    }

    public void afficherAvisPourDemande(int idDemandeAvis) {
        System.out.println("=== Avis pour la demande #" + idDemandeAvis + " ===");

        for (Avis unAvis : avis.values()) {
            if (unAvis.getIdDemandeAvis() == idDemandeAvis) {
                unAvis.afficher();
                System.out.println("-------------------------");
            }
        }
    }

    public HashMap<Integer, Avis> getAvis() {
        return avis;
    }
}
