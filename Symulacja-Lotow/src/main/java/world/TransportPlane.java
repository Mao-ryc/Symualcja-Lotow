package world;

import java.util.Random;

import Core.StateManager;
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
			
			if(StateManager.simState.map.airportLu.id == pickAirport)
			{
				desiredX = StateManager.simState.map.airportLu.x;
				desiredY = StateManager.simState.map.airportLu.y;
				distance = (float)Math.sqrt((desiredX-x)*(desiredX-x) + (desiredY-y)*(desiredY-y));
			}
			else if(StateManager.simState.map.airportWr.id == pickAirport)
			{
				desiredX = StateManager.simState.map.airportWr.x;
				desiredY = StateManager.simState.map.airportWr.y;
				distance = (float)Math.sqrt((desiredX-x)*(desiredX-x) + (desiredY-y)*(desiredY-y));
			}
			else if(StateManager.simState.map.airportWa.id == pickAirport)
			{
				desiredX = StateManager.simState.map.airportWa.x;
				desiredY = StateManager.simState.map.airportWa.y;
				distance = (float)Math.sqrt((desiredX-x)*(desiredX-x) + (desiredY-y)*(desiredY-y));
			}
			else if(StateManager.simState.map.airportPo.id == pickAirport)
			{
				desiredX = StateManager.simState.map.airportPo.x;
				desiredY = StateManager.simState.map.airportPo.y;
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
		//
		
		if((x==StateManager.simState.map.airportLu.x && y==StateManager.simState.map.airportLu.y) || (x==StateManager.simState.map.airportWa.x && y==StateManager.simState.map.airportWa.y)|| (x==StateManager.simState.map.airportWr.x && y==StateManager.simState.map.airportWr.y) || (x==StateManager.simState.map.airportPo.x && y==StateManager.simState.map.airportPo.y))
		{

			load = (float) (random.nextFloat()*0.2*capacity+0.8*capacity);
		
			float earnings = (MoneyManager.priceForKg*load) - (crewNumber*crewPayment)-(MoneyManager.gasPrice*distance);
		
			MoneyManager.earnings +=earnings;
		}
	}

}
