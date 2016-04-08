import java.awt.*;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Circle extends JFrame {
	 
	private static Color[] colors = {Color.RED, Color.BLUE, Color.WHITE, Color.BLACK, Color.GREEN};
	private static Color leftColor, rightColor;
	private static int size;
	private boolean drawAllDirections = false;
	
	public Circle(int[] letters){
		
		setSize(800,600);
		setBackground(Color.WHITE);
		setResizable(false);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    size = letters[0] * 80;
	    if(letters[2] % 2 != 0){
	    	leftColor = colors[0];
	    	rightColor = colors[1];
	    }
	    else
	    {
	    	leftColor = colors[3];
	    	rightColor = colors[4];
	    }
	    if(letters[1] % 2 == 0)
	    	drawAllDirections = true;
	    
	}
	
//	public void addColor(Color letter1){
//		
//		if (letter1[0] <= 9){
//			
//			colors[0] = letter1[0];
//			colors[4] = letter1[]
//		}
		
	
	
	public void paint (Graphics graphics)
	{
	    int radius=size; //radius of first circle
	    int xMid=400, yMid=300; //center point (x,y) of circle

	    //draw invisible line
	    //graphics.drawLine(0,250,500,250);

	    //draw first circle
	    //graphics.drawOval(xMid-radius,yMid-radius,radius*2,radius*2);

	    Graphics2D g2 = (Graphics2D)graphics;
	    //run fractal algorithm to draw 2 circles to the left and right
	    g2.setStroke(new BasicStroke(2.0f));
	    drawCircles(g2, xMid, yMid, radius, radius);

	}

	void drawCircles (Graphics2D graphics, int xMid, int yMid, int radius, int depth)
	{
//		int x1 = xMid-radius-(radius/2);
//		int x2 = xMid+radius-(radius/2);
//		int x3 = xMid+radius+(radius/2);
//		int x4 = xMid-radius+(radius/2);
//		int y = yMid-(radius/2);

		if(radius < 5)
			return;
		
		if(depth % 2 == 0)
			graphics.setColor(leftColor);
		else
			graphics.setColor(rightColor);
		
		     //draw 4 circles
		graphics.drawOval(xMid - radius, yMid - radius, radius*2, radius*2);
		
		if(!drawAllDirections){
			//left
			drawCircles(graphics, xMid-radius, yMid, radius / 2, depth-1);
			//right
			drawCircles(graphics, xMid+radius, yMid, radius / 2, depth-1);  
			// up
			drawCircles(graphics, xMid, yMid-radius, radius / 2, depth-1);
			//down
			drawCircles(graphics, xMid, yMid+radius, radius / 2, depth-1);  
		}
		else
		{
			//left
			//graphics.setColor(leftColor);
			drawCircles(graphics, xMid-radius, yMid, radius / 2, depth-1);
			//right
			//graphics.setColor(rightColor);
			drawCircles(graphics, xMid+radius, yMid, radius / 2, depth-1);  
		}
		
	}
}