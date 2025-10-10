import java.util.Comparator;

public class ComparateurDeCarte implements Comparator<Carte> {

    @Override
    public int compare(Carte c1, Carte c2) {
        int cmpValeur = c2.valeur().compareTo(c1.valeur()); // décroissant
        if (cmpValeur != 0) return cmpValeur;
        return c1.couleur().compareTo(c2.couleur()); // croissant si valeurs égales
    }
}
