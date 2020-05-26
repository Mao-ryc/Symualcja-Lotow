package world;

import java.util.Random;

import graphics.Screen;
import graphics.Sprite;
import logic.MoneyManager;

public class TransportPlane extends Plane {
	
	private float capacity = 70000;
	private float load = 0;
	
	private Random random = new Random();
	
	float distance = (float)Math.sqrt((desiredX-x)*(desiredX-x) + (desiredY-y)*(desiredY-y));
	
	public TransportPlane(int x,int y,String name,int fuelCapacity,int crewNumber,int speed,Sprite image)
	{
		super(x,y,name,fuelCapacity,crewNumber,speed,image);
		//ustalenie poczatkowych wartosci celu
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
				distance = (float)Math.sqrt((desiredX-x)*(desiredX-x) + (desiredY-y)*(desiredY-y));
			}
			else if(Map.airportWr.id == pickAirport)
			{
				desiredX = Map.airportWr.x;
				desiredY = Map.airportWr.y;
				distance = (float)Math.sqrt((desiredX-x)*(desiredX-x) + (desiredY-y)*(desiredY-y));
			}
			else if(Map.airportWa.id == pickAirport)
			{
				desiredX = Map.airportWa.x;
				desiredY = Map.airportWa.y;
				distance = (float)Math.sqrt((desiredX-x)*(desiredX-x) + (desiredY-y)*(desiredY-y));
			}
			else if(Map.airportPo.id == pickAirport)
			{
				desiredX = Map.airportPo.x;
				desiredY = Map.airportPo.y;
				distance = (float)Math.sqrt((desiredX-x)*(desiredX-x) + (desiredY-y)*(desiredY-y));
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
		calculateEarnings();
	}
	public void render(Screen s)
	{
		s.renderSprite(x, y, image);
	}
	public void calculateEarnings() //oblicza zarobki
	{
		
		
		if((x==Map.airportLu.x && y==Map.airportLu.y) || (x==Map.airportWa.x && y==Map.airportWa.y)|| (x==Map.airportWr.x && y==Map.airportWr.y) || (x==Map.airportPo.x && y==Map.airportPo.y))
		{

			load = (float) (random.nextFloat()*0.2*capacity+0.8*capacity);
		
			float earnings = (MoneyManager.priceForKg*load) - (crewNumber*crewPayment)-(MoneyManager.gasPrice*distance);
		
			MoneyManager.earnings +=earnings;
		}
	}

}
