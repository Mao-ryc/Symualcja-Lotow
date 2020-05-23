package world;

import graphics.Screen;
import graphics.Sprite;

public class TransportPlane extends Plane {
	
	private int capacity = 0;
	private int load = 0;
	
	
	public TransportPlane(int x,int y,String name,int fuelCapacity,int crewNumber,int speed,Sprite image)
	{
		super(x,y,name,fuelCapacity,crewNumber,speed,image);
		
		//testy
				desiredX=60;
				desiredY=60;
	}
	public void update()
	{
		//Po wyl¹dowaniu wybiera lotnisko kolejne
		if(x==desiredX && y==desiredY)
		{
			int pickAirport = random.nextInt(4);
			
			if(Map.airportLu.id == pickAirport)
			{
				desiredX = Map.airportLu.x;
				desiredY = Map.airportLu.y;
			}
			else if(Map.airportWr.id == pickAirport)
			{
				desiredX = Map.airportWr.x;
				desiredY = Map.airportWr.y;
			}
			else if(Map.airportWa.id == pickAirport)
			{
				desiredX = Map.airportWa.x;
				desiredY = Map.airportWa.y;
			}
			else if(Map.airportPo.id == pickAirport)
			{
				desiredX = Map.airportPo.x;
				desiredY = Map.airportPo.y;
			}
		}
		
		//Podstawowe poruszanie
		if(desiredX<x)
		{
			x--;
		}
		else if(desiredX>x)
		{
			x++;
		}
		
		if(desiredY<y)
		{
			y--;
		}
		else if(desiredY>y)
		{
			y++;
		}
	}
	public void render(Screen s)
	{
		s.renderSprite(x, y, image);
	}
	public void fly()
	{
		
	}
	public void calculateEarnings()
	{
		
	}

}
