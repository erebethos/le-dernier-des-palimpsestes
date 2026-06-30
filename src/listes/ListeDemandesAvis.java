package listes;

import java.util.ArrayList;
import java.util.HashMap;
import classes.DemandeAvis;
import classes.Groupe;
import java.io.Serializable;

/**
 * Gère les demandes d'avis.
 * Elle peut créer une demande vers une liste d'utilisateurs ou vers un groupe.
 */

public class ListeDemandesAvis implements Serializable {

    private HashMap<Integer, DemandeAvis> demandesAvis;
    private int prochainId;

    public ListeDemandesAvis() {
        this.demandesAvis = new HashMap<Integer, DemandeAvis>();
        this.prochainId = 1;
    }

    // Conserve uniquement les destinataires existants, différents du demandeur et sans doublons.
    public DemandeAvis ajouterDemandeAvis(
            int idFragment,
            int idDemandeur,
            ArrayList<Integer> idsDestinataires,
            String message,
            ListeUtilisateurs listeUtilisateurs,
            ListeFragments listeFragments
    ) {
        if (!listeFragments.existe(idFragment)) {
            System.out.println("Impossible de créer la demande : le fragment n'existe pas.");
            return null;
        }

        if (!listeUtilisateurs.existe(idDemandeur)) {
            System.out.println("Impossible de créer la demande : le demandeur n'existe pas.");
            return null;
        }

        ArrayList<Integer> destinatairesValides = new ArrayList<Integer>();

        for (int idDestinataire : idsDestinataires) {
            if (listeUtilisateurs.existe(idDestinataire) && idDestinataire != idDemandeur) {
                if (!destinatairesValides.contains(idDestinataire)) {
                    destinatairesValides.add(idDestinataire);
                }
            }
        }

        if (destinatairesValides.isEmpty()) {
            System.out.println("Impossible de créer la demande : aucun destinataire valide.");
            return null;
        }

        DemandeAvis demande = new DemandeAvis(
                prochainId,
                idFragment,
                idDemandeur,
                destinatairesValides,
                message
        );

        demandesAvis.put(prochainId, demande);
        prochainId++;

        return demande;
    }

    public DemandeAvis ajouterDemandeAvisPourGroupe(
            int idFragment,
            int idDemandeur,
            int idGroupe,
            String message,
            ListeUtilisateurs listeUtilisateurs,
            ListeFragments listeFragments,
            ListeGroupes listeGroupes
    ) {
        if (!listeGroupes.existe(idGroupe)) {
            System.out.println("Impossible de créer la demande : le groupe n'existe pas.");
            return null;
        }

        Groupe groupe = listeGroupes.trouverParId(idGroupe);
        ArrayList<Integer> destinataires = groupe.getIdsMembresSauf(idDemandeur);

        return ajouterDemandeAvis(
                idFragment,
                idDemandeur,
                destinataires,
                message,
                listeUtilisateurs,
                listeFragments
        );
    }

    public DemandeAvis trouverParId(int id) {
        return demandesAvis.get(id);
    }

    public boolean existe(int id) {
        return demandesAvis.containsKey(id);
    }

    public void supprimerDemandeAvis(int id) {
        demandesAvis.remove(id);
    }

    public void gelerDemandeAvis(int id) {
        DemandeAvis demande = demandesAvis.get(id);

        if (demande != null) {
            demande.geler();
        }
    }

    public void reactiverDemandeAvis(int id) {
        DemandeAvis demande = demandesAvis.get(id);

        if (demande != null) {
            demande.reactiver();
        }
    }

    public void afficherDemandesAvis() {
        System.out.println("=== Liste des demandes d'avis ===");

        for (DemandeAvis demande : demandesAvis.values()) {
            demande.afficher();
            System.out.println("-------------------------");
        }
    }

    public void afficherDemandesPourFragment(int idFragment) {
        System.out.println("=== Demandes d'avis pour le fragment #" + idFragment + " ===");

        for (DemandeAvis demande : demandesAvis.values()) {
            if (demande.getIdFragment() == idFragment) {
                demande.afficher();
                System.out.println("-------------------------");
            }
        }
    }

    public void afficherDemandesPourUtilisateur(int idUtilisateur) {
        System.out.println("=== Demandes reçues par l'utilisateur #" + idUtilisateur + " ===");

        for (DemandeAvis demande : demandesAvis.values()) {
            if (demande.estDestinataire(idUtilisateur)) {
                demande.afficher();
                System.out.println("-------------------------");
            }
        }
    }

    public HashMap<Integer, DemandeAvis> getDemandesAvis() {
        return demandesAvis;
    }
}
