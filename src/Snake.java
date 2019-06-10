import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JFrame;



public class Snake extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<JButton> snake = new ArrayList<>();
	public JButton snakeHead;
	
	public Snake(JFrame mainFrame) {
		snakeHead = new JButton("");
		snakeHead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		snakeHead.setBackground(Color.RED);
		snakeHead.setForeground(Color.RED);
		snakeHead.setBounds(100, 100, 20, 20);
		snake.add(snakeHead);
		
		mainFrame.getContentPane().add(snakeHead);
	}
}
