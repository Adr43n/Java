public class Rectangle {

    private Point point1;

    private Point point2;

    public Rectangle(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return this.point1;
    }

    public Point getPoint2() {
        return this.point2;
    }

    public int largeur() {
        return Math.abs(this.point2.getX() - this.point1.getX());
    }

    public int hauteur() {
        return Math.abs(this.point2.getY() - this.point1.getY());
    }

    public double périmètre() {
        return 2 * (this.largeur() + this.hauteur());
    }

    public double surface() {
        return this.largeur() * this.hauteur();
    }

}
