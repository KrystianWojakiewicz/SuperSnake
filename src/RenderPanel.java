import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class RenderPanel extends JPanel{

	static int currColor = 0;
	final static Color green =  new Color(1666073);
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(green);
		g.fillRect(0, 0, 500, 500);
		
		if(currColor < 200)
			currColor++;	
	}
}
