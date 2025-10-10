import java.awt.Graphics;
public class Rectangle extends Figurefermee {
    public Rectangle(Point p1, Point p2) {
        super(p1, p2);
    }

    public int largeur() { 
    	return Math.abs(p2.getX() - p1.getX()); 
    	}
    
    public int hauteur() { 
    	return Math.abs(p2.getY() - p1.getY()); 
    	}

    @Override
    public void tracer(Graphics g) {
    	g.drawRect(p1.getX(),p1.getY(), largeur(), hauteur());
    }
    @Override
    public double périmètre() {
        return 2 * (largeur() + hauteur());
    }

    @Override
    public double surface() {
        return largeur() * hauteur();
    }
    
}
