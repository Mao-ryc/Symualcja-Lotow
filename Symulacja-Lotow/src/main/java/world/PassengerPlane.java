package world;

import java.util.Random;

import Core.Main;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;
import logic.MoneyManager;

public class PassengerPlane extends Plane {

	private int number_of_seats_in_First_class = 20;
	private int number_of_seats_in_Biznes_class = 80;
	private int number_of_seats_in_Eco__class = 100;
	private int seats_taken_in_First_class;
	private int seats_taken_in_Biznes_class;
	private int seats_taken_in_Eco_class;
	private int whole_baggage;
	private float priceForBaggageKg= 3;
	
	private float distance;
	
	private Random random = new Random();
	
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
		
		float distance = (float)Math.sqrt((desiredX-x)*(desiredX-x) + (desiredY-y)*(desiredY-y));
		
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
	public void fly()
	{
		
	}
	public void calculateEarnings()
	{
		if((x==Map.airportLu.x && y==Map.airportLu.y) || (x==Map.airportWa.x && y==Map.airportWa.y)|| (x==Map.airportWr.x && y==Map.airportWr.y) || (x==Map.airportPo.x && y==Map.airportPo.y))
		{
			switch(MoneyManager.concentratinonOfPeople)
			{
			case 1:	seats_taken_in_Eco_class = random.nextInt((int)(number_of_seats_in_Eco__class*0.5)); 
					seats_taken_in_Biznes_class = random.nextInt((int)(number_of_seats_in_Biznes_class*0.5));
					seats_taken_in_First_class = random.nextInt((int)(number_of_seats_in_First_class*0.5));
					break;
			case 2:	seats_taken_in_Eco_class = (int) (random.nextInt((int)(number_of_seats_in_Eco__class*0.4))+0.3*number_of_seats_in_Eco__class); 
					seats_taken_in_Biznes_class = (int) (random.nextInt((int)(number_of_seats_in_Biznes_class*0.4))+0.3*number_of_seats_in_Biznes_class);
					seats_taken_in_First_class = (int) (random.nextInt((int)(number_of_seats_in_First_class*0.4))+0.3*number_of_seats_in_First_class);
					break;
			case 3:seats_taken_in_Eco_class = (int) (random.nextInt((int)(number_of_seats_in_Eco__class*0.3))+0.7*number_of_seats_in_Eco__class); 
					seats_taken_in_Biznes_class = (int) (random.nextInt((int)(number_of_seats_in_Biznes_class*0.5))+0.7*number_of_seats_in_Biznes_class);
					seats_taken_in_First_class = (int) (random.nextInt((int)(number_of_seats_in_First_class*0.5))+0.7*number_of_seats_in_First_class);
					break;
			}
			whole_baggage = random.nextInt(10000);
			
			
			float earnings = ((seats_taken_in_Biznes_class * MoneyManager.bTicketsPricePerKm*distance)+(seats_taken_in_Eco_class * MoneyManager.eTicketsPricePerKm*distance)+ (seats_taken_in_First_class* MoneyManager.fTicketsPricePerKm*distance)+(whole_baggage*priceForBaggageKg))-(MoneyManager.gasPrice*distance)-(crewNumber*crewPayment);                                                     
			
			MoneyManager.earnings +=earnings;
		}
	}
}
