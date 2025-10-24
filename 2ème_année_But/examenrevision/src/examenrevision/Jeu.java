package examenrevision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MêmeNomException extends RuntimeException {
}
public class Jeu {
 private Map<String, Roboticus> mapParNom;
 private List<Roboticus> liste;
 // construit un jeu de cartes de Roboticus à partir d'un tableau de Roboticus
 // déclenche l'exception MêmeNomException si 2 Roboticus ont même nom
 public Jeu(Roboticus... cartes) throws MêmeNomException {
     this.mapParNom = new TreeMap<>();
     this.liste = new ArrayList<>();
     for (Roboticus arg0 : cartes) {
         if (this.liste.contains(arg0)) {
             throw new MêmeNomException();
         }
         this.mapParNom.put(arg0.getNom(), arg0);
         this.liste.add(arg0);
         
     }
 }
 // recherche un Rotiboticus à partir de son nom (retourne null en cas d'échec)
 public Roboticus rechercheParNom(String nom) {
    return this.mapParNom.get(nom);
 }
 // calcule le nombre de points du jeu (égal à la somme des points des Roboticus)
 public int nombreDePoints() {
     int res = 0 ;
     for(Roboticus arg0 : this.liste) {
         res += arg0.points();
     }
     return res;
 }
 // enlève aléatoirement une carte du jeu
 public void enleverCarte() {
    int rang = (int) (Math.random()) ;
    Roboticus r = this.liste.get(rang);
    this.mapParNom.remove(r);
    this.liste.remove(r.getNom());
 }
 @Override
 // produit une chaîne de caractères des Roboticus du jeu
 public String toString() {
 // non demandé
 }
 // trie le jeu par ordre croissant des tailles des Roboticus
 public void trier() {
     Collections.sort(this.liste);
 }
}
