package world;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;
import logic.MoneyManager;

public class Map {

	public int WIDTH;
	public int HEIGHT;
	public Sprite background = new Sprite(0,0,SpriteSheet.mapSpriteSheet.WIDTH,SpriteSheet.mapSpriteSheet.HEIGHT,SpriteSheet.mapSpriteSheet);
	public static final Airport airportWa = new Airport(60, 60, "Wa", 0, 1,true);
	public static final Airport airportWr = new Airport(270, 50, "Wr", 1, 1,true);
	public static final Airport airportLu = new Airport(170, 140, "Lu", 2, 1,true);
	public static final Airport airportPo = new Airport(160, 30, "Po", 3, 1,true);
	
	
	public Plane[] planesP = new Plane[10];
	public Plane[] planesT = new Plane[10];
	
	
	public Map(int mx,int my)
	{
		WIDTH = mx;
		HEIGHT = my;
		for(int i=0;i<MoneyManager.nr_of_PassengerPlanes;i++)
		{
			planesP[i] = new PassengerPlane(60, 60, "Boeing", 100000, 5, 900, new Sprite(0, 0, 16, 16, SpriteSheet.mainSpriteSheet));
		}
		for(int i=0;i<MoneyManager.nr_of_TransportPlanes;i++)
		{
			planesT[i] = new TransportPlane(270, 50, "Transporter", 100000, 2, 850, new Sprite(1, 0, 16, 16, SpriteSheet.mainSpriteSheet)); 
		}
		
	}
	public void update()
	{
		for(int i=0; i<MoneyManager.nr_of_PassengerPlanes;i++)
		{
			planesP[i].update();
		}
		for(int i=0; i<MoneyManager.nr_of_TransportPlanes;i++)
		{
			planesT[i].update();
		}
	}
	public void render(Screen s)
	{
		s.renderSprite(0, 0, background);
		airportWa.render(s);
		airportWr.render(s);
		airportLu.render(s);
		airportPo.render(s);
		
		for(int i=0; i<MoneyManager.nr_of_PassengerPlanes;i++)
		{
			planesP[i].render(s);
		}
		for(int i=0; i<MoneyManager.nr_of_TransportPlanes;i++)
		{
			planesT[i].render(s);
		}
	}
}
