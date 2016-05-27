import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.Color;

public class boutonhexa extends JButton {
	public boutonhexa(String str) {
		super(str);
	}
	
	int[] x = {0, 1, 2, 1, 0, 2};
	int[] y = {0, 0, 1, 2, 2, 1};
	
	public void paintComponent(Graphics g){
		g.setColor(Color.orange);
	    g.fillPolygon(x, y, 6);
	    g.drawPolygon(x, y, 6);
	  }
}
