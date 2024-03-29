import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class RenderPanel extends JPanel{


	final static Color board =  new Color(0x8CADAE);
	final static Color green = new Color(0xBADA55);
	final static Color red = new Color(0xE40059);
	final static Color appleColor = new Color(0xA02837);
	final static Color pearColor = new Color(0xBADA55);
	final static Color cherryColor = new Color(0xA30262);
	final static Color bananaColor = new Color(0xffff00);
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(board);
		g.fillRect(0, 0, 500, 500);
		
		for(Point snakeElement : Game.snake.snake) {
			g.setColor(green);
			g.fillRect(snakeElement.x * Game.scale, snakeElement.y * Game.scale, Game.scale, Game.scale);
		}
		g.setColor(red);
		g.fillRect(Game.snake.getSnakeHead().x * Game.scale, Game.snake.getSnakeHead().y * Game.scale, 
					Game.scale, Game.scale);
		paintFruit(g);
		
		SnakeGUI.scoreBox.setText("Score: " + Game.score);
	}

	private void paintFruit(Graphics g) {
		if(Game.fruit == null || Game.fruitPos == null) return;
		
		switch(Game.fruit) {
			case APPLE: { g.setColor(appleColor); break; }
			case PEAR: { g.setColor(pearColor); break; }
			case CHERRY: { g.setColor(cherryColor); break; }
			case BANANA: { g.setColor(bananaColor); break; }
			default: break;
		}
		g.fillRect(Game.fruitPos.x * Game.scale, Game.fruitPos.y * Game.scale, Game.scale, Game.scale);
	}
}
