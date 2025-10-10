public class CompteBancaire extends Compte {
    /**
     * numéro du compte bancaire
     */
    private String numéro;

    /**
     * crée un compte bancaire vide
     * 
     * @param numéro
     *                   numéro du compte bancaire
     */
    public CompteBancaire(String numéro) {
        this.numéro = numéro;
    }

    /**
     * fournit le numéro du compte bancaire
     * 
     * @return numéro du compte bancaire
     */
    public String getNuméro() {
        return this.numéro;
    }
    
    

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numéro == null) ? 0 : numéro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CompteBancaire)) {
			return false;
		}
		CompteBancaire other = (CompteBancaire) obj;
		if (numéro == null) {
			if (other.numéro != null) {
				return false;
			}
		} else if (!numéro.equals(other.numéro)) {
			return false;
		}
		return true;
	}

	/**
     * fournit une version unicode d'un compte bancaire
     * 
     * @return chaîne contenant le numéro concaténé au crédit concaténé au
     *             ddébit
     */
	
    @Override
    public String toString() {
        return "Numéro : " + this.getNuméro() + ", " + super.toString();
    }

}