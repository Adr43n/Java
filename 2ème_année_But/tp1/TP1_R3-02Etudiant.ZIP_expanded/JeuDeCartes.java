import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuDeCartes {
    private List<Carte> cartes;

    // Constructeur : construit un jeu de 52 cartes
    public JeuDeCartes() {
        cartes = new ArrayList<>();
        for (Valeur valeur : Valeur.values())
        { for (Couleur couleur : Couleur.values())
            {
                cartes.add(new Carte(couleur, valeur));
            }
        }
    }

    // renvoie la carte située au-dessus du paquet
    public Carte premiereCarte() throws PaquetVideException {
        if (cartes.isEmpty()) {
            throw new PaquetVideException("Le paquet est vide !");
        }
        return cartes.get(0);
    }

    // renvoie le nombre de cartes du jeu
    public int nombreDeCartes() {
        return cartes.size();
    }

    // trie le paquet dans l’ordre naturel des cartes
    public void trier() {
        Collections.sort(cartes);
    }

    // enlève la première carte du paquet
    public void distribuerUneCarte() throws PaquetVideException {
        if (cartes.isEmpty()) {
            throw new PaquetVideException("Impossible de distribuer, le paquet est vide !");
        }
        cartes.remove(0);
    }

    // mélange aléatoirement le paquet de cartes
    public void melanger() {
        Collections.shuffle(cartes);
    }

    // déplace la première carte sous le paquet
    public void mettrePremiereCarteSousLePaquet() throws PaquetVideException {
        if (cartes.isEmpty()) {
            throw new PaquetVideException("Le paquet est vide !");
        }
        Carte premiere = cartes.remove(0);
        cartes.add(premiere);
    }

    @Override
    public String toString() {
        return cartes.toString();
    }
}
