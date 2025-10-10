import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ApplicationCarteV1 {

    public static void main(String[] args) {
        List<Carte> paquet = new LinkedList<>();
        for (Couleur c : Couleur.values()) {
            for (Valeur v : Valeur.values()) {
                paquet.add(new Carte(c, v));
            }
        }

        Collections.sort(paquet);
        System.out.println(paquet);
        Collections.sort(paquet, new ComparatorCarte());
        System.out.println(paquet);
    }

}
