import java.util.Objects;

public class Produit implements Comparable<Produit> {
    private int id;
    private String nom;
    private Categorie categorie;
    private double prix;

    public Produit(int id, String nom, Categorie categorie, double prix) {
        super();
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit [id=" + this.id + ", nom=" + this.nom + ", categorie="
                + this.categorie + ", prix=" + this.prix + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Produit o) {
        return this.getId() - o.getId();
    }

}
