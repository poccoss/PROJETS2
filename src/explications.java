import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class explications extends JFrame {
	public explications(){
		  this.setTitle("Règles");
		  this.setSize(650, 650);
		  //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setLocationRelativeTo(null);
		  
		  JPanel premiertexte = new JPanel();
		  //On définit le layout en lui indiquant qu'il travaillera en ligne
		  premiertexte.setLayout(new BoxLayout(premiertexte, BoxLayout.LINE_AXIS));
		  JLabel bienvenue = new JLabel("Explications");
		  bienvenue.setFont(new Font("Tahoma", Font.BOLD, 50));
		  premiertexte.add(bienvenue);
		  
		  JPanel deuxiemetexte = new JPanel();
		  deuxiemetexte.setLayout(new BoxLayout(deuxiemetexte, BoxLayout.LINE_AXIS));
		  JLabel joueurVSjoueur = new JLabel("Le Joueur 1 commence en haut à gauche, le Joueur 2 en bas à droite");
		  joueurVSjoueur.setFont(new Font("Tahoma", Font.BOLD, 15));
		  deuxiemetexte.add(joueurVSjoueur);
		  
		  JPanel deuxiemetexte2 = new JPanel();
		  deuxiemetexte2.setLayout(new BoxLayout(deuxiemetexte2, BoxLayout.LINE_AXIS));
		  JLabel joueurVSjoueur2 = new JLabel("Le but est d'avoir le plus grand territoire en contrôlant le plus de cases possibles");
		  joueurVSjoueur2.setFont(new Font("Tahoma", Font.BOLD, 15));
		  deuxiemetexte2.add(joueurVSjoueur2);
		  
		  JPanel troisiemetexte = new JPanel();
		  troisiemetexte.setLayout(new BoxLayout(troisiemetexte, BoxLayout.LINE_AXIS));
		  JLabel joueurVSIA = new JLabel("En cliquant sur une couleur, le joueur récupère toutes les cases de cette couleur qui touche son territoire");
		  joueurVSIA.setFont(new Font("Tahoma", Font.BOLD, 15));
		  troisiemetexte.add(joueurVSIA);
		  
		  JPanel troisiemetexte2 = new JPanel();
		  troisiemetexte2.setLayout(new BoxLayout(troisiemetexte2, BoxLayout.LINE_AXIS));
		  JLabel joueurVSIA2 = new JLabel("Le joueur contrôlant plus de la moitié des cases gagne le jeu");
		  joueurVSIA2.setFont(new Font("Tahoma", Font.BOLD, 15));
		  troisiemetexte2.add(joueurVSIA2);
		  
		  JPanel troisiemetexte3 = new JPanel();
		  troisiemetexte3.setLayout(new BoxLayout(troisiemetexte3, BoxLayout.LINE_AXIS));
		  JLabel joueurVSIA3 = new JLabel("Enfin, vous saurez quel est votre territoire car il sera en surbrillance, et la fenêtre vous dira quand c'est à vous de jouer");
		  joueurVSIA3.setFont(new Font("Tahoma", Font.BOLD, 15));
		  troisiemetexte3.add(joueurVSIA3);
		  
		  JPanel fin = new JPanel();
		  //On positionne maintenant ces trois lignes en colonne
		  fin.setLayout(new BoxLayout(fin, BoxLayout.PAGE_AXIS));
		  fin.add(premiertexte);
		  fin.add(deuxiemetexte);
		  fin.add(deuxiemetexte2);
		  fin.add(troisiemetexte);
		  fin.add(troisiemetexte2);
		  fin.add(troisiemetexte3);
		  
		  
		  
		  this.getContentPane().add(fin);
		  this.setVisible(true);
	}
}
