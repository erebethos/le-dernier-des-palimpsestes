package classes;

import java.io.Serializable;

/**
 * Classe mère des différents types de fragments.
 * Elle contient les attributs communs et permet le polymorphisme
 * avec Citation, PenseePersonnelle, NoteLecture et ExtraitWeb.
 */

public class Fragment implements Serializable {

    protected int id;
    protected String texte;
    protected int idCreateur;
    protected InfoCreation infoCreation;
    protected boolean actif;

    public Fragment(int id, String texte, int idCreateur) {
        this.id = id;
        this.texte = formaterTexte(texte);
        this.idCreateur = idCreateur;
        this.infoCreation = new InfoCreation();
        this.actif = true;
    }

    public Fragment(int id, String texte, int idCreateur, String origine) {
        this.id = id;
        this.texte = formaterTexte(texte);
        this.idCreateur = idCreateur;
        this.infoCreation = new InfoCreation(origine);
        this.actif = true;
    }

    // Uniformise légèrement le texte lors de sa création ou modification.
    private String formaterTexte(String texte) {
        texte = texte.trim();

        if (texte.isEmpty()) {
            return texte;
        }

        texte = texte.substring(0, 1).toUpperCase() + texte.substring(1);

        if (!texte.endsWith(".") && !texte.endsWith("!") && !texte.endsWith("?")) {
            texte += ".";
        }

        return texte;
    }

    public boolean estCreePar(int idUtilisateur) {
        return this.idCreateur == idUtilisateur;
    }

    public void modifierTexte(String nouveauTexte) {
        this.texte = formaterTexte(nouveauTexte);
    }

    public void afficher() {
        System.out.println("Fragment #" + id);
        System.out.println("Texte : \"" + texte + "\"");
        System.out.println("Createur : utilisateur #" + idCreateur);
        infoCreation.afficher();
        System.out.println("Actif : " + actif);
    }

    public int getId() {
        return id;
    }

    public String getTexte() {
        return texte;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public InfoCreation getInfoCreation() {
        return infoCreation;
    }

    // Le gel évite de supprimer physiquement un fragment qui peut être lié à d'autres objets.  
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
