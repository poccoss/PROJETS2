import java.awt.GridLayout; 
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.*;

 
public class fenetrelos extends JFrame implements ActionListener {
	
	JFrame choix = new JFrame();
	String couleur1 = ""; //me permettra d'assurer de ne pas utiliser la couleur d'un autre joueur
	String couleur2 = "";
	String couleur3 = "";
	String couleur4 = "";
	String[] couleurs = {"blue", "green", "yellow", "red", "magenta", "orange"};
	JLabel nom = new JLabel("au tour du Joueur 1"); // savoir � quel joueur c'est et quel est son nom (Joueur ou IA)
	JLabel nom2 = new JLabel("JEU");
	JLabel joueur1 = new JLabel("Joueur 1");
	JLabel joueur1choix = new JLabel("Joueur 1");
	JLabel score1 = new JLabel("1");
	JLabel joueur2 = new JLabel("Joueur 2");
	JLabel joueur2choix = new JLabel("Joueur 2");
	JLabel score2 = new JLabel("1");
	JLabel joueur3 = new JLabel("");
	JLabel joueur3choix = new JLabel("");
	JLabel score3 = new JLabel("");
	JLabel joueur4 = new JLabel("");
	JLabel joueur4choix = new JLabel("");
	JLabel score4 = new JLabel("");
	JPanel tab = new JPanel();
	JPanel scores = new JPanel();
	JPanel choix2 = new JPanel();
	JButton sauvegarde = new JButton("Sauvegarder et quitter");
	JButton ajoutjoueur = new JButton("ajouter un joueur 3"); //boutons permettant l'ajout de joueurs
	JButton ajoutjoueur4 = new JButton("ajouter un joueur 4");
	JButton explication = new JButton("explications");
	JCheckBox IAdifficile1 = new JCheckBox("IA difficile");
	JCheckBox IAfacile1 = new JCheckBox("IA facile");
	JCheckBox IAdifficile2 = new JCheckBox("IA difficile");
	JCheckBox IAfacile2 = new JCheckBox("IA facile");
	JCheckBox IAdifficile3 = new JCheckBox("IA difficile");
	JCheckBox IAfacile3 = new JCheckBox("IA facile");
	JButton jouer = new JButton("Jouer");
	int ia1 = 1;
	int IA1 = 0;
	int ia2 = 1;
	int IA2 = 0;
	int ia3 = 1;
	int IA3 = 0;
	int joueur = 1;
	int nbrejoueur = 2;
	int[][] tableau = tableaujeu();
	int[][] tableaujoueur = tableaujoueur();
	
	JPanel panjoueur2 = new JPanel();
	JPanel panjoueur3 = new JPanel();
	JPanel panjoueur4 = new JPanel();
	
	
	public void choix() {
		choix.setTitle("JEU");
		choix.setSize(300, 300);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		choix.setLocationRelativeTo(null);
		
		choix2.setLayout(new BoxLayout(choix2, BoxLayout.PAGE_AXIS));
		
		panjoueur2.setLayout(new BoxLayout(panjoueur2, BoxLayout.X_AXIS));
		panjoueur3.setLayout(new BoxLayout(panjoueur3, BoxLayout.X_AXIS));
		panjoueur4.setLayout(new BoxLayout(panjoueur4, BoxLayout.X_AXIS));
		
		JPanel panjouer = new JPanel();
		panjouer.setLayout(new BoxLayout(panjouer, BoxLayout.X_AXIS));
		
		/*
		 * Sur chaque bouton, je fais la m�me chose
		 * Je lui donne une ActionCommand, que je r�cup�re ensuite dans la fonction actionPerformed
		 * Cela me permet de savoir sur quel bouton j'ai cliqu�
		 * 
		 * J'ajoute �galement un ActionListener qui permet � la fen�tre "d'�couter" si on clique sur le bouton
		 */
		
		ajoutjoueur.setActionCommand("ajout");
		ajoutjoueur.addActionListener(this);
		ajoutjoueur4.setActionCommand("ajout4");
		ajoutjoueur4.addActionListener(this);
		explication.setActionCommand("explication");
		explication.addActionListener(this);
		IAdifficile1.setActionCommand("IAdifficile1");
		IAdifficile1.addActionListener(this);
		IAfacile1.setActionCommand("IAfacile1");
		IAfacile1.addActionListener(this);
		IAdifficile2.setActionCommand("IAdifficile2");
		IAdifficile2.addActionListener(this);
		IAfacile2.setActionCommand("IAfacile2");
		IAfacile2.addActionListener(this);
		IAdifficile3.setActionCommand("IAdifficile3");
		IAdifficile3.addActionListener(this);
		IAfacile3.setActionCommand("IAfacile3");
		IAfacile3.addActionListener(this);
		jouer.setActionCommand("jouer");
		jouer.addActionListener(this);
		
		//on ajoute les boutons configur�s au panel choix2
		choix2.add(new JLabel("\n"));
		choix2.add(joueur1choix);
		choix2.add(new JLabel("\n"));
		panjoueur2.add(joueur2choix);
		panjoueur2.add(IAdifficile1);
		panjoueur2.add(IAfacile1);
		choix2.add(panjoueur2);
		choix2.add(new JLabel("\n"));
		panjoueur3.add(joueur3choix);
		panjoueur3.add(IAdifficile2);
		panjoueur3.add(IAfacile2);
		panjoueur3.add(ajoutjoueur);
		choix2.add(panjoueur3);
		choix2.add(new JLabel("\n"));
		panjoueur4.add(joueur4choix);
		panjoueur4.add(IAdifficile3);
		panjoueur4.add(IAfacile3);
		panjoueur4.add(ajoutjoueur4);
		choix2.add(panjoueur4);
		choix2.add(new JLabel("\n"));
		panjouer.add(jouer);
		choix2.add(panjouer);
		
		choix.getContentPane().add(choix2);
		
		choix.setVisible(true);
	}
	
	public fenetrelos(){
	  this.setTitle("JEU");
	  this.setSize(700, 700);
	  //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  
	  this.setLayout(new BorderLayout());
	  
	  nom2.setFont(new Font("Tahoma", Font.BOLD, 25));
	  nom2.setForeground(Color.black);
	  nom2.setHorizontalAlignment(JLabel.CENTER);
	  nom.setFont(new Font("Tahoma", Font.BOLD, 25));
	  nom.setForeground(Color.black);
	  nom.setHorizontalAlignment(JLabel.CENTER);
	  
	  tab.setLayout(new GridLayout(25, 25));
	  redessin(1);
	  
	  joueur1.setFont(new Font("Tahoma", Font.BOLD, 25));
	  joueur1.setForeground(Color.black);
	  joueur1.setHorizontalAlignment(JLabel.CENTER);
	  joueur2.setFont(new Font("Tahoma", Font.BOLD, 25));
	  joueur2.setForeground(Color.black);
	  joueur2.setHorizontalAlignment(JLabel.CENTER);
	  score1.setFont(new Font("Tahoma", Font.BOLD, 25));
	  score1.setForeground(Color.black);
	  score1.setHorizontalAlignment(JLabel.CENTER);
	  score2.setFont(new Font("Tahoma", Font.BOLD, 25));
	  score2.setForeground(Color.black);
	  score2.setHorizontalAlignment(JLabel.CENTER);
	  joueur3.setFont(new Font("Tahoma", Font.BOLD, 25));
	  joueur3.setForeground(Color.black);
	  joueur3.setHorizontalAlignment(JLabel.CENTER);
	  score3.setFont(new Font("Tahoma", Font.BOLD, 25));
	  score3.setForeground(Color.black);
	  score3.setHorizontalAlignment(JLabel.CENTER);
	  joueur4.setFont(new Font("Tahoma", Font.BOLD, 25));
	  joueur4.setForeground(Color.black);
	  joueur4.setHorizontalAlignment(JLabel.CENTER);
	  score4.setFont(new Font("Tahoma", Font.BOLD, 25));
	  score4.setForeground(Color.black);
	  score4.setHorizontalAlignment(JLabel.CENTER);
	  
	  sauvegarde.setActionCommand("sauvegarde");
	  sauvegarde.addActionListener(this);
	  
	  scores.setLayout(new BoxLayout(scores, BoxLayout.PAGE_AXIS));
	  scores.add(joueur1);
	  scores.add(score1);
	  scores.add(joueur2);
	  scores.add(score2);
	  scores.add(joueur3);
	  scores.add(score3);
	  scores.add(joueur4);
	  scores.add(score4);
	  scores.add(sauvegarde);
	  scores.add(explication);
	  
	  this.getContentPane().add(nom2, BorderLayout.NORTH);
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.getContentPane().add(nom, BorderLayout.SOUTH);
	  this.getContentPane().add(scores, BorderLayout.EAST);
	  
	  this.setVisible(true);
	  choix();
  }
  
  
  public int compte(int[][] tableau2, int k) {
	  int somme = 0;
	  for (int i = 0; i<25; i++) {
			for (int j = 0; j<25; j++) {
				if (tableau2[i][j]==k) {
					somme++;
				}
			}
		}
	  return somme;
  }
  
  
  
  public void joueur1(int h) {
	  //lorsque le premier joueur joue, on s'assure de fermer la fen�tre permettant d'ajouter des joueurs
	  choix.dispose();
	  /*
	   * parcourt des des tableaux
	   * si la case appartient au joueur, celle-ci prend la couleur selectionn�e
	   * ensuite, si le case a la m�me couleur mais n'appartient pas au joueur, on regarde si elle touche le territoire du joueur
	   * si c'est le cas, on l'attribue au joueur
	   */
	  for (int i = 0; i<25; i++) {
			for (int j = 0; j<25; j++) {
				if (tableaujoueur[i][j]==1) {
					tableau[i][j]=h;
				}
				if (tableau[i][j]==h && tableaujoueur[i][j]!=1) {
					if (((i-1)>=0 && tableaujoueur[i-1][j]==1) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==1) || ((j-1)>=0 && tableaujoueur[i][j-1]==1) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==1)) {
						tableaujoueur[i][j]=1;
					}
				}
			}
		}
	  /*
	   * 10 fois de suite, on refait la m�me chose en partant du d�but et de la fin des tableaux
	   * cela permet de ne pas rater une case car sa voisine n'appartiendra au joueur qu'� l'�tape suivante
	   */
	  for (int l = 0; l<10; l++) {
		  for (int i = 24; i>=0; i--) {
			  for (int j = 24; j>=0; j--) {
				  if (tableau[i][j]==h && tableaujoueur[i][j]!=1) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==1) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==1) || ((j-1)>=0 && tableaujoueur[i][j-1]==1) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==1)) {
							tableaujoueur[i][j]=1;
						}
				  }
			  }
		  }
		  for (int i = 0; i<25; i++) {
				for (int j = 0; j<25; j++) {
					if (tableau[i][j]==h && tableaujoueur[i][j]!=1) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==1) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==1) || ((j-1)>=0 && tableaujoueur[i][j-1]==1) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==1)) {
							tableaujoueur[i][j]=1;
						}
					}
				}
		  }
	  }
	  //on redessine le nouveau tableau, et on signale � la fonction que sera au joueur 2 de jouer ensuite
	  redessin(2);
	  
	  //on rajoute le nouveau tableau, et on valide
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.validate();
	  
	  //calcul du score du joueur
	  int compte = compte(tableaujoueur, 1);
	  //en fonction du nombre de joueurs, le score n�cessaire � la victoire n'est pas le m�me
	  if (compte>=157 && joueur3.getText()=="" && joueur4.getText()=="") {
		  //this.dispose();
		  //si le joueur a gagn�, une nouvelle fen�tre s'ouvre pour le lui dire
		  Test.victoire("Le joueur 1", compte);
		  redessin(1);
	  }
	  else if (compte>=105 && joueur3.getText()!="" && joueur4.getText()=="") {
		  //this.dispose();
		  Test.victoire("Le joueur 1", compte);
		  redessin(1);
	  }
	  else if (compte>=79 && joueur3.getText()!="" && joueur4.getText()!="") {
		  //this.dispose();
		  Test.victoire("Le joueur 1", compte);
		  redessin(1);
	  }
	  //modification du JLabel pour mettre � jour le score et le montrer aux joueurs
	  score1.setText(Integer.toString(compte));
	  
	  //on signal que c'est au joueur 2 de jouer
	  joueur = 2;
	  
	  //en fonction de la couleur control�e par le joueur 2, on change la couleur disant que c'est � lui de jouer
	  if (couleur2=="blue") {
		  nom.setForeground(Color.BLUE);
	  }
	  if (couleur2=="green") {
		  nom.setForeground(Color.GREEN);
	  }
	  if (couleur2=="yellow") {
		  nom.setForeground(Color.YELLOW);
	  }
	  if (couleur2=="red") {
		  nom.setForeground(Color.RED);
	  }
	  if (couleur2=="magenta") {
		  nom.setForeground(Color.MAGENTA);
	  }
	  if (couleur2=="orange") {
		  nom.setForeground(Color.ORANGE);
	  }
	  
	  nom.setText("au tour du Joueur 2");
	  
	  
	  //si le joueur2 est une IA, on utilise la fonction avant de lancer le processus
	  if (joueur2.getText()!="Joueur 2") {
		  int k = 0;
		  if (IA1==1) {
			  k = IAfacile(2);
		  }
		  else {
			  k = IAdifficile(2);
		  }
		  couleur2 = couleurs[k-1];
		  joueur2(k);
	  }
  }
  
  public void joueur2(int h) {
	  for (int i = 24; i>=0; i--) {
			for (int j = 24; j>=0; j--) {
				if (tableaujoueur[i][j]==2) {
					tableau[i][j]=h;
				}
				if (tableau[i][j]==h && tableaujoueur[i][j]!=2) {
					if (((i-1)>=0 && tableaujoueur[i-1][j]==2) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==2) || ((j-1)>=0 && tableaujoueur[i][j-1]==2) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==2)) {
						tableaujoueur[i][j]=2;
					}
				}
			}
		}
	  
	  for (int l = 0; l<10; l++) {
		  for (int i = 0; i<25; i++) {
				for (int j = 0; j<25; j++) {
					if (tableau[i][j]==h && tableaujoueur[i][j]!=2) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==2) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==2) || ((j-1)>=0 && tableaujoueur[i][j-1]==2) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==2)) {
							tableaujoueur[i][j]=2;
						}
					}
				}
		  }
		  for (int i = 24; i>=0; i--) {
			  for (int j = 24; j>=0; j--) {
				  if (tableau[i][j]==h && tableaujoueur[i][j]!=2) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==2) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==2) || ((j-1)>=0 && tableaujoueur[i][j-1]==2) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==2)) {
							tableaujoueur[i][j]=2;
						}
				  }
			  }
		  }
	  }
	  //en fonction de l'existance ou non d'un joueur 3, on redessine avec 1 ou 3
	  if (joueur3.getText()=="Joueur 3") {
			redessin(3);
		}
		else if (joueur3.getText()=="") {
			redessin(1);
		}
	  
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.validate();
	  
	  int compte = compte(tableaujoueur, 2);
	  if (compte>=157 && joueur3.getText()=="" && joueur4.getText()=="") {
		  //this.dispose();
		  redessin(2);
		  Test.victoire(joueur2.getText(), compte);
	  }
	  else if (compte>=105 && joueur3.getText()!="" && joueur4.getText()=="") {
		  //this.dispose();
		  redessin(2);
		  Test.victoire(joueur2.getText(), compte);
	  }
	  else if (compte>=79 && joueur3.getText()!="" && joueur4.getText()!="") {
		  //this.dispose();
		  redessin(2);
		  Test.victoire(joueur2.getText(), compte);
	  }
	  score2.setText(Integer.toString(compte));
	  
	  //s'il y a un joueur 3, c'est � son tour
	  if (joueur3.getText()!="") {
		  joueur = 3;
		  if (couleur3=="blue") {
			  nom.setForeground(Color.BLUE);
		  }
		  if (couleur3=="green") {
			  nom.setForeground(Color.GREEN);
		  }
		  if (couleur3=="yellow") {
			  nom.setForeground(Color.YELLOW);
		  }
		  if (couleur3=="red") {
			  nom.setForeground(Color.RED);
		  }
		  if (couleur3=="magenta") {
			  nom.setForeground(Color.MAGENTA);
		  }
		  if (couleur3=="orange") {
			  nom.setForeground(Color.ORANGE);
		  }
		  
		  nom.setText("au tour du Joueur 3");
		  
		  if (joueur3.getText()!="Joueur 3") {
			  int k = 0;
			  if (IA2==1) {
				  k = IAfacile(3);
			  }
			  else {
				  k = IAdifficile(3);
			  }
			  couleur3 = couleurs[k-1];
			  joueur3(k);
		  }
	  }
	  
	  //sinon, c'est au joueur 1
	  else if (joueur3.getText()=="") {
		  joueur = 1;
		  if (couleur1=="blue") {
			  nom.setForeground(Color.BLUE);
		  }
		  if (couleur1=="green") {
			  nom.setForeground(Color.GREEN);
		  }
		  if (couleur1=="yellow") {
			  nom.setForeground(Color.YELLOW);
		  }
		  if (couleur1=="red") {
			  nom.setForeground(Color.RED);
		  }
		  if (couleur1=="magenta") {
			  nom.setForeground(Color.MAGENTA);
		  }
		  if (couleur1=="orange") {
			  nom.setForeground(Color.ORANGE);
		  }
		  
		  nom.setText("au tour du Joueur 1");
	  }
  }
  
  public void joueur3(int h) {
	  for (int i = 24; i>=0; i--) {
			for (int j = 24; j>=0; j--) {
				if (tableaujoueur[i][j]==3) {
					tableau[i][j]=h;
				}
				if (tableau[i][j]==h && tableaujoueur[i][j]!=3) {
					if (((i-1)>=0 && tableaujoueur[i-1][j]==3) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==3) || ((j-1)>=0 && tableaujoueur[i][j-1]==3) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==3)) {
						tableaujoueur[i][j]=3;
					}
				}
			}
		}
	  
	  for (int l = 0; l<10; l++) {
		  for (int i = 0; i<25; i++) {
				for (int j = 0; j<25; j++) {
					if (tableau[i][j]==h && tableaujoueur[i][j]!=3) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==3) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==3) || ((j-1)>=0 && tableaujoueur[i][j-1]==3) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==3)) {
							tableaujoueur[i][j]=3;
						}
					}
				}
		  }
		  for (int i = 24; i>=0; i--) {
			  for (int j = 24; j>=0; j--) {
				  if (tableau[i][j]==h && tableaujoueur[i][j]!=3) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==3) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==3) || ((j-1)>=0 && tableaujoueur[i][j-1]==3) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==3)) {
							tableaujoueur[i][j]=3;
						}
					}
			  }
		  }
	  }
	  
	  
	  if (joueur4.getText()=="Joueur 4") {
			redessin(4);
	  }
	  else if (joueur4.getText()=="") {
			redessin(1);
	  }
	  
	  
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.validate();
	  
	  int compte = compte(tableaujoueur, 3);
	  if (compte>=157 && joueur3.getText()=="" && joueur4.getText()=="") {
		  //this.dispose();
		  redessin(3);
		  Test.victoire(joueur3.getText(), compte);
	  }
	  else if (compte>=105 && joueur3.getText()!="" && joueur4.getText()=="") {
		  //this.dispose();
		  redessin(3);
		  Test.victoire(joueur3.getText(), compte);
	  }
	  else if (compte>=79 && joueur3.getText()!="" && joueur4.getText()!="") {
		  //this.dispose();
		  redessin(3);
		  Test.victoire(joueur3.getText(), compte);
	  }
	  score3.setText(Integer.toString(compte));
	  
	  if (joueur4.getText()!="") {
		  joueur = 4;
		  
		  if (couleur4=="blue") {
			  nom.setForeground(Color.BLUE);
		  }
		  if (couleur4=="green") {
			  nom.setForeground(Color.GREEN);
		  }
		  if (couleur4=="yellow") {
			  nom.setForeground(Color.YELLOW);
		  }
		  if (couleur4=="red") {
			  nom.setForeground(Color.RED);
		  }
		  if (couleur4=="magenta") {
			  nom.setForeground(Color.MAGENTA);
		  }
		  if (couleur4=="orange") {
			  nom.setForeground(Color.ORANGE);
		  }
		  
		  nom.setText("au tour du Joueur 4");
		  
		  if (joueur4.getText()!="Joueur 4") {
			  int k = 0;
			  if (IA3==1) {
				  k = IAfacile(4);
			  }
			  else {
				  k = IAdifficile(4);  
			  }
			  couleur4 = couleurs[k-1];
			  joueur4(k);
		  }
	  }
	  
	  else if (joueur4.getText()=="") {
		  joueur = 1;
		  
		  if (couleur1=="blue") {
			  nom.setForeground(Color.BLUE);
		  }
		  if (couleur1=="green") {
			  nom.setForeground(Color.GREEN);
		  }
		  if (couleur1=="yellow") {
			  nom.setForeground(Color.YELLOW);
		  }
		  if (couleur1=="red") {
			  nom.setForeground(Color.RED);
		  }
		  if (couleur1=="magenta") {
			  nom.setForeground(Color.MAGENTA);
		  }
		  if (couleur1=="orange") {
			  nom.setForeground(Color.ORANGE);
		  }
		  
		  nom.setText("au tour du Joueur 1");
	  }
  }
  
  public void joueur4(int h) {

	  for (int i = 0; i<25; i++) {
			for (int j = 0; j<25; j++) {
				if (tableaujoueur[i][j]==4) {
					tableau[i][j]=h;
				}
				if (tableau[i][j]==h && tableaujoueur[i][j]!=4) {
					if (((i-1)>=0 && tableaujoueur[i-1][j]==4) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==4) || ((j-1)>=0 && tableaujoueur[i][j-1]==4) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==4)) {
						tableaujoueur[i][j]=4;
					}
				}
			}
		}
	  
	  for (int l = 0; l<10; l++) {
		  for (int i = 24; i>=0; i--) {
			  for (int j = 24; j>=0; j--) {
				  if (tableau[i][j]==h && tableaujoueur[i][j]!=4) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==4) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==4) || ((j-1)>=0 && tableaujoueur[i][j-1]==4) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==4)) {
							tableaujoueur[i][j]=4;
						}
					}
			  }
		  }
		  
		  for (int i = 0; i<25; i++) {
				for (int j = 0; j<25; j++) {
					if (tableau[i][j]==h && tableaujoueur[i][j]!=4) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==4) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==4) || ((j-1)>=0 && tableaujoueur[i][j-1]==4) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==4)) {
							tableaujoueur[i][j]=4;
						}
					}
				}
		  }
	  }
	  
	  
	  redessin(1);
	  
	  
	  
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.validate();
	  
	  int compte = compte(tableaujoueur, 4);
	  if (compte>=157 && joueur3.getText()=="" && joueur4.getText()=="") {
		  //this.dispose();
		  Test.victoire(joueur4.getText(), compte);
		  redessin(4);
	  }
	  else if (compte>=105 && joueur3.getText()!="" && joueur4.getText()=="") {
		  //this.dispose();
		  Test.victoire(joueur4.getText(), compte);
		  redessin(4);
	  }
	  else if (compte>=79 && joueur3.getText()!="" && joueur4.getText()!="") {
		  //this.dispose();
		  Test.victoire(joueur4.getText(), compte);
		  redessin(4);
	  }
	  score4.setText(Integer.toString(compte));
	  
	  joueur = 1;
	  
	  if (couleur1=="blue") {
		  nom.setForeground(Color.BLUE);
	  }
	  if (couleur1=="green") {
		  nom.setForeground(Color.GREEN);
	  }
	  if (couleur1=="yellow") {
		  nom.setForeground(Color.YELLOW);
	  }
	  if (couleur1=="red") {
		  nom.setForeground(Color.RED);
	  }
	  if (couleur1=="magenta") {
		  nom.setForeground(Color.MAGENTA);
	  }
	  if (couleur1=="orange") {
		  nom.setForeground(Color.ORANGE);
	  }
	  
	  nom.setText("au tour du Joueur 1");
  }
  
  //fonction permettant de voir quel bouton est cliqu�
  public void actionPerformed(ActionEvent action) {
	  //on teste d'abord quel joueur est en train de jouer
	  if (joueur==1) {
		  //en fonction de l'ActionCommand cliqu�, on choisit le num�ro appel� par joueurk(i)
		  //on v�rifie �galement que la couleur appel�e n'appartient pas � un autre joueur
		  if (action.getActionCommand()=="blue" && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur1 = "blue";
			  joueur1(1);
		  }
		  if (action.getActionCommand()=="green" && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur1 = "green";
			  joueur1(2);
		  }
		  if (action.getActionCommand()=="yellow" && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur1 = "yellow";
			  joueur1(3);
		  }
		  if (action.getActionCommand()=="red" && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur1 = "red";
			  joueur1(4);
		  }
		  if (action.getActionCommand()=="magenta" && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur1 = "magenta";
			  joueur1(5);
		  }
		  if (action.getActionCommand()=="orange" && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur1 = "orange";
			  joueur1(6);
		  }
	  }
	  if (joueur==2) {
		  if (action.getActionCommand()=="blue" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur2 = "blue";
			  joueur2(1);
		  }
		  if (action.getActionCommand()=="green" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur2 = "green";
			  joueur2(2);
		  }
		  if (action.getActionCommand()=="yellow" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur2 = "yellow";
			  joueur2(3);
		  }
		  if (action.getActionCommand()=="red" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur2 = "red";
			  joueur2(4);
		  }
		  if (action.getActionCommand()=="magenta" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur2 = "magenta";
			  joueur2(5);
		  }
		  if (action.getActionCommand()=="orange" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur3 && action.getActionCommand()!=couleur4) {
			  couleur2 = "orange";
			  joueur2(6);
		  }
	  }
	  if (joueur==3) {
		  if (action.getActionCommand()=="blue" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur4) {
			  couleur3 = "blue";
			  joueur3(1);
		  }
		  if (action.getActionCommand()=="green" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur4) {
			  couleur3 = "green";
			  joueur3(2);
		  }
		  if (action.getActionCommand()=="yellow" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur4) {
			  couleur3 = "yellow";
			  joueur3(3);
		  }
		  if (action.getActionCommand()=="red" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur4) {
			  couleur3 = "red";
			  joueur3(4);
		  }
		  if (action.getActionCommand()=="magenta" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur4) {
			  couleur3 = "magenta";
			  joueur3(5);
		  }
		  if (action.getActionCommand()=="orange" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur4) {
			  couleur3 = "orange";
			  joueur3(6);
		  }
	  }
	  if (joueur==4) {
		  if (action.getActionCommand()=="blue" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3) {
			  couleur4 = "blue";
			  joueur4(1);
		  }
		  if (action.getActionCommand()=="green" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3) {
			  couleur4 = "green";
			  joueur4(2);
		  }
		  if (action.getActionCommand()=="yellow" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3) {
			  couleur4 = "yellow";
			  joueur4(3);
		  }
		  if (action.getActionCommand()=="red" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3) {
			  couleur4 = "red";
			  joueur4(4);
		  }
		  if (action.getActionCommand()=="magenta" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3) {
			  couleur4 = "magenta";
			  joueur4(5);
		  }
		  if (action.getActionCommand()=="orange" && action.getActionCommand()!=couleur1 && action.getActionCommand()!=couleur2 && action.getActionCommand()!=couleur3) {
			  couleur4 = "orange";
			  joueur4(6);
		  }
	  }
	  //si le bouton est celui de sauvegarde, on appelle la fonction correspondante, et on ferme la fen�tre
	  if (action.getActionCommand()=="sauvegarde") {
		  sauvegarde();
		  this.dispose();
	  }
	  //s'il y a 2 joueurs, on peut en ajouter un 3�me
	  //appel de la fonction permettant l'ajout, et modification du nombre de joueurs
	  if (action.getActionCommand()=="ajout" && nbrejoueur==2) {
		  nbrejoueur++;
		  ajoutjoueur3();
	  }
	  //s'il y a 3 joeuurs, on peut en ajouter un 4�me
	  if (action.getActionCommand()=="ajout4" && nbrejoueur==3) {
		  nbrejoueur++;
		  ajoutjoueur4();
	  }
	  //ouverture si besoin d'une fen�tre d'explications
	  if (action.getActionCommand()=="explication") {
		  Test.explication();
	  }
	  //si le joueur2 devient une AI
	  if (action.getActionCommand()=="IAdifficile1") {
		  //on modifie son nom
		  if (ia1==1) {
			  joueur2.setText("IA 1");
			  joueur2choix.setText("IA 1");
			  ia1=2;
			  IA1=2;
		  }
		  else {
			  joueur2.setText("Joueur 2");
			  joueur2choix.setText("Joueur 2");
			  ia1=1;
			  IA1=0;
		  }
	  }
	  if (action.getActionCommand()=="IAfacile1") {
		  //on modifie son nom
		  if (ia1==1) {
			  joueur2.setText("IA 1");
			  joueur2choix.setText("IA 1");
			  ia1=2;
			  IA1=1;
		  }
		  else {
			  joueur2.setText("Joueur 2");
			  joueur2choix.setText("Joueur 2");
			  ia1=1;
			  IA1=0;
		  }
	  }
	  //idem pour joueur3 et 4
	  if (action.getActionCommand()=="IAdifficile2" && nbrejoueur>=3) {
		  if (ia2==1) {
			  if (joueur2.getText()=="IA 1") {
				  joueur3.setText("IA 2");
				  joueur3choix.setText("IA 2");
			  }
			  else {
				  joueur3.setText("IA 1");
				  joueur3choix.setText("IA 1");
			  }
			  ia2=2;
			  IA2=2;
		  }
		  else {
			  joueur3.setText("Joueur 3");
			  joueur3choix.setText("Joueur 3");
			  ia2=1;
			  IA2=0;
		  }
	  }
	  if (action.getActionCommand()=="IAfacile2" && nbrejoueur>=3) {
		  if (ia2==1) {
			  if (joueur2.getText()=="IA 1") {
				  joueur3.setText("IA 2");
				  joueur3choix.setText("IA 2");
			  }
			  else {
				  joueur3.setText("IA 1");
				  joueur3choix.setText("IA 1");
			  }
			  ia2=2;
			  IA2=1;
		  }
		  else {
			  joueur3.setText("Joueur 3");
			  joueur3choix.setText("Joueur 3");
			  ia2=1;
			  IA2=0;
		  }
	  }
	  
	  if (action.getActionCommand()=="IAdifficile3" && nbrejoueur>=4) {
		  if (ia3==1) {
			  if (joueur2.getText()=="IA") {
				  joueur2.setText("IA 1");
				  joueur2choix.setText("IA 1");
				  joueur4.setText("IA 2");
				  joueur4choix.setText("IA 2");
			  }
			  else if (joueur2.getText()=="IA 1") {
				  joueur4.setText("IA 3");
				  joueur4choix.setText("IA 3");
			  }
			  else if (joueur3.getText()=="IA 1") {
				  joueur4.setText("IA 2");
				  joueur4choix.setText("IA 2");
			  }
			  else {
				  joueur4.setText("IA 1");
				  joueur4choix.setText("IA 1");
			  }
			  ia3=2;
			  IA3=2;
		  }
		  else {
			  joueur4.setText("Joueur 4");
			  joueur4choix.setText("Joueur 4");
			  ia3=1;
			  IA3=0;
		  }
	  }
	  if (action.getActionCommand()=="IAfacile3" && nbrejoueur>=4) {
		  if (ia3==1) {
			  if (joueur2.getText()=="IA") {
				  joueur2.setText("IA 1");
				  joueur2choix.setText("IA 1");
				  joueur4.setText("IA 2");
				  joueur4choix.setText("IA 2");
			  }
			  else if (joueur2.getText()=="IA 1") {
				  joueur4.setText("IA 3");
				  joueur4choix.setText("IA 3");
			  }
			  else if (joueur3.getText()=="IA 1") {
				  joueur4.setText("IA 2");
				  joueur4choix.setText("IA 2");
			  }
			  else {
				  joueur4.setText("IA 1");
				  joueur4choix.setText("IA 1");
			  }
			  ia3=2;
			  IA3=1;
		  }
		  else {
			  joueur4.setText("Joueur 4");
			  joueur4choix.setText("Joueur 4");
			  ia3=1;
			  IA3=0;
		  }
	  }
	  
	  //si on clique sur jouer, �a ferme la fen�tre de choix d'actions
	  if (action.getActionCommand()=="jouer") {
		  choix.dispose();
	  }
  }
  
  public static void tesst() {
	  System.out.println("ok");
  }
  
  public void ajoutjoueur3() {
	  joueur3.setText("Joueur 3");
	  joueur3choix.setText("Joueur 3");
	  score3.setText("1");
	  tableaujoueur[24][12]=3;
	  tableau[24][12]=7;
	  redessin(1);
  }
  
  public void ajoutjoueur4() {
	  joueur4.setText("Joueur 4");
	  joueur4choix.setText("Joueur 4");
	  score4.setText("1");
	  tableaujoueur[12][0]=4;
	  tableau[12][0]=7;
	  redessin(1);
  }
  
  public int[][] tableaujeu() {
		int[][] tableaujeu = new int[25][25];
		Random rand = new Random();
		int k = 12;
		int k2 = 1;
		int q =1;
		int q2=23;
		for (int i = 0; i<25; i++) {
			int j =0;
			if (i<13) {
				while (j<(k)) {
					tableaujeu[i][j]=0;
					j++;
				}
				while (j<(k+q)) {
					int f = rand.nextInt(6)+1;
					tableaujeu[i][j]=f;
					j++;
				}
				while (j<25) {
					tableaujeu[i][j]=0;
					j++;
				}
				q++;
				q++;
				k--;
			}
			else {
				while (j<k2) {
					tableaujeu[i][j]=0;
					j++;
				}
				while (j<(k2+q2)) {
					int f = rand.nextInt(6)+1;
					tableaujeu[i][j]=f;
					j++;
				}
				while (j<25) {
					tableaujeu[i][j]=0;
					j++;
				}
				q2--;
				q2--;
				k2++;
			}
		}
		tableaujeu[0][12]=7;
		tableaujeu[24][12]=7;
		
		return tableaujeu;
	}
	
	public int[][] tableaujoueur() {
		int[][] tableaujoueur = new int[25][25];
		for (int i = 0; i<25; i++) {
			for (int j = 0; j<25; j++) {
				tableaujoueur[i][j]=0;
			}
		}
		tableaujoueur[0][12]=1;
		tableaujoueur[24][12]=2;
		
		return tableaujoueur;
	}
  
  public void redessin(int k) {
	  tab.removeAll();
	  for (int i = 0; i<25; i++) {
		  for (int j = 0; j<25; j++) {
	        	if (tableau[i][j]==1) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.blue);
	        		bouton.setActionCommand("blue");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==k) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==2) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.green);
	        		bouton.setActionCommand("green");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==k) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==3) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.yellow);
	        		bouton.setActionCommand("yellow");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==k) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==4) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.red);
	        		bouton.setActionCommand("red");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==k) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==5) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.magenta);
	        		bouton.setActionCommand("magenta");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==k) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==6) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.ORANGE);
	        		bouton.setActionCommand("orange");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==k) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==7) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.black);
	        		bouton.setActionCommand("black");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==k) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==0) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.white);
	        		bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		tab.add(bouton);
	        	}
	        	
	    	}
	    }
  }
  
  public void sauvegarde() {
	  String path = "sauvegardes/partie13carredi/sauvegarde.txt";
	  String path2 = "sauvegardes/partie13carredi/sauvegardejoueur.txt";
	  String path3 = "sauvegardes/partie13carredi/joueur.txt";
	  try {
		  BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
		  for (int i = 0; i<25; i++) {
			  for (int j = 0; j<25; j++) {
				  writer.write(Integer.toString(tableau[i][j]));
				  writer.write("\n");
			  }
		  }
		  writer.close();
		  
		  BufferedWriter writer2 = new BufferedWriter(new FileWriter(new File(path2)));
		  for (int i = 0; i<25; i++) {
			  for (int j = 0; j<25; j++) {
				  writer2.write(Integer.toString(tableaujoueur[i][j]));
				  writer2.write("\n");
			  }
		  }
		  writer2.close();
		  
		  BufferedWriter writer3 = new BufferedWriter(new FileWriter(new File(path3)));
		  writer3.write(Integer.toString(joueur));
		  writer3.write("\n");
		  writer3.write(Integer.toString(nbrejoueur));
		  writer3.write("\n");
		  writer3.write(joueur2.getText());
		  writer3.write("\n");
		  writer3.write(joueur3.getText());
		  writer3.write("\n");
		  writer3.write(joueur4.getText());
		  writer3.write("\n");
		  writer3.write(Integer.toString(IA1));
		  writer3.write("\n");
		  writer3.write(Integer.toString(IA2));
		  writer3.write("\n");
		  writer3.write(Integer.toString(IA3));
		  writer3.write("\n");
		  writer3.close();
	  }
	  catch (IOException ioe) {
		  System.out.println(ioe.toString());
	  }
  }
  
  public int IAfacile(int c) {
	  //on r�p�re les couleurs utilis�es par les autres joeurs
	  int h = 0;
	  if (couleur1=="blue") {
		  h=1;
	  }
	  else if (couleur1=="green") {
		  h=2;
	  }
	  else if (couleur1=="yellow") {
		  h=3;
	  }
	  else if (couleur1=="red") {
		  h=4;
	  }
	  else if (couleur1=="magenta") {
		  h=5;
	  }
	  else if (couleur1=="orange") {
		  h=6;
	  }
	  int m = 0;
	  if (couleur2=="blue") {
		  m=1;
	  }
	  else if (couleur2=="green") {
		  m=2;
	  }
	  else if (couleur2=="yellow") {
		  m=3;
	  }
	  else if (couleur2=="red") {
		  m=4;
	  }
	  else if (couleur2=="magenta") {
		  m=5;
	  }
	  else if (couleur2=="orange") {
		  m=6;
	  }
	  int p = 0;
	  if (couleur3=="blue") {
		  p=1;
	  }
	  else if (couleur3=="green") {
		  p=2;
	  }
	  else if (couleur3=="yellow") {
		  p=3;
	  }
	  else if (couleur3=="red") {
		  p=4;
	  }
	  else if (couleur3=="magenta") {
		  p=5;
	  }
	  else if (couleur3=="orange") {
		  p=6;
	  }
	  int u = 0;
	  if (couleur4=="blue") {
		  u=1;
	  }
	  else if (couleur4=="green") {
		  u=2;
	  }
	  else if (couleur4=="yellow") {
		  u=3;
	  }
	  else if (couleur4=="red") {
		  u=4;
	  }
	  else if (couleur4=="magenta") {
		  u=5;
	  }
	  else if (couleur4=="orange") {
		  u=6;
	  }
	  //utilisation d'un chiffre random pour choisir la prochaine couleur jou�e
	  Random rand = new Random();
	  int k = h;
	  //on cherche un chiffre tant que le chiffre trouv� est celui d'un autre joueur
	  while (k==h && k==u && k==p && k==m) {
		  k = rand.nextInt(6)+1;
	  }
	  return k;
  }
  
  public int IAdifficile(int c) {
	  int[] nbre = {0,0,0,0,0,0};
	  
	  for (int i = 0; i<25; i++) {
			for (int j = 0; j<25; j++) {
				if (tableaujoueur[i][j]!=c) {
					if (((i-1)>=0 && tableaujoueur[i-1][j]==c) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==c) || ((j-1)>=0 && tableaujoueur[i][j-1]==c) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==c)) {
						if (tableau[i][j]!=0) {
							int co = recup(i, j, 1);
							nbre[tableau[i][j]-1]=nbre[tableau[i][j]-1]+co;
						}
					}
				}
			}
		}
	  int h = 0;
	  if (couleur1=="blue") {
		  h=1;
	  }
	  else if (couleur1=="green") {
		  h=2;
	  }
	  else if (couleur1=="yellow") {
		  h=3;
	  }
	  else if (couleur1=="red") {
		  h=4;
	  }
	  else if (couleur1=="magenta") {
		  h=5;
	  }
	  else if (couleur1=="orange") {
		  h=6;
	  }
	  int m = 0;
	  if (couleur2=="blue") {
		  m=1;
	  }
	  else if (couleur2=="green") {
		  m=2;
	  }
	  else if (couleur2=="yellow") {
		  m=3;
	  }
	  else if (couleur2=="red") {
		  m=4;
	  }
	  else if (couleur2=="magenta") {
		  m=5;
	  }
	  else if (couleur2=="orange") {
		  m=6;
	  }
	  int p = 0;
	  if (couleur3=="blue") {
		  p=1;
	  }
	  else if (couleur3=="green") {
		  p=2;
	  }
	  else if (couleur3=="yellow") {
		  p=3;
	  }
	  else if (couleur3=="red") {
		  p=4;
	  }
	  else if (couleur3=="magenta") {
		  p=5;
	  }
	  else if (couleur3=="orange") {
		  p=6;
	  }
	  int u = 0;
	  if (couleur4=="blue") {
		  u=1;
	  }
	  else if (couleur4=="green") {
		  u=2;
	  }
	  else if (couleur4=="yellow") {
		  u=3;
	  }
	  else if (couleur4=="red") {
		  u=4;
	  }
	  else if (couleur4=="magenta") {
		  u=5;
	  }
	  else if (couleur4=="orange") {
		  u=6;
	  }
	  
	  
	  int k = -1;
	  int max = -1;
	  for (int i = 0; i<6; i++) {
		  if (nbre[i]>max && (i+1)!=h && (i+1)!=m && (i+1)!=p && (i+1)!=u) {
			  max = nbre[i];
			  k = i;
		  }
	  }
	  
	  return k+1;
  }
  
  public int recup(int i, int j, int k) {
	  int co =k;
	  int c = tableau[i][j];
	  int q = 21545;
	  int a = 21545;
	  
	  boolean conti = true;
	  
	  while (conti) {
		  if ((i-1)>=0 && tableau[i-1][j]==c) {
			  co++;
			  i--;
		  }
		  if ((j-1)>=0 && tableau[i][j-1]==c) {
			  co++;
			  j--;
		  }
		  if ((i+1)<tableau.length && tableau[i+1][j]==c) {
			  co++;
			  i++;
		  }
		  if ((j+1)<tableau.length && tableau[i][j+1]==c) {
			  co++;
			  j++;
		  }
		  if (i==q && j==a) {
			  conti=false;
		  }
		  else {
			  conti=false;
		  }
		  q=i;
		  a=j;
	  }
	  return co;
  }
}