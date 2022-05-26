import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Image {
	
	BufferedImage image;
	
	public Image(String name){
		try {
			image = ImageIO.read(new File(name));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g, int x, int y){
		g.drawImage(image, x, y, null);
	}
	
	public void draw(Graphics g, int x, int y, int w, int h){
		g.drawImage(image, x, y, w, h, null);
	}
	
	public BufferedImage getBufferedImage(){
		return image;
	}
}
