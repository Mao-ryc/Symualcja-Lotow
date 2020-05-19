package simstate;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;
import world.Map;

public class S_World extends SimState{
	
	public Map map;
	
	public S_World()
	{
		map = new Map(320, 180);
	}
	public void update()
	{
		map.update();
	}
	public void render(Screen s)
	{
		map.render(s);
	}
}
