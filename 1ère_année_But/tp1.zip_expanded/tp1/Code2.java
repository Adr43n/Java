import java.util.Scanner;

public class Code2 {
    public static void main(String[] args) {
        Scanner entrée = new Scanner(System.in);
        System.out.println(
                "Entrer un code d'identification de quatre chiffres : ");
        String code = entrée.nextLine();
        int somme3PremiersChiffres = code.charAt(0) - '0' + code.charAt(1) - '0'
                + code.charAt(2) - '0';
        if (code.charAt(3) - '0' == somme3PremiersChiffres % 7) {
            System.out.println(
                    "*** Code " + code + " correct. Prêt à photocopier.");
        } else {
            System.out.println("*** Code " + code + " incorrect.");
        }
        entrée.close();
    }
}
