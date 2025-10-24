package tp3;

public class Contact {
    private String nom;
    private String prénom;
    private String numéro;
    
    public Contact(String nom, String prénom, String numéro)throws IllegalArgumentException{
        this.nom = nom;
        this.prénom = prénom;
        this.numéro = numéro;
        if (this.nom == null || this.prénom == null || this.numéro == null) {
            throw new IllegalArgumentException ("Référence null");
        }
    }
    
    public Contact unContact(String nom, String prénom, String numéro) {
        return new Contact(nom, prénom ,numéro);
    }

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public String getNuméro() {
        return numéro;
    }
    
    @Override
    public String toString() {
        return nom + prénom + numéro;
    }
    
    

}
