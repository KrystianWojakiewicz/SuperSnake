import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SnakeGUI implements ActionListener{

	public static JFrame frame;
	public static RenderPanel renderPanel;
	
	public static Snake snake = new Snake();
	private static int fps = 50;
	public Timer repaintTimer = new Timer(fps, this);

	public SnakeGUI() {
	
		Rectangle screenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		
		frame = new JFrame("Super Snake");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setLocation( (screenDim.width - frame.getWidth())/2, (screenDim.height - frame.getHeight())/2 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		renderPanel = new RenderPanel();
		renderPanel.setBounds(0, 0, 500, 500);
		frame.getContentPane().add(renderPanel);
		renderPanel.setLayout(null);
		
		repaintTimer.start();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		renderPanel.repaint();
	}
}
