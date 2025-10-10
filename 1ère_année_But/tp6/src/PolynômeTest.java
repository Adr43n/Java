import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PolynômeTest {

    @Test
    public void testToStringPolynômeNul() {
        Polynôme nul = new Polynôme();
        assertEquals("0", nul.toString());
    }

    @Test
    public void testToStringPolynômeCoefficientsPositifs() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(8.0F, 4));
        p.setMonôme(new Monôme(8.0F, 2));
        p.setMonôme(new Monôme(1.0F, 0));
        assertEquals("8.0xe4 + 8.0xe2 + 1.0", p.toString());
    }

    @Test
    public void testToStringPolynômeCoefficientsPositifsEtNégatifs() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(128.0F, 8));
        p.setMonôme(new Monôme(160.0F, 4));
        p.setMonôme(new Monôme(-32.0F, 2));
        p.setMonôme(new Monôme(1F, 0));
        assertEquals("128.0xe8 + 160.0xe4 - 32.0xe2 + 1.0", p.toString());
    }

    @Test
    public void testToStringPolynômePremierCoefficientNégatif() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(-128.0F, 8));
        p.setMonôme(new Monôme(160.0F, 4));
        p.setMonôme(new Monôme(-32.0F, 2));
        p.setMonôme(new Monôme(1.0F, 0));
        assertEquals("-128.0xe8 + 160.0xe4 - 32.0xe2 + 1.0", p.toString());
    }

    @Test
    public void testGetMonômeAvecExposantSupADegréMax() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(6F, 1));
        assertEquals(110, p.getMonôme(110).getExposant());
        assertEquals(0.0F, p.getMonôme(110).getCoefficient(), 0.0F);
    }

    @Test
    public void testGetMonômeAvecExposantInfADegréMax() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(6F, 1));
        assertTrue(p.getMonôme(3).estNul());
        assertEquals(1, p.getMonôme(1).getExposant());
        assertEquals(6.0F, p.getMonôme(1).getCoefficient(), 0.0F);
        assertEquals(0, p.getMonôme(0).getExposant());
        assertEquals(0.0F, p.getMonôme(0).getCoefficient(), 0.0F);
    }

    @Test
    public void testSetMonômeNulDegréSupADegréMax() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(0.0F, 101));
        assertEquals("0", p.toString());
    }

    @Test
    public void testDérivée() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(2.0F, 2));
        p.setMonôme(new Monôme(6.0F, 1));
        p.setMonôme(new Monôme(32.0F, 0));
        assertEquals("4.0x + 6.0", p.dérivée().toString());
    }

    @Test
    public void testSomme() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(-128.0F, 8));
        p.setMonôme(new Monôme(160.0F, 4));
        p.setMonôme(new Monôme(-32.0F, 2));
        p.setMonôme(new Monôme(1.0F, 0));
        Polynôme other = new Polynôme();
        other.setMonôme(new Monôme(128.0F, 8));
        other.setMonôme(new Monôme(6.0F, 4));
        other.setMonôme(new Monôme(33.0F, 3));
        assertEquals("166.0xe4 + 33.0xe3 - 32.0xe2 + 1.0",
                p.somme(other).toString());
    }

    @Test
    public void testProduitMonôme() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(128.0F, 8));
        p.setMonôme(new Monôme(160.0F, 4));
        p.setMonôme(new Monôme(-32.0F, 2));
        p.setMonôme(new Monôme(1.0F, 0));
        Monôme m = new Monôme(2.0F, 1);
        assertEquals("256.0xe9 + 320.0xe5 - 64.0xe3 + 2.0x",
                p.produit(m).toString());
    }

    @Test
    public void testProduitMonômeAvecPolynômeNul() {
        Polynôme p = new Polynôme();
        Monôme m = new Monôme(2.0F, 1);
        assertEquals("0", p.produit(m).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMonômeExposantNégatif() {
        Polynôme p = new Polynôme();
        p.getMonôme(-8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMonômeNonNulExposantSupérieurDegréMax() {
        Polynôme p = new Polynôme();
        p.setMonôme(new Monôme(128.0F, 2000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProduitMonômeAvecExposantMonômeSupérieurDegréMax() {
        Polynôme p = new Polynôme();
        Monôme m = new Monôme(5.0F, 6);
        p.setMonôme(new Monôme(10.0F, 98));
        p.produit(m);
    }

}
