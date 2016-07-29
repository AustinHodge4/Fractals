/*
 * This class will generate a 4 element array based off of
 * letters.
 * 
 */
import javax.swing.*;

@SuppressWarnings("serial")
public class FractalClient  extends JApplet{
	/* Cool names to try: nick, zach, nicole, chris, frank,
						  adam, phil, heca, lizzie, west, lance
	*/
	private static String _name = "";
	private static int[] _output = new int[4];
	
	// d e n j q z
	private static int[] _treeFractal = {10,5,4,14,26,17};
	// x i f g k c v 
	private static int[] _circleFractal = {3,11,7,9,22,6,24};
	// a y p s h b
	private static int[] _squareFractal = {1,19,2,8,16,25};
	// w r t u o l m
	private static int[] _snowFractal = {13,12,18,20,23,15,21};
	
	public static void main(String[] args) {
		while(true){
			try{
				_name = JOptionPane.showInputDialog("Enter Name: ");
				computeName();
				selectFractal();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
	}

	public static void computeName(){
		for(int i = 0; i < 4; i++){
			char c = _name.charAt(i);
			int a = Character.getNumericValue(c);
			a -= 9;
			_output[i] = a;
		}
	}
	public static void selectFractal()
	{
		for(int i = 0; i < 6; i++)
		{
			if(_output[0] == _treeFractal[i])
			{
				// Draw Trees
				new FractalTree(_output).setVisible(true);
			}
			else if(_output[0] == _squareFractal[i])
			{
				// Draw Squares
				new FractalSquare(_output).setVisible(true);
			}
			
			if(i < 7)
			{
				if(_output[0] == _snowFractal[i])
				{
					// Draw Snow Flake
					new SnowFlake(_output).setVisible(true);
				}
				else if(_output[0] == _circleFractal[i])
				{
					// Draw Circles
					new Circle(_output).setVisible(true);
				}
			}
		}
	}
}
