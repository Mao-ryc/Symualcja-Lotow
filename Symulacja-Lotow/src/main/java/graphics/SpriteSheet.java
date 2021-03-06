package graphics;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public static final SpriteSheet BcSpriteSheet = new SpriteSheet("resource/bc_Menu.png"); 
	public static final SpriteSheet mainSpriteSheet = new SpriteSheet("resource/mainSpriteSheet.png");
	public static final SpriteSheet mapSpriteSheet = new SpriteSheet("resource/Map.png");
	
	public  int WIDTH,HEIGHT;
	public  int[] pixels;
	
	public SpriteSheet(String path)
	{
		try
		{
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			WIDTH = image.getWidth();
			HEIGHT = image.getHeight();
			pixels = new int[WIDTH * HEIGHT];
			
			image.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
