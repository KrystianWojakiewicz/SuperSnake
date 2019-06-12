import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu {

	public static JFrame frame;
	
	public static SnakeGUI snakeGUI;
	public static RenderPanel gameBoard;
	public static HighScoreFrame highscore;
	
	
	public Menu() {
		Rectangle screenDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		
		frame = new JFrame("Welcome to Super Snake");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLocation( (screenDim.width - frame.getWidth())/2, (screenDim.height - frame.getHeight())/2 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel menu = new JPanel();
		frame.getContentPane().add(menu, "Menu");
		menu.setLayout(null);
		
		
		
		JButton newGameBtn = new JButton("New Game");
		newGameBtn.setBounds(173, 60, 124, 42);
		menu.add(newGameBtn);
		
		JButton settingsBtn = new JButton("Settings");
		settingsBtn.setBounds(173, 109, 124, 42);
		menu.add(settingsBtn);
		
		JButton highScoreBtn = new JButton("High Score");
		highScoreBtn.setBounds(173, 164, 124, 42);
		menu.add(highScoreBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(173, 219, 124, 42);
		menu.add(exitBtn);
		
		
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		newGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SnakeGUI snakeGUI = new SnakeGUI();
				Game newGame = new Game();
				frame.setVisible(false);
			}
		});
		
		highScoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				highscore = new HighScoreFrame();
				frame.setVisible(false);
			}
		});
		
		settingsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Settings settings = new Settings();
				frame.setVisible(false);
			}
		});
	}
}
