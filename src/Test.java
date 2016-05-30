import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.File;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Test {
	
	public static void main(String[] args) {
		initialisation();
		for (int i=0; i<20; i++) {
			musique();
		}
	}

	public static void musique() {
		try {
			URL url = Test.class.getResource("musique.mp3");
			InputStream audioIn = url.openStream();
			new Player(audioIn).play();
		}
		catch (Exception e) {
			
		}
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
	
	public static void jeulosau() {
		fenetrelossau fen = new fenetrelossau();
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
