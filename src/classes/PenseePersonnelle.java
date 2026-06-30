package classes;

/**
 * Type spécialisé de Fragment représentant une pensée personnelle.
 * Elle ne possède pas d'attribut spécifique, mais redéfinit son affichage.
 */

public class PenseePersonnelle extends Fragment {

    public PenseePersonnelle(int id, String texte, int idCreateur) {
        super(id, texte, idCreateur);
    }

    public void afficher() {
        System.out.println("Pensée personnelle #" + id);
        System.out.println("\"" + texte + "\"");
        System.out.println("Auteur : utilisateur #" + idCreateur);
        infoCreation.afficher();
    }
}
