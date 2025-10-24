package n;

public class RoboticusIntellectuel extends Roboticus {
    private int nbNeurones;
    protected void setNeurones(int nbNeurones) {
    this.nbNeurones = nbNeurones;
    }
    public int getNbNeurones() {
    return this.nbNeurones;
    }
    public RoboticusIntellectuel(String nom, int taille, int nbNeurones) {
    super(nom, taille);
    this.nbNeurones = nbNeurones;
    }
    @Override
    public int points() {
    return this.getTaille() * this.getNbNeurones();
    }
    @Override
    public String toString() {
    return "RoboticusIntellectuel [nom=" + this.getNom() + ", taille()="
    + this.getTaille() + ", nbNeurone=" + this.nbNeurones + "]";
    }

}
