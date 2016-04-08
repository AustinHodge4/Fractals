/** Adam Miles */
import java.awt.*;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FractalSquare extends JFrame
{
	private static int color[] = {0,0,0,254,0,0,0,10};
	private static int var[] = {2,0,0,0};
	private static int theNums[];
	
	public FractalSquare(int[] clientLetters)
	{
		super("Squares");
		setBounds(100,100,800,600);
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		theNums = clientLetters;
	}
	
	public void myMethod(int[] fourLetters)
	{
/** first letter *///even is filled squares, odd is square outline
		var[1] = fourLetters[0]%2;
/** second letter *///change color
		if(fourLetters[1] <= 8)//A-H make more red
		{
			color[0] = 254;
			color[4] = fourLetters[2];
			color[1] = fourLetters[3];
			color[5] = 1;
			color[2] = fourLetters[3];
			color[6] = 1;
		}
		else if(fourLetters[1] > 8 && fourLetters[1] <= 17)//I-Q make more green
		{
			color[0] = fourLetters[3];
			color[4] = 1;
			color[1] = 254;
			color[5] = fourLetters[2];
			color[2] = fourLetters[3];
			color[6] = 1;
		}
		else//R-Z make more blue
		{
			color[0] = fourLetters[3];
			color[4] = 1;
			color[1] = fourLetters[3];
			color[5] = 1;
			color[2] = 254;
			color[6] = fourLetters[2];
		}
/** third letter *///pick starting size of side length
		var[2] = (fourLetters[2]*16)+184;
		
/** fourth letter *///shift and minimum size
		var[3] = (fourLetters[3] / 4) + 1;//end case, lower is more squares
		if(fourLetters[3]%2 == 1)//if fourth letter is odd, positive shift
		{
			var[0] = fourLetters[1]/3 + 1;
		}
		else
		{
			var[0] = -1*(fourLetters[2]/3 + 1);
		}
	// color[] = {R,G,B,A,shift R, shift G, shift B, shift A}
	// var[0] = {distance from starting point can't be (-1, 0, 1), should be (-10 -> 10), all 2s is perfect image}
	// var[1] = make square outlines if == 1
	// var[2] = side length//200-600
	// var[3] = {sets end-case for recursion, based on side length so.. 
				//the smaller the number, the more and smaller rectangles created, can't be negative}
				//should be 0-10, pref 0-6
	}
	
    public void paint(Graphics g) 
	{
		myMethod(theNums);
		int sideLength = var[2];
	    int startX = ((800-sideLength)/2);//centers square
	    int startY = ((600-sideLength)/2);//according to 800x600 dimensions
		drawSquares(g, startX, startY, sideLength, sideLength, var, color);//
	}
	
	private void drawSquares(Graphics g, int xCoor, int yCoor, int width, int height, int[] var, int[] color)
	{
		if(var[1] == 1)
		{
			if(width <= (var[3]*15) && height <= (var[3]*15))
				return;
			else
			{
				Color d = new Color(color[0],color[1],color[2],color[3]);//create a color from color array
				g.setColor(d);//sets next rectangles color
				Graphics2D g2 = (Graphics2D)g;
				g2.setStroke(new BasicStroke(4));
				g.drawRect(xCoor, yCoor, width, height);//draws rectangle
				color[0] = (color[0]+color[4])%255;//shift colors 
				color[1] = (color[1]+color[5])%255;//use modulus to stay within RGB parameters
				color[2] = (color[2]+color[6])%255;
				color[3] = (color[3]+color[7])%255;//shift transparency 
				drawSquares(g, xCoor + width, yCoor + (height/(4*var[0])), (width*3/4), (height*3/4), var, color);
				drawSquares(g, xCoor - (width*3/(2*var[0])), yCoor + (height/(4*var[0])), (width*3/4), (height*3/4), var, color);
				drawSquares(g, xCoor + (width/(4*var[0])), yCoor + (height/(4*var[0])), ((width*3)/4), ((height*3)/4), var, color);
				//drawSquares(g, xCoor + (width/(2*var[0])), yCoor + height, (width*3/4), (height*3/4), var, color);
			}
		}
		else
		{
			if(width <= var[3] && height <= var[3])//if height and width fall below threshold, stop recursion 
				return;//stopping case
			else
			{
				Color c = new Color(color[0],color[1],color[2],color[3]);//create a color from color array
				g.setColor(c);//sets next rectangles color
				g.fillRect(xCoor, yCoor, width, height);//draws rectangle
				color[0] = (color[0]+color[4])%255;//shift colors 
				color[1] = (color[1]+color[5])%255;//use modulus to stay within RGB parameters
				color[2] = (color[2]+color[6])%255;
				color[3] = (color[3]+color[7])%255;//shift transparency 
				drawSquares(g, xCoor + width, yCoor + (height/(2*var[0])), (width/2), (height/2), var, color);//move x to the right 1 unit, and y down 1/(2x)
				drawSquares(g, xCoor - (width/var[0]), yCoor + (height/(2*var[0])), (width/2), (height/2), var, color);//move x to the left 1/x, and y down 1/(2x)
				drawSquares(g, xCoor + (width/(2*var[0])), yCoor - (height/var[0]), (width/2), (height/2), var, color);//move x to the right 1/(2x) unit, and y up 1/x
				drawSquares(g, xCoor + (width/(2*var[0])), yCoor + height, (width/2), (height/2), var, color);//move x to the right 1/(2x) unit, and y down 1 unit
			}
		}
          
	}
}