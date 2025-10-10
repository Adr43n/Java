import java.util.Arrays;

public class TableauPolynôme {
    /**
     * tableau des coefficients du polynôme
     */
    private float[] coefficients;

    /**
     * construit un polynôme nul dans un tableau de coefficients
     * 
     * @param degréMax
     *                     degré maximum du polynôme
     */
    public TableauPolynôme(int degréMax) {
        this.coefficients = new float[degréMax + 1];
        Arrays.fill(this.coefficients, 0.0F);
    }

    /**
     * retourne le degré maximum du polynôme
     * 
     * @return l'exposant maximum d'un monôme non nul du polynôme
     */
    public int getDegréMax() {
        return this.coefficients.length - 1;
    }

    /**
     * renvoie le monôme d'exposant donné. Si l'exposant dépasse degréMax, il
     * s'agit forcément d'un monôme nul
     * 
     * @param exposant
     *                     du monôme à renvoyer
     * @return monôme ayant l'exposant donné
     * @throws IllegalArgumentException
     *                                      si l'exposant est négatif
     */
    public Monôme getMonôme(int exposant) throws IllegalArgumentException {
        if (exposant < 0) {
            throw new IllegalArgumentException("exposant négatif " + exposant);
        }
        if (exposant > this.getDegréMax()) {
            return new Monôme(0.0F, exposant);
        } else {
            return new Monôme(this.coefficients[exposant], exposant);
        }
    }

    /**
     * positionne un monôme dans le polynôme. Un monôme de degré supérieur à
     * degréMax doit forcément être nul
     * 
     * @param m
     *              monôme à positionner
     * @throws IllegalArgumentException
     *                                      si le monôme à positionner n'est pas
     *                                      nul et a un degré plus grand que
     *                                      degréMax
     */
    public void setMonôme(Monôme m) throws IllegalArgumentException {
        if (m.getExposant() > this.getDegréMax() && !m.estNul()) {
            throw new IllegalArgumentException(
                    "exposant trop grand " + m.getExposant() + " " + m);
        }
        if (m.getExposant() <= this.getDegréMax()) {
            this.coefficients[m.getExposant()] = m.getCoefficient();
        }
        // le sinon du if correspondrait au positionnement d'un monôme nul
        // dépassant
        // la taille du tableau. Dans ce cas, il n'y a rien à faire.
    }

}
