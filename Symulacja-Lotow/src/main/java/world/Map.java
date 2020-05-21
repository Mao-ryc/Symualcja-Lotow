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
	
	public PassengerPlane planeP = new PassengerPlane(60, 60, "Boeing", 100000, 5, 900, new Sprite(0, 0, 16, 16, SpriteSheet.mainSpriteSheet));
	public TransportPlane planeT = new TransportPlane(270, 50, "Transporter", 100000, 2, 850, new Sprite(1, 0, 16, 16, SpriteSheet.mainSpriteSheet));
	
	public Map(int mx,int my)
	{
		WIDTH = mx;
		HEIGHT = my;
	}
	public void update()
	{
		planeP.update();
		planeT.update();
	}
	public void render(Screen s)
	{
		s.renderSprite(0, 0, background);
		airportWa.render(s);
		airportWr.render(s);
		planeP.render(s);
		planeT.render(s);
	}
}
