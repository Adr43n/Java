import java.awt.Graphics;
public abstract class Figurefermee {
    protected Point p1;
    protected Point p2;

    public Figurefermee(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point point1() { 
    	return p1; 
    	}
    
    public Point point2() { 
    	return p2; 
    	}
    
    public abstract void tracer(Graphics g);

    public abstract double périmètre();
    public abstract double surface();
}
