package world;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class Map {

	public int WIDTH;
	public int HEIGHT;
	public Sprite background = new Sprite(0,0,SpriteSheet.mapSpriteSheet.WIDTH,SpriteSheet.mapSpriteSheet.HEIGHT,SpriteSheet.mapSpriteSheet);
	public Airport airportWa = new Airport(60, 60, "Wa", 0, 1,true);
	public Airport airportWr = new Airport(270, 50, "Wr", 1, 1,true);
	
	public Map(int mx,int my)
	{
		WIDTH = mx;
		HEIGHT = my;
	}
	public void update()
	{
		
	}
	public void render(Screen s)
	{
		s.renderSprite(0, 0, background);
		airportWa.render(s);
		airportWr.render(s);
	}
}
