package listes;

import java.util.HashMap;
import java.io.Serializable;
import classes.Citation;
import classes.ExtraitWeb;
import classes.Fragment;
import classes.NoteLecture;
import classes.PenseePersonnelle;

/**
 * Gère l'ensemble des fragments. La HashMap stocke des objets de type Fragment,
 * ce qui permet le polymorphisme avec les différentes classes filles.
 */
public class ListeFragments implements Serializable {

    // Stockage polymorphe : les valeurs sont de type Fragment,
    // mais peuvent contenir des Citation, NoteLecture, ExtraitWeb, etc.
    private HashMap<Integer, Fragment> fragments;
    private int prochainId;

    public ListeFragments() {
        this.fragments = new HashMap<Integer, Fragment>();
        this.prochainId = 1;
    }

    public Citation ajouterCitation(String texte, int idCreateur, String auteur, String oeuvre, int annee) {
        Citation citation = new Citation(prochainId, texte, idCreateur, auteur, oeuvre, annee);
        fragments.put(prochainId, citation);
        prochainId++;
        return citation;
    }

    /* ListeFragments contient une surcharge de ajouterCitation, 
    ce qui permet d’ajouter une citation avec ou sans année connue. */
    public Citation ajouterCitation(String texte, int idCreateur, String auteur, String oeuvre) {
        Citation citation = new Citation(prochainId, texte, idCreateur, auteur, oeuvre);
        fragments.put(prochainId, citation);
        prochainId++;
        return citation;
    }

    public PenseePersonnelle ajouterPenseePersonnelle(String texte, int idCreateur) {
        PenseePersonnelle pensee = new PenseePersonnelle(prochainId, texte, idCreateur);
        fragments.put(prochainId, pensee);
        prochainId++;
        return pensee;
    }

    public NoteLecture ajouterNoteLecture(String texte, int idCreateur, String extraitOriginal, String auteur, String oeuvre, int annee, int page) {
        NoteLecture note = new NoteLecture(prochainId, texte, idCreateur, extraitOriginal, auteur, oeuvre, annee, page);
        fragments.put(prochainId, note);
        prochainId++;
        return note;
    }

    public ExtraitWeb ajouterExtraitWeb(String texte, int idCreateur, String titrePage, String site, String url, String auteur) {
        ExtraitWeb extrait = new ExtraitWeb(prochainId, texte, idCreateur, titrePage, site, url, auteur);
        fragments.put(prochainId, extrait);
        prochainId++;
        return extrait;
    }

    // Grâce au polymorphisme, afficher() appelle la méthode du type réel de l'objet.
    public void afficherFragments() {
        System.out.println("=== Liste des fragments ===");

        for (Fragment fragment : fragments.values()) {
            fragment.afficher();
            System.out.println("-------------------------");
        }
    }

    public Fragment trouverParId(int id) {
        return fragments.get(id);
    }

    public boolean existe(int id) {
        return fragments.containsKey(id);
    }

    public void supprimerFragment(int id) {
        fragments.remove(id);
    }

    public void gelerFragment(int id) {
        Fragment fragment = fragments.get(id);

        if (fragment != null) {
            fragment.geler();
        }
    }

    public void reactiverFragment(int id) {
        Fragment fragment = fragments.get(id);

        if (fragment != null) {
            fragment.reactiver();
        }
    }

    public HashMap<Integer, Fragment> getFragments() {
        return fragments;
    }
}
