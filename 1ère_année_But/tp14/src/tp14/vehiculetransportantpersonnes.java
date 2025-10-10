package tp14;

public abstract class vehiculetransportantpersonnes extends vehicule {
	
	private int max;
	
	public vehiculetransportantpersonnes(String immatriculation, float poids) {
		super(immatriculation, poids);
		
	}
	
	public int getNbMaxPersonnes() {
		return this.max;
	}
}
