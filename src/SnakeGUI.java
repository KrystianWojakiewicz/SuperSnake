import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SnakeGUI implements ActionListener{

	public static JFrame frame;
	public static JLabel scoreBox;
	public static RenderPanel renderPanel;
	
	public static int fps = 10;
	public Timer repaintTimer;

	public SnakeGUI() {
		
		Rectangle screenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		
		frame = new JFrame("Super Snake");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLocation( (screenDim.width - frame.getWidth())/2, (screenDim.height - frame.getHeight())/2 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setPreferredSize(new Dimension(500, 500));
		frame.pack();
		
		renderPanel = new RenderPanel();
		renderPanel.setBounds(0, 0, 500, 500);
		frame.getContentPane().add(renderPanel);
		renderPanel.setLayout(null);
		
		scoreBox = new JLabel();
		scoreBox.setSize(90, 25);
		scoreBox.setBounds(500 - scoreBox.getWidth(),  0, scoreBox.getWidth(), scoreBox.getHeight());
		scoreBox.setText("Score: " + Game.score);
		//scoreBox.setOpaque(true);
		renderPanel.add(scoreBox);
		
		Game.isGameOver = false;
		repaintTimer = new Timer(fps, this);
		repaintTimer.start();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(Game.isGameOver) {
			repaintTimer.stop();
		}
		renderPanel.repaint();
	}
}
