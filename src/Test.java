
public class Test {

	public static void main(String[] args) {
		initialisation();
	}
	
	public static void initialisation() {
		Fenetre fenetre = new Fenetre();
	}
	
	public static void jeu13() {
		fenetre13 fen = new fenetre13();
	}
	
	public static void jeulo() {
		fenetrelos fen = new fenetrelos();
	}
	
	public static void victoire(String nom, int h) {
		Victoire fen = new Victoire(nom, h);
	}
	
	public static void fenetre13sau() {
		fenetre13sau fen = new fenetre13sau();
	}
	
	public static void explication() {
		explications fen = new explications();
	}
}
