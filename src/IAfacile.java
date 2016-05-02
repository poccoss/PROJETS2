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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font; 

 
public class IAfacile extends JFrame implements ActionListener {
	
	public int[][] tableaujeu() {
		Random rand = new Random();
		int[][] tableaujeu = new int[13][13];
		for (int i = 0; i<13; i++) {
			for (int j = 0; j<13; j++) {
	            int k = rand.nextInt(6)+1;
				tableaujeu[i][j]=k;
			}
		}
		tableaujeu[0][0]=7;
		tableaujeu[12][12]=7;
		return tableaujeu;
	}
	
	public int[][] tableaujoueur() {
		int[][] tableaujoueur = new int[13][13];
		for (int i = 0; i<13; i++) {
			for (int j = 0; j<13; j++) {
				tableaujoueur[i][j]=0;
			}
		}
		tableaujoueur[0][0]=1;
		tableaujoueur[13-1][13-1]=2;
		
		return tableaujoueur;
	}
	
	String couleur1 = "";
	String couleur2 = "";
	boolean clic = false;
	JLabel nom = new JLabel("au tour du Joueur 1");
	JLabel nom2 = new JLabel("JEU");
	JLabel joueur1 = new JLabel("Joueur 1");
	JLabel score1 = new JLabel("1");
	JLabel joueur2 = new JLabel("Joueur 2");
	JLabel score2 = new JLabel("1");
	JPanel tab = new JPanel();
	JPanel scores = new JPanel();
	JButton sauvegarde = new JButton("Sauvegarder et quitter");
	JButton explication = new JButton("explications");
	int joueur = 1;
	int[][] tableau = tableaujeu();
	int[][] tableaujoueur = tableaujoueur();
	
	public IAfacile(){
	  this.setTitle("Bouton");
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
	  for (int i = 0; i<13; i++) {
		  for (int j = 0; j<13; j++) {
	        	if (tableau[i][j]==1) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.blue);
	        		bouton.setActionCommand("blue");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==2) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.green);
	        		bouton.setActionCommand("green");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==3) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.yellow);
	        		bouton.setActionCommand("yellow");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==4) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.red);
	        		bouton.setActionCommand("red");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==5) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.magenta);
	        		bouton.setActionCommand("magenta");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==6) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.ORANGE);
	        		bouton.setActionCommand("orange");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==7) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.black);
	        		bouton.setActionCommand("black");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	
	    	}
	    }
	  
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
	  
	  sauvegarde.setActionCommand("sauvegarde");
	  sauvegarde.addActionListener(this);
	  explication.setActionCommand("explication");
	  explication.addActionListener(this);
	  
	  scores.setLayout(new BoxLayout(scores, BoxLayout.PAGE_AXIS));
	  scores.add(joueur1);
	  scores.add(score1);
	  scores.add(joueur2);
	  scores.add(score2);
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
	  
	  
	  tab.removeAll();
	  for (int i = 0; i<13; i++) {
		  for (int j = 0; j<13; j++) {
	        	if (tableau[i][j]==1) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.blue);
	        		bouton.setActionCommand("blue");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==2) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==2) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.green);
	        		bouton.setActionCommand("green");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==2) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==3) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.yellow);
	        		bouton.setActionCommand("yellow");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==2) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==4) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.red);
	        		bouton.setActionCommand("red");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==2) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==5) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.magenta);
	        		bouton.setActionCommand("magenta");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==2) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==6) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.ORANGE);
	        		bouton.setActionCommand("orange");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==2) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==7) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.black);
	        		bouton.setActionCommand("black");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==2) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	
	    	}
	  }
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.validate();
	  
	  int compte = compte(tableaujoueur, 1);
	  if (compte>=85) {
		  //this.dispose();
		  Test.victoire(1, compte);
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
	  
	  Random rand = new Random();
	  int k = h;
	  while (k==h) {
		  k = rand.nextInt(6)+1;
	  }
	  
	  if (k==1) {
		  couleur2="blue";
	  }
	  if (k==2) {
		  couleur2="green";
	  }
	  if (k==3) {
		  couleur2="yellow";
	  }
	  if (k==4) {
		  couleur2="red";
	  }
	  if (k==5) {
		  couleur2="magenta";
	  }
	  if (k==6) {
		  couleur2="orange";
	  }
	  
	  joueur2(k);
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
	  
	  tab.removeAll();
	  for (int i = 0; i<13; i++) {
		  for (int j = 0; j<13; j++) {
	        	if (tableau[i][j]==1) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.blue);
	        		bouton.setActionCommand("blue");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==2) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.green);
	        		bouton.setActionCommand("green");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==3) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.yellow);
	        		bouton.setActionCommand("yellow");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==4) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.red);
	        		bouton.setActionCommand("red");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==5) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.magenta);
	        		bouton.setActionCommand("magenta");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	if (tableau[i][j]==6) {
	        		JButton bouton = new JButton("");
	        		bouton.setBackground(Color.ORANGE);
	        		bouton.setActionCommand("orange");
	        		bouton.addActionListener(this);
	        		if (tableaujoueur[i][j]==1) {
	        			bouton.setBorder(new LineBorder(Color.WHITE, 2));
	        		}
	        		tab.add(bouton);
	        	}
	        	
	    	}
	  }
	  this.getContentPane().add(tab, BorderLayout.CENTER);
	  this.validate();
	  
	  int compte = compte(tableaujoueur, 2);
	  if (compte>=85) {
		  //this.dispose();
		  Test.victoire(10, compte);
	  }
	  score2.setText(Integer.toString(compte));
	  
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
		  if (action.getActionCommand()=="blue" && action.getActionCommand()!=couleur2) {
			  couleur1 = "blue";
			  joueur1(1);
		  }
		  if (action.getActionCommand()=="green" && action.getActionCommand()!=couleur2) {
			  couleur1 = "green";
			  joueur1(2);
		  }
		  if (action.getActionCommand()=="yellow" && action.getActionCommand()!=couleur2) {
			  couleur1 = "yellow";
			  joueur1(3);
		  }
		  if (action.getActionCommand()=="red" && action.getActionCommand()!=couleur2) {
			  couleur1 = "red";
			  joueur1(4);
		  }
		  if (action.getActionCommand()=="magenta" && action.getActionCommand()!=couleur2) {
			  couleur1 = "magenta";
			  joueur1(5);
		  }
		  if (action.getActionCommand()=="orange" && action.getActionCommand()!=couleur2) {
			  couleur1 = "orange";
			  joueur1(6);
		  }
	  }
	  if (action.getActionCommand()=="sauvegarde") {
		  sauvegarde();
		  this.dispose();
	  }
	  if (action.getActionCommand()=="explication") {
		  Test.explication();
	  }
  }
  
  public static void tesst() {
	  System.out.println("ok");
  }
  
  public void sauvegarde() {
	  String path = "sauvegardes/partie13carrefa/sauvegarde.txt";
	  String path2 = "sauvegardes/partie13carrefa/sauvegardejoueur.txt";
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
		  
	  }
	  catch (IOException ioe) {
		  System.out.println(ioe.toString());
	  }
  }
}