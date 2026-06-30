package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Gère la sauvegarde et le chargement des données.
 * La sérialisation permet d'écrire l'objet Data complet dans un fichier.
 */

public class Fichier {
    // Le fichier est placé dans le dossier utilisateur pour éviter les problèmes de droits d'écriture.
    private static final String NOM_FICHIER = System.getProperty("user.home") + "\\palimpseste.dat";
    
    /**
     * Sauvegarde l'état complet de l'application dans un fichier objet.
    */
    public static void sauvegarder(Data data) {
        // Les opérations de fichier peuvent provoquer des exceptions : accès refusé,
        // fichier indisponible ou problème de sérialisation.
        try {
            ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(NOM_FICHIER));
            sortie.writeObject(data);
            sortie.close();

            System.out.println("Donnees sauvegardees dans " + NOM_FICHIER + ".");
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
    
    /**
     * Recharge les données sauvegardées.
     * Si aucun fichier n'existe, une nouvelle instance de Data est créée.
    */
    public static Data charger() {
        try {
            ObjectInputStream entree = new ObjectInputStream(new FileInputStream(NOM_FICHIER));
            Data data = (Data) entree.readObject();
            entree.close();

            System.out.println("Donnees chargees depuis " + NOM_FICHIER + ".");
            return data;
        } catch (Exception e) {
            System.out.println("Aucune sauvegarde trouvee. Nouvelle session.");
            return new Data();
        }
    }
}