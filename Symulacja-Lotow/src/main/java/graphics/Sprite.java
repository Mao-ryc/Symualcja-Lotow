package graphics;

public class Sprite {
	
	public int x;
	public int y;
	public int width;
	public int height;
	public SpriteSheet spriteSheet;
	
	public Sprite(int x,int y,int width,int height,SpriteSheet sp) // x - xowa wspó³¿êdna na spritesheetie, y - yowa, sieze - rozmiar sprita
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		spriteSheet = sp;
	}

}
