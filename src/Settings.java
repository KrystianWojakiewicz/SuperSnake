import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Settings {
	public static JFrame frame;
	private final static int SNAKE_SLIDER_MAX = 100;
	private final static int PAINT_SLIDER_MAX = 600;
	
	public Settings() {
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
		
		JSlider paintSpeedSlider = new JSlider();
		paintSpeedSlider.setMaximum(PAINT_SLIDER_MAX);
		paintSpeedSlider.setBackground(new Color(245, 222, 179));
		paintSpeedSlider.setBounds(12, 59, 200, 40);
		paintSpeedSlider.setMajorTickSpacing(200);
		paintSpeedSlider.setMinorTickSpacing(50);
		paintSpeedSlider.setPaintTicks(true);
		paintSpeedSlider.setPaintLabels(true);
		
		paintSpeedSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
			    if (!source.getValueIsAdjusting()) {
			        SnakeGUI.fps = PAINT_SLIDER_MAX - (int)source.getValue();
			        System.out.println("SnakeGUI.fps: " + SnakeGUI.fps);
			    }
			}
			
		});
		
		frame.getContentPane().add(paintSpeedSlider);
		
		JLabel paintSpeedLabel = new JLabel("Painting Speed:");
		paintSpeedLabel.setBounds(12, 13, 109, 32);
		frame.getContentPane().add(paintSpeedLabel);
		
		JSlider snakeSpeedSlider = new JSlider();
		snakeSpeedSlider.setMaximum(SNAKE_SLIDER_MAX);
		snakeSpeedSlider.setBackground(new Color(245, 222, 179));
		snakeSpeedSlider.setBounds(12, 179, 200, 40);
		snakeSpeedSlider.setMajorTickSpacing(50);
		snakeSpeedSlider.setMinorTickSpacing(10);
		snakeSpeedSlider.setPaintTicks(true);
		snakeSpeedSlider.setPaintLabels(true);
		
		snakeSpeedSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
			    if (!source.getValueIsAdjusting()) {
			        Game.fps = SNAKE_SLIDER_MAX - (int)source.getValue();
			        System.out.println("Game.fps: " + Game.fps);
			    }
			}
			
		});
		
		frame.getContentPane().add(snakeSpeedSlider);
		
		JLabel snakeSpeedLabel = new JLabel("Snake Speed:");
		snakeSpeedLabel.setBounds(12, 130, 109, 32);
		frame.getContentPane().add(snakeSpeedLabel);
		
		JButton returnBtn = new JButton("Return");
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		returnBtn.setBounds(323, 215, 97, 25);
		frame.getContentPane().add(returnBtn);
	}
}
