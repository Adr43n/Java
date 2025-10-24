import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Commandes {
    private List<Commande> commandes;

    public Commandes() {
        this.commandes = new ArrayList<>();
    }

    public void addCommande(Commande c) {
        this.commandes.add(c);
    }

    public List<Commande> getCommandes() {
        return this.commandes;
    }

    public Commande getCommande(int id) {
        return this.commandes.stream().filter(x -> x.getId() == id)
                .collect(Collectors.toList()).get(0);
    }

}
