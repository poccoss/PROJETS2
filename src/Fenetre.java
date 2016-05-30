import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 


public class Fenetre extends JFrame implements ActionListener {
	
  public Fenetre(){ 
	  
	  this.setTitle("JEU");
	  this.setSize(700, 500);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  JPanel premiertexte = new JPanel();
	  //On définit le layout en lui indiquant qu'il travaillera en ligne
	  premiertexte.setLayout(new BoxLayout(premiertexte, BoxLayout.LINE_AXIS));
	  JLabel bienvenue = new JLabel("Bienvenue");
	  bienvenue.setFont(new Font("Tahoma", Font.BOLD, 50));
	  premiertexte.add(bienvenue);
	  premiertexte.setBackground(Color.WHITE);
	  
	  JPanel deuxiemetexte = new JPanel();
	  deuxiemetexte.setLayout(new BoxLayout(deuxiemetexte, BoxLayout.LINE_AXIS));
	  JLabel joueurVSjoueur = new JLabel("Comment voulez vous jouer ?");
	  joueurVSjoueur.setFont(new Font("Tahoma", Font.BOLD, 40));
	  deuxiemetexte.add(joueurVSjoueur);
	  deuxiemetexte.setBackground(Color.WHITE);
	  
	  JPanel partie13 = new JPanel();
	  //Idem pour cette ligne
	  partie13.setLayout(new BoxLayout(partie13, BoxLayout.LINE_AXIS));
	  JButton jouer13 = new JButton("Grille carrée (taille variable)");
	  jouer13.setBackground(Color.RED);
	  jouer13.setFont(new Font("Tahoma", Font.BOLD, 30));
	  jouer13.addActionListener(this);
	  jouer13.setActionCommand("jouer13");
	  partie13.add(jouer13);
	  
	  JPanel partiesauv = new JPanel();
	  //Idem pour cette ligne
	  partiesauv.setLayout(new BoxLayout(partiesauv, BoxLayout.LINE_AXIS));
	  JButton partiesauv13 = new JButton("terminer la partie sauvegardée (carrée)");
	  partiesauv13.setBackground(Color.green);
	  partiesauv13.addActionListener(this);
	  partiesauv13.setFont(new Font("Tahoma", Font.BOLD, 30));
	  partiesauv13.setActionCommand("partiesauv13");
	  partiesauv.add(partiesauv13);
	  
	  JPanel partielo = new JPanel();
	  //Idem pour cette ligne
	  partielo.setLayout(new BoxLayout(partielo, BoxLayout.LINE_AXIS));
	  JButton jouerlo = new JButton("Grille losange (taille unique)");
	  jouerlo.setBackground(Color.yellow);
	  jouerlo.addActionListener(this);
	  jouerlo.setFont(new Font("Tahoma", Font.BOLD, 30));
	  jouerlo.setActionCommand("jouerlo");
	  partielo.add(jouerlo);
	  
	  JPanel partielosau = new JPanel();
	  //Idem pour cette ligne
	  partielosau.setLayout(new BoxLayout(partielosau, BoxLayout.LINE_AXIS));
	  JButton jouerlosau = new JButton("Terminer la partie sauvegardée (losange)");
	  jouerlosau.setBackground(Color.magenta);
	  jouerlosau.addActionListener(this);
	  jouerlosau.setFont(new Font("Tahoma", Font.BOLD, 30));
	  jouerlosau.setActionCommand("jouerlosau");
	  partielosau.add(jouerlosau);
	  

	  
	  JPanel fin = new JPanel();
	  //On positionne maintenant ces trois lignes en colonne
	  fin.setLayout(new BoxLayout(fin, BoxLayout.PAGE_AXIS));
	  fin.add(premiertexte);
	  fin.add(deuxiemetexte);
	  fin.add(new JLabel("\n"));
	  fin.add(partie13);
	  fin.add(new JLabel("\n"));
	  fin.add(partiesauv);
	  fin.add(new JLabel("\n"));
	  fin.add(partielo);
	  fin.add(new JLabel("\n"));
	  fin.add(partielosau);
	  fin.setBackground(Color.WHITE);
	  
	  
	  this.getContentPane().add(fin);
	  this.setVisible(true);
	  

  }
  
  public void actionPerformed(ActionEvent action) {
	  if (action.getActionCommand()=="jouer13") {
		  Test.jeu13();
	  }
	  if (action.getActionCommand()=="jouerlo") {
		  Test.jeulo();
	  }
	  if (action.getActionCommand()=="partiesauv13") {
		  Test.fenetre13sau();
	  }
	  if (action.getActionCommand()=="jouerlosau") {
		  Test.jeulosau();
	  }
  }
}