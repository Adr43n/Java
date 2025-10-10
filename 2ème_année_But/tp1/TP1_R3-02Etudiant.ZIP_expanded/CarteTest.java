import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarteTest {

    @Test
    public void testConstructeur() {
        Carte c = new Carte(Couleur.COEUR, Valeur.AS);
        assertEquals(Valeur.AS, c.valeur());
        assertEquals(Couleur.COEUR, c.couleur());
    }

    @Test
    public void testToString() {
        assertEquals("As de Coeur",
                new Carte(Couleur.COEUR, Valeur.AS).toString());
        assertEquals("Deux de Coeur",
                new Carte(Couleur.COEUR, Valeur.DEUX).toString());
        assertEquals("Dix de Trèfle",
                new Carte(Couleur.TREFLE, Valeur.DIX).toString());
        assertEquals("Roi de Pique",
                new Carte(Couleur.PIQUE, Valeur.ROI).toString());
        assertEquals("Dame de Carreau",
                new Carte(Couleur.CARREAU, Valeur.DAME).toString());
    }

    @Test
    public void testEquals() {
        assertEquals(new Carte(Couleur.COEUR, Valeur.AS),
                new Carte(Couleur.COEUR, Valeur.AS));
        assertNotEquals(new Carte(Couleur.COEUR, Valeur.AS),
                new Carte(Couleur.COEUR, Valeur.DEUX));
        assertNotEquals(new Carte(Couleur.COEUR, Valeur.AS),
                new Carte(Couleur.TREFLE, Valeur.AS));
        assertNotEquals(new Carte(Couleur.COEUR, Valeur.AS),
                new Carte(Couleur.TREFLE, Valeur.DEUX));
    }

    @Test
    public void testCompareTo() {
        assertTrue(new Carte(Couleur.COEUR, Valeur.AS)
                .compareTo(new Carte(Couleur.COEUR, Valeur.AS)) == 0);
        assertTrue(new Carte(Couleur.PIQUE, Valeur.AS)
                .compareTo(new Carte(Couleur.COEUR, Valeur.AS)) < 0);
        assertTrue(new Carte(Couleur.PIQUE, Valeur.AS)
                .compareTo(new Carte(Couleur.PIQUE, Valeur.TROIS)) < 0);
        assertTrue(new Carte(Couleur.COEUR, Valeur.ROI)
                .compareTo(new Carte(Couleur.COEUR, Valeur.AS)) > 0);
        assertTrue(new Carte(Couleur.TREFLE, Valeur.DIX)
                .compareTo(new Carte(Couleur.PIQUE, Valeur.TROIS)) > 0);

    }

}
