public class Compte {
    private float crédit;
    private float débit;

    /**
     * construit un compte vide
     */
    public Compte() {
        this.crédit = 0.0F;
        this.débit = 0.0F;
    }

    /**
     * renvoie le solde du compte
     * 
     * @return solde du compte
     */
    public float solde() {
        return this.crédit - this.débit;
    }

    /**
     * déposer de l'argent sur un compte
     * 
     * @param v
     *              valeur déposée
     * @throws IllegalArgumentException
     *                                      si v est négative
     */
    public void déposer(float v) throws IllegalArgumentException {
        if (v < 0) {
            throw new IllegalArgumentException("valeur à créditer négative");
        }
        this.crédit += v;
    }

    /**
     * retirede l'agent sur un compte
     * 
     * @param v
     *              valeur retirée
     * @throws IllegalArgumentException
     *                                      si v est négative
     */
    public void retirer(float v) throws IllegalArgumentException {
        if (v < 0) {
            throw new IllegalArgumentException("valeur à débiter négative");
        }
        this.débit += v;
    }

    /**
     * retourne la valeur unicode d'un compte
     * 
     * @return credit et debit
     */
    @Override
    public String toString() {
        return "Crédit : " + this.crédit + ", Débit : " + this.débit;
    }

}
