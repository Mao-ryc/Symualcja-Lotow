package simstate;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;
import world.Map;

public class S_World extends SimState{
	
	public Map map;
	
	//chwilowo
	public static final Sprite plane = new Sprite(0,1,16,16,SpriteSheet.mainSpriteSheet);
	//
	
	public S_World()
	{
		map = new Map(320, 180);
	}
	public void update()
	{
		
	}
	public void render(Screen s)
	{
		map.render(s);
		s.renderSprite(40, 40, plane);
	}
}
