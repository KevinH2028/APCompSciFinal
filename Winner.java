import java.awt.*;
import BreezyGUI.*;

public class Winner extends GBFrame {
	public Image player;
	private Dimension wind = this.getSize();
	Winner (Image play){
		player = play;
	}
	public void paint(Graphics g) {
		Font font = new Font("Arial", Font.PLAIN, 100);
		g.setFont(font);
		g.drawString("The winner is ", 30, 150);
		
		player.draw(g, 700, 40, 250, 250);
		
		Image playAgain;
		playAgain = new Image("playAgain.jpeg");
		playAgain.draw(g, 150, 325, 400, 75);
		
		wind = this.getSize();
		if(wind.width < 500)
			this.setSize(500, wind.height);
		g.setColor(Color.black);
		g.fillRect(0, wind.height-40, 75, 40);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString("Exit", 10, wind.height-10);
		
	}
	public void mouseClicked(int x, int y) {
		
		if (x >= 150 && x <= 550 && y >= 325 && y <= 400)
		{	
			super.dispose();
			Frame frm = new boardColor(); 
			frm.setSize (1500, 750); //Set the application's window width and height in pixels
			frm.setVisible (true); //Make the window visible to the user
		}
		if(x >= 0 && x <= 75 && y >= wind.height-40 && y <= wind.height)
			super.dispose();
		
	}
}