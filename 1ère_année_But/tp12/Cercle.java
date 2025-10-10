public class Cercle {

    private Point point1;

    private Point point2;

    public Cercle(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return this.point1;
    }

    public Point getPoint2() {
        return this.point2;
    }

    public double rayon() {
        return Point.distance(this.point2, this.point1);
    }

    public double diamètre() {
        return this.rayon() * 2;
    }

    public double périmètre() {
        return 2 * Math.PI * this.rayon();
    }

    public double surface() {
        return Math.PI * Math.pow(this.rayon(), 2);
    }

}
