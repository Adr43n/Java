import java.util.Objects;

public class Carte implements Comparable<Carte> {
    private final Couleur couleur;
    private final Valeur valeur;

    @Override
    public String toString() {
        return this.valeur.getDésignation() + " de "
                + this.couleur.getDésignation();
    }

    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public Valeur getValeur() {
        return this.valeur;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.couleur, this.valeur);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Carte)) {
            return false;
        }
        Carte other = (Carte) obj;
        return this.couleur == other.couleur && this.valeur == other.valeur;
    }

    @Override
    public int compareTo(Carte o) {
        if (this.getValeur().compareTo(o.getValeur()) == 0) {
            return this.getCouleur().compareTo(o.getCouleur());
        } else {
            return this.getValeur().compareTo(o.getValeur());
        }
    }
}