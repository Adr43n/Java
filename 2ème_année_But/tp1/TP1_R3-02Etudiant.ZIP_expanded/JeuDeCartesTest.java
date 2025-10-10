import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class JeuDeCartesTest {

    @Test
    public void testConstructeur() {
        JeuDeCartes jeu = new JeuDeCartes();
        assertEquals("[As de Pique, As de Coeur, As de Carreau, As de Trèfle, "
                + "Roi de Pique, Roi de Coeur, Roi de Carreau, Roi de Trèfle, "
                + "Dame de Pique, Dame de Coeur, Dame de Carreau, "
                + "Dame de Trèfle, Valet de Pique, Valet de Coeur, "
                + "Valet de Carreau, Valet de Trèfle, Dix de Pique, "
                + "Dix de Coeur, Dix de Carreau, Dix de Trèfle, Neuf de Pique, "
                + "Neuf de Coeur, Neuf de Carreau, Neuf de Trèfle, "
                + "Huit de Pique, Huit de Coeur, Huit de Carreau, "
                + "Huit de Trèfle, Sept de Pique, Sept de Coeur, "
                + "Sept de Carreau, Sept de Trèfle, Six de Pique, "
                + "Six de Coeur, Six de Carreau, Six de Trèfle, Cinq de Pique, "
                + "Cinq de Coeur, Cinq de Carreau, Cinq de Trèfle, "
                + "Quatre de Pique, Quatre de Coeur, Quatre de Carreau, "
                + "Quatre de Trèfle, Trois de Pique, Trois de Coeur, "
                + "Trois de Carreau, Trois de Trèfle, Deux de Pique, "
                + "Deux de Coeur, Deux de Carreau, Deux de Trèfle]",
                jeu.toString());
        assertEquals(52, jeu.nombreDeCartes());

    }

    @Test
    public void testPremièreCarte() {
        JeuDeCartes jeu = new JeuDeCartes();
        assertEquals(new Carte(Couleur.PIQUE, Valeur.AS), jeu.premiereCarte());
        assertEquals(52, jeu.nombreDeCartes());
    }

    @Test
    public void testDistribuerUneCarte() {
        JeuDeCartes jeu = new JeuDeCartes();
        jeu.distribuerUneCarte();
        assertEquals(new Carte(Couleur.COEUR, Valeur.AS), jeu.premiereCarte());
        assertEquals(51, jeu.nombreDeCartes());
    }

    @Test
    public void testMettrePremièreCarteSousLePaquet() {
        JeuDeCartes jeu = new JeuDeCartes();
        jeu.mettrePremiereCarteSousLePaquet();
        assertEquals(new Carte(Couleur.COEUR, Valeur.AS), jeu.premiereCarte());
        assertEquals(52, jeu.nombreDeCartes());
    }

    @Test
    public void testTrier() {
        JeuDeCartes jeu = new JeuDeCartes();
        jeu.trier();
        assertEquals("[As de Pique, Roi de Pique, Dame de Pique, "
                + "Valet de Pique, Dix de Pique, Neuf de Pique, Huit de Pique, "
                + "Sept de Pique, Six de Pique, Cinq de Pique, "
                + "Quatre de Pique, Trois de Pique, Deux de Pique, "
                + "As de Coeur, Roi de Coeur, Dame de Coeur, Valet de Coeur, "
                + "Dix de Coeur, Neuf de Coeur, Huit de Coeur, Sept de Coeur, "
                + "Six de Coeur, Cinq de Coeur, Quatre de Coeur, "
                + "Trois de Coeur, Deux de Coeur, As de Carreau, "
                + "Roi de Carreau, Dame de Carreau, Valet de Carreau, "
                + "Dix de Carreau, Neuf de Carreau, Huit de Carreau, "
                + "Sept de Carreau, Six de Carreau, Cinq de Carreau, "
                + "Quatre de Carreau, Trois de Carreau, Deux de Carreau, "
                + "As de Trèfle, Roi de Trèfle, Dame de Trèfle, "
                + "Valet de Trèfle, Dix de Trèfle, Neuf de Trèfle, "
                + "Huit de Trèfle, Sept de Trèfle, Six de Trèfle, "
                + "Cinq de Trèfle, Quatre de Trèfle, Trois de Trèfle, "
                + "Deux de Trèfle]", jeu.toString());
    }

    @Ignore
    @Test
    public void testTrier2() {
        JeuDeCartes jeu = new JeuDeCartes();
        jeu.trier();
        assertEquals("[As de Pique, Deux de Pique, Trois de Pique, "
                + "Quatre de Pique, Cinq de Pique, Six de Pique, Sept de Pique, "
                + "Huit de Pique, Neuf de Pique, Dix de Pique, Valet de Pique, "
                + "Dame de Pique, Roi de Pique, As de Coeur, Deux de Coeur, "
                + "Trois de Coeur, Quatre de Coeur, Cinq de Coeur, "
                + "Six de Coeur, Sept de Coeur, Huit de Coeur, Neuf de Coeur, "
                + "Dix de Coeur, Valet de Coeur, Dame de Coeur, Roi de Coeur, "
                + "As de Carreau, Deux de Carreau, Trois de Carreau, "
                + "Quatre de Carreau, Cinq de Carreau, Six de Carreau, "
                + "Sept de Carreau, Huit de Carreau, Neuf de Carreau, "
                + "Dix de Carreau, Valet de Carreau, Dame de Carreau, "
                + "Roi de Carreau, As de Trèfle, Deux de Trèfle, "
                + "Trois de Trèfle, Quatre de Trèfle, Cinq de Trèfle, "
                + "Six de Trèfle, Sept de Trèfle, Huit de Trèfle, "
                + "Neuf de Trèfle, Dix de Trèfle, Valet de Trèfle, "
                + "Dame de Trèfle, Roi de Trèfle]", jeu.toString());
    }

    @Test(expected = PaquetVideException.class)
    public void testPremièreCarteSurPaquetVide() throws PaquetVideException {
        JeuDeCartes jeu = new JeuDeCartes();
        for (int i = 1; i <= 52; i++) {
            jeu.distribuerUneCarte();
        }
        jeu.premiereCarte();
    }

    @Test(expected = PaquetVideException.class)
    public void testDistribuerUneCarteSurPaquetVide()
            throws PaquetVideException {
        JeuDeCartes jeu = new JeuDeCartes();
        for (int i = 1; i <= 52; i++) {
            jeu.distribuerUneCarte();
        }
        jeu.distribuerUneCarte();
    }

    @Test(expected = PaquetVideException.class)
    public void testMettrePremièreCarteSousLePaquetSurPaquetVide()
            throws PaquetVideException {
        JeuDeCartes jeu = new JeuDeCartes();
        for (int i = 1; i <= 52; i++) {
            jeu.distribuerUneCarte();
        }
        jeu.mettrePremiereCarteSousLePaquet();
    }

}
