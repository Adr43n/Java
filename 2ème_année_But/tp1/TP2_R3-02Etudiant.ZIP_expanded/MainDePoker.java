import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainDePoker {

    private List<Carte> mainJoueur;
    private Map<Valeur, Integer> nbCartesParValeur;
    private Map<Couleur, Integer> nbCartesParCouleur;

    public MainDePoker(Carte[] cartes) throws TricheurException {
        if (cartes.length != 5) {
            throw new TricheurException("une main de cartes doit être strictement égale à 5");
        }

        for (int i = 0; i < cartes.length; i++) {
            for (int j = i + 1; j < cartes.length; j++) {
                if (cartes[i].valeur().equals(cartes[j].valeur()) &&
                    cartes[i].couleur().equals(cartes[j].couleur())) {
                    throw new TricheurException("Les cartes sont identiques");
                }
            }
        }

        mainJoueur = new ArrayList<>(Arrays.asList(cartes));

        Collections.sort(mainJoueur, new ComparateurDeCarte());


        nbCartesParValeur = new TreeMap<Valeur, Integer>();
        nbCartesParCouleur = new TreeMap<Couleur, Integer>();

        for (Carte c : mainJoueur) {
            nbCartesParValeur.put(c.valeur(), nbCartesParValeur.getOrDefault(c.valeur(), 0) + 1);
            nbCartesParCouleur.put(c.couleur(), nbCartesParCouleur.getOrDefault(c.couleur(), 0) + 1);
        }
    }

    @Override
    public String toString() {
        return "mainJoueur=" + this.mainJoueur +
               "\nnbCartesParValeur=" + this.nbCartesParValeur +
               "\nnbCartesParCouleur=" + this.nbCartesParCouleur;
    }

    public Iterator<Carte> iterateurDeCarte() {
        return mainJoueur.iterator();
    }

    private Carte plusGrandeCarte() {
        return this.mainJoueur.get(0);
    }

    private Valeur plusGrandeValeur() {
        return this.mainJoueur.get(0).valeur();
    }

    private boolean estUneSuiteDeValeurs() {
        List<Integer> ordinals = new ArrayList<>();
        for (Carte c : mainJoueur) ordinals.add(c.valeur().ordinal());
        Collections.sort(ordinals);
        for (int i = 1; i < ordinals.size(); i++) {
            if (ordinals.get(i) != ordinals.get(i - 1) + 1) return false;
        }
        return true;
    }

    public boolean isQuinteFlushRoyale() {
        return isQuinteFlush() && plusGrandeValeur() == Valeur.AS;
    }

    public boolean isQuinteFlush() {
        return isSuite() && isCouleur();
    }

    public boolean isCarré() {
        return nbCartesParValeur.containsValue(4);
    }

    public boolean isFull() {
        return nbCartesParValeur.containsValue(3) && nbCartesParValeur.containsValue(2);
    }

    public boolean isCouleur() {
        return nbCartesParCouleur.containsValue(5);
    }

    public boolean isSuite() {
        return estUneSuiteDeValeurs();
    }

    public boolean isBrelan() {
        return nbCartesParValeur.containsValue(3);
    }

    public boolean isDoublePaire() {
        int count = 0;
        for (int v : nbCartesParValeur.values()) {
            if (v == 2) count++;
        }
        return count == 2;
    }

    public boolean isPaire() {
        return nbCartesParValeur.containsValue(2) && !isDoublePaire();
    }

    public boolean isHauteur() {
        return !(isPaire() || isDoublePaire() || isBrelan() || isSuite() || 
                 isCouleur() || isFull() || isCarré() || isQuinteFlush() || isQuinteFlushRoyale());
    }

    public String annonce() {
        if (isQuinteFlushRoyale()) return "Quinte flush royale";

        if (isQuinteFlush()) return "Quinte flush au " + plusGrandeCarte();

        if (isCarré()) {
            Valeur carre = null;
            for (Map.Entry<Valeur, Integer> e : nbCartesParValeur.entrySet()) {
                if (e.getValue() == 4) carre = e.getKey();
            }
            return "Carré de " + carre;
        }

        if (isFull()) {
            Valeur brelan = null;
            Valeur paire = null;
            for (Map.Entry<Valeur, Integer> e : nbCartesParValeur.entrySet()) {
                if (e.getValue() == 3) brelan = e.getKey();
                if (e.getValue() == 2) paire = e.getKey();
            }
            return "Full des " + brelan + " par les " + paire;
        }

        if (isCouleur()) return "Couleur au " + plusGrandeCarte();
        if (isSuite()) return "Suite au " + plusGrandeCarte();

        if (isBrelan()) {
            Valeur b = null;
            for (Map.Entry<Valeur, Integer> e : nbCartesParValeur.entrySet()) {
                if (e.getValue() == 3) b = e.getKey();
            }
            return "Brelan de " + b;
        }

        if (isDoublePaire()) {
            List<Valeur> paires = new ArrayList<>();
            for (Map.Entry<Valeur, Integer> e : nbCartesParValeur.entrySet()) {
                if (e.getValue() == 2) paires.add(e.getKey());
            }
            Collections.sort(paires, (v1, v2) -> v2.ordinal() - v1.ordinal());
            return "Double paire de " + paires.get(0) + " par les " + paires.get(1);
        }

        if (isPaire()) {
            Valeur p = null;
            for (Map.Entry<Valeur, Integer> e : nbCartesParValeur.entrySet()) {
                if (e.getValue() == 2) p = e.getKey();
            }
            return "Paire de " + p;
        }

        return "Un " + plusGrandeCarte();
    }
}
