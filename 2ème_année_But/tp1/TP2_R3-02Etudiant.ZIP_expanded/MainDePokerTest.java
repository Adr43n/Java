import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainDePokerTest {
    private MainDePoker mainQuinteFlushRoyale;
    private MainDePoker mainQuinteFlush;
    private MainDePoker mainCarré;
    private MainDePoker mainFull;
    private MainDePoker mainCouleur;
    private MainDePoker mainSuite;
    private MainDePoker mainBrelan;
    private MainDePoker mainDoublePaire;
    private MainDePoker mainPaire;
    private MainDePoker mainHauteur;

    static Carte[] tQuinteFlushRoyale = { new Carte(Couleur.CARREAU, Valeur.AS),
            new Carte(Couleur.CARREAU, Valeur.ROI),
            new Carte(Couleur.CARREAU, Valeur.DAME),
            new Carte(Couleur.CARREAU, Valeur.VALET),
            new Carte(Couleur.CARREAU, Valeur.DIX) };

    static Carte[] tQuinteFlush = { new Carte(Couleur.CARREAU, Valeur.DIX),
            new Carte(Couleur.CARREAU, Valeur.NEUF),
            new Carte(Couleur.CARREAU, Valeur.SEPT),
            new Carte(Couleur.CARREAU, Valeur.VALET),
            new Carte(Couleur.CARREAU, Valeur.HUIT) };

    static Carte[] tCarré = { new Carte(Couleur.PIQUE, Valeur.ROI),
            new Carte(Couleur.CARREAU, Valeur.ROI),
            new Carte(Couleur.COEUR, Valeur.ROI),
            new Carte(Couleur.TREFLE, Valeur.ROI),
            new Carte(Couleur.TREFLE, Valeur.TROIS) };

    static Carte[] tFull = { new Carte(Couleur.COEUR, Valeur.ROI),
            new Carte(Couleur.CARREAU, Valeur.TROIS),
            new Carte(Couleur.CARREAU, Valeur.ROI),
            new Carte(Couleur.PIQUE, Valeur.TROIS),
            new Carte(Couleur.TREFLE, Valeur.TROIS) };

    static Carte[] tCouleur = { new Carte(Couleur.CARREAU, Valeur.ROI),
            new Carte(Couleur.CARREAU, Valeur.DIX),
            new Carte(Couleur.CARREAU, Valeur.QUATRE),
            new Carte(Couleur.CARREAU, Valeur.HUIT),
            new Carte(Couleur.CARREAU, Valeur.TROIS) };

    static Carte[] tSuite = { new Carte(Couleur.CARREAU, Valeur.QUATRE),
            new Carte(Couleur.CARREAU, Valeur.CINQ),
            new Carte(Couleur.TREFLE, Valeur.SIX),
            new Carte(Couleur.PIQUE, Valeur.SEPT),
            new Carte(Couleur.TREFLE, Valeur.HUIT) };

    static Carte[] tBrelan = { new Carte(Couleur.CARREAU, Valeur.ROI),
            new Carte(Couleur.PIQUE, Valeur.ROI),
            new Carte(Couleur.TREFLE, Valeur.ROI),
            new Carte(Couleur.PIQUE, Valeur.DAME),
            new Carte(Couleur.TREFLE, Valeur.CINQ) };

    static Carte[] tDoublePaire = { new Carte(Couleur.PIQUE, Valeur.ROI),
            new Carte(Couleur.TREFLE, Valeur.ROI),
            new Carte(Couleur.PIQUE, Valeur.DAME),
            new Carte(Couleur.PIQUE, Valeur.HUIT),
            new Carte(Couleur.CARREAU, Valeur.HUIT) };

    static Carte[] tPaire = { new Carte(Couleur.TREFLE, Valeur.HUIT),
            new Carte(Couleur.PIQUE, Valeur.ROI),
            new Carte(Couleur.CARREAU, Valeur.HUIT),
            new Carte(Couleur.PIQUE, Valeur.DAME),
            new Carte(Couleur.TREFLE, Valeur.CINQ) };

    static Carte[] tHauteur = { new Carte(Couleur.PIQUE, Valeur.ROI),
            new Carte(Couleur.CARREAU, Valeur.SIX),
            new Carte(Couleur.TREFLE, Valeur.CINQ),
            new Carte(Couleur.PIQUE, Valeur.DAME),
            new Carte(Couleur.CARREAU, Valeur.HUIT) };

    @Before
    public void setUp() throws Exception {
        this.mainQuinteFlushRoyale = new MainDePoker(tQuinteFlushRoyale);
        this.mainQuinteFlush = new MainDePoker(tQuinteFlush);
        this.mainCarré = new MainDePoker(tCarré);
        this.mainFull = new MainDePoker(tFull);
        this.mainCouleur = new MainDePoker(tCouleur);
        this.mainSuite = new MainDePoker(tSuite);
        this.mainBrelan = new MainDePoker(tBrelan);
        this.mainDoublePaire = new MainDePoker(tDoublePaire);
        this.mainPaire = new MainDePoker(tPaire);
        this.mainHauteur = new MainDePoker(tHauteur);

    }

    @After
    public void tearDown() throws Exception {
        this.mainQuinteFlushRoyale = null;
        this.mainQuinteFlush = null;
        this.mainCarré = null;
        this.mainFull = null;
        this.mainCouleur = null;
        this.mainSuite = null;
        this.mainBrelan = null;
        this.mainDoublePaire = null;
        this.mainPaire = null;
        this.mainHauteur = null;

    }

    @Test(expected = TricheurException.class)
    public void testConstructionMainNbCartesIncorrect() {
        Carte[] m = { new Carte(Couleur.CARREAU, Valeur.AS),
                new Carte(Couleur.CARREAU, Valeur.ROI),
                new Carte(Couleur.CARREAU, Valeur.DAME),
                new Carte(Couleur.CARREAU, Valeur.VALET) };
        new MainDePoker(m);
    }

    @Test(expected = TricheurException.class)
    public void testConstructionMainCartesEnDouble() {
        Carte[] m = { new Carte(Couleur.CARREAU, Valeur.AS),
                new Carte(Couleur.CARREAU, Valeur.ROI),
                new Carte(Couleur.CARREAU, Valeur.DAME),
                new Carte(Couleur.CARREAU, Valeur.VALET),
                new Carte(Couleur.CARREAU, Valeur.DAME) };
        new MainDePoker(m);
    }

    @Test
    public void testConstructionMainCarteTriée() {
        Carte[] m = { new Carte(Couleur.PIQUE, Valeur.ROI),
                new Carte(Couleur.COEUR, Valeur.SIX),
                new Carte(Couleur.TREFLE, Valeur.CINQ),
                new Carte(Couleur.CARREAU, Valeur.DAME),
                new Carte(Couleur.CARREAU, Valeur.HUIT) };
        Carte[] mTrié = { new Carte(Couleur.PIQUE, Valeur.ROI),
                new Carte(Couleur.CARREAU, Valeur.DAME),
                new Carte(Couleur.CARREAU, Valeur.HUIT),
                new Carte(Couleur.COEUR, Valeur.SIX),
                new Carte(Couleur.TREFLE, Valeur.CINQ) };
        MainDePoker mainDeM = new MainDePoker(m);
        Iterator<Carte> it = mainDeM.iterateurDeCarte();
        int i = 0;
        while (it.hasNext()) {
            assertEquals(mTrié[i], it.next());
            i++;
        }
    }

    @Test
    public void testConstructeurGlobal() {
        Carte[] m = { new Carte(Couleur.PIQUE, Valeur.ROI),
                new Carte(Couleur.COEUR, Valeur.SIX),
                new Carte(Couleur.TREFLE, Valeur.CINQ),
                new Carte(Couleur.PIQUE, Valeur.SIX),
                new Carte(Couleur.PIQUE, Valeur.HUIT) };
        MainDePoker mainDeM = new MainDePoker(m);
        assertEquals(
                "mainJoueur=[Roi de Pique, Huit de Pique, Six de Pique, Six de Coeur, Cinq de Trèfle]\n"
                        + "nbCartesParValeur={ROI=1, HUIT=1, SIX=2, CINQ=1}\n"
                        + "nbCartesParCouleur={PIQUE=3, COEUR=1, TREFLE=1}",
                mainDeM.toString());
    }

   
    @Test
    public void testQuinteFlushRoyale() {
        assertTrue(this.mainQuinteFlushRoyale.isQuinteFlushRoyale());
        assertFalse(this.mainQuinteFlush.isQuinteFlushRoyale());
        assertFalse(this.mainCarré.isQuinteFlushRoyale());
        assertFalse(this.mainFull.isQuinteFlushRoyale());
        assertFalse(this.mainCouleur.isQuinteFlushRoyale());
        assertFalse(this.mainSuite.isQuinteFlushRoyale());
        assertFalse(this.mainBrelan.isQuinteFlushRoyale());
        assertFalse(this.mainDoublePaire.isQuinteFlushRoyale());
        assertFalse(this.mainPaire.isQuinteFlushRoyale());
        assertFalse(this.mainHauteur.isQuinteFlushRoyale());
    }


    @Test
    public void testQuinteFlush() {
        assertFalse(this.mainQuinteFlushRoyale.isQuinteFlush());
        assertTrue(this.mainQuinteFlush.isQuinteFlush());
        assertFalse(this.mainCarré.isQuinteFlush());
        assertFalse(this.mainFull.isQuinteFlush());
        assertFalse(this.mainCouleur.isQuinteFlush());
        assertFalse(this.mainSuite.isQuinteFlush());
        assertFalse(this.mainBrelan.isQuinteFlush());
        assertFalse(this.mainDoublePaire.isQuinteFlush());
        assertFalse(this.mainPaire.isQuinteFlush());
        assertFalse(this.mainHauteur.isQuinteFlush());
    }

   
    @Test
    public void testCarré() {
        assertFalse(this.mainQuinteFlushRoyale.isCarré());
        assertFalse(this.mainQuinteFlush.isCarré());
        assertTrue(this.mainCarré.isCarré());
        assertFalse(this.mainFull.isCarré());
        assertFalse(this.mainCouleur.isCarré());
        assertFalse(this.mainSuite.isCarré());
        assertFalse(this.mainBrelan.isCarré());
        assertFalse(this.mainDoublePaire.isCarré());
        assertFalse(this.mainPaire.isCarré());
        assertFalse(this.mainHauteur.isCarré());
    }

  
    @Test
    public void testFull() {
        assertFalse(this.mainQuinteFlushRoyale.isFull());
        assertFalse(this.mainQuinteFlush.isFull());
        assertFalse(this.mainCarré.isFull());
        assertTrue(this.mainFull.isFull());
        assertFalse(this.mainCouleur.isFull());
        assertFalse(this.mainSuite.isFull());
        assertFalse(this.mainBrelan.isFull());
        assertFalse(this.mainDoublePaire.isFull());
        assertFalse(this.mainPaire.isFull());
        assertFalse(this.mainHauteur.isFull());
    }

   
    @Test
    public void testCouleur() {
        assertFalse(this.mainQuinteFlushRoyale.isCouleur());
        assertFalse(this.mainQuinteFlush.isCouleur());
        assertFalse(this.mainCarré.isCouleur());
        assertFalse(this.mainFull.isCouleur());
        assertTrue(this.mainCouleur.isCouleur());
        assertFalse(this.mainSuite.isCouleur());
        assertFalse(this.mainBrelan.isCouleur());
        assertFalse(this.mainDoublePaire.isCouleur());
        assertFalse(this.mainPaire.isCouleur());
        assertFalse(this.mainHauteur.isCouleur());
    }

 
    @Test
    public void testSuite() {
        assertFalse(this.mainQuinteFlushRoyale.isSuite());
        assertFalse(this.mainQuinteFlush.isSuite());
        assertFalse(this.mainCarré.isSuite());
        assertFalse(this.mainFull.isSuite());
        assertFalse(this.mainCouleur.isSuite());
        assertTrue(this.mainSuite.isSuite());
        assertFalse(this.mainBrelan.isSuite());
        assertFalse(this.mainDoublePaire.isSuite());
        assertFalse(this.mainPaire.isSuite());
        assertFalse(this.mainHauteur.isSuite());
    }

   
    @Test
    public void testBrelan() {
        assertFalse(this.mainQuinteFlushRoyale.isBrelan());
        assertFalse(this.mainQuinteFlush.isBrelan());
        assertFalse(this.mainCarré.isBrelan());
        assertFalse(this.mainFull.isBrelan());
        assertFalse(this.mainCouleur.isBrelan());
        assertFalse(this.mainSuite.isBrelan());
        assertTrue(this.mainBrelan.isBrelan());
        assertFalse(this.mainDoublePaire.isBrelan());
        assertFalse(this.mainPaire.isBrelan());
        assertFalse(this.mainHauteur.isBrelan());
    }

    @Test
    
    public void testDoublePaire() {
        assertFalse(this.mainQuinteFlushRoyale.isDoublePaire());
        assertFalse(this.mainQuinteFlush.isDoublePaire());
        assertFalse(this.mainCarré.isDoublePaire());
        assertFalse(this.mainFull.isDoublePaire());
        assertFalse(this.mainCouleur.isDoublePaire());
        assertFalse(this.mainSuite.isDoublePaire());
        assertFalse(this.mainBrelan.isDoublePaire());
        assertTrue(this.mainDoublePaire.isDoublePaire());
        assertFalse(this.mainPaire.isDoublePaire());
        assertFalse(this.mainHauteur.isDoublePaire());
    }

    @Test
    
    public void testPaire() {
        assertFalse(this.mainQuinteFlushRoyale.isPaire());
        assertFalse(this.mainQuinteFlush.isPaire());
        assertFalse(this.mainCarré.isPaire());
        assertFalse(this.mainFull.isPaire());
        assertFalse(this.mainCouleur.isPaire());
        assertFalse(this.mainSuite.isPaire());
        assertFalse(this.mainBrelan.isPaire());
        assertFalse(this.mainDoublePaire.isPaire());
        assertTrue(this.mainPaire.isPaire());
        assertFalse(this.mainHauteur.isPaire());
    }

    
    @Test
    public void testHauteur() {
        assertFalse(this.mainQuinteFlushRoyale.isHauteur());
        assertFalse(this.mainQuinteFlush.isHauteur());
        assertFalse(this.mainCarré.isHauteur());
        assertFalse(this.mainFull.isHauteur());
        assertFalse(this.mainCouleur.isHauteur());
        assertFalse(this.mainSuite.isHauteur());
        assertFalse(this.mainBrelan.isHauteur());
        assertFalse(this.mainDoublePaire.isHauteur());
        assertFalse(this.mainPaire.isHauteur());
        assertTrue(this.mainHauteur.isHauteur());
    }

  
    @Test
    public void testAnnonceQuinteFlushRoyale() {
        assertEquals("Quinte flush royale",
                this.mainQuinteFlushRoyale.annonce());
    }


    @Test
    public void testAnnonceQuinteFlush() {
        assertEquals("Quinte flush au Valet de Carreau",
                this.mainQuinteFlush.annonce());
    }

    
    @Test
    public void testAnnonceCarré() {
        assertEquals("Carré de Roi", this.mainCarré.annonce());
    }


    @Test
    public void testAnnonceFull() {
        assertEquals("Full des Trois par les Roi", this.mainFull.annonce());
    }

  
    @Test
    public void testAnnonceCouleur() {
        assertEquals("Couleur au Roi de Carreau", this.mainCouleur.annonce());
    }

  
    @Test
    public void testAnnonceSuite() {
        assertEquals("Suite au Huit", this.mainSuite.annonce());
    }

  
    @Test
    public void testAnnonceBrelan() {
        assertEquals("Brelan de Roi", this.mainBrelan.annonce());
    }


    @Test
    public void testAnnonceDoublePaire() {
        assertEquals("Double paire de Roi par les Huit",
                this.mainDoublePaire.annonce());
    }

   
    @Test
    public void testAnnoncePaire() {
        assertEquals("Paire de Huit", this.mainPaire.annonce());
    }

 
    @Test
    public void testAnnonceHauteur() {
        assertEquals("Un Roi", this.mainHauteur.annonce());
    }

}
