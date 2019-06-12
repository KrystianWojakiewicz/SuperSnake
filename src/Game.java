import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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
	public static Menu menu;
	
	public final static int scale = 20;
	public static int score = 0;
	public static boolean isGameOver = false;
	
	public static int fps = 130;
	Timer moveTimer;
	
	public static List<HighScore> scores = new ArrayList<>();
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu = new Menu();
					//window = new SnakeGUI();
					//Game myGame = new Game();
	
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
		
		isGameOver = false;
		
		snake.snake.add( new Point(SnakeGUI.renderPanel.getX() + 3, SnakeGUI.renderPanel.getY()) );
		snake.snake.add( new Point(SnakeGUI.renderPanel.getX() + 2, SnakeGUI.renderPanel.getY()) );
		snake.snake.add( new Point(SnakeGUI.renderPanel.getX() + 1, SnakeGUI.renderPanel.getY()) );
		snake.snake.add( new Point(SnakeGUI.renderPanel.getX(), SnakeGUI.renderPanel.getY()) );
		
		moveTimer = new Timer(fps, this);
		moveTimer.start();
	}
	
	
	void moveUp() {
		
		Point currentHeadPos = snake.getSnakeHead();
		Point[] temp = new Point[2];
		
		for(int i = 0; i < snake.snake.size(); i++) {
			if(i == 0) {
				temp[0] = currentHeadPos;
				snake.snake.set(0, new Point(currentHeadPos.x, currentHeadPos.y - 1));
				continue;
			}
			else {
				temp[1] = snake.snake.get(i);
				snake.snake.set(i, new Point(temp[0].x, temp[0].y));
				temp[0] = temp[1];
			}
		}
	}
	
	void moveDown() {
		
		Point currentHeadPos = snake.getSnakeHead();
		Point[] temp = new Point[2];
		
		for(int i = 0; i < snake.snake.size(); i++) {
			if(i == 0) {
				temp[0] = currentHeadPos;
				snake.snake.set(0, new Point(currentHeadPos.x, currentHeadPos.y + 1));
				continue;
			}
			else {
				temp[1] = snake.snake.get(i);
				snake.snake.set(i, new Point(temp[0].x, temp[0].y));
				temp[0] = temp[1];
			}
		}
	}
	
	void moveLeft() {
		
		Point currentHeadPos = snake.getSnakeHead();
		Point[] temp = new Point[2];
		
		for(int i = 0; i < snake.snake.size(); i++) {
			if(i == 0) {
				temp[0] = currentHeadPos;
				snake.snake.set(0, new Point(currentHeadPos.x - 1, currentHeadPos.y));
				continue;
			}
			else {
				temp[1] = snake.snake.get(i);
				snake.snake.set(i, new Point(temp[0].x, temp[0].y));
				temp[0] = temp[1];
			}
		}
	}
	
	void moveRight() {
		
		Point currentHeadPos = snake.getSnakeHead();
		Point[] temp = new Point[2];
		
		for(int i = 0; i < snake.snake.size(); i++) {
			if(i == 0) {
				temp[0] = currentHeadPos;
				snake.snake.set(0, new Point(currentHeadPos.x + 1, currentHeadPos.y));
				continue;
			}
			else {
				temp[1] = snake.snake.get(i);
				snake.snake.set(i, new Point(temp[0].x, temp[0].y));
				temp[0] = temp[1];
			}	
		}
	}
	
	public void actionPerformed(ActionEvent e) {

		if(fruitPos == null) {
			fruit = pickRandomFruit();
			fruitPos = pickRandomPoint();
		}
		
		if(checkDeath() ){
			isGameOver = true;
			moveTimer.stop();
			JOptionPane.showMessageDialog(null, "Oops. You Lost!");
			scores.add(new HighScore("Krysh97", score));
			snake.snake.clear();
			
			HighScoreFrame.scorelist.add("Krysh:     \t" + score);
			
			SnakeGUI.frame.setVisible(false);
			Menu.frame.setVisible(true);
		}
		
		if(checkFruitColl()) {
			score++;
			fruitPos = null;
			
			addNewElement();
		}
		move();
	}

	private boolean checkDeath() {
		if(snake.getSnakeHead().x >= SnakeGUI.renderPanel.getWidth()/scale)
			return true;
		
		if(snake.getSnakeHead().x < 0)
			return true;
		
		if(snake.getSnakeHead().y >= SnakeGUI.renderPanel.getHeight()/scale)
			return true;
		
		if(snake.getSnakeHead().y < 0)
			return true;
			
		for(int i = 1; i < snake.snake.size(); i++) {
			if(snake.getSnakeHead().equals(snake.snake.get(i)))
				return true;
		}
		return false;
	}

	private void addNewElement() {
		Point nextLastElement = snake.snake.get(snake.snake.size() - 2);
		Point lastElement = snake.snake.get(snake.snake.size() - 1);
		Point newElement = null;
		
		if( nextLastElement.x < lastElement.x) {
			newElement = new Point(lastElement.x + 1, lastElement.y);
		}
		else if(nextLastElement.x > lastElement.x) {
			newElement = new Point(lastElement.x - 1, lastElement.y);
		}
		else if(nextLastElement.y < lastElement.y) {
			newElement = new Point(lastElement.x, lastElement.y + 1);
		}
		else if(nextLastElement.y > lastElement.y) {
			newElement = new Point(lastElement.x, lastElement.y - 1);
		}
		if(newElement != null)
			snake.snake.add(newElement);
	}

	private Fruit pickRandomFruit() {
		Random rnd = new Random();
		return Fruit.values()[rnd.nextInt(Fruit.values().length)];
	}
	
	private Point pickRandomPoint() {
		Random rnd = new Random();
		Point randomPoint = new Point(-1, -1);
		boolean flag = true;
		while(flag) {
			flag = false;
			randomPoint = new Point(rnd.nextInt(SnakeGUI.renderPanel.getWidth()/scale), 
									rnd.nextInt(SnakeGUI.renderPanel.getHeight()/scale));
			for (Point snakeElement : snake.snake) {
				if(snakeElement.equals(randomPoint)) {
					flag = true;
					break;
				}
			}
		}
		return randomPoint;
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
			if(direction !=Direction.DOWN)
				direction = Direction.UP;
		}
	};
				    
	Action MoveDown = new AbstractAction(){
		        
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			if(direction !=Direction.UP)
				direction = Direction.DOWN;
		}
	};
		
	Action MoveLeft = new AbstractAction(){
		        
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			if(direction !=Direction.RIGHT)
				direction = Direction.LEFT;
		}
	};
		
	Action MoveRight = new AbstractAction(){
		        
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			if(direction !=Direction.LEFT)
				direction = Direction.RIGHT;
		}
	};
			
	//Setup Input for Binding//
	KeyStroke upArrow = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
	KeyStroke downArrow = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
	KeyStroke leftArrow = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
	KeyStroke rightArrow = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
}

