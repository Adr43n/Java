import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class application {
	    public static void main(String[] args) {
	        List<Figurefermee> figures = new ArrayList<>();
	        figures.add(new Rectangle(new Point(50, 50), new Point(100, 100)));
	        figures.add(new Cercle(new Point(200, 300), new Point(200, 150)));
	        figures.add(new Rectangle(new Point(90, 90), new Point(450, 300)));
	        figures.add(new Cercle(new Point(120, 250), new Point(120, 300)));
	        figures.add(new Cercle(new Point(100, 100), new Point(0, 100)));
	        

	        JFrame frame = new JFrame("Dessin de Figures");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 400);
	        frame.add(new FenêtreFigures(figures));
	        frame.setVisible(true);
	    
	}
	    
	    
}


