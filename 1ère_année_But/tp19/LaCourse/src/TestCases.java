import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCases {
		@Test
		public void testCaseNormale() {
		CaseNormale c = new CaseNormale(0);
		assertEquals(3,c.nouvellePosition(3));
		}
		@Test
		public void testCaseAttente() {
		CaseAttente c = new CaseAttente(0, 2);
		assertEquals(2, c.nouvellePosition(2));
		assertEquals(0, c.nouvellePosition(1));
		}
		@Test
		public void testCaseSaut() {
		CaseSaut c = new CaseSaut(0, 1, 10);
		assertEquals(10, c.nouvellePosition(1));
		assertEquals(2, c.nouvellePosition(2));
		}
		@Test
		public void testCasePaireOuImpaire() {
		CasePaireOuImpaire c = new CasePaireOuImpaire(5);
		assertEquals(11, c.nouvellePosition(6));
		assertEquals(0, c.nouvellePosition(5));
		}
		@Test
	    public void testCases5Avec6() {
	        Plateau p = new Plateau();
	        int resultat = p.nouvellePosition(5, 6);
	        assertEquals(20, resultat);
	    }

	    @Test
	    public void testAcceptationPosition0De1() {
	        Plateau p = new Plateau();
	        assertEquals(1, p.nouvellePosition(0, 1));
	    }

	    @Test
	    public void testCase36Avec1() {
	        Plateau p = new Plateau();
	        assertEquals(10, p.nouvellePosition(36, 1)); 
	    }

	    @Test
	    public void testAcceptation_0_0_1() {
	        Plateau p = new Plateau();
	        assertEquals(1, p.nouvellePosition(0, 1));
	    }

	    @Test
	    public void testAcceptation_1_3_4() {
	        Plateau p = new Plateau();
	        assertEquals(4, p.nouvellePosition(1, 3));
	    }

	    @Test
	    public void testAcceptation_5_6_20() {
	        Plateau p = new Plateau();
	        assertEquals(20, p.nouvellePosition(5, 6));
	    }
		
		
}
