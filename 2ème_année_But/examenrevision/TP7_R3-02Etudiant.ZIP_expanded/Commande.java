import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Commande {
    private int id;
    private Etat etat;
    private LocalDate dateCommande;
    private List<Produit> produits;
    private Client client;

    public Commande(int id, Etat etat, LocalDate dateCommande,
            List<Produit> produits, Client client) {
        super();
        this.id = id;
        this.etat = etat;
        this.dateCommande = dateCommande;
        this.produits = produits;
        this.client = client;
    }

    public int getId() {
        return this.id;
    }

    public Etat getEtat() {
        return this.etat;
    }

    public LocalDate getDateCommande() {
        return this.dateCommande;
    }

    public List<Produit> getProduits() {
        return this.produits;
    }

    public Client getClient() {
        return this.client;
    }

    @Override
    public String toString() {
        return "Commande [id=" + this.id + ", etat=" + this.etat
                + ", dateCommande=" + this.dateCommande + ", produits="
                + this.produits + ", client=" + this.client + "]";
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
        if (!(obj instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) obj;
        return this.id == other.id;
    }

}
