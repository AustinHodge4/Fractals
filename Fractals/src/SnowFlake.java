//Java program to draw a von Koch Snowflake
//Created by Lance Allison 3-12-15

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class SnowFlake extends JFrame
{
	int stopCounter = 0;
	int level = 6;
	double m1= 0.6;
	double m2= 0.6;
	double mf = 0.6;
	int n1= 0;
	int n2= 0;
	int n3= 0;
	int n4= 0;
	int c1=125;
	int c2=125;
	int c3=125;
	int cR;
	int cG;
	int cB;
	int stroke =1;
	
	
	int stan;
	
	int x1=160, x2=480, x3=320, y1=360, y2=360, y3=80;

	public SnowFlake(int[] startNum)
	{
	
		
		 n1 = startNum[0];
		
		 n2 = startNum[1];
		
		 n3 = startNum[2];
		 
		 n4 = startNum[3];
		 
		
	     JPanel jp = new JPanel();
	     jp.setBackground(Color.BLACK);
	     add(jp);				 
		 setVisible(true);		 
		 setSize(800, 600);
		 

		 
		 createVaiables();
	}


	public void createVaiables()
	{
		
		if(n3>14)
		{
		   c1=25;
		   c2=25;
		   c3=25;		
		}
		
		
		else if(n3>9)
		{
		   c1=25;
		   c2=125;
		   c3=25;		
		}
		else if(n3>2)
		{
		   c1=125;
		   c2=125;
		   c3=15;
			
		}
		
		
		 if(n4> 21)
			 m1 = n4/11;
		 else if(n4 > 15)
			 m1 = n4/8.5;
	     else if(n4>10)	
	    	 m1 = n4/7;
	     else if(n4>6)	
	    	 m1 = n4/3;
	     else if(n4<6)	
	    	 m1 = n4/3;
		 
		 if(n2 > 19)
			 level = 2;
		 else if(n2 > 11)
			 level = 3;
	     else if(n2 >6)	
	    	 level = 3;
	     else if(n2 >4)	
	    	 level = 3;
	     else if(n2 >0)	
	    	 level = 4; 
	    	 	    	 

		 mf = n4/9.45;
		 
		 m2 = m1; 
		
		c1 += n2*5;
		c2 += n3*5;
		c3 += n4*5;
	 
	}
	
	

	public void paint(Graphics g)
	{

		
//************************************************************************************************		

	    
		Point pointOne1 = new Point(470, 320);
		Point pointTwo1 = new Point(790, 320);	// reusing Points from example program * 2;
		Point pointThree1 = new Point(620, 20);
		
		stroke = 2;
		cR=c1;
	    cG=250;
	    cB=c2;
		drawSnowFlake(g, level, pointOne1, pointTwo1, pointThree1);

		
//************************************************************************************************	
		Point pointOne2 = new Point(120, 620);
		Point pointTwo2 = new Point(440, 620);	// reusing Points from example program * 2;
		Point pointThree2 = new Point(280, 340);
		
		cR=255;
	    cG=c1;
	    cB=c3;
		drawSnowFlake(g, level, pointOne2, pointTwo2, pointThree2);
		
//************************************************************************************************	
		
		
		Point pointOne3 = new Point(470, 620);
		Point pointTwo3 = new Point(790, 620);	// reusing Points from example program * 2;
		Point pointThree3 = new Point(620, 340);
		
		cR=c1;
	    cG=c2;
	    cB=255;
		drawSnowFlake(g, level, pointOne3, pointTwo3, pointThree3);
//************************************************************************************************		
		
		Point pointOne4 = new Point(20, 300);
		Point pointTwo4 = new Point(340, 300);	// reusing Points from example program * 2;
		Point pointThree4 = new Point(150, 20);
		
		cR=c1;
	    cG=50;
	    cB=c3;
		drawSnowFlake(g, level, pointOne4, pointTwo4, pointThree4);
		
//************************************************************************************************			
		

		cR=255;
	    cG=c2;
	    cB=255;
	    
		Point pointOne5 = new Point(5, 550);
		Point pointTwo5 = new Point(750, 550);	// reusing Points from example program * 2;
		Point pointThree5 = new Point(550, 5);
		
		drawSnowFlake(g, level, pointOne5, pointTwo5, pointThree5);		
		
//************************************************************************************************			
		

		cR=15;
	    cG=c1;
	    cB=130;
	    
		Point pointOne6 = new Point(200, 550);
		Point pointTwo6 = new Point(650, 550);	// reusing Points from example program * 2;
		Point pointThree6 = new Point(550, 200);
		
		drawSnowFlake(g, level, pointOne6, pointTwo6, pointThree6);		
		
//************************************************************************************************	

		cR=255;
	    cG=c3;
	    cB=75;
	    
		Point pointOne7 = new Point(200, 200);
		Point pointTwo7 = new Point(650, 200);	// reusing Points from example program * 2;
		Point pointThree7 = new Point(550, 5);
		
		drawSnowFlake(g, level, pointOne7, pointTwo7, pointThree7);		
		
//************************************************************************************************		
		cR=133;
	    cG=c1;
	    cB=255;
	    
		Point pointOne8 = new Point(5, 300);
		Point pointTwo8 = new Point(100, 300);	// reusing Points from example program * 2;
		Point pointThree8 = new Point(100,50);
		
		drawSnowFlake(g, level, pointOne8, pointTwo8, pointThree8);		
		
//************************************************************************************************		
		cR=10;
	    cG=c2;
	    cB=20;
	    
		Point pointOne9 = new Point(700, 600);
		Point pointTwo9 = new Point(650, 600);	// reusing Points from example program * 2;
		Point pointThree9 = new Point(10, 500);
		
		drawSnowFlake(g, level, pointOne9, pointTwo9, pointThree9);		
		
//************************************************************************************************		
		
		Point pointOne = new Point(220, 400);
		Point pointTwo = new Point(540, 400);	// reusing Points from example program * 2;
		Point pointThree = new Point(370, 120);
		level = 5;
		stroke = 4;
		cR=255;
	    cG=255;
	    cB=255;
	    m1 = mf;
	    m2 = mf;
	    
		drawSnowFlake(g, level, pointOne, pointTwo, pointThree);
	
		
	}

	
	private void drawSnowFlake(Graphics g, int lev,
                              Point p1, Point p2, Point p3)
	{
	
		drawSegment(g, lev, p1, p2);	// draw 3 lines to make a triangle
		drawSegment(g, lev, p2, p3);
		drawSegment(g, lev, p3, p1);
	
	}
	

	
	private void drawSegment(Graphics g, int lev, Point pOne, Point pTwo)
	{
		if (lev == 0)
		{
			 Graphics2D g2 = (Graphics2D)g;
			
			g.drawLine(pOne.x, pOne.y, pTwo.x, pTwo.y);
			
			}
		if (lev >= 1){
		Point distance = new Point( (pTwo.x-pOne.x)/3, (pTwo.y-pOne.y)/3 );
       Point pA = new Point( pOne.x+distance.x, pOne.y+distance.y);
       Point pB = new Point( pTwo.x-distance.x, pTwo.y-distance.y);
			double sin60 = -0.866025403784438646763723170752936183471402626905190;
       Point pTip = new Point(
       	pA.x + (int)(distance.x * m1 + distance.y*sin60),
       	pA.y + (int)(distance.y * m2 - distance.x*sin60)
       );
      
        Graphics2D g2 = (Graphics2D)g;
      
          g.setColor(new Color(cR,cG,cB));
           
          g2.setStroke(new BasicStroke(stroke));

          
			drawSegment(g, lev - 1, pOne, pA);	// if level 1 or higher,
			drawSegment(g, lev - 1, pA, pTip);	// recursively call self 4 times
			drawSegment(g, lev - 1, pTip, pB);	
			drawSegment(g, lev - 1, pB, pTwo);
			 
				
		}
	}
}