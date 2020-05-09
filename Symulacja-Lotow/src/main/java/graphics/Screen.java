package graphics;

import java.awt.image.BufferedImage;

public class Screen {
	
	public final int WIDTH; 
	public final int HEIGHT;
	
	private BufferedImage image;
	private int[] pixels;
	
	public Screen(int w,int h)
	{
		WIDTH = w;
		HEIGHT = h;
	}

}
