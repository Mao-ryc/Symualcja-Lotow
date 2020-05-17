package simstate;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class S_Menu extends SimState{

	public  Sprite s_background = new Sprite(0,0,SpriteSheet.BcSpriteSheet.WIDTH,SpriteSheet.BcSpriteSheet.HEIGHT,SpriteSheet.BcSpriteSheet); 
	
	public S_Menu()
	{
		
	}
	public void update()
	{
		
	}
	public void render(Screen s)
	{
		s.renderSprite(0, 0, s_background);
	}
	
}
