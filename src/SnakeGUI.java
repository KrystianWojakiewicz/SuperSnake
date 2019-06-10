import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SnakeGUI implements ActionListener{

	private JFrame frame;
	private RenderPanel renderPanel;
	public Timer repaintTimer = new Timer(20, this);
	public static Game newGame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnakeGUI window = new SnakeGUI();
					window.frame.setVisible(true);
	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SnakeGUI() {
	
		Rectangle screenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		frame = new JFrame("Super Snake");
		frame.setSize(500, 500);
		frame.setLocation( (screenDim.width - frame.getWidth())/2, (screenDim.height - frame.getHeight())/2 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		renderPanel = new RenderPanel();
		renderPanel.setBounds(0, 0, 500, 500);
		frame.getContentPane().add(renderPanel);
		renderPanel.setLayout(null);	
		
		newGame = new Game(frame);
		
		repaintTimer.start();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		renderPanel.repaint();
	}
}
