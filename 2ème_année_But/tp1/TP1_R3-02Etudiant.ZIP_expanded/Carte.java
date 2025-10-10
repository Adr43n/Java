import java.util.Objects;

public class Carte implements Comparable<Carte> {
	private final Couleur couleur;
	private final Valeur valeur;
	
	public Carte(Couleur couleur,Valeur valeur) {
		this.couleur = couleur;
        this.valeur  = valeur;	
	}
	
	public Carte uneCarte(Couleur couleur,Valeur valeur) {
		return new Carte(couleur,valeur);
	}
	
	public Couleur couleur() {
		return this.couleur;
	}
	
	public Valeur valeur() {
		return this.valeur;
	}
	
	
	
	@Override
	public int compareTo(Carte autre) {
		int compCouleur = this.couleur.compareTo(autre.couleur);
		if (compCouleur!= 0) {
		    return compCouleur;
        }
        // Si même couleur → comparer la valeur
        return this.valeur.compareTo(autre.valeur);
    }
		
		
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Carte)) return false;
	    Carte autre = (Carte) o;
	    return this.couleur == autre.couleur && this.valeur == autre.valeur;
	}

	@Override
	public int hashCode() {
	    return 31 * couleur.hashCode() + valeur.hashCode();
	}


	@Override
	public String toString() {
		return this.valeur.getDésignation() + " de " + this.couleur.getDésignation();
	}

}
