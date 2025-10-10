import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class PanneauFigures extends JPanel {
    private static final long serialVersionUID = -5633501983987020072L;
    private List<FigureFermée> figures;

    public PanneauFigures(List<FigureFermée> figures) {
        this.figures = figures;
    }

    @Override
    public void paint(Graphics g) {
        Color[] tableauCouleur = { Color.RED, Color.BLACK, Color.BLUE,
                Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK };
        int i = 0;
        for (FigureFermée f : this.figures) {
            g.setColor(tableauCouleur[i % tableauCouleur.length]);
            f.tracer(g);
            i++;
        }
    }
}
