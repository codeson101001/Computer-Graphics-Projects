//DXM151030


import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.util.*;




public class Tetris extends Frame  {

	


	Tetris() {

	   

      super("TETRIS GAME BY DAVID");

      
      //I used both of these methods provided in Java
      addWindowListener(new WindowAdapter() {

         public void windowClosing(WindowEvent e) {
        	 
        	 System.exit(0);
         
         }

      }
      
);

      
      
      //This is me calling JPanel
      JPanel JPanel = new JPanel();

      JPanel.setLayout(new GridLayout(5, 5));

      setSize(650, 650);

      add("Center", new Sample());

      //This cursor will give the mouse a plus sign
      setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

      //I am setting the cursor to true
      setVisible(true);

   }

   public static void main(String[] args){

	  new Tetris();

   }

   

  

}




//This Sample class can not have a access modifier like public otherwise this code will not run
//Sample is a child class of Canvas
class Sample extends Canvas implements MouseListener,MouseMotionListener{

	//I am using double to store these values
   double pixels, width = 10.0F, height = 10.0F, X= 1000, Y;


   public Sample() {

	  addMouseListener(this);

	    addMouseMotionListener(this);

   }

	   

      
   		//These methods are methods that I will use in the Java Graphics class
   		//They will help with making the pause button light up when hoverened over      
   		public void mousePressed(MouseEvent e) {

            int X =1000; 

            //This repaint method will help me with my shapes
            repaint();

         }

       

         
         //This is the method for when the cursor goes over the Pause button
         public void mouseEntered(MouseEvent e) {

        	Graphics z = getGraphics();

        	z.setColor(Color.blue);

        	z.drawRect(30,80,80,25);

        	z.drawString("Pause",50,95);

        	

         }
         
         
         

         public void mouseExited(MouseEvent e) {

        	Graphics graphics = getGraphics();

        	graphics.setColor(Color.black);

        	graphics.drawString(" ",100,100);

        	repaint();
        	
        	

         }

      
  
         


   


   public void paint(Graphics g) {
	   
	   

	      //This code id for the scoring format	
	      g.setColor(Color.BLACK);

	      g.drawString("Level:", 150, 100);

	      g.drawString("Lines:", 150, 130);

	      g.drawString("Score:" , 150, 160);

	     

	      g.drawString("1", 210, 100);

	      g.drawString("0", 210, 130);

	      g.drawString("0", 210, 160);

	     

	      g.drawString("QUIT", 160,195);

	     
	      //This main rectangle will 10 by 20 squares
	      g.drawRect(15,0,100,200);

	     
	      g.drawRect(140,20,70,40);

	      

	      g.drawRect(140,180,70,20);

	      
	      
	      
	      

	      g.drawString("1", 210, 100);

	      g.drawString("0", 210, 130);

	      g.drawString("0", 210, 160);
	      
	   
	   
	   
	      
	      
	      //RED
	      //Next box: shape

	      //Far left red square
	      
	      g.setColor(Color.red);

	      g.fillRect(160,40,10,10);
	      
	      g.setColor(Color.black);

	      g.drawRect(160,40,10,10);


	     
	      //Middle red square
	      
	      g.setColor(Color.red);

	      g.fillRect(170,40,10,10);

	      g.setColor(Color.black);

	      g.drawRect(170,40,10,10);


	     
	      //Far right red square
	      
	      g.setColor(Color.red);

	      g.fillRect(180,40,10,10);
	      
	      g.setColor(Color.black);

	      g.drawRect(180,40,10,10);


	     
	      //Red square on top of other red square
	      
	      g.setColor(Color.red);

	      g.fillRect(180,30,10,10);
	      
	      g.setColor(Color.black);

	      g.drawRect(180,30,10,10);

	   
	   
	   
	   
	   
	   	 
	    

		     

	      //GREEN SQUARE
	      //The square
	      //Top left
	      g.setColor(Color.green);   

	      g.fillRect(55,15,10,10);
	      
	      g.setColor(Color.black);

	      g.drawRect(55,15,10,10);
	     

	      
	      
	      //Top right
	      g.setColor(Color.green);

	      g.fillRect(65,15,10,10);

	      g.setColor(Color.black);

	      g.drawRect(65,15,10,10);

	      
	      
	      
	      
	      //Bottom right
	      g.setColor(Color.green);

	      g.fillRect(55,25,10,10);
	      
	      g.setColor(Color.black);

	      g.drawRect(55,25,10,10);





	      
	      //Bottom left
	      g.setColor(Color.green);

	      g.fillRect(65,25,10,10);

	      g.setColor(Color.black);

	      g.drawRect(65,25,10,10);



	     

	      
	      //YELLOW
	      // The yellow "Z" shape
	      g.setColor(Color.yellow);

	      g.fillRect(85,190,10,10);

	      g.setColor(Color.black);

	      g.drawRect(85,190,10,10);


	     
	      
	      
	      g.setColor(Color.yellow);

	      g.fillRect(75,190,10,10);

	      g.setColor(Color.black);

	      g.drawRect(75,190,10,10);

	     
	      
	      
	      g.setColor(Color.yellow);

	      g.fillRect(85,180,10,10);

	      g.setColor(Color.black);

	      g.drawRect(85,180,10,10);


	     
	      
	      g.setColor(Color.yellow);

	      g.fillRect(95,180,10,10);


	      g.setColor(Color.black);

	      g.drawRect(95,180,10,10);


	      
	      
	     

	     
	      
	      
	      //BLUE
	      //The blue "L" shape

	      
	      //Bottom Right
	      g.setColor(Color.black);

	      g.drawRect(105,190,10,10);

	      g.setColor(Color.blue);

	      g.fillRect(105,190,10,10);

	     
	      
	      //Middle of three bricks
	      g.setColor(Color.black);

	      g.drawRect(105,180,10,10);

	      g.setColor(Color.blue);

	      g.fillRect(105,180,10,10);


		     

	      
	      //Topmost 
	      g.setColor(Color.black);

	      g.drawRect(105,170,10,10);

	      g.setColor(Color.blue);

	      g.fillRect(105,170,10,10);




	      g.setColor(Color.black);

	      g.drawRect(95,190,10,10);

	      g.setColor(Color.blue);

	      g.fillRect(95,190,10,10);




	     
	      
	      
	      
	      
	      
	      //YELLOW
	      // The yellow "Z" shape
	      g.setColor(Color.yellow);

	      g.fillRect(85,190,10,10);

	      g.setColor(Color.black);

	      g.drawRect(85,190,10,10);


	     
	      
	      
	      g.setColor(Color.yellow);

	      g.fillRect(75,190,10,10);

	      g.setColor(Color.black);

	      g.drawRect(75,190,10,10);

	     
	      
	      
	      g.setColor(Color.yellow);

	      g.fillRect(85,180,10,10);

	      g.setColor(Color.black);

	      g.drawRect(85,180,10,10);


	     
	      
	      g.setColor(Color.yellow);

	      g.fillRect(95,180,10,10);


	      g.setColor(Color.black);

	      g.drawRect(95,180,10,10);


	      
	      
	     

	     
	      
	      
	      
	      
	      

	  
	      

	      //This code id for the scoring format	
	      g.setColor(Color.BLACK);

	      g.drawString("Level: ", 150, 100);

	      g.drawString("Lines: ", 150, 130);

	      g.drawString("Score: " , 150, 160);

	     

	      g.drawString("1", 210, 100);

	      g.drawString("0", 210, 130);

	      g.drawString("0", 210, 160);

	     

	      g.drawString("QUIT", 160,195);

	     
	      //This main rectangle will 10 by 20 squares
	      g.drawRect(15,0,100,200);

	      //The small box for the next shape is shown here
	      g.drawRect(140,20,70,40);

	      

	      g.drawRect(140,180,70,20);


	     

	  }



//These methods are auto provided from one of the classes
//I don not really need these methods and the code will work just fine. I just included them anyway
@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}





@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}





@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}





@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

	 

}











