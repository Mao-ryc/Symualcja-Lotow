package world;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class Map {

	public int WIDTH;
	public int HEIGHT;
	public Sprite background = new Sprite(0,0,SpriteSheet.mapSpriteSheet.WIDTH,SpriteSheet.mapSpriteSheet.HEIGHT,SpriteSheet.mapSpriteSheet);
	
	public Map(int mx,int my)
	{
		
	}
	public void update()
	{
		
	}
	public void render(Screen s)
	{
		s.renderSprite(0, 0, background);
	}
}
