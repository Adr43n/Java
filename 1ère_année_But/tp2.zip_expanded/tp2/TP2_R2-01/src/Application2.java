public class Application2 {
		
		public static void main(String[] args){
					Rationnel unDemi = new Rationnel(1L, 2L);
					Rationnel u = new Rationnel(2L, 1L);
					for(int i = 1; i <= 4; i++) {
						u = unDemi.produit(
								u.somme(
									new Rationnel(2L, 1L).division(u)));
										}
					System.out.println("Valeur de racine carrée 2 : " + u);
					System.out.println("Valeur de racine carrée 2 approchée : " + (double) u.getNumérateur() / u.getDénominateur());
		}
}
