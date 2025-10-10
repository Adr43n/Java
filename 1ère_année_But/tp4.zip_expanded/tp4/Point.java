public class Point {

    private float abscisse;
    private float ordonnée;

    public Point(float abscisse, float ordonnée) {
        this.abscisse = abscisse;
        this.ordonnée = ordonnée;
    }

    public Point() {
        this.abscisse = 0.0F;
        this.ordonnée = 0.0F;
    }

    public float getAbscisse() {
        return this.abscisse;
    }

    public float getOrdonnée() {
        return this.ordonnée;
    }

    public void translater(float tx, float ty) {
        this.abscisse += tx;
        this.ordonnée += ty;
    }

    public void mettreAEchelle(float h) throws IllegalArgumentException {
        if (h <= 0.0F) {
            throw new IllegalArgumentException("facteur erroné " + h);
        }
        this.abscisse *= h;
        this.ordonnée *= h;
    }
}
