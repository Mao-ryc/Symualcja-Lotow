package graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class Screen {
	
	public final int WIDTH; 
	public final int HEIGHT;
	
	private BufferedImage image;
	private int[] pixels;
	
	public Screen(int w,int h)
	{
		WIDTH = w;
		HEIGHT = h;
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	}
	public void clear(int color)
	{
		for(int i=0;i<WIDTH*HEIGHT;i++)
		{
			pixels[i] = color;
		}
	}
	public void renderSprite(int px,int py,Sprite s)
	{
		
	}
	public BufferedImage getImage()
	{
		return image;
	}

}
