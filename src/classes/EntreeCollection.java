package classes;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Représente la conservation personnelle d'un fragment par un utilisateur.
 * Cette classe sépare le contenu brut du fragment de son classement personnel :
 * thèmes, mots-clés, favori, commentaire et mode d'archivage.
 */

public class EntreeCollection implements Serializable {

    private int id;
    private int idUtilisateur;
    private int idFragment;
    private ArrayList<String> themes;
    private ArrayList<String> motsCles;
    private boolean favori;
    private ModeArchivage modeArchivage;
    private String commentairePersonnel;
    private boolean actif;

    public EntreeCollection(int id, int idUtilisateur, int idFragment) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.idFragment = idFragment;
        this.themes = new ArrayList<String>();
        this.motsCles = new ArrayList<String>();
        this.favori = false;
        this.modeArchivage = ModeArchivage.INDEXE;
        this.commentairePersonnel = "";
        this.actif = true;
    }

    /* Surcharge du constructeur d’EntreeCollection : on peut créer 
    une entrée simple ou une entrée avec un commentaire personnel dès le départ. */
    public EntreeCollection(int id, int idUtilisateur, int idFragment, String commentairePersonnel) {
        this(id, idUtilisateur, idFragment);
        this.commentairePersonnel = commentairePersonnel;
    }

    public void ajouterTheme(String theme) {
        if (theme != null && !theme.isEmpty() && !themes.contains(theme)) {
            themes.add(theme);
        }
    }

    public void retirerTheme(String theme) {
        themes.remove(theme);
    }

    public void ajouterMotCle(String motCle) {
        if (motCle != null && !motCle.isEmpty() && !motsCles.contains(motCle)) {
            motsCles.add(motCle);
        }
    }

    /* Surcharge de ajouterMotCle. La version simple ajoute un mot-clé normal. 
    La version avec un booléen permet de marquer un mot-clé comme important. */
    public void ajouterMotCle(String motCle, boolean important) {
        if (important) {
            ajouterMotCle("important:" + motCle);
        } else {
            ajouterMotCle(motCle);
        }
    }

    public void retirerMotCle(String motCle) {
        motsCles.remove(motCle);
    }

    public void mettreEnFavori() {
        favori = true;
    }

    public void retirerDesFavoris() {
        favori = false;
    }

    public void archiverLibre() {
        modeArchivage = ModeArchivage.ARCHIVE_LIBRE;
    }

    public void indexer() {
        modeArchivage = ModeArchivage.INDEXE;
    }

    public void afficher() {
        System.out.println("Entrée de collection #" + id);
        System.out.println("Utilisateur : #" + idUtilisateur);
        System.out.println("Fragment : #" + idFragment);
        System.out.println("Mode d'archivage : " + modeArchivage);
        System.out.println("Favori : " + favori);
        System.out.println("Thèmes : " + themes);
        System.out.println("Mots-clés : " + motsCles);
        System.out.println("Commentaire personnel : " + commentairePersonnel);
        System.out.println("Actif : " + actif);
    }

    public int getId() {
        return id;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int getIdFragment() {
        return idFragment;
    }

    public ArrayList<String> getThemes() {
        return themes;
    }

    public ArrayList<String> getMotsCles() {
        return motsCles;
    }

    public boolean isFavori() {
        return favori;
    }

    public ModeArchivage getModeArchivage() {
        return modeArchivage;
    }

    public String getCommentairePersonnel() {
        return commentairePersonnel;
    }

    public void setCommentairePersonnel(String commentairePersonnel) {
        this.commentairePersonnel = commentairePersonnel;
    }

    public void setModeArchivage(ModeArchivage modeArchivage) {
        this.modeArchivage = modeArchivage;
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
