package tp14;

abstract public class vehicule {
	protected float poids;
	private String immatriculation;
	
	public vehicule(String immatriculation, float poids) {
		this.immatriculation = immatriculation;
		this.poids = poids;
	}
	abstract public float vitesseMax();
	
	public float getPoids() {
		return this.poids;
	}
	
	public String getImmatriculation() {
		return this.immatriculation;
	}
	

}
