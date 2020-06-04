package world;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;
import logic.MoneyManager;

public class Map {

	private int WIDTH;
	private int HEIGHT;
	private Sprite background = new Sprite(0,0,SpriteSheet.mapSpriteSheet.WIDTH,SpriteSheet.mapSpriteSheet.HEIGHT,SpriteSheet.mapSpriteSheet);
	 
	
	public Airport[] airports = new Airport[4];
	private Plane[] planesP = new Plane[10];
	private Plane[] planesT = new Plane[10];
	
	
	public Map(int mx,int my)
	{
		WIDTH = mx;
		HEIGHT = my;
		
		//dodanie odpowiedniej ilosci samolotow i lotnisk
		for(int i=0;i<MoneyManager.nr_of_PassengerPlanes;i++)
		{
			planesP[i] = new PassengerPlane(60, 60, "Boeing", 100000, 5, 900, new Sprite(0, 0, 16, 16, SpriteSheet.mainSpriteSheet));
		}
		for(int i=0;i<MoneyManager.nr_of_TransportPlanes;i++)
		{
			planesT[i] = new TransportPlane(270, 50, "Transporter", 100000, 2, 850, new Sprite(1, 0, 16, 16, SpriteSheet.mainSpriteSheet)); 
		}
		airports[0] = new Airport(60, 60, "Wa", 0, 1);
		airports[1] = new Airport(270, 50, "Wr", 1, 1);
		airports[2] = new Airport(170, 140, "Lu", 2, 1);
		airports[3] = new Airport(160, 30, "Po", 3, 1);
		
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
		for(int i=0;i<4;i++)
		{
			airports[i].render(s);
		}
		
		if(MoneyManager.nr_of_PassengerPlanes>0)
		{
			for(int i=0; i<MoneyManager.nr_of_PassengerPlanes;i++)
			{
				planesP[i].render(s);
			}
		}
		if(MoneyManager.nr_of_TransportPlanes>0)
		{
			for(int i=0; i<MoneyManager.nr_of_TransportPlanes;i++)
			{
				planesT[i].render(s);
			}
		}
	}
}
