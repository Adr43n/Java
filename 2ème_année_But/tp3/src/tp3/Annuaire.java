package tp3;

import java.util.TreeMap;

public class Annuaire {
    private TreeMap<String, Contact>contacts;
    
    public Annuaire() {
      contacts = new TreeMap<>();
    }
    
    public void ajouterContact(Contact c) {
        if (c != null) {
            String cle = c.getNom() + c.getPrénom();
            contacts.put(cle, c);
        }
    }
    
    public Contact rechercherContact(String nomPrenom) {
        return contacts.get(nomPrenom);
    }

}
