import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static Clients repositoryClients;
    private static Produits repositoryProduits;
    private static Commandes repositoryCommandes;

    public static void main(String[] args) {
        // créer les repositories
        construireRepositoryClients();
        afficherListe(repositoryClients.getClients());
        System.out.println("-----------------------");
        construireRepositoryProduits();
        afficherListe(repositoryProduits.getProduits());
        System.out.println("-----------------------");
        construireRepertoireCommandes();
        afficherListe(repositoryCommandes.getCommandes());
        System.out.println("-----------------------");

        afficherListe(listeDesProduitsCategorieLivreAvecPrixSupA90());
        System.out.println("-----------------------");
        // ...
        
        afficherListe(listedescommandescontenantaumoinsunarticledelacatégorieBEBE());
        System.out.println("-----------------------");
        
        afficherListe(lalistedesproduitsdecatégorieJOUETetleurappliqueruneréductionde10());
        System.out.println("-----------------------");
        
    }

    public static <T> void afficherListe(List<T> liste) {
        liste.stream().forEach(System.out::println);
    }

    public static void construireRepositoryClients() {
        repositoryClients = new Clients();
        repositoryClients.addClient(new Client(1, "Stefan Walker"));
        repositoryClients.addClient(new Client(2, "Daija Von"));
        repositoryClients.addClient(new Client(3, "Ariane Rodriguez"));
        repositoryClients.addClient(new Client(4, "Marques Nikolaus"));
        repositoryClients.addClient(new Client(5, "Rachelle Greenfelder"));
        repositoryClients.addClient(new Client(6, "Larissa White"));
        repositoryClients.addClient(new Client(7, "Fae Heidenreich"));
        repositoryClients.addClient(new Client(8, "Dino Will"));
        repositoryClients.addClient(new Client(9, "Eloy Stroman"));
        repositoryClients.addClient(new Client(10, "Brisa O'Connell"));
    }

    public static void construireRepositoryProduits() {
        repositoryProduits = new Produits();
        repositoryProduits.addProduit(new Produit(1, "omnis quod consequatur",
                Categorie.JOUET, 92.83));
        repositoryProduits.addProduit(
                new Produit(2, "vel libero suscipit", Categorie.JOUET, 12.66));
        repositoryProduits.addProduit(
                new Produit(3, "non nemo iure", Categorie.EPICERIE, 12.50));
        repositoryProduits.addProduit(new Produit(4,
                "voluptatem voluptas aspernatur", Categorie.JOUET, 45.11));
        repositoryProduits.addProduit(
                new Produit(5, "animi cum rem", Categorie.JEU, 152.00));
        repositoryProduits.addProduit(new Produit(6, "dolorem porro debitis",
                Categorie.JOUET, 43.10));
        repositoryProduits.addProduit(
                new Produit(7, "aspernatur rerum qui", Categorie.LIVRE, 20.60));
        repositoryProduits.addProduit(
                new Produit(8, "deleniti earum et", Categorie.BEBE, 60.50));
        repositoryProduits.addProduit(
                new Produit(9, "voluptas ut quidem", Categorie.LIVRE, 247.00));
        repositoryProduits.addProduit(
                new Produit(10, "eos sed debitis", Categorie.BEBE, 55.00));
        repositoryProduits.addProduit(new Produit(11, "laudantium sit nihil",
                Categorie.JOUET, 68.00));
        repositoryProduits.addProduit(new Produit(12, "ut perferendis corporis",
                Categorie.EPICERIE, 34.00));
        repositoryProduits.addProduit(
                new Produit(13, "sint voluptatem ut", Categorie.JOUET, 70.00));
        repositoryProduits.addProduit(
                new Produit(14, "uos sunt ipsam", Categorie.EPICERIE, 5.10));
        repositoryProduits.addProduit(
                new Produit(15, "qui illo error", Categorie.BEBE, 45.99));
        repositoryProduits.addProduit(
                new Produit(16, "aut ex ducimus", Categorie.LIVRE, 92.20));
        repositoryProduits.addProduit(new Produit(17,
                "accusamus repellendus minus", Categorie.LIVRE, 30.00));
        repositoryProduits.addProduit(
                new Produit(18, "aut accusamus quia", Categorie.BEBE, 101.10));
        repositoryProduits.addProduit(new Produit(19, "doloremque incidunt sed",
                Categorie.JEU, 215.00));
        repositoryProduits.addProduit(
                new Produit(20, "libero omnis velit", Categorie.BEBE, 24.00));
        repositoryProduits.addProduit(new Produit(21,
                "consectetur cupiditate sunt", Categorie.JOUET, 92.83));
        repositoryProduits.addProduit(
                new Produit(22, "itaque ea qui", Categorie.BEBE, 66.92));
        repositoryProduits.addProduit(
                new Produit(23, "non et nulla", Categorie.EPICERIE, 12.06));
        repositoryProduits.addProduit(new Produit(24, "veniam consequatur et",
                Categorie.LIVRE, 22.05));
        repositoryProduits.addProduit(new Produit(25,
                "magnam adipisci voluptate", Categorie.EPICERIE, 18.52));
        repositoryProduits.addProduit(new Produit(26,
                "reiciendis consequuntur placeat", Categorie.JOUET, 51.06));
        repositoryProduits.addProduit(
                new Produit(27, "dolores ipsum sit", Categorie.JOUET, 72.45));
        repositoryProduits.addProduit(
                new Produit(28, "ut hic tempore", Categorie.JOUET, 52.00));
        repositoryProduits.addProduit(
                new Produit(29, "quas quis deserunt", Categorie.JOUET, 121.58));
        repositoryProduits.addProduit(new Produit(30,
                "excepturi nesciunt accusantium", Categorie.JOUET, 142.05));
    }

    public static void construireRepertoireCommandes() {
        repositoryCommandes = new Commandes();

        List<Produit> l = Arrays.asList(repositoryProduits.getProduit(19),
                repositoryProduits.getProduit(21),
                repositoryProduits.getProduit(5));
        repositoryCommandes.addCommande(new Commande(1, Etat.LIVREE,
                LocalDate.of(2022, 11, 2), l, repositoryClients.getClient(5)));

        l = Arrays.asList(repositoryProduits.getProduit(17),
                repositoryProduits.getProduit(11),
                repositoryProduits.getProduit(14),
                repositoryProduits.getProduit(13));
        repositoryCommandes.addCommande(new Commande(2, Etat.LIVREE,
                LocalDate.of(2022, 11, 2), l, repositoryClients.getClient(3)));

        l = Arrays.asList(repositoryProduits.getProduit(5),
                repositoryProduits.getProduit(3),
                repositoryProduits.getProduit(19),
                repositoryProduits.getProduit(13),
                repositoryProduits.getProduit(15));
        repositoryCommandes.addCommande(new Commande(3, Etat.LIVREE,
                LocalDate.of(2022, 11, 2), l, repositoryClients.getClient(5)));

        l = Arrays.asList(repositoryProduits.getProduit(22),
                repositoryProduits.getProduit(26),
                repositoryProduits.getProduit(12));
        repositoryCommandes.addCommande(new Commande(4, Etat.EN_ATTENTE,
                LocalDate.of(2022, 11, 3), l, repositoryClients.getClient(3)));

        l = Arrays.asList(repositoryProduits.getProduit(5));
        repositoryCommandes.addCommande(new Commande(5, Etat.EN_ATTENTE,
                LocalDate.of(2022, 11, 3), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(5),
                repositoryProduits.getProduit(12));
        repositoryCommandes.addCommande(new Commande(6, Etat.LIVREE,
                LocalDate.of(2022, 11, 5), l, repositoryClients.getClient(9)));

        l = Arrays.asList(repositoryProduits.getProduit(8),
                repositoryProduits.getProduit(25),
                repositoryProduits.getProduit(1),
                repositoryProduits.getProduit(13),
                repositoryProduits.getProduit(10));
        repositoryCommandes.addCommande(new Commande(7, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 6), l, repositoryClients.getClient(8)));

        l = Arrays.asList(repositoryProduits.getProduit(12),
                repositoryProduits.getProduit(8));
        repositoryCommandes.addCommande(new Commande(8, Etat.EN_ATTENTE,
                LocalDate.of(2022, 11, 6), l, repositoryClients.getClient(4)));

        l = Arrays.asList(repositoryProduits.getProduit(8));
        repositoryCommandes.addCommande(new Commande(9, Etat.EN_ATTENTE,
                LocalDate.of(2022, 11, 6), l, repositoryClients.getClient(10)));

        l = Arrays.asList(repositoryProduits.getProduit(14),
                repositoryProduits.getProduit(8));
        repositoryCommandes.addCommande(new Commande(10, Etat.ENVOYEE,
                LocalDate.of(2022, 11, 6), l, repositoryClients.getClient(8)));

        l = Arrays.asList(repositoryProduits.getProduit(12),
                repositoryProduits.getProduit(6),
                repositoryProduits.getProduit(21),
                repositoryProduits.getProduit(22),
                repositoryProduits.getProduit(27),
                repositoryProduits.getProduit(11));
        repositoryCommandes.addCommande(new Commande(11, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 7), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(19),
                repositoryProduits.getProduit(13),
                repositoryProduits.getProduit(11),
                repositoryProduits.getProduit(6));
        repositoryCommandes.addCommande(new Commande(12, Etat.ENVOYEE,
                LocalDate.of(2022, 11, 8), l, repositoryClients.getClient(5)));

        l = Arrays.asList(repositoryProduits.getProduit(11),
                repositoryProduits.getProduit(24),
                repositoryProduits.getProduit(26),
                repositoryProduits.getProduit(23));
        repositoryCommandes.addCommande(new Commande(13, Etat.ENVOYEE,
                LocalDate.of(2022, 11, 12), l, repositoryClients.getClient(5)));

        l = Arrays.asList(repositoryProduits.getProduit(18));
        repositoryCommandes.addCommande(new Commande(14, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 12), l, repositoryClients.getClient(4)));

        l = Arrays.asList(repositoryProduits.getProduit(16),
                repositoryProduits.getProduit(13),
                repositoryProduits.getProduit(7));
        repositoryCommandes.addCommande(new Commande(15, Etat.LIVREE,
                LocalDate.of(2022, 11, 13), l, repositoryClients.getClient(5)));

        l = Arrays.asList(repositoryProduits.getProduit(23),
                repositoryProduits.getProduit(29),
                repositoryProduits.getProduit(18),
                repositoryProduits.getProduit(16),
                repositoryProduits.getProduit(22),
                repositoryProduits.getProduit(26));
        repositoryCommandes.addCommande(new Commande(16, Etat.LIVREE,
                LocalDate.of(2022, 11, 14), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(18),
                repositoryProduits.getProduit(4));
        repositoryCommandes.addCommande(new Commande(17, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 14), l, repositoryClients.getClient(6)));

        l = Arrays.asList(repositoryProduits.getProduit(13),
                repositoryProduits.getProduit(3),
                repositoryProduits.getProduit(27),
                repositoryProduits.getProduit(2));
        repositoryCommandes.addCommande(new Commande(18, Etat.ENVOYEE,
                LocalDate.of(2022, 11, 14), l, repositoryClients.getClient(9)));

        l = Arrays.asList(repositoryProduits.getProduit(26),
                repositoryProduits.getProduit(22),
                repositoryProduits.getProduit(18),
                repositoryProduits.getProduit(14),
                repositoryProduits.getProduit(15),
                repositoryProduits.getProduit(13));
        repositoryCommandes.addCommande(new Commande(19, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 20), l, repositoryClients.getClient(9)));

        l = Arrays.asList(repositoryProduits.getProduit(22));
        repositoryCommandes.addCommande(new Commande(20, Etat.ENVOYEE,
                LocalDate.of(2022, 11, 20), l, repositoryClients.getClient(5)));

        l = Arrays.asList(repositoryProduits.getProduit(21),
                repositoryProduits.getProduit(26));
        repositoryCommandes.addCommande(new Commande(21, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 20), l, repositoryClients.getClient(9)));

        l = Arrays.asList(repositoryProduits.getProduit(7),
                repositoryProduits.getProduit(6));
        repositoryCommandes.addCommande(new Commande(22, Etat.EN_ATTENTE,
                LocalDate.of(2022, 11, 20), l, repositoryClients.getClient(5)));

        l = Arrays.asList(repositoryProduits.getProduit(24),
                repositoryProduits.getProduit(2),
                repositoryProduits.getProduit(6),
                repositoryProduits.getProduit(28),
                repositoryProduits.getProduit(4));
        repositoryCommandes.addCommande(new Commande(23, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 20), l, repositoryClients.getClient(4)));

        l = Arrays.asList(repositoryProduits.getProduit(28),
                repositoryProduits.getProduit(17),
                repositoryProduits.getProduit(2),
                repositoryProduits.getProduit(29),
                repositoryProduits.getProduit(19));
        repositoryCommandes.addCommande(new Commande(24, Etat.ENVOYEE,
                LocalDate.of(2022, 11, 21), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(4),
                repositoryProduits.getProduit(6),
                repositoryProduits.getProduit(15),
                repositoryProduits.getProduit(24));
        repositoryCommandes.addCommande(new Commande(25, Etat.ENVOYEE,
                LocalDate.of(2022, 11, 22), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(22),
                repositoryProduits.getProduit(9));
        repositoryCommandes.addCommande(new Commande(26, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 22), l,
                repositoryClients.getClient(10)));

        l = Arrays.asList(repositoryProduits.getProduit(22),
                repositoryProduits.getProduit(29),
                repositoryProduits.getProduit(6),
                repositoryProduits.getProduit(8));
        repositoryCommandes.addCommande(new Commande(27, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 22), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(16),
                repositoryProduits.getProduit(12),
                repositoryProduits.getProduit(28));
        repositoryCommandes.addCommande(new Commande(28, Etat.ENVOYEE,
                LocalDate.of(2022, 11, 23), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(8),
                repositoryProduits.getProduit(5));
        repositoryCommandes.addCommande(new Commande(29, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 28), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(12),
                repositoryProduits.getProduit(26),
                repositoryProduits.getProduit(21),
                repositoryProduits.getProduit(23),
                repositoryProduits.getProduit(29),
                repositoryProduits.getProduit(13));
        repositoryCommandes.addCommande(new Commande(30, Etat.ENVOYEE,
                LocalDate.of(2022, 11, 29), l, repositoryClients.getClient(2)));

        l = Arrays.asList(repositoryProduits.getProduit(1),
                repositoryProduits.getProduit(6),
                repositoryProduits.getProduit(22),
                repositoryProduits.getProduit(19),
                repositoryProduits.getProduit(13),
                repositoryProduits.getProduit(27));
        repositoryCommandes.addCommande(new Commande(31, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 29), l, repositoryClients.getClient(3)));

        l = Arrays.asList(repositoryProduits.getProduit(5),
                repositoryProduits.getProduit(11),
                repositoryProduits.getProduit(26),
                repositoryProduits.getProduit(9));
        repositoryCommandes.addCommande(new Commande(32, Etat.LIVREE,
                LocalDate.of(2022, 11, 29), l, repositoryClients.getClient(2)));

        l = Arrays.asList(repositoryProduits.getProduit(28),
                repositoryProduits.getProduit(7));
        repositoryCommandes.addCommande(new Commande(33, Etat.LIVREE,
                LocalDate.of(2022, 11, 30), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(15),
                repositoryProduits.getProduit(11));
        repositoryCommandes.addCommande(new Commande(34, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 30), l, repositoryClients.getClient(6)));

        l = Arrays.asList(repositoryProduits.getProduit(1),
                repositoryProduits.getProduit(21));
        repositoryCommandes.addCommande(new Commande(35, Etat.EN_ATTENTE,
                LocalDate.of(2022, 11, 30), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(12),
                repositoryProduits.getProduit(10),
                repositoryProduits.getProduit(11),
                repositoryProduits.getProduit(29),
                repositoryProduits.getProduit(1));
        repositoryCommandes.addCommande(new Commande(36, Etat.EN_PREPARATION,
                LocalDate.of(2022, 11, 30), l, repositoryClients.getClient(2)));

        l = Arrays.asList(repositoryProduits.getProduit(13),
                repositoryProduits.getProduit(19),
                repositoryProduits.getProduit(5),
                repositoryProduits.getProduit(29),
                repositoryProduits.getProduit(14),
                repositoryProduits.getProduit(4));
        repositoryCommandes.addCommande(new Commande(37, Etat.ENVOYEE,
                LocalDate.of(2022, 12, 1), l, repositoryClients.getClient(8)));

        l = Arrays.asList(repositoryProduits.getProduit(2));
        repositoryCommandes.addCommande(new Commande(38, Etat.EN_PREPARATION,
                LocalDate.of(2022, 12, 1), l, repositoryClients.getClient(8)));

        l = Arrays.asList(repositoryProduits.getProduit(6));
        repositoryCommandes.addCommande(new Commande(39, Etat.LIVREE,
                LocalDate.of(2022, 12, 3), l, repositoryClients.getClient(9)));

        l = Arrays.asList(repositoryProduits.getProduit(20),
                repositoryProduits.getProduit(18),
                repositoryProduits.getProduit(8),
                repositoryProduits.getProduit(24),
                repositoryProduits.getProduit(26),
                repositoryProduits.getProduit(13));
        repositoryCommandes.addCommande(new Commande(40, Etat.LIVREE,
                LocalDate.of(2022, 12, 3), l, repositoryClients.getClient(3)));

        l = Arrays.asList(repositoryProduits.getProduit(23),
                repositoryProduits.getProduit(1),
                repositoryProduits.getProduit(27),
                repositoryProduits.getProduit(15));
        repositoryCommandes.addCommande(new Commande(41, Etat.ENVOYEE,
                LocalDate.of(2022, 12, 3), l, repositoryClients.getClient(5)));

        l = Arrays.asList(repositoryProduits.getProduit(16),
                repositoryProduits.getProduit(24),
                repositoryProduits.getProduit(19),
                repositoryProduits.getProduit(13),
                repositoryProduits.getProduit(11));
        repositoryCommandes.addCommande(new Commande(42, Etat.EN_PREPARATION,
                LocalDate.of(2022, 12, 3), l, repositoryClients.getClient(9)));

        l = Arrays.asList(repositoryProduits.getProduit(23),
                repositoryProduits.getProduit(28),
                repositoryProduits.getProduit(20),
                repositoryProduits.getProduit(21));
        repositoryCommandes.addCommande(new Commande(43, Etat.LIVREE,
                LocalDate.of(2022, 12, 3), l, repositoryClients.getClient(3)));

        l = Arrays.asList(repositoryProduits.getProduit(15),
                repositoryProduits.getProduit(3),
                repositoryProduits.getProduit(26),
                repositoryProduits.getProduit(7),
                repositoryProduits.getProduit(19),
                repositoryProduits.getProduit(10));
        repositoryCommandes.addCommande(new Commande(44, Etat.EN_PREPARATION,
                LocalDate.of(2022, 12, 4), l, repositoryClients.getClient(4)));

        l = Arrays.asList(repositoryProduits.getProduit(5),
                repositoryProduits.getProduit(13),
                repositoryProduits.getProduit(29),
                repositoryProduits.getProduit(3),
                repositoryProduits.getProduit(12),
                repositoryProduits.getProduit(17));
        repositoryCommandes.addCommande(new Commande(45, Etat.ENVOYEE,
                LocalDate.of(2022, 12, 5), l, repositoryClients.getClient(1)));

        l = Arrays.asList(repositoryProduits.getProduit(15),
                repositoryProduits.getProduit(16));
        repositoryCommandes.addCommande(new Commande(46, Etat.LIVREE,
                LocalDate.of(2022, 12, 6), l, repositoryClients.getClient(10)));

        l = Arrays.asList(repositoryProduits.getProduit(16));
        repositoryCommandes.addCommande(new Commande(47, Etat.EN_PREPARATION,
                LocalDate.of(2022, 12, 8), l, repositoryClients.getClient(2)));

        l = Arrays.asList(repositoryProduits.getProduit(3),
                repositoryProduits.getProduit(6),
                repositoryProduits.getProduit(9));
        repositoryCommandes.addCommande(new Commande(48, Etat.EN_PREPARATION,
                LocalDate.of(2022, 12, 8), l, repositoryClients.getClient(2)));

        l = Arrays.asList(repositoryProduits.getProduit(2),
                repositoryProduits.getProduit(1));
        repositoryCommandes.addCommande(new Commande(49, Etat.EN_PREPARATION,
                LocalDate.of(2022, 12, 8), l, repositoryClients.getClient(7)));

        l = Arrays.asList(repositoryProduits.getProduit(19));
        repositoryCommandes.addCommande(new Commande(50, Etat.EN_PREPARATION,
                LocalDate.of(2022, 12, 10), l, repositoryClients.getClient(9)));
    }

     public static List<Produit>
     listeDesProduitsCategorieLivreAvecPrixSupA90(){
     {
    	 return repositoryProduits.getProduits().stream().filter(x -> x.getCategorie().equals(Categorie.LIVRE) && x.getPrix() > 90).collect(Collectors.toList());
     }
     }
     
     public static List<Commande>
     listedescommandescontenantaumoinsunarticledelacatégorieBEBE(){
    	 {
    		 return repositoryCommandes.getCommandes().stream()
    				 .filter( x -> x.getProduits().stream().anyMatch(b -> b.getCategorie().equals(Categorie.BEBE)))
    				 .collect(Collectors.toList());
    	 }
     }
     
     public static List<Produit>
     lalistedesproduitsdecatégorieJOUETetleurappliqueruneréductionde10(){
    	 {
    		 return repositoryProduits.getProduits().stream()
    				 .filter(x -> x.getCategorie().equals(Categorie.JOUET))
    				 .map(p -> { p.setPrix(p.getPrix() * 0.9); return p; })
					 .collect(Collectors.toList());
    	 }
     }
     
     public static List<Commande> listeproduitcommandéentre(){
    	 {
    		 LocalDate debut = LocalDate.of(2022, 11, 3);
    		 LocalDate fin   = LocalDate.of(2022, 11, 15);

    		 return repositoryCommandes.getCommandes().stream()
    				 .filter(c -> !c.getDateCommande().isBefore(debut) && !c.getDateCommande().isAfter(fin))    				 
    				 .sorted(Comparator.comparing(Commande::getId))
    				 .collect(Collectors.toList());
    	 }
     }
     
     public static List<Produit> listemoinscher(){
    	 {
    		 return repositoryProduits.getProduits().stream()
    				 .filter(x -> x.getCategorie().equals(Categorie.LIVRE))
    				 .min(Comparator.comparing(Produit::getPrix))
    				 .map(List::of)
    				 .orElse(List.of());
    	 }
     }
     
     

}
