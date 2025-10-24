import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Produits {
    private List<Produit> produits;

    public Produits() {
        this.produits = new ArrayList<>();
    }

    public void addProduit(Produit p) {
        this.produits.add(p);
    }

    public List<Produit> getProduits() {
        return this.produits;
    }

    public Produit getProduit(int id) {
        return this.produits.stream().filter(x -> x.getId() == id)
                .collect(Collectors.toList()).get(0);
    }

}
