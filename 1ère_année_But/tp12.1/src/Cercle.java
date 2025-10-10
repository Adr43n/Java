import java.awt.Graphics;
public class Cercle extends Figurefermee {
    public Cercle(Point p1, Point p2) {
        super(p1, p2);
    }

    public double rayon() { 
    	return Point.distance(p2, p1); 
    	}
    
    public double diamètre() {
    	return 2 * rayon(); 
    	}
    
    @Override
    public void tracer(Graphics g) {
        int rayon = (int) rayon();
        g.drawOval(p1.getX() - rayon, p1.getY() - rayon ,  2*rayon, 2*rayon);
    }

    @Override
    public double périmètre() {
        return 2 * Math.PI * rayon();
    }

    @Override
    public double surface() {
        return Math.PI * rayon() * rayon();
    }
}
