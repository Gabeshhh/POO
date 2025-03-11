public class EtudiantDiplome extends Etudiant {
    public EtudiantDiplome(String nom, int age, String etudiantID) {
        super(nom, age, etudiantID);
    }

    @Override
    public double getMoyenne() {
        return super.getMoyenne() + 5; // Bonus pour les diplômés
    }
}
