package classes;

/**
 * Type spécialisé de Fragment représentant une citation.
 * Elle ajoute les informations propres à une citation : auteur, œuvre et année.
 */

public class Citation extends Fragment {

    private String auteur;
    private String oeuvre;
    private int annee;

    public Citation(int id, String texte, int idCreateur, String auteur, String oeuvre, int annee) {
        super(id, texte, idCreateur);
        this.auteur = auteur;
        this.oeuvre = oeuvre;
        this.annee = annee;
    }
    
    /* Surcharge du constructeur de Citation pour pouvoir créer une citation avec ou sans année. 
    Le constructeur court appelle le constructeur complet avec this(...). */
    
    public Citation(int id, String texte, int idCreateur, String auteur, String oeuvre) {
        this(id, texte, idCreateur, auteur, oeuvre, 0);
    }

    public void afficher() {
        System.out.println("Citation #" + id);
        System.out.println("\"" + texte + "\"");
        System.out.println("Auteur : " + auteur);
        System.out.println("Œuvre : " + oeuvre + " (" + annee + ")");
        System.out.println("Créateur : utilisateur #" + idCreateur);
        infoCreation.afficher();
    }

    public String getAuteur() {
        return auteur;
    }

    public String getOeuvre() {
        return oeuvre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setOeuvre(String oeuvre) {
        this.oeuvre = oeuvre;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
