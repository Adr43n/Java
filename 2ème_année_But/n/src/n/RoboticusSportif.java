package n;

public class RoboticusSportif extends Roboticus {
    private int nbPattes;
    public RoboticusSportif(String nom, int taille, int nbPattes) {
    super(nom, taille);
    this.nbPattes = nbPattes;
    }
    public int getNbPattes() {
    return this.nbPattes;
    }
    @Override
    public int points() {
    return this.getTaille() * this.getNbPattes();
    }
    @Override
    public String toString() {
    return "RoboticusSportif [nom=" + this.getNom() + ", taille()="
    + this.getTaille() + ", nbPattes=" + this.nbPattes + "]";
    }
   }