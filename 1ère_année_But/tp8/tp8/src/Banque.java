import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une banque avec une liste de comptes bancaires.
 */
public class Banque {
    private String libellé;
    private List<CompteBancaire> comptes;

    /**
     * Constructeur de la banque.
     * @param libelle Nom de la banque
     */
    public Banque(String libellé) {
        this.libellé = libellé;
        this.comptes = new ArrayList<>();
    }

    /**
     * Retourne le libellé de la banque.
     * @return libellé de la banque
     */
    public String getLibellé() {
        return libellé;
    }

    public boolean estCompteExistant(String Numéro) {
        return this.getCompte(Numéro) != null;
    }

   
    public CompteBancaire getCompte(String Numéro) {
        for (CompteBancaire c : this.comptes) {
            if (c.getNuméro().equals(Numéro)) {
                return c;
            }
        }
        return null;
    }
    
    public void ouvrir(String Numéro, float valeur) throws IllegalArgumentException {
        if (this.estCompteExistant(Numéro) || valeur < 0) {
            throw new IllegalArgumentException("Compte existant ou montant invalide : " + Numéro);
        }
        CompteBancaire c = new CompteBancaire(Numéro);
        c.déposer(valeur);
        this.comptes.add(c);
    }

   
    public void ouvrir(String Numéro, float taux, float valeur) throws IllegalArgumentException {
        if (this.estCompteExistant(Numéro) || valeur < 0) {
            throw new IllegalArgumentException("Compte existant ou montant invalide : " + Numéro);
        }
        CompteEpargne c = new CompteEpargne(Numéro, taux);
        c.déposer(valeur);
        this.comptes.add(c);
    }

    
    public void fermer(String Numéro) throws IllegalArgumentException {
        CompteBancaire c = this.getCompte(Numéro);
        if (c == null || c.solde() != 0) {
            throw new IllegalArgumentException("Compte inexistant ou solde non nul : " + Numéro);
        }
        this.comptes.remove(c);
    }

    /**
     * Calcule le solde total de la banque.
     * @return solde total de la banque
     */
    public float solde() {
        float total = 0;
        for (CompteBancaire c : this.comptes) {
            total += c.solde();
        }
        return total;
    }

   
    public void deposer(String Numéro, float valeur) throws IllegalArgumentException {
        CompteBancaire c = this.getCompte(Numéro);
        if (c == null || valeur < 0) {
            throw new IllegalArgumentException("Compte inexistant ou montant invalide : " + Numéro);
        }
        c.déposer(valeur);
    }

 
    public void retirer(String Numéro, float valeur) throws IllegalArgumentException {
        CompteBancaire c = this.getCompte(Numéro);
        if (c == null || valeur < 0) {
            throw new IllegalArgumentException("Compte inexistant ou montant invalide : " + Numéro);
        }
        c.retirer(valeur);
    }

    
    

    /**
     * Retourne une représentation textuelle de la banque et de ses comptes.
     * @return Chaîne de caractères représentant la banque
     */
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("[Banque : " + this.libellé);
        for (CompteBancaire c : this.comptes) {
            r.append("\nNuméro : ").append(c.getNuméro())
             .append(", Crédit : ").append(c.solde())
             .append(", Débit : 0.0");
        }
        return r.append("]").toString();
    }
}
