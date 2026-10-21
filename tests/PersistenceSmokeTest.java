import classes.Utilisateur;
import data.Data;
import data.Fichier;
import java.nio.file.Files;
import java.nio.file.Path;

/** Vérifie une vraie sauvegarde puis un rechargement dans un dossier isolé. */
public class PersistenceSmokeTest {
    public static void main(String[] args) throws Exception {
        Path home = Path.of(System.getProperty("user.home"));
        if (!Files.isDirectory(home) || Files.exists(home.resolve("palimpseste.dat"))) {
            throw new IllegalStateException("Utiliser un dossier de test neuf avec -Duser.home.");
        }
        Data data = new Data();
        Utilisateur user = data.getListeUtilisateurs().ajouterUtilisateur("demo", "demo@example.com");
        data.getListeFragments().ajouterPenseePersonnelle("Un fragment conservé.", user.getId());
        Fichier.sauvegarder(data);
        if (!Files.isRegularFile(home.resolve("palimpseste.dat"))) {
            throw new AssertionError("La sauvegarde doit se trouver dans le dossier utilisateur.");
        }
        Data restored = Fichier.charger();
        Utilisateur restoredUser = restored.getListeUtilisateurs().trouverParId(user.getId());
        if (restoredUser == null || !restoredUser.getPseudo().equals("demo")
                || restored.getListeFragments().getFragments().size() != 1) {
            throw new AssertionError("Les utilisateurs et fragments doivent survivre au rechargement.");
        }
        System.out.println("Persistence smoke test passed.");
    }
}
