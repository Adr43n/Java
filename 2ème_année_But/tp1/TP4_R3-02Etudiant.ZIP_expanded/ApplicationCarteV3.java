import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ApplicationCarteV3 {
	public static void main(String[]args) {
		List<Carte> paquet = new LinkedList<>();
		for(Couleur c : Couleur.values()) {
			for(Valeur v : Valeur.values()) {
				paquet.add(new Carte(c, v));
			}
		}
		Collections.sort(paquet);
		System.out.println(paquet);
		Collections.sort(paquet, (c1,c2) -> {
			  if (c1.getCouleur().compareTo(c2.getCouleur()) == 0) {
		            return c1.getValeur().compareTo(c2.getValeur());
		        } else {
		            return c1.getCouleur().compareTo(c2.getCouleur());
		        }
		});
	}
}
