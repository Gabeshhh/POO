import java.util.*;

public class GestionEtudiants {
    public static void main(String[] args) {
        Random random = new Random();

        // Création des étudiants
        Etudiant etudiant1 = new EtudiantLicence("Bull", 20, "E1");
        Etudiant etudiant2 = new EtudiantDiplome("Kaaption", 25, "E2");
        Etudiant etudiant3 = new EtudiantLicence("Juju", 19, "E3");
        Etudiant etudiant4 = new EtudiantDiplome("Damonx", 18, "E4");

        // Création du cours
        Cours cours1 = new Cours("Mathématiques", "MATH101", 3);

        // Inscription des étudiants
        new Inscription(etudiant1, cours1);
        new Inscription(etudiant2, cours1);
        new Inscription(etudiant3, cours1);
        new Inscription(etudiant4, cours1);

        // Génération de notes
        genererNotes(etudiant1, random);
        genererNotes(etudiant2, random);
        genererNotes(etudiant3, random);
        genererNotes(etudiant4, random);

        // Affichage sous forme de tableau
        System.out.println("\n=== 📚 GESTION DES ÉTUDIANTS ===\n");
        System.out.printf("📖 Cours : %-20s | Code : %-10s | Crédits : %d\n\n", 
                          cours1.getNomCours(), cours1.getCodeCours(), cours1.getCredits());

        System.out.println("+------------+------------------+-----+----------------------------+---------+");
        System.out.println("| ID Étudiant | Nom             | Âge | Notes                      | Moyenne |");
        System.out.println("+------------+------------------+-----+----------------------------+---------+");

        for (Etudiant etudiant : cours1.getEtudiantsInscrits()) {
            List<Double> notes = etudiant.getNotes();
            System.out.printf("| %-10s | %-16s | %-3d | %-26s | %-7.2f |\n",
                              etudiant.getEtudiantID(), etudiant.getNom(), etudiant.getAge(),
                              notes.toString(), etudiant.getMoyenne());
        }

        System.out.println("+------------+------------------+-----+----------------------------+---------+");
        System.out.println("\n✅ Nombre total d'étudiants inscrits : " + cours1.getEtudiantsInscrits().size());
    }

    // Méthode pour générer 4 notes aléatoires entre 0 et 20
    private static void genererNotes(Etudiant etudiant, Random random) {
        for (int i = 0; i < 4; i++) {
            etudiant.ajouterNote(random.nextInt(21)); // Génère un nombre entre 0 et 20
        }
    }
}
