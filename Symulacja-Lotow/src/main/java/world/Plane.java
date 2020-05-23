package world;

import java.util.Random;

import graphics.Screen;
import graphics.Sprite;

public abstract class Plane {

	protected String name;
	protected int fuelCapacity;
	protected int crewNumber;
	protected int speed;
	protected Sprite image;
	protected int x,y;
	protected int desiredX ,desiredY;
	
	protected Random random = new Random();
	
	
	public Plane(int x,int y,String name,int fuelCapacity,int crewNumber,int speed,Sprite image)
	{
		this.x = x;
		this.y = y;
		this.name = name;
		this.fuelCapacity = fuelCapacity;
		this.crewNumber = crewNumber;
		this.speed = speed;
		this.image = image;
	}
	public void fly()
	{
		
	}
	public void calculateEarnings()
	{
		
	}
	public void update()
	{
		
	}
	public void render(Screen s)
	{
		
	}
	
}
