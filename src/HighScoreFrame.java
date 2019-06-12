import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class HighScoreFrame {
	
	public static JFrame frame;
	public static List scorelist = new List();
	
	public HighScoreFrame() {
		Rectangle screenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		
		frame = new JFrame("Super Snake");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLocation( (screenDim.width - frame.getWidth())/2, (screenDim.height - frame.getHeight())/2 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setPreferredSize(new Dimension(450, 340));
		frame.pack();
		
		
		JButton returnBtn = new JButton("Return");
		returnBtn.setBounds(323, 215, 97, 25);
		frame.getContentPane().add(returnBtn);
		

		scorelist.setBounds(0, 27, 300, 226);
		frame.getContentPane().add(scorelist);
		
		JLabel lblHighScores = new JLabel("High Scores");
		lblHighScores.setBounds(12, 0, 99, 21);
		frame.getContentPane().add(lblHighScores);
		
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Menu.frame.setVisible(true);
			}
		});
	}
}
