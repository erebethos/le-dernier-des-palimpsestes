package classes;

/**
 * Type spécialisé de Fragment représentant un extrait provenant du web.
 * Elle ajoute des informations comme le site, l'URL et le titre de la page.
 */

public class ExtraitWeb extends Fragment {

    private String titrePage;
    private String site;
    private String url;
    private String auteur;

    public ExtraitWeb(int id, String texte, int idCreateur, String titrePage, String site, String url, String auteur) {
        super(id, texte, idCreateur);
        this.titrePage = titrePage;
        this.site = site;
        this.url = url;
        this.auteur = auteur;
    }

    public void afficher() {
        System.out.println("Extrait web #" + id);
        System.out.println("Titre de la page : " + titrePage);
        System.out.println("Site : " + site);

        if (auteur != null && !auteur.isEmpty()) {
            System.out.println("Auteur : " + auteur);
        }

        System.out.println("URL : " + url);
        System.out.println("Extrait : \"" + texte + "\"");
        System.out.println("Créateur : utilisateur #" + idCreateur);
        infoCreation.afficher();
    }

    public String getTitrePage() {
        return titrePage;
    }

    public String getSite() {
        return site;
    }

    public String getUrl() {
        return url;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setTitrePage(String titrePage) {
        this.titrePage = titrePage;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
