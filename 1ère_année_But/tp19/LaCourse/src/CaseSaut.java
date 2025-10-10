
public class CaseSaut extends Case{
	private int valeurDe;
	private int caseArrivee;
	
	public CaseSaut(int position, int valeurDe, int caseArrivee) {
		super(position);
		this.valeurDe = valeurDe;
		this.caseArrivee = caseArrivee;
	}
	
	public int nouvellePosition(int valeurDe) {
		if(this.valeurDe == valeurDe) {
			return this.caseArrivee;
		}else {
			return super.getPosition() + valeurDe;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"aller à la case " + this.caseArrivee + 
				"si vous faites " + this.valeurDe + 
				"sinon avancer de la valeur du dé";
	}


}
