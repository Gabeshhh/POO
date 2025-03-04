import java.util.*;

// Classe Personne
abstract class Personne {
    protected String nom;
    protected int age;

    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public String getNom() { return nom; }
    public int getAge() { return age; }
}

// Classe Étudiant
class Etudiant extends Personne {
    private String etudiantID;
    private List<Double> notes;

    public Etudiant(String nom, int age, String etudiantID) {
        super(nom, age);
        this.etudiantID = etudiantID;
        this.notes = new ArrayList<>();
    }

    public void ajouterNote(double note) {
        notes.add(note);
    }

    public double getMoyenne() {
        return notes.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public String getEtudiantID() { return etudiantID; }
    public List<Double> getNotes() { return notes; }
}

// Classe Étudiant Diplômé
class EtudiantDiplome extends Etudiant {
    public EtudiantDiplome(String nom, int age, String etudiantID) {
        super(nom, age, etudiantID);
    }

    @Override
    public double getMoyenne() {
        return super.getMoyenne() + 5; // Bonus pour les diplômés
    }
}

// Classe Étudiant Licence
class EtudiantLicence extends Etudiant {
    public EtudiantLicence(String nom, int age, String etudiantID) {
        super(nom, age, etudiantID);
    }
}

// Classe Cours
class Cours {
    private String nomCours;
    private String codeCours;
    private int credits;
    private List<Etudiant> etudiants;

    public Cours(String nomCours, String codeCours, int credits) {
        this.nomCours = nomCours;
        this.codeCours = codeCours;
        this.credits = credits;
        this.etudiants = new ArrayList<>();
    }

    public void inscrireEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public List<Etudiant> getEtudiantsInscrits() {
        return etudiants;
    }

    public String getNomCours() { return nomCours; }
    public String getCodeCours() { return codeCours; }
    public int getCredits() { return credits; }
}

// Classe Inscription
class Inscription {
    public Inscription(Etudiant etudiant, Cours cours) {
        cours.inscrireEtudiant(etudiant);
    }
}

// Classe principale
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
