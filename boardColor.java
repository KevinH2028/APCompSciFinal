import java.awt.*;
import BreezyGUI.GBFrame;

public class boardColor extends GBFrame{
	private int start = 120;
	private int boxSize = start - 10;
	private Color[] colors = {Color.red, Color.orange, Color.green, Color.cyan, Color.blue, Color.magenta, Color.gray};
	boardColor() {
		
	}
	
	public void paint (Graphics g) {
		Font font = new Font("Arial", Font.PLAIN, 70);
		g.setFont(font);
		g.drawString("Which color would you like? ", 30, 90);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(boxSize/10));
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < colors.length-row*3 && col < 3; col++) {
				int x = col * start + boxSize;
				int y = row * start + boxSize;
				g.setColor(colors[row*3+col]);
				g.fillRect(x, y, boxSize, boxSize);
				
				g.setColor(Color.black);
				g.drawRoundRect(x-5, y-5, start, start, 20, 20);
			}
		}
		
		g.fillRect(0, this.getSize().height-40, 75, 40);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString("Exit", 10, this.getSize().height-10);
	}
		
	public void mouseClicked(int x, int y) {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < colors.length-row*3 && col < 3; col++) {
				if(x >= start*col+boxSize && x <= start*col+(boxSize*2) && y >= start*row+boxSize && y <= start*row+(boxSize*2)) {
					try {
						Thread.sleep(150);
					} catch (Exception e) { e.printStackTrace(); }
					super.dispose();
					Frame frm = new Icon(colors[row*3+col]);
					frm.setSize(1000, 600);
					frm.setVisible(true);
				}
			}
		}
		if(x >= 0 && x <= 75 && y >= this.getSize().height-40 && y <= this.getSize().height)
			super.dispose();
	}
}
