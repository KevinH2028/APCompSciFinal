import java.awt.*;
import BreezyGUI.*;

public class TheGUIPart extends GBFrame {
	private int[][] board;
	private int size;
	private boolean isWhiteTurn;
	private Color color;
	private Image player1, player2;
	private int boxSize = 200;
	private Dimension wind = this.getSize();

	TheGUIPart(Color boardColor, Image play1, Image play2) {
		player1 = play1;
		player2 = play2;
		color = boardColor;
		this.setSize(boxSize*5, boxSize*5);
		size = 3;
		board = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				board[row][col] = 0;
			}
		}
		isWhiteTurn = true;
	}

	public void paint(Graphics g) {
		wind = this.getSize();
		if(wind.width < 1000)
			this.setSize(1000, wind.height);
		if(wind.height < 1000)
			this.setSize(wind.width, 1000);
		int x, y;
		g.setFont(new Font("Arial", Font.PLAIN, (int)(boxSize*2.0/5.0)));
		g.drawString("TicTacToe", (int)(boxSize*1.6), (int)(boxSize*(3.0/4.0)));
		g.setColor(color);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(boxSize/12));
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				x = col * boxSize + boxSize;
				y = row * boxSize + boxSize;
				g.drawRoundRect(x, y, boxSize, boxSize, 20, 20);
				if (board[row][col] == -1) {
					player1.draw(g, x + (int)(boxSize/5.0), y + (int)(boxSize/5.0), (int)(boxSize*(3.0/5.0)), (int)(boxSize*(3.0/5.0)));
				} else if (board[row][col] == 1) {
					player2.draw(g, x + (int)(boxSize/5.0), y + (int)(boxSize/5.0), (int)(boxSize*(3.0/5.0)), (int)(boxSize*(3.0/5.0)));
				}
			}
		}
		
		g.setColor(Color.black);
		g.fillRect(0, wind.height-40, 75, 40);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString("Exit", 10, wind.height-10);
		
		
		boolean p1Win = player1();
		boolean p2Win = player2();
		boolean tie = noWinner();
		if (p1Win||p2Win) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			super.dispose(); //Get's rid of old board
			Frame win;
			if(p1Win)
				win = new Winner(player1);
			else
				win = new Winner(player2);
		    win.setSize (1000, 450); //Sets window size
		    win.setVisible(true); //Sets win window visible to user
		}
		
		else if(tie) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			super.dispose(); //Get's rid of old board
			
		    Frame win = new WinnerNA();
		    win.setSize (1000, 450); //Sets window size
		    win.setVisible(true); //Sets win window visible to user
		}
	}
	
	public boolean player1 () {
		for(int i = 0; i < 3; i++) {
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] == -1)
				return true;
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == -1)
				return true;
		}
		if(((board[0][0] == board[1][1] && board[1][1] == board[2][2])||(board[0][2] == board[1][1] && board[1][1] == board[2][0])) && board[1][1] == -1)
			return true;
		
		return false;
	}

	public boolean player2 () {
		for(int i = 0; i < 3; i++) {
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] == 1)
				return true;
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == 1)
				return true;
		}
		if(((board[0][0] == board[1][1] && board[1][1] == board[2][2])||(board[0][2] == board[1][1] && board[1][1] == board[2][0])) && board[1][1] == 1)
			return true;
		
		return false;
	}
	
	public boolean noWinner () {
		if(board[0][0] != 0 && board[1][0] != 0 && board[2][0] != 0 &&
			board[0][1] != 0 && board[1][1] != 0 && board[2][1] != 0 &&
			board[0][2] != 0 && board[1][2] != 0 && board[2][2] != 0 )
			return true;
		
		return false;
	}
	
	public void mouseClicked(int x, int y) {
		int row = (y - boxSize) / boxSize;
		int col = (x - boxSize) / boxSize;
		if(x >= 0 && x <= 75 && y >= wind.height-40 && y <= wind.height)
			super.dispose();
		if (row < 0 || row >= size || col < 0 || col >= size || x < boxSize) {
			return; // clicked off the board
		}
		if (board[row][col] != 0) {
			return; // square already full
		}
		if (isWhiteTurn) {
			board[row][col] = -1;
			isWhiteTurn = !isWhiteTurn; // change turns
		} else  {
			board[row][col] = 1;
			isWhiteTurn = !isWhiteTurn; // change turns
		}
		
		repaint();
	}
}


