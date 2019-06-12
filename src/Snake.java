import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;




import javax.swing.JButton;
import javax.swing.JFrame;



public class Snake {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Point> snake = new ArrayList<>();
	
	public Point getSnakeHead() {
		try {
			return snake.get(0);
		} catch(IndexOutOfBoundsException e) { }
		return new Point();
		
	}
	
	public Snake() {
		
	}
}
