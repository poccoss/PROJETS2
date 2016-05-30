import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream; 


public class Victoire extends JFrame {

	
  public Victoire(String nom, int h){
	  this.setTitle("victoire");
	  this.setSize(650, 300);
	  //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  
	  JPanel joueur = new JPanel();
	  joueur.setLayout(new BoxLayout(joueur, BoxLayout.LINE_AXIS));
	  JLabel numjoueur = new JLabel("");
	  numjoueur.setText(nom+" a gagné avec");
	  numjoueur.setHorizontalAlignment(JLabel.CENTER);
	  numjoueur.setFont(new Font("Tahoma", Font.BOLD, 40));
	  joueur.add(numjoueur);
	  
	  JPanel score = new JPanel();
	  score.setLayout(new BoxLayout(score, BoxLayout.LINE_AXIS));
	  JLabel numscore = new JLabel("");
	  numscore.setText(Integer.toString(h));
	  numscore.setHorizontalAlignment(JLabel.CENTER);
	  numscore.setFont(new Font("Tahoma", Font.BOLD, 50));
	  score.add(numscore);
	  
	  JPanel avec = new JPanel ();
	  avec.setLayout(new BoxLayout(avec, BoxLayout.LINE_AXIS));
	  JLabel motavec = new JLabel("avec");
	  motavec.setHorizontalAlignment(JLabel.CENTER);
	  motavec.setFont(new Font("Tahoma", Font.BOLD, 40));
	  avec.add(motavec);
	  
	  JPanel cases = new JPanel ();
	  cases.setLayout(new BoxLayout(cases, BoxLayout.LINE_AXIS));
	  JLabel motcases = new JLabel("cases !");
	  motcases.setHorizontalAlignment(JLabel.CENTER);
	  motcases.setFont(new Font("Tahoma", Font.BOLD, 40));
	  cases.add(motcases);
	  
	  
	  JPanel fin = new JPanel();
	  //On définit le layout en lui indiquant qu'il travaillera en ligne
	  fin.setLayout(new BoxLayout(fin, BoxLayout.PAGE_AXIS));
	  fin.add(joueur);
	  fin.add(avec);
	  fin.add(score);
	  fin.add(cases);

	  
	  
	  this.getContentPane().add(fin);
	  this.setVisible(true);
  }
}