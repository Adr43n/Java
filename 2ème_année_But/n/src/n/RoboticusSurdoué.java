package n;

public class RoboticusSurdoué extends RoboticusIntellectuel {
    public RoboticusSurdoué(String nom, int taille, int nbNeurones) {
    super(nom, taille, nbNeurones);
    }
    @Override
    public int points() {
    return super.points() * 2;
    }
    public void ajouterNeurones(int nbNeurones) {
    this.setNeurones(this.getNbNeurones() + nbNeurones);
    }
    @Override
    public String toString() {
    return "RoboticusSurdoué [nom=" + this.getNom() + ", taille()="
    + this.getTaille() + ", nbNeurone=" + this.getNbNeurones()
    + "]";
    }
   }