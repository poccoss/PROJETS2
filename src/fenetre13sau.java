import java.awt.GridLayout; 
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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

 
public class fenetre13sau extends JFrame implements ActionListener {
	
	int exist=0;
	
	JFrame choix = new JFrame();
	String couleur1 = "";
	String couleur2 = "";
	String couleur3 = "";
	String couleur4 = "";
	String[] couleurs = {"blue", "green", "yellow", "red", "magenta", "orange"};
	boolean clic = false;
	JLabel nom = new JLabel("au tour du Joueur 1");
	JLabel nom2 = new JLabel("JEU");
	JLabel joueur1 = new JLabel("Joueur 1");
	JLabel score1 = new JLabel("1");
	JLabel joueur2 = new JLabel("Joueur 2");
	JLabel score2 = new JLabel("1");
	JLabel joueur3 = new JLabel("");
	JLabel score3 = new JLabel("");
	JLabel joueur4 = new JLabel("");
	JLabel score4 = new JLabel("");
	JPanel tab = new JPanel();
	JPanel scores = new JPanel();
	JPanel choix2 = new JPanel();
	JButton sauvegarde = new JButton("Sauvegarder et quitter");
	JButton ajoutjoueur = new JButton("ajouter un joueur 3");
	JButton ajoutjoueur4 = new JButton("ajouter un joueur 4");
	JButton explication = new JButton("explications");
	JButton IAdifficile1 = new JButton("le joueur 2 est une AI");
	JButton IAdifficile2 = new JButton("ajouter une AI");
	JButton IAdifficile3 = new JButton("ajouter une AI");
	int joueur = joueur();
	int nbrejoueur = nbrejoueur();
	int[][] tableau = tableaujeu();
	int[][] tableaujoueur = tableaujoueur();
	
	
	
	public fenetre13sau(){
		System.out.println(nbrejoueur);
	  this.setTitle("JEU");
	  this.setSize(650, 650);
	  //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  
	  this.setLayout(new BorderLayout());
	  
	  nom2.setFont(new Font("Tahoma", Font.BOLD, 25));
	  nom2.setForeground(Color.black);
	  nom2.setHorizontalAlignment(JLabel.CENTER);
	  nom.setFont(new Font("Tahoma", Font.BOLD, 25));
	  nom.setForeground(Color.black);
	  nom.setHorizontalAlignment(JLabel.CENTER);
	  
	  tab.setLayout(new GridLayout(13, 13));
	  redessin(joueur);
	  
	  joueur1.setFont(new Font("Tahoma", Font.BOLD, 25));
	  joueur1.setForeground(Color.black);
	  joueur1.setHorizontalAlignment(JLabel.CENTER);
	  joueur2.setFont(new Font("Tahoma", Font.BOLD, 25));
	  joueur2.setForeground(Color.black);
	  joueur2.setHorizontalAlignment(JLabel.CENTER);
	  score1.setFont(new Font("Tahoma", Font.BOLD, 25));
	  score1.setForeground(Color.black);
	  score1.setHorizontalAlignment(JLabel.CENTER);
	  score1.setText(Integer.toString(compte(tableaujoueur, 1)));
	  score2.setFont(new Font("Tahoma", Font.BOLD, 25));
	  score2.setForeground(Color.black);
	  score2.setHorizontalAlignment(JLabel.CENTER);
	  score2.setText(Integer.toString(compte(tableaujoueur, 2)));
	  joueur3.setFont(new Font("Tahoma", Font.BOLD, 25));
	  joueur3.setForeground(Color.black);
	  joueur3.setHorizontalAlignment(JLabel.CENTER);
	  score3.setFont(new Font("Tahoma", Font.BOLD, 25));
	  score3.setForeground(Color.black);
	  score3.setHorizontalAlignment(JLabel.CENTER);
	  if (joueur3.getText()=="Joueur 3" || joueur3.getText().startsWith("IA")) {
		  score3.setText(Integer.toString(compte(tableaujoueur, 3)));
	  }
	  joueur4.setFont(new Font("Tahoma", Font.BOLD, 25));
	  joueur4.setForeground(Color.black);
	  joueur4.setHorizontalAlignment(JLabel.CENTER);
	  score4.setFont(new Font("Tahoma", Font.BOLD, 25));
	  score4.setForeground(Color.black);
	  score4.setHorizontalAlignment(JLabel.CENTER);
	  if (joueur4.getText()=="Joueur 4" || joueur4.getText().startsWith("IA")) {
		  score4.setText(Integer.toString(compte(tableaujoueur, 4)));
	  }
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
  }
  
  
  public int compte(int[][] tableau2, int k) {
	  int somme = 0;
	  for (int i = 0; i<13; i++) {
			for (int j = 0; j<13; j++) {
				if (tableau2[i][j]==k) {
					somme++;
				}
			}
		}
	  return somme;
  }
  

  
  public void joueur1(int h) {
	  choix.dispose();
	  for (int i = 0; i<13; i++) {
			for (int j = 0; j<13; j++) {
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
	  for (int l = 0; l<10; l++) {
		  for (int i = 12; i>=0; i--) {
			  for (int j = 12; j>=0; j--) {
				  if (tableau[i][j]==h && tableaujoueur[i][j]!=1) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==1) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==1) || ((j-1)>=0 && tableaujoueur[i][j-1]==1) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==1)) {
							tableaujoueur[i][j]=1;
						}
				  }
			  }
		  }
		  for (int i = 0; i<13; i++) {
				for (int j = 0; j<13; j++) {
					if (tableau[i][j]==h && tableaujoueur[i][j]!=1) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==1) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==1) || ((j-1)>=0 && tableaujoueur[i][j-1]==1) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==1)) {
							tableaujoueur[i][j]=1;
						}
					}
				}
		  }
	  }
	  
	  redessin(2);
	  
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.validate();
	  
	  int compte = compte(tableaujoueur, 1);
	  if (compte>=85 && nbrejoueur==2) {
		  //this.dispose();
		  Test.victoire("Le joueur 1", compte);
		  redessin(1);
	  }
	  else if (compte>=57 && nbrejoueur==3) {
		  //this.dispose();
		  Test.victoire("Le joueur 1", compte);
		  redessin(1);
	  }
	  else if (compte>=43 && nbrejoueur==4) {
		  //this.dispose();
		  Test.victoire("Le joueur 1", compte);
		  redessin(1);
	  }
	  score1.setText(Integer.toString(compte));
	  
	  joueur = 2;
	  
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
	  
	  

	  if (joueur2.getText().startsWith("IA")) {
		  int k = IAdifficile(2);
		  couleur2 = couleurs[k-1];
		  joueur2(k);
	  }
  }
  
  public void joueur2(int h) {
	  for (int i = 12; i>=0; i--) {
			for (int j = 12; j>=0; j--) {
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
		  for (int i = 0; i<13; i++) {
				for (int j = 0; j<13; j++) {
					if (tableau[i][j]==h && tableaujoueur[i][j]!=2) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==2) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==2) || ((j-1)>=0 && tableaujoueur[i][j-1]==2) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==2)) {
							tableaujoueur[i][j]=2;
						}
					}
				}
		  }
		  for (int i = 12; i>=0; i--) {
			  for (int j = 12; j>=0; j--) {
				  if (tableau[i][j]==h && tableaujoueur[i][j]!=2) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==2) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==2) || ((j-1)>=0 && tableaujoueur[i][j-1]==2) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==2)) {
							tableaujoueur[i][j]=2;
						}
				  }
			  }
		  }
	  }
	  
	  if (joueur3.getText().startsWith("IA") || joueur3.getText().startsWith("Joueur")) {
			redessin(3);
		}
	  else {
			redessin(1);
		}
	  
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.validate();
	  
	  int compte = compte(tableaujoueur, 2);
	  if (compte>=85 && nbrejoueur==2) {
		  //this.dispose();
		  redessin(2);
		  Test.victoire(joueur2.getText(), compte);
	  }
	  else if (compte>=57 && nbrejoueur==3) {
		  //this.dispose();
		  redessin(2);
		  Test.victoire(joueur2.getText(), compte);
	  }
	  else if (compte>=43 && nbrejoueur==4) {
		  //this.dispose();
		  redessin(2);
		  Test.victoire(joueur2.getText(), compte);
	  }
	  score2.setText(Integer.toString(compte));
	  
	  if (joueur3.getText().startsWith("IA") || joueur3.getText().startsWith("Joueur")) {
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
		  
		  if (joueur3.getText().startsWith("IA")) {
			  int k = IAdifficile(3);
			  couleur3 = couleurs[k-1];
			  joueur3(k);
		  }
	  }
	  else {
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
	  for (int i = 12; i>=0; i--) {
			for (int j = 12; j>=0; j--) {
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
		  for (int i = 0; i<13; i++) {
				for (int j = 0; j<13; j++) {
					if (tableau[i][j]==h && tableaujoueur[i][j]!=3) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==3) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==3) || ((j-1)>=0 && tableaujoueur[i][j-1]==3) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==3)) {
							tableaujoueur[i][j]=3;
						}
					}
				}
		  }
		  for (int i = 12; i>=0; i--) {
			  for (int j = 12; j>=0; j--) {
				  if (tableau[i][j]==h && tableaujoueur[i][j]!=3) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==3) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==3) || ((j-1)>=0 && tableaujoueur[i][j-1]==3) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==3)) {
							tableaujoueur[i][j]=3;
						}
					}
			  }
		  }
	  }
	  
	  
	  if (joueur4.getText().startsWith("IA") || joueur4.getText().startsWith("Joueur")) {
			redessin(4);
	  }
	  else {
			redessin(1);
	  }
	  
	  
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.validate();
	  
	  int compte = compte(tableaujoueur, 3);
	  if (compte>=85 && nbrejoueur==2) {
		  //this.dispose();
		  redessin(3);
		  Test.victoire(joueur3.getText(), compte);
	  }
	  else if (compte>=57 && nbrejoueur==3) {
		  //this.dispose();
		  redessin(3);
		  Test.victoire(joueur3.getText(), compte);
	  }
	  else if (compte>=43 && nbrejoueur==4) {
		  //this.dispose();
		  redessin(3);
		  Test.victoire(joueur3.getText(), compte);
	  }
	  score3.setText(Integer.toString(compte));
	  
	  if (joueur4.getText().startsWith("IA") || joueur4.getText().startsWith("Joueur")) {
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
		  
		  if (joueur4.getText().startsWith("IA")) {
			  int k = IAdifficile(4);
			  couleur4 = couleurs[k-1];
			  joueur4(k);
		  }
	  }
	  
	  else {
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
	  for (int i = 0; i<13; i++) {
			for (int j = 0; j<13; j++) {
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
		  for (int i = 12; i>=0; i--) {
			  for (int j = 12; j>=0; j--) {
				  if (tableau[i][j]==h && tableaujoueur[i][j]!=4) {
						if (((i-1)>=0 && tableaujoueur[i-1][j]==4) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==4) || ((j-1)>=0 && tableaujoueur[i][j-1]==4) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==4)) {
							tableaujoueur[i][j]=4;
						}
					}
			  }
		  }
		  
		  for (int i = 0; i<13; i++) {
				for (int j = 0; j<13; j++) {
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
	  if (compte>=85 && nbrejoueur==2) {
		  //this.dispose();
		  Test.victoire(joueur4.getText(), compte);
		  redessin(4);
	  }
	  else if (compte>=57 && nbrejoueur==3) {
		  //this.dispose();
		  Test.victoire(joueur4.getText(), compte);
		  redessin(4);
	  }
	  else if (compte>=43 && nbrejoueur==4) {
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
  
  public void actionPerformed(ActionEvent action) {
	  if (joueur==1) {
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
	  if (action.getActionCommand()=="sauvegarde") {
		  sauvegarde();
		  this.dispose();
	  }
	  if (action.getActionCommand()=="ajout" && nbrejoueur==2) {
		  nbrejoueur++;
		  ajoutjoueur3();
	  }
	  if (action.getActionCommand()=="ajout4" && nbrejoueur==3) {
		  nbrejoueur++;
		  ajoutjoueur4();
	  }
	  if (action.getActionCommand()=="explication") {
		  Test.explication();
	  }
  }
  
  public static void tesst() {
	  System.out.println("ok");
  }
  
  public void ajoutjoueur3() {
	  joueur3.setText("Joueur 3");
	  score3.setText("1");
	  tableaujoueur[0][12]=3;
	  tableau[0][12]=7;
	  redessin(1);
  }
  
  public void ajoutjoueur4() {
	  joueur4.setText("Joueur 4");
	  score4.setText("1");
	  tableaujoueur[12][0]=4;
	  tableau[12][0]=7;
	  redessin(1);
  }
  
  public int[][] tableaujeu() {
		int[][] tableaujeu = new int[13][13];
		try {
			InputStream ips=new FileInputStream("sauvegardes/partie13carre/sauvegarde.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String chiffre;
			int i = 0;
			int j = 0;
			while((chiffre=br.readLine()) != null){
				exist++;
				int x = Integer.parseInt(chiffre);
				tableaujeu[i][j]=x;
				if (j==12) {
					j=-1;
					i++;
				}
				j++;
			}
			br.close();
			
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		
		return tableaujeu;
	}
	
	public int[][] tableaujoueur() {
		int[][] tableaujoueur = new int[13][13];
		
		try {
			InputStream ips=new FileInputStream("sauvegardes/partie13carre/sauvegardejoueur.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String chiffre;
			int i = 0;
			int j = 0;
			while((chiffre=br.readLine()) != null){
				int x = Integer.parseInt(chiffre);
				tableaujoueur[i][j]=x;
				if (j==12) {
					j=-1;
					i++;
				}
				j++;
			}
			br.close();
			
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		return tableaujoueur;
	}
	
	public int joueur() {
		int joueur=1;
		try {
			InputStream ips=new FileInputStream("sauvegardes/partie13carre/joueur.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String chiffre;
			for (int i=0; i<5; i++) {
				if (i==0) {
					chiffre=br.readLine();
					int x = Integer.parseInt(chiffre);
					joueur=x;
				}
				if (i==1) {
					chiffre=br.readLine();
				}
				if (i==2) {
					chiffre=br.readLine();
					joueur2.setText(chiffre);
				}
				if (i==3) {
					chiffre=br.readLine();
					joueur3.setText(chiffre);
				}
				if (i==4) {
					chiffre=br.readLine();
					joueur4.setText(chiffre);
				}
			}
			br.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		return joueur;
	}
	
	public int nbrejoueur() {
		int recupjoueur = 0;
		try {
			InputStream ips=new FileInputStream("sauvegardes/partie13carre/joueur.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String chiffre;
			
			chiffre=br.readLine();
			chiffre=br.readLine();
			int x = Integer.parseInt(chiffre);
			recupjoueur=x;
			
			br.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		return recupjoueur;
	}
  
  public void redessin(int k) {
	  tab.removeAll();
	  for (int i = 0; i<13; i++) {
		  for (int j = 0; j<13; j++) {
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
	  String path = "sauvegardes/partie13carre/sauvegarde.txt";
	  String path2 = "sauvegardes/partie13carre/sauvegardejoueur.txt";
	  String path3 = "sauvegardes/partie13carre/joueur.txt";
	  try {
		  BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
		  for (int i = 0; i<13; i++) {
			  for (int j = 0; j<13; j++) {
				  writer.write(Integer.toString(tableau[i][j]));
				  writer.write("\n");
			  }
		  }
		  writer.close();
		  
		  BufferedWriter writer2 = new BufferedWriter(new FileWriter(new File(path2)));
		  for (int i = 0; i<13; i++) {
			  for (int j = 0; j<13; j++) {
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
		  writer3.close();
	  }
	  catch (IOException ioe) {
		  System.out.println(ioe.toString());
	  }
  }
  
  public int IAdifficile(int c) {
	  int[] nbre = {0,0,0,0,0,0};
	  
	  for (int i = 0; i<13; i++) {
			for (int j = 0; j<13; j++) {
				if (tableaujoueur[i][j]!=c) {
					if (((i-1)>=0 && tableaujoueur[i-1][j]==c) || ((i+1)<tableaujoueur.length && tableaujoueur[i+1][j]==c) || ((j-1)>=0 && tableaujoueur[i][j-1]==c) || ((j+1)<tableaujoueur.length && tableaujoueur[i][j+1]==c)) {
						int co = recup(i, j, 1);
						nbre[tableau[i][j]-1]=nbre[tableau[i][j]-1]+co;
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
	  
	  
	  int k = 0;
	  int max = 0;
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