import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;




enum Direction {
	UP,
	DOWN,
	LEFT,
	RIGHT,
}

public class Game implements ActionListener{
	
	Direction direction = Direction.RIGHT;
	Snake snake;
	static int scale = 10;
	static int fps = 1000;
	JFrame mainFrame;
	Timer moveTimer = new Timer(20, this);
	
	public Game(JFrame mainFrame) {
		
		snake = new Snake(mainFrame);
		
		//Setup Action for Binding//
		Action MoveUp = new AbstractAction(){
			        
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent e){
						direction = Direction.UP;
						JButton snakeHead = snake.snake.get(snake.snake.size() - 1);
						Rectangle currentHeadPos = snakeHead.getBounds();
						snakeHead.setBounds(currentHeadPos.x, currentHeadPos.y - scale, currentHeadPos.width, currentHeadPos.height);
			    }
		};
			    
		Action MoveDown = new AbstractAction(){
	        
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e){
				direction = Direction.DOWN;
				JButton snakeHead = snake.snake.get(snake.snake.size() - 1);
				Rectangle currentHeadPos = snakeHead.getBounds();
				snakeHead.setBounds(currentHeadPos.x, currentHeadPos.y + scale, currentHeadPos.width, currentHeadPos.height);
		    }
		};
	
		Action MoveLeft = new AbstractAction(){
	        
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e){
				direction = Direction.LEFT;
				JButton snakeHead = snake.snake.get(snake.snake.size() - 1);
				Rectangle currentHeadPos = snakeHead.getBounds();
				snakeHead.setBounds(currentHeadPos.x - scale, currentHeadPos.y, currentHeadPos.width, currentHeadPos.height);
		    }
		};
	
		Action MoveRight = new AbstractAction(){
	        
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e){
				direction = Direction.RIGHT;
				JButton snakeHead = snake.snake.get(snake.snake.size() - 1);
				Rectangle currentHeadPos = snakeHead.getBounds();
				snakeHead.setBounds(currentHeadPos.x + scale, currentHeadPos.y, currentHeadPos.width, currentHeadPos.height);
		    }
		};
		
		//Setup Input for Binding//
		KeyStroke upArrow = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
		KeyStroke downArrow = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
		KeyStroke leftArrow = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
		KeyStroke rightArrow = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
		
		((JComponent) mainFrame.getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(upArrow, "up");
		((JComponent) mainFrame.getContentPane()).getActionMap().put("up", MoveUp);
		
		((JComponent) mainFrame.getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(downArrow, "down");
		((JComponent) mainFrame.getContentPane()).getActionMap().put("down", MoveDown);
		
		((JComponent) mainFrame.getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(leftArrow, "left");
		((JComponent) mainFrame.getContentPane()).getActionMap().put("left", MoveLeft);
		
		((JComponent) mainFrame.getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(rightArrow, "right");
		((JComponent) mainFrame.getContentPane()).getActionMap().put("right", MoveRight);
	}
	// EOF Constructor
	
	void moveUp() {
		JButton snakeHead = snake.snake.get(snake.snake.size() - 1);
		Rectangle currentHeadPos = snakeHead.getBounds();
		snakeHead.setBounds(currentHeadPos.x, currentHeadPos.y - scale, currentHeadPos.width, currentHeadPos.height);
	}
	
	void moveDown() {
		JButton snakeHead = snake.snake.get(snake.snake.size() - 1);
		Rectangle currentHeadPos = snakeHead.getBounds();
		snakeHead.setBounds(currentHeadPos.x, currentHeadPos.y + scale, currentHeadPos.width, currentHeadPos.height);
	}
	
	void moveLeft() {
		JButton snakeHead = snake.snake.get(snake.snake.size() - 1);
		Rectangle currentHeadPos = snakeHead.getBounds();
		snakeHead.setBounds(currentHeadPos.x - scale, currentHeadPos.y, currentHeadPos.width, currentHeadPos.height);
	}
	
	void moveRight() {
		JButton snakeHead = snake.snake.get(snake.snake.size() - 1);
		Rectangle currentHeadPos = snakeHead.getBounds();
		snakeHead.setBounds(currentHeadPos.x + scale, currentHeadPos.y, currentHeadPos.width, currentHeadPos.height);
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (direction) {
			case UP: { moveUp(); break; }
			case DOWN: { moveDown(); break; }
			case LEFT: { moveLeft(); break; }
			case RIGHT: { moveRight(); break; }
			default: JOptionPane.showMessageDialog(new JFrame(), "Unknown Input");
		}
	}
}

