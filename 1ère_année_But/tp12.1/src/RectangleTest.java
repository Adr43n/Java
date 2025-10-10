import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
    private Rectangle r;

    @Before
    public void setUp() throws Exception {
        this.r = new Rectangle(new Point(90, 90), new Point(450, 350));
    }

    @After
    public void tearDown() throws Exception {
        this.r = null;
    }

    @Test
    public void testLargeur() {
        assertEquals(Math.abs(450 - 90), this.r.largeur());
    }

    @Test
    public void testHauteur() {
        assertEquals(Math.abs(350 - 90), this.r.hauteur());
    }

    @Test
    public void testPérimètre() {
        assertEquals(2 * (Math.abs(450 - 90) + Math.abs(350 - 90)),
                this.r.périmètre(), 0);
    }

    @Test
    public void testSurface() {
        assertEquals(Math.abs(450 - 90) * Math.abs(350 - 90), this.r.surface(),
                0);
    }

}
