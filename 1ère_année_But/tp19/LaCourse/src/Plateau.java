
public class Plateau {
	public static final int NB_CASES = 48;
	private Case[] cases;
	
	public Plateau() {
	 cases = new Case[NB_CASES];
       for (int i = 0; i < NB_CASES; i++) {
         cases[i] = new CaseNormale(i);
       }
       cases[5] = new CaseSaut(5, 6, 20);
       cases[12] = new CaseAttente(12, 2);
       cases[15] = new CasePaireOuImpaire(15);
       cases[16] = new CaseSaut(16, 4, 22);
       cases[18] = new CaseAttente(18, 5);
       cases[20] = new CasePaireOuImpaire(20);
       cases[24] = new CaseAttente(24, 2);
       cases[27] = new CaseAttente(27, 5);
       cases[33] = new CaseAttente(33, 4);
       cases[36] = new CaseSaut(36, 1, 10);
       cases[45] = new CaseSaut(45, 2, 0);
    }
	
	public int nouvellePosition(int position, int valeurDe) {
		int nvllepos= cases[position].nouvellePosition(valeurDe);;
		if(position >= NB_CASES) {
			return  nouvellePositionQuandDépassement(nvllepos);
		}else {
			return nvllepos;
		}
	}
	
	public int nouvellePositionQuandDépassement(int nouvellePosition) {
		int dépassement = nouvellePosition - (NB_CASES);
		return NB_CASES - dépassement ;
	}
	
	public String toString(int positionJoueur) {
		return cases[positionJoueur].toString();
	}

	
	
}
