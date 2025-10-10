import java.util.Comparator;

public class ComparatorCarte implements Comparator<Carte> {
    @Override
    public int compare(Carte c1, Carte c2) {
        if (c1.getCouleur().compareTo(c2.getCouleur()) == 0) {
            return c1.getValeur().compareTo(c2.getValeur());
        } else {
            return c1.getCouleur().compareTo(c2.getCouleur());
        }
    }

}
