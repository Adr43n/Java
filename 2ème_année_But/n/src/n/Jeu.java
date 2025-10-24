package n;

import java.util.List;
import java.util.Map;
import java.util.*;

public class MêmeNomException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
}

public class Jeu {
    private Map<String, Roboticus> mapParNom;
    private List<Roboticus> liste;
    // construit un jeu de cartes de Roboticus à partir d'un tableau de Roboticus
    // déclenche l'exception MêmeNomException si 2 Roboticus ont même nom
    public Jeu(Roboticus... cartes) throws MêmeNomException {
    this.mapParNom = new TreeMap<>();
    this.liste = new ArrayList<>();
    for (Roboticus r : cartes) {
        if (this.liste.contains(r)) {
            throw new MêmeNomException();
        }
     this.mapParNom.put(r.getNom(), r);
     this.liste.add(r);
        
    }
    }
    // recherche un Rotiboticus à partir de son nom (retourne null en cas d'échec)
    public Roboticus rechercheParNom(String nom) {
     return this.mapParNom.get(nom); 
    }
    // calcule le nombre de points du jeu (égal à la somme des points des Roboticus)
    public int nombreDePoints() {
        int res = 0;
        for(Roboticus r : this.liste ) {
            res += r.points();
        }
        return res;
    }
    // enlève aléatoirement une carte du jeu
    public void enleverCarte() {
        
    }
    @Override
    // produit une chaîne de caractères des Roboticus du jeu
    public String toString() {
    // non demandé
    }
    // trie le jeu par ordre croissant des tailles des Roboticus
    public void trier() {
    // à compléter
    }
   }

