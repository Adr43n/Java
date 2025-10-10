
public class CasePaireOuImpaire extends Case{
	
	public CasePaireOuImpaire(int position) {
		super(position);
	}
	
	public int nouvellePosition(int valeurDe) {
		if (valeurDe % 2 == 0) {
			return super.getPosition() + valeurDe;
		}else {
			return super.getPosition() - valeurDe;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "avancer de la valeur du dé si elle est paire, le contraire si elle est impaire";
	}

}
