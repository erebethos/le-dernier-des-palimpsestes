package le_dernier_des_palimpsestes;

import data.Data;
import data.Fichier;
import menus.MenuPrincipal;

/**
 * Point d'entrée de l'application.
 * Le programme charge les données, lance le menu principal,
 * puis sauvegarde l'état de l'application à la fermeture.
 */

public class Main {

    public static void main(String[] args) {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            // On ignore l'erreur si l'encodage n'est pas supporté
        }

        Data data = Fichier.charger();

        MenuPrincipal menuPrincipal = new MenuPrincipal(data);
        menuPrincipal.lancer();

        Fichier.sauvegarder(data);
    }
}