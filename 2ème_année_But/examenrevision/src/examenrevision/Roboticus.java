package examenrevision;

public class Roboticus implements Comparable<Roboticus>  {
    
    private int taille;
    
    
    @Override
    public int compareTo(Roboticus arg0) {
        return (((Integer)this.taille).compareTo(arg0.taille));
    }

}
