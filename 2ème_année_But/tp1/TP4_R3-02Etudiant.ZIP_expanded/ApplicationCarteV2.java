import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ApplicationCarteV2 {
	
	public static void main(String[]args) {
		List<Carte> paquet = new LinkedList<>();
		for(Couleur c : Couleur.values()) {
			for(Valeur v : Valeur.values()) {
				paquet.add(new Carte(c, v));
			}
		}
	
	Collections.sort(paquet);
	System.out.println(paquet);
	
	Collections.sort(paquet, new Comparator<Carte>() {
		@Override
		public int compare(Carte c1, Carte c2) {
			int cmp = c1.getCouleur().compareTo(c2.getCouleur());
			if (cmp!=0) {
				return cmp;
			}
			return c1.getValeur().compareTo(c2.getValeur());
		}
	
	});
	
	System.out.println(paquet);
	}
	
}
