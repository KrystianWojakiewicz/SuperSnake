import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

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


public class Game implements ActionListener {
	
	Direction direction = Direction.RIGHT;
	
	public static Fruit fruit;
	public static Point fruitPos;
	
	public static Snake snake = new Snake();
	public static SnakeGUI window;
	
	public final static int scale = 15;
	public static int score = 0;
	public static int tick = 0;
	
	private static int fps = 100;
	Timer moveTimer = new Timer(fps, this);
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new SnakeGUI();
					Game myGame = new Game();
	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Game() {
		
		((JComponent) SnakeGUI.frame.getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(upArrow, "up");
		((JComponent) SnakeGUI.frame.getContentPane()).getActionMap().put("up", MoveUp);
		
		((JComponent) SnakeGUI.frame.getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(downArrow, "down");
		((JComponent) SnakeGUI.frame.getContentPane()).getActionMap().put("down", MoveDown);
		
		((JComponent) SnakeGUI.frame.getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(leftArrow, "left");
		((JComponent) SnakeGUI.frame.getContentPane()).getActionMap().put("left", MoveLeft);
		
		((JComponent) SnakeGUI.frame.getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(rightArrow, "right");
		((JComponent) SnakeGUI.frame.getContentPane()).getActionMap().put("right", MoveRight);
		
		snake.snake.add( new Point(SnakeGUI.renderPanel.getX(), SnakeGUI.renderPanel.getY()) );
		
		moveTimer.start();
	}
	
	
	void moveUp() {
		
		Point currentHeadPos = snake.getSnakeHead();
		snake.snake.set(0, new Point(currentHeadPos.x, currentHeadPos.y - 1));
	}
	
	void moveDown() {
		
		Point currentHeadPos = snake.getSnakeHead();
		snake.snake.set(0, new Point(currentHeadPos.x, currentHeadPos.y + 1));
	}
	
	void moveLeft() {
		
		Point currentHeadPos = snake.getSnakeHead();
		snake.snake.set(0, new Point(currentHeadPos.x - 1, currentHeadPos.y));
	}
	
	void moveRight() {
		
		Point currentHeadPos = snake.getSnakeHead();
		snake.snake.set(0, new Point(currentHeadPos.x + 1, currentHeadPos.y));
	}
	
	public void actionPerformed(ActionEvent e) {
		tick++;
		if(tick % 50 == 0) {
			fruit = pickRandomFruit();
			fruitPos = pickRandomPoint();
		}
		
		System.out.println(direction);
		//checkDeath();
		if(checkFruitColl()) {
			score++;
			fruitPos = null;
		}
		move();
	}

	private Fruit pickRandomFruit() {
		Random rnd = new Random();
		return Fruit.values()[rnd.nextInt(Fruit.values().length)];
	}
	
	private Point pickRandomPoint() {
		Random rnd = new Random();
		return new Point(rnd.nextInt(SnakeGUI.renderPanel.getWidth()/scale), rnd.nextInt(SnakeGUI.renderPanel.getHeight()/scale));
	}
	
	private void move() {
		
		switch (direction) {
			case UP: { moveUp(); break; }
			case DOWN: { moveDown(); break; }
			case LEFT: { moveLeft(); break; }
			case RIGHT: { moveRight(); break; }
			default: break;
		}
	}

	private boolean checkFruitColl() {
		if(snake.getSnakeHead().equals(fruitPos)) {
			return true;
		}
		return false;
	}
	
	//Setup Action for Binding//
	Action MoveUp = new AbstractAction(){
				        
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			direction = Direction.UP;
		}
	};
				    
	Action MoveDown = new AbstractAction(){
		        
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			direction = Direction.DOWN;
		}
	};
		
	Action MoveLeft = new AbstractAction(){
		        
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			direction = Direction.LEFT;
		}
	};
		
	Action MoveRight = new AbstractAction(){
		        
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			direction = Direction.RIGHT;
		}
	};
			
	//Setup Input for Binding//
	KeyStroke upArrow = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
	KeyStroke downArrow = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
	KeyStroke leftArrow = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
	KeyStroke rightArrow = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
}

