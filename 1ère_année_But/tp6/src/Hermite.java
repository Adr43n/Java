public class Hermite {

    public static void main(String[] args) {
        System.out.println("Les 10 premiers polynômes d'Hermite : ");
        Polynôme[] hermite = Hermite.dixPremiersPolynômes();
        for (int i = 0; i < 10; i++) {
            System.out.println("H" + i + "(x) = " + hermite[i]);
        }
    }

    public static Polynôme[] dixPremiersPolynômes() {
        Polynôme[] hermite = new Polynôme[10];
        hermite[0] = new Polynôme();
        hermite[0].setMonôme(new Monôme(1, 0));
        hermite[1] = new Polynôme();
        hermite[1].setMonôme(new Monôme(1, 1));
        Monôme m1 = new Monôme(1.0F, 1);
        for (int i = 2; i < 10; i++) {
            Monôme m2 = new Monôme(-i + 1, 0);
            Polynôme terme1 = hermite[i - 1].produit(m1);
            Polynôme terme2 = hermite[i - 2].produit(m2);
            hermite[i] = terme1.somme(terme2);
        }
        return hermite;
    }
}
