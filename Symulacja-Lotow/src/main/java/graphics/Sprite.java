package graphics;

public class Sprite {
	
	int x;
	int y;
	int width;
	int height;
	SpriteSheet spriteSheet;
	
	public Sprite(int x,int y,int width,int height,SpriteSheet sp) // x - xowa wspó³¿êdna na spritesheetie, y - yowa, sieze - rozmiar sprita
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		spriteSheet = sp;
	}

}
