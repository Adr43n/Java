import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Testpileborne {

	public class PileBorneeTest {
		private PileBornee pile;

	    @Before
	    public void setUp() throws Exception{
	        this.pile = new PileBornee(2);
	    }
	    @After
	    public void tearDown() throws Exception{
	    	
	    }
	    @Test
	    public void testPileVideApresCreation() {
	    	assertTrue(this.pile.isEmpty());
	    }
	    @Test
	    public void TestPileAvecUnElement() {
	    	this.pile.push(2);
	    	assertFalse(this.pile.isEmpty());
	    }
	    @Test
	    public void TestPileVérificationTailleMaximale () {
	    	assertEquals(2, this.pile.isEmpty());
	    }
	    @Test
	    public void TestTailleInchangéeApresEmpilation () {
	    	this.pile.push(3);
	    	this.pile.push(4);
	    	assertEquals(2, this.pile.getMaxSize());
	    }
	    @Test
	    public void TestNombreEgalZero () {
	    	assertEquals(0, this.pile.getSize());
	    }
	    @Test
	    public void TestSousScenario () {
	    	this.pile.push(1);
	    	assertEquals(1, this.pile.getSize());
	    	this.pile.push(2);
	    	assertEquals(2, this.pile.getSize());
	    	this.pile.push(1);
	    	assertEquals(2, this.pile.getSize());
	    }
	    @Test
	    public void TestPilePasPleine () {
	    	assertFalse(this.pile.isFull());
	    }
	    @Test
	    public void TestPilePleine () {
	    	this.pile.push(2);
	    	assertFalse(this.pile.isFull());
	    	this.pile.push(3);
	    	assertTrue(this.pile.isFull());
	    }
	    @Test
	    public void testPiletop() throws EmptyStackException {
	    	this.pile.push(2);
	    	assertEquals(1,this.pile.top());
	    	this.pile.push(1);
	    	assertEquals(2,this.pile.top());
	    	this.pile.push(3);
	    	assertEquals(2,this.pile.top());
	    }
	    @Test
	    public void pop() {
	    	this.pile.push(2);
	    	assertEquals(2, this.pile.getSize());
	    	assertEquals(2, this.pile.getMaxSize());
	    }
	    @Test
	    public void pop2() throws EmptyStackException {
	    	this.pile.push(1);
	    	this.pile.pop();
	    	assertTrue(this.pile.isEmpty());
	    	this.pile.push(1);
	    	this.pile.push(2);
	    	this.pile.pop();
	    	assertEquals(1, this.pile.top());	
	    }
	    @Test(expected= EmptyStackException.class)
	    public void testExceptionTop() throws EmptyStackException {
	    	this.pile.top();
	    }
	    @Test(expected= IllegalArgumentException.class)
	    public void testExceptionPile() throws IllegalArgumentException {
	    	PileBornee p = new PileBornee(0);
	    	PileBornee n = new PileBornee(-1);
	    	
	    }
	    
	}

}
