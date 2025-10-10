
public enum Couleur {
	PIQUE("Pique"),COEUR("Coeur"),
	CARREAU("Carreau"),TREFLE("Trèfle");
	
	private final String désignation;
	
	private Couleur(String désignation) {
		this.désignation = désignation;
	};
	
	public String getDésignation() {
		return this.désignation;
	}
}
