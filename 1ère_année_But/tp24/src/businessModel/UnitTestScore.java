package businessModel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTestScore {
	
	@Test
	public void testSetUp() {
		Score score = new Score(0);
		assertEquals(0,score.getScore());
	}
	
	@Test
	public void testTearDown() {
		 
	}
	
	
}
