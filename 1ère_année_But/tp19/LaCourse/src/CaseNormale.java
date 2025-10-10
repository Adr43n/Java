
public class CaseNormale extends Case {
	
	public CaseNormale(int position) {
		super(position);
	}
	
	@Override
	public int nouvellePosition(int valeurDe) {
		return super.getPosition() + valeurDe;
	}
	
	@Override
	public String toString() {
		return super.toString() + "avancer de la valeur du dé";
	}



}
