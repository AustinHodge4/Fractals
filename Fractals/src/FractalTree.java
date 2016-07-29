/**
 * @author Austin Hodge
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FractalTree extends JFrame {
	 
	private static Random rand = new Random();
	private static int _length;
	private static int _angleRange; 
	private static int _depth;
	private static float _scale = 1.0f;
	private static Color[] colors = {Color.RED, Color.BLUE, Color.BLUE, Color.BLACK, Color.DARK_GRAY, Color.GREEN, Color.BLUE, Color.MAGENTA};
	private static Color leftColor, rightColor;
	
	// params { depth(density), angle(branch), length(height), Color index } 
	public FractalTree(int[] params){
		super("Fractal Tree");
		setBounds(0, 0, 800, 700);
		setResizable(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
		_depth = clamp(params[0], 13, 15);
		_angleRange = clamp(params[1], 10, 21);
	    _length = clamp(params[2], 12, 25);
	    
		int index = clamp(params[3], 1, 14)/2;
		
		leftColor = colors[index];

		rightColor = colors[index % 2 == 0 ? Math.floorMod(index+1, 8) : Math.floorMod(index-1, 8)];
		if(_length < 15 && _depth < 15)
			_scale = 1.5f;
		if(_length >= 15 && _depth >= 15){
			_scale = 0.5f;
		}
	}
	
	public void drawTree(Graphics2D g2, Point2D p1, int len, float angle, int depth, float scale){
		// Stopping condition
		if(depth == 0 || len <= 0)
			return;

		// Switch colors at every other depth level
		if(depth % 2 == 0)
			g2.setColor(leftColor);
		else
			g2.setColor(rightColor);
		
		int theta = _angleRange;
		
		// Random angle of new branch 1 - 30
		if(depth % 4 == 0)
			theta = rand.nextInt((30-1) + 1) + 1;
		
		// Random length of new branch 1 - 2
		int randomLength = rand.nextInt((2 - 1) + 1) + 1;
		
		// End point x and y values of the branch multiplied by a scale factor
		double x1 = (len * Math.cos(Math.toRadians(angle))) * scale;
		double y1 = (len * Math.sin(Math.toRadians(angle)))* scale;
		
		// End point
		Point2D.Double p2 = new Point2D.Double((p1.getX() + x1), (p1.getY() + y1));

		// Draw line
		g2.draw(new Line2D.Double(p1, p2));
		// Continue on left side of tree
		drawTree(g2, p2, len - randomLength, angle - theta, depth - 1, scale);
		// Continue on right side of tree
		drawTree(g2, p2, len - randomLength, angle + theta, depth - 1, scale);

	}
	
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		
        drawTree(g2, new Point2D.Double(400, 400), _length*2, -90, _depth, _scale);
        if(_angleRange % 2 == 0 && _length > 13){
        	drawTree(g2, new Point2D.Double(400, 400), _length*2, 0, _depth, _scale);
        	drawTree(g2, new Point2D.Double(400, 400), _length*2, 180, _depth, _scale);
        	drawTree(g2, new Point2D.Double(400, 400), _length*2, 90, _depth, _scale);
        }
        if(_angleRange % 2 == 0 && _length < 13){
        	drawTree(g2, new Point2D.Double(650, 600), _length*2, -90, _depth, _scale);
        	drawTree(g2, new Point2D.Double(150, 600), _length*2, -90, _depth, _scale);
        }
    }

	public int clamp(int n, int r1, int r2){
		if(n <= r1)
			return r1;
		if(n >= r2)
			return r2;
		return n;
	}
}
