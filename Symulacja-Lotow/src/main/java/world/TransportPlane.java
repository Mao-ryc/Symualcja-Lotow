package world;

import graphics.Screen;
import graphics.Sprite;

public class TransportPlane extends Plane {
	
	private int capacity = 0;
	private int load = 0;
	
	
	public TransportPlane(int x,int y,String name,int fuelCapacity,int crewNumber,int speed,Sprite image)
	{
		super(x,y,name,fuelCapacity,crewNumber,speed,image);
	}
	public void update()
	{
		
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
