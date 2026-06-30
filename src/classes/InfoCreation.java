package classes;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Regroupe les informations de création d'un objet.
 * Cette classe sert d'exemple d'attribut de type classe dans le projet.
 */

public class InfoCreation implements Serializable {
    private static final String ORIGINE_DEFAUT = "PALIMPSESTE";

    private String dateCreation;
    private String origine;

    public InfoCreation() {
        this.dateCreation = LocalDateTime.now().toString();
        this.origine = ORIGINE_DEFAUT;
    }

    public InfoCreation(String origine) {
        this.dateCreation = LocalDateTime.now().toString();
        this.origine = origine;
    }

    public InfoCreation(String dateCreation, String origine) {
        this.dateCreation = dateCreation;
        this.origine = origine;
    }

    public void afficher() {
        System.out.println("Date de creation : " + dateCreation);
        System.out.println("Origine : " + origine);
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getOrigine() {
        return origine;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }
}