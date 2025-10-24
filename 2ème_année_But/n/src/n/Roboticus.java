package n;

import java.util.Objects;

public abstract class Roboticus implements Comparable<Roboticus>{
    private String nom;
    private int taille;
    
    public Roboticus(String nom, Integer taille) {
        this.nom = nom;
        this.taille = taille;
    }
    
    public int getTaille() {
        return this.taille;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public abstract int points();
    
    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
    
    @Override 
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (!(obj instanceof Roboticus)) {
            return false;
            }
            Roboticus other = (Roboticus) obj;
            return Objects.equals(nom, other.nom);
            }
    
    @Override
    public int compareTo(Roboticus r) {
        return (((Integer)this.taille).compareTo(r.taille)); 
    }

}
