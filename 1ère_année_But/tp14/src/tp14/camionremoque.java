package tp14;

public abstract class camionremoque extends vehiculetransportantmarchandises {

	public camionremoque(String immatriculation, float poids, float chargeMax, float chargeUtile) {
		super(immatriculation, poids, chargeMax, chargeUtile);
	}
	
	@Override
	public float vitesseMax() {
		return 100 - (getChargeUtile());
		
	}

}
