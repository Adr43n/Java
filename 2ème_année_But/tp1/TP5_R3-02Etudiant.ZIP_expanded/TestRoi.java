import java.util.*;
import java.util.function.*;

public class TestRoi {

	static class Carte {
	private final int valeur;      
	private final String couleur;  
    private final String unicode;  

    public Carte(int valeur, String couleur, String unicode) {
    	this.valeur = valeur;
        this.couleur = couleur;
        this.unicode = unicode;
    }

	        public int getValeur() {
	            return valeur;
	        }

	        public String getCouleur() {
	            return couleur;
	        }

	        @Override
	        public String toString() {
	            return unicode;
	        }
	    }

	    // --- Lambdas demandées ---
	    static Supplier<Carte> roi = () -> {
	        int n = (int) (Math.random() * 4); // 0..3
	        switch (n) {
	            case 0: return new Carte(13, "Pique", "🂮");
	            case 1: return new Carte(13, "Cœur", "🂾");
	            case 2: return new Carte(13, "Carreau", "🃎");
	            default: return new Carte(13, "Trèfle", "🃞");
	        }
	    };

	    static BiPredicate<Carte, Carte> mêmeCouleur =
	            (c1, c2) -> c1.getCouleur().equals(c2.getCouleur());

	    static Consumer<Carte> affichage =
	            c -> System.out.println("Carte : " + c + " (" + c.getCouleur() + ")");

	    static BiFunction<Carte, Carte, Optional<String>> laPlusForte = (c1, c2) -> {
	        if (c1.getValeur() > c2.getValeur()) {
	            return Optional.of(c1.toString());
	        } else if (c2.getValeur() > c1.getValeur()) {
	            return Optional.of(c2.toString());
	        } else {
	            return Optional.empty();
	        }
	    };

	    // --- Méthode transforme ---
	    public static int[] transforme(int[] tab, Function<Integer, Integer> lambda) {
	        int[] res = new int[tab.length];
	        for (int i = 0; i < tab.length; i++) {
	            res[i] = lambda.apply(tab[i]);
	        }
	        return res;
	    }

	    // --- MAIN ---
	    public static void main(String[] args) {
	        System.out.println("=== Partie 1 : Cartes ===");
	        Carte roi1 = roi.get();
	        Carte roi2 = roi.get();

	        affichage.accept(roi1);
	        affichage.accept(roi2);

	        System.out.println("Même couleur ? " + mêmeCouleur.test(roi1, roi2));
	        System.out.println("La plus forte : " + laPlusForte.apply(roi1, roi2));

	        System.out.println("\n=== Partie 2 : Tableaux ===");
	        int[] tab = {1, 2, 3, 4, 5};

	        Function<Integer, Integer> lambda1 = x -> x * x;       // f(x)=x²
	        Function<Integer, Integer> lambda2 = x -> x * x * x;   // f(x)=x³
	        Function<Integer, Integer> lambda3 = x -> 2 * x + 3;   // f(x)=2x+3

	        System.out.println("x² : " + Arrays.toString(transforme(tab, lambda1)));
	        System.out.println("x³ : " + Arrays.toString(transforme(tab, lambda2)));
	        System.out.println("2x+3 : " + Arrays.toString(transforme(tab, lambda3)));

	        System.out.println("\n=== Partie 3 : Version réduite (3 lignes) ===");
	        System.out.println(Arrays.toString(transforme(tab, x -> x * x)));
	        System.out.println(Arrays.toString(transforme(tab, x -> x * x * x)));
	        System.out.println(Arrays.toString(transforme(tab, x -> 2 * x + 3)));
	    }
	}

