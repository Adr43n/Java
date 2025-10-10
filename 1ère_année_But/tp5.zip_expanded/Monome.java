public class Monome {

    private final float coefficient;

    private final int exposant;

    public Monome(float coefficient, int exposant)
            throws IllegalArgumentException {
        if (exposant < 0) {
            throw new IllegalArgumentException("exposant négatif");
        }
        this.coefficient = coefficient;
        this.exposant = exposant;
    }

    public float getCoefficient() {
        return this.coefficient;
    }

    public int getExposant() {
        return this.exposant;
    }

    public Monome somme(Monome m) throws ArithmeticException {
        if (this.getExposant() != m.getExposant()) {
            throw new ArithmeticException(
                    "coefficient des deux monômes différents");
        }
        return new Monome(this.getCoefficient() + m.getCoefficient(),
                this.getExposant());
    }

    public Monome produit(Monome m) {
        return new Monome(this.getCoefficient() * m.getCoefficient(),
                this.getExposant() + m.getExposant());
    }

    public Monome dérivée() {
        if (this.getExposant() == 0) {
            return new Monome(0, 0);
        } else {
            return new Monome(this.getCoefficient() * this.getExposant(),
                    this.getExposant() - 1);
        }
    }

    public boolean estNul() {
        return this.getCoefficient() == 0;
    }

}