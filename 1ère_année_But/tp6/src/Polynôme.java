public class Polynôme {
    /**
     * degré maximum du polynôme
     */
    public static final int DEGRE_MAX = 99;

    /**
     * représentation d'un polynôme
     */
    private TableauPolynôme polynôme;

    /**
     * crée un polynôme nul de degré maximum DEGRE_MAX
     */
    public Polynôme() {
        this.polynôme = new TableauPolynôme(DEGRE_MAX);

    }

    /**
     * positionne un monôme dans le polynôme. Un monôme de degré supérieur à
     * DEGRE_MAX doit forcément être nul
     * 
     * @param m
     *              monôme à positionner
     * @throws IllegalArgumentException
     *                                      si le monôme à positionner n'est pas
     *                                      nul et a un degré plus grand que
     *                                      degréMax
     */
    public void setMonôme(Monôme m) throws IllegalArgumentException {
        this.polynôme.setMonôme(m);
    }

    /**
     * renvoie le monôme d'exposant donné. Si l'exposant dépasse DEGRE_MAX, il
     * s'agit forcément d'un monôme nul
     * 
     * @param exposant
     *                     du monôme à renvoyer
     * @return monôme ayant l'exposant donné
     * @throws IllegalArgumentException
     *                                      si l'exposant est négatif
     */
    public Monôme getMonôme(int exposant) throws IllegalArgumentException {
        return this.polynôme.getMonôme(exposant);
    }

    /**
     * calcule la dérivée d'un polynôme
     * 
     * @return dérivée du polynôme
     */
    public Polynôme dérivée() throws IllegalArgumentException {
        Polynôme d = new Polynôme();
        for(int i = 0 ; i <= DEGRE_MAX; i++) {
        	d.polynôme.setMonôme(this.polynôme.getMonôme(i).dérivée());
        }
        return d;
    }

    /**
     * calcule la somme de deux polynômes
     * 
     * @param p
     *              deuxième polynôme associé à la somme
     * @return polynôme resultat
     */
    public Polynôme somme(Polynôme p) {
        	Polynôme s = new Polynôme();
        	for(int i = 0 ; i <= DEGRE_MAX; i++) {
        		s.polynôme.setMonôme(this.polynôme.getMonôme(i).somme(p.getMonôme(i)));
        	}
        	return s;
    }

    /**
     * calcule le produit d'un polynôme et d'un monôme
     * 
     * @param m
     *              monôme associé au produit
     * @throws IllegalArgumentException
     *                                      si l'exposant d'un monôme du
     *                                      résultat est supérieur à DEGRE_MAX
     * @return polynôme produit
     */
    public Polynôme produit(Monôme m) throws IllegalArgumentException {
        Polynôme p = new Polynôme();
        for(int i = 0 ; i <= DEGRE_MAX ; i++) {
        	p.polynôme.setMonôme(this.polynôme.getMonôme(i).produit(m));
        if(this.polynôme.getMonôme(i).getExposant() > DEGRE_MAX) {
        	throw new IllegalArgumentException("Exposant du monôme résultant supérieur à DEGRE_MAX !");
        }
        }
        return p;
    }
    
    
    public int degré() throws IllegalArgumentException {
    	int exposant = 0;
    	for(int i = 0 ; i <= DEGRE_MAX ; i++) {
    		if(this.polynôme.getMonôme(i).getExposant() > exposant ) {
    			exposant = this.polynôme.getMonôme(i).getExposant();
    		}
    	}
    	
    	return exposant;
    }
    
    
    public Polynôme différence() {
    	Polynôme d = new Polynôme();
    	for(int i = 0; i <= DEGRE_MAX; i++) {
    		d.polynôme.setMonôme(this.polynôme.getMonôme(i).différence());
    	}    	
    	return d;
    }
    

    @Override
    public String toString() {
        String résultat = "";
        for (int i = Polynôme.DEGRE_MAX - 1; i >= 0; i--) {
            if (!this.getMonôme(i).estNul()) {
                résultat += this.getMonôme(i);
            }
        }
        if (résultat.equals("")) {
            return "0";
        }
        if (résultat.charAt(1) == '-') {
            return "-" + résultat.substring(3, résultat.length());
        }
        return résultat.substring(3, résultat.length());
    }

}
