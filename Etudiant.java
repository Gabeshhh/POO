import java.util.*;

public class Etudiant extends Personne {
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