import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.List;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class a {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a window = new a();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public a() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSlider paintSpeedSlider = new JSlider();
		paintSpeedSlider.setBackground(new Color(245, 222, 179));
		paintSpeedSlider.setBounds(12, 59, 200, 26);
		frame.getContentPane().add(paintSpeedSlider);
		
		JLabel paintSpeedLabel = new JLabel("Painting Speed:");
		paintSpeedLabel.setBounds(12, 13, 109, 32);
		frame.getContentPane().add(paintSpeedLabel);
		
		JSlider snakeSpeedSlider = new JSlider();
		snakeSpeedSlider.setBackground(new Color(245, 222, 179));
		snakeSpeedSlider.setBounds(12, 179, 200, 26);
		frame.getContentPane().add(snakeSpeedSlider);
		
		JLabel snakeSpeedLabel = new JLabel("Snake Speed:");
		snakeSpeedLabel.setBounds(12, 130, 109, 32);
		frame.getContentPane().add(snakeSpeedLabel);
		
		JButton returnBtn = new JButton("Return");
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		returnBtn.setBounds(323, 215, 97, 25);
		frame.getContentPane().add(returnBtn);
	}
}
