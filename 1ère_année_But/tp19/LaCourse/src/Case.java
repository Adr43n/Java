
public abstract class Case {
	private int position ;
	
	public Case(int position) {
		this.position = position;
	}
	
	public int getPosition () {
		return this.position;
	}
	
	public abstract int nouvellePosition(int valeurDe);
	
	@Override
	public String toString() {
		return "Case [position=" + this.position + "] : ";
	}

}
