package graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {
	
	private final int WIDTH; 
	private final int HEIGHT;
	
	private BufferedImage image;
	private int[] pixels;
	
	public Screen(int w,int h)
	{
		WIDTH = w;
		HEIGHT = h;
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	}
	/**
	 * metoda czyszcz¹ca ekran
	 * @param color
	 */
	public void clear(int color) 
	{
		for(int i=0;i<WIDTH*HEIGHT;i++)
		{
			pixels[i] = color;
		}
	}
	/**
	 *  metoda wyswietla grafike
	 * @param px 
	 * @param py 
	 * @param 
	 */
	public void renderSprite(int px,int py, Sprite s) 
	{
		for(int y=0;y<s.height;y++)
		{
			for(int x=0;x<s.width;x++)
			{
				pixel(px+x,py+y,s.spriteSheet.pixels[s.x * s.width + x + (s.y * s.height +y)*s.spriteSheet.WIDTH]);
			}
		}
	}
	public BufferedImage getImage()
	{
		return image;
	}
	private void pixel(int x,int y,int color)
	{
		if(x<0 || x>=WIDTH || y<0 || y>=HEIGHT || color == 0xFFFF00FF)
			return;
		pixels[x+y * WIDTH] = color;
	}

}
