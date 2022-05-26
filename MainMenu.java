import java.awt.*;
import BreezyGUI.GBFrame;

public class MainMenu extends GBFrame {
	private Dimension wind = this.getSize();
	private int mainWid = wind.width/2-250;
	private int gameWid = wind.width/2-150;
	MainMenu() {
		this.setSize(1500, 750);
	}
	
	
	public void paint(Graphics g) {
		//draw boxes
		wind = this.getSize();
		if(wind.width < 500)
			this.setSize(500, wind.height);
		mainWid = wind.width/2-250;
		gameWid = wind.width/2-150;
		g.setColor(Color.black);
		g.fillRect(mainWid, 20, 500, 150);
		
		g.fillRect(0, wind.height-40, 75, 40);
		
		g.setColor(Color.blue);
		g.fillRect(gameWid, 250, 300, 100);
		g.fillRect(gameWid, 400, 300, 100);
		
		// Draw words
		Font font = new Font("Arial", Font.PLAIN, 70);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Main Menu", mainWid+70, 120);
		
		font = new Font("Arial", Font.PLAIN, 50);
		g.setFont(font);
		g.drawString("3DTest", gameWid+65, 320);
		g.drawString("TicTacToe", gameWid+30, 470);
		
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString("Exit", 10, wind.height-10);
	}
	
	public void mouseClicked(int x, int y) {
		if(x >= gameWid && x <= gameWid+300 && y >= 250 && y <= 350) {
			super.dispose();
			Frame frm = new ThreeDTest();
			frm.setSize(1500, 750);
			frm.setVisible(true);
		}
		if(x >= gameWid && x <= gameWid+300 && y >= 400 && y <= 500) {
			super.dispose();
			Frame frm = new boardColor();
			frm.setSize(1500, 750);
			frm.setVisible(true);
		}
		if(x >= 0 && x <= 75 && y >= wind.height-40 && y <= wind.height)
			super.dispose();
	}
}