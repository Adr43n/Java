package tp14;

public abstract class minibus extends vehiculetransportantpersonnes {
	
	public minibus(String immatriculation, float poids) {
		super(immatriculation, poids);
	}
	
	@Override
	public float vitesseMax() {
		if (getNbMaxPersonnes()<=6) {
			return 130.0f;
		}else if (getNbMaxPersonnes()>=7 && getNbMaxPersonnes()<=9) {
			return 120.0f;
		}else if(getNbMaxPersonnes()>=10) {
			return 110.0f;
		}
		return 0;
		
	}

}
