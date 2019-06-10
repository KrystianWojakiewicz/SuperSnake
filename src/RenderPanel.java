import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class RenderPanel extends JPanel{

	static int currColor = 0;
	final static Color green =  new Color(1666073);
	final static Color red = new Color(0xE40059);
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(green);
		g.fillRect(0, 0, 500, 500);
		
		for(Point snakeElement : Game.snake.snake) {
			g.setColor(red);
			g.fillRect(snakeElement.x * Game.scale, snakeElement.y * Game.scale, Game.scale, Game.scale);
		}
	}
}
