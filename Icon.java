import java.awt.*;
import BreezyGUI.*;

public class Icon extends GBFrame {
	private Color color;
	public Image board, player1, player2;
	private Dimension wind = this.getSize();
	Icon (Color boardColor){
		color = boardColor;
	}
	public void paint (Graphics g) {
		Font font = new Font("Arial", Font.PLAIN, 70);
		g.setFont(font);
		g.drawString("Which Icon would you like? ", 30, 100);
		board = new Image("tictactoeIcon.png");
		board.draw(g, 100, 150);
		
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
		if (x >= 100 && x <= 400 && y >= 150 && y <= 300) {
			try {
				Thread.sleep(150);
			} catch (Exception e) { e.printStackTrace(); }
			super.dispose();
			player1 = new Image("tictactoeX.png");
			player2 = new Image("tictactoeO.png");
			Frame frm = new TheGUIPart(color, player1, player2);
			//frm.setSize(500, 600);
			frm.setVisible(true);
		}
		if(x >= 0 && x <= 75 && y >= wind.height-40 && y <= wind.height)
			super.dispose();
	}
}
