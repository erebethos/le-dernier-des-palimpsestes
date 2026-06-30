package classes;

/**
 * Type spécialisé de Fragment représentant une note de lecture.
 * Le texte hérité de Fragment correspond à la note personnelle,
 * tandis que l'extrait original est conservé séparément.
 */

public class NoteLecture extends Fragment {

    private String extraitOriginal;
    private String auteur;
    private String oeuvre;
    private int annee;
    private int page;

    public NoteLecture(int id, String texte, int idCreateur, String extraitOriginal, String auteur, String oeuvre, int annee, int page) {
        super(id, texte, idCreateur);
        this.extraitOriginal = extraitOriginal;
        this.auteur = auteur;
        this.oeuvre = oeuvre;
        this.annee = annee;
        this.page = page;
    }

    public void afficher() {
        System.out.println("Note de lecture #" + id);
        System.out.println("Œuvre : " + oeuvre + " (" + annee + ")");
        System.out.println("Auteur : " + auteur);

        if (page > 0) {
            System.out.println("Page : " + page);
        }

        System.out.println("Extrait original : \"" + extraitOriginal + "\"");
        System.out.println("Note personnelle : " + texte);
        System.out.println("Créateur : utilisateur #" + idCreateur);
        infoCreation.afficher();
    }

    public String getExtraitOriginal() {
        return extraitOriginal;
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

    public int getPage() {
        return page;
    }

    public void setExtraitOriginal(String extraitOriginal) {
        this.extraitOriginal = extraitOriginal;
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

    public void setPage(int page) {
        this.page = page;
    }
}
