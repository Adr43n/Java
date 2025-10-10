package tp14;


import java.util.ArrayList;

public abstract class convoi extends vehicule{
	
	private ArrayList<vehicule> vehicules;
	 
	public convoi(String immatriculation, float poids) {
		super(immatriculation, poids);
	}
	
	public void ajoutervehicule(vehicule v) {
		this.vehicules.add(v);
	}
	
	 
	  
	@Override
	public float vitesseMax() {
		if(vehicules.isEmpty()) {
			return 0;
		}
		float minVitesse = vehicules.get(0).vitesseMax();
        for (vehicule v : vehicules) {
            float vitesse = v.vitesseMax();
            if (vitesse < minVitesse) {
                minVitesse = vitesse;
            }
        }
        return minVitesse;
	}
	
}
