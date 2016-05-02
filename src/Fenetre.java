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
	  this.setSize(650, 650);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  
	  JPanel premiertexte = new JPanel();
	  //On définit le layout en lui indiquant qu'il travaillera en ligne
	  premiertexte.setLayout(new BoxLayout(premiertexte, BoxLayout.LINE_AXIS));
	  JLabel bienvenue = new JLabel("Bienvenue");
	  bienvenue.setFont(new Font("Tahoma", Font.BOLD, 50));
	  premiertexte.add(bienvenue);
	  
	  JPanel deuxiemetexte = new JPanel();
	  deuxiemetexte.setLayout(new BoxLayout(deuxiemetexte, BoxLayout.LINE_AXIS));
	  JLabel joueurVSjoueur = new JLabel("Joueur VS Joueur(s)");
	  joueurVSjoueur.setFont(new Font("Tahoma", Font.BOLD, 40));
	  deuxiemetexte.add(joueurVSjoueur);
	  
	  JPanel partie13 = new JPanel();
	  //Idem pour cette ligne
	  partie13.setLayout(new BoxLayout(partie13, BoxLayout.LINE_AXIS));
	  JButton jouer13 = new JButton("partie rapide (13x13)");
	  jouer13.addActionListener(this);
	  jouer13.setActionCommand("jouer13");
	  partie13.add(jouer13);
	  
	  JPanel partiesauv = new JPanel();
	  //Idem pour cette ligne
	  partiesauv.setLayout(new BoxLayout(partiesauv, BoxLayout.LINE_AXIS));
	  JButton partiesauv13 = new JButton("terminer la partie en cours");
	  partiesauv13.addActionListener(this);
	  partiesauv13.setActionCommand("partiesauv13");
	  partiesauv.add(partiesauv13);
	  
	  JPanel partielo = new JPanel();
	  //Idem pour cette ligne
	  partielo.setLayout(new BoxLayout(partielo, BoxLayout.LINE_AXIS));
	  JButton jouerlo = new JButton("partie rapide (losange)");
	  jouerlo.addActionListener(this);
	  jouerlo.setActionCommand("jouerlo");
	  partielo.add(jouerlo);
	  
	  JPanel troisiemetexte = new JPanel();
	  troisiemetexte.setLayout(new BoxLayout(troisiemetexte, BoxLayout.LINE_AXIS));
	  JLabel joueurVSIA = new JLabel("Joueur VS IA");
	  joueurVSIA.setFont(new Font("Tahoma", Font.BOLD, 40));
	  troisiemetexte.add(joueurVSIA);
	  
	  JPanel IAfacile = new JPanel();
	  IAfacile.setLayout(new BoxLayout(IAfacile, BoxLayout.LINE_AXIS));
	  JButton iafa = new JButton("facile");
	  iafa.addActionListener(this);
	  iafa.setActionCommand("iafacile");
	  IAfacile.add(iafa);
	  
	  JPanel partiesauvfa = new JPanel();
	  //Idem pour cette ligne
	  partiesauvfa.setLayout(new BoxLayout(partiesauvfa, BoxLayout.LINE_AXIS));
	  JButton partiesauv13fa = new JButton("terminer la partie en cours");
	  partiesauv13fa.addActionListener(this);
	  partiesauv13fa.setActionCommand("partiesauv13fa");
	  partiesauvfa.add(partiesauv13fa);
	  
	  JPanel IAdifficile = new JPanel();
	  IAdifficile.setLayout(new BoxLayout(IAdifficile, BoxLayout.LINE_AXIS));
	  JButton iadi = new JButton("difficile");
	  iadi.addActionListener(this);
	  iadi.setActionCommand("iadifficile");
	  IAdifficile.add(iadi);
	  
	  JPanel partiesauvdi = new JPanel();
	  //Idem pour cette ligne
	  partiesauvdi.setLayout(new BoxLayout(partiesauvdi, BoxLayout.LINE_AXIS));
	  JButton partiesauv13di = new JButton("terminer la partie en cours");
	  partiesauv13di.addActionListener(this);
	  partiesauv13di.setActionCommand("partiesauv13di");
	  partiesauvdi.add(partiesauv13di);
	  
	  JPanel fin = new JPanel();
	  //On positionne maintenant ces trois lignes en colonne
	  fin.setLayout(new BoxLayout(fin, BoxLayout.PAGE_AXIS));
	  fin.add(premiertexte);
	  fin.add(deuxiemetexte);
	  fin.add(partie13);
	  fin.add(partiesauv);
	  fin.add(partielo);
	  fin.add(troisiemetexte);
	  fin.add(IAfacile);
	  fin.add(partiesauvfa);
	  fin.add(IAdifficile);
	  fin.add(partiesauvdi);
	  
	  
	  
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
	  if (action.getActionCommand()=="iafacile") {
		  Test.IAfacile();
	  }
	  if (action.getActionCommand()=="partiesauv13") {
		  Test.fenetre13sau();
	  }
	  if (action.getActionCommand()=="partiesauv13fa") {
		  Test.fenetre13saufa();
	  }
  }
}