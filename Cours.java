import java.util.*;

public class Cours {
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
