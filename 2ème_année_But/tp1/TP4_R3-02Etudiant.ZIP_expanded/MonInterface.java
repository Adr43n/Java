
@FunctionalInterface
public interface MonInterface {
	
	int calcul(int x);
	
	default void écrire(int x) {
		System.out.println(x);
	}

}
