package tp14;

public abstract class camionciterne extends vehiculetransportantmarchandises{
	
	public camionciterne(String immatriculation, float poids, float chargeMax, float chargeUtile) {
		super(immatriculation, poids, chargeMax, chargeUtile);
	}

	@Override
	public float vitesseMax() {
		return 100 - (getChargeUtile() * 2);
		
	}
}
