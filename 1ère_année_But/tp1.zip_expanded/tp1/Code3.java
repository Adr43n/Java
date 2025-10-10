import java.util.Scanner;

public class Code3 {
    public static void main(String[] args) {
        final int TAILLE_CODE = 4;
        int[] code = new int[TAILLE_CODE];
        Scanner entrée = new Scanner(System.in);
        System.out.println(
                "Entrer un code d'identification de 4 chiffres (séparés par des espaces) : ");
        for (int i = 0; i < TAILLE_CODE; i++) {
            code[i] = entrée.nextInt();
        }
        int somme3PremiersChiffres = code[0] + code[1] + code[2];
        if (code[3] == somme3PremiersChiffres % 7) {
            System.out.println("*** Code " + code[0] + code[1] + code[2]
                    + code[3] + " correct. Prêt à photocopier. ");
        } else {
            System.out.println("*** Code " + code[0] + code[1] + code[2]
                    + code[3] + " incorrect.");
        }
        entrée.close();
    }
}
