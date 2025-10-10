import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CercleTest {
    private Cercle c;

    @Before
    public void setUp() throws Exception {
        this.c = new Cercle(new Point(200, 300), new Point(200, 150));
    }

    @After
    public void tearDown() throws Exception {
        this.c = null;
    }

    @Test
    public void testGetPoint1() {
        assertEquals(new Point(200, 300), this.c.getPoint1());
    }

    @Test
    public void testGetPoint2() {
        assertEquals(new Point(200, 150), this.c.getPoint2());
    }

    @Test
    public void testRayon() {
        assertEquals(Point.distance(new Point(200, 300), new Point(200, 150)),
                this.c.rayon(), 0);
    }

    @Test
    public void testDiamètre() {
        assertEquals(
                2 * Point.distance(new Point(200, 300), new Point(200, 150)),
                this.c.diamètre(), 0);
    }

    @Test
    public void testPérimètre() {
        assertEquals(2 * Math.PI
                * Point.distance(new Point(200, 300), new Point(200, 150)),
                this.c.périmètre(), 0);
    }

    @Test
    public void testSurface() {
        assertEquals(Math.PI * Math.pow(
                Point.distance(new Point(200, 300), new Point(200, 150)), 2),
                this.c.surface(), 0);
    }

}
