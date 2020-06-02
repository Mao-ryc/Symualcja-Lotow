package Core;

import graphics.Screen;
import simstate.S_Menu;
import simstate.S_World;
import simstate.SimState;

public class StateManager {

	public static final int SIM_STATE_MENU = 0;
	public static final int SIM_STATE_WORLD = 1;
	
	public static SimState simState;
	
	public StateManager()
	{
		changeSimState(SIM_STATE_MENU);
	}
	public static void changeSimState(int id)
	{
		if(id==SIM_STATE_MENU)
			simState = new S_Menu();		
		if(id==SIM_STATE_WORLD)
			simState = new S_World();
	}
	public void update()
	{
		simState.update();
	}
	public void render(Screen s)
	{
		simState.render(s);
	}
}
