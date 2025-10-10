
public class Joueur {
	private Plateau plateau;
	private int positionJoueur;
	
	public Joueur() {
		this.positionJoueur = 0;
	}
	
	public boolean estPartieFinie() {
		return this.positionJoueur == Plateau.NB_CASES - 1;
	}
	
	public int getPositionJoueur() {
		return this.positionJoueur;
	}
	
	public int setPositionJoueur(int positionJoueur) {
		return this.positionJoueur=positionJoueur;
	}

}
