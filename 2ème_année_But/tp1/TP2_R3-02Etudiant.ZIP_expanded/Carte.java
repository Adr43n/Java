public class Carte implements Comparable<Carte> {
    private final Couleur couleur;
    private final Valeur valeur;

    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public Couleur couleur() {
        return this.couleur;
    }

    public Valeur valeur() {
        return this.valeur;
    }

    @Override
    public int compareTo(Carte autre) {
        int cmpValeur = autre.valeur.compareTo(this.valeur); // décroissant
        if (cmpValeur != 0) return cmpValeur;
        return this.couleur.compareTo(autre.couleur); // croissant si valeurs égales
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
