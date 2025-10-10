package tp14;

public abstract class vehiculetransportantmarchandises extends vehicule {
	
	private float chargeMax;
	private float chargeUtile;
	
	public vehiculetransportantmarchandises(String immatriculation, float poids, float chargeMax,float chargeUtile) {
		super(immatriculation, poids);
		this.chargeMax = chargeMax;
		this.chargeUtile = chargeUtile;
	}
	
	public float getChargeMax() {
		return this.chargeMax;
	}
	
	public float getChargeUtile() {
		return this.chargeUtile;
	}
	
	public float charger(float c)throws IllegalArgumentException{
		if(chargeUtile + c > chargeMax) {
			throw new IllegalArgumentException("La charge max a été dépasser");
		}
		return this.chargeUtile += c;
		
	}
	
	public float vider(){
		return this.chargeUtile += 0 ;
	}
	
}
