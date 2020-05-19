package world;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class Airport {

	public int x;
	public int y;
	public String name;
	public int id;
	public int nr_of_runways;
	public Sprite icon;
	public Plane[] planes;
	public boolean isActive;
	
	public Airport(int x, int y,String name, int id,int nr_of_runways,boolean isActive)
	{
		this.x =x;
		this.y = y;
		this.name = name;
		this.id=id;
		this.nr_of_runways = nr_of_runways;
		this.isActive = isActive;
		icon = new Sprite(2,0,16,16,SpriteSheet.mainSpriteSheet);
	}
	public void update()
	{
		
	}
	
	public void render(Screen s)
	{
		if(isActive)
		{
			s.renderSprite(x, y, icon);
		}
	}
	
	
	
}
