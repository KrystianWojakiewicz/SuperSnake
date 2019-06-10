import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;



enum Direction {
	UP,
	DOWN,
	LEFT,
	RIGHT,
}

public class Game implements Runnable{
	public Game(JFrame mainFrame) {
		//Setup Action for Binding//
		Action MoveUp = new AbstractAction(){
			        
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent e){
							
			            }
		};
			    
		Action MoveDown = new AbstractAction(){
	        
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e){
						
		            }
		};
	
		Action MoveLeft = new AbstractAction(){
	        
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e){
						
		            }
		};
	
		Action MoveRight = new AbstractAction(){
	        
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e){
						
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
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	Direction checkInputFromUser() {
		while(true) {
			
		}
	}
}

