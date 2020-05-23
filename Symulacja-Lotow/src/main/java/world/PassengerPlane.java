package world;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class PassengerPlane extends Plane {

	private int number_of_seats_in_First_class;
	private int number_of_seats_in_Biznes_class;
	private int number_of_seats_in_Eco__class;
	private int seats_taken_in_First_class;
	private int seats_taken_in_Biznes_class;
	private int seats_taken_in_Eco_class;
	private int whole_baggage;
	
	public PassengerPlane(int x,int y,String name,int fuelCapacity,int crewNumber,int speed,Sprite image)
	{
		super(x,y,name,fuelCapacity,crewNumber,speed,image);
		
		//testy
		desiredX=170;
		desiredY=140;
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
