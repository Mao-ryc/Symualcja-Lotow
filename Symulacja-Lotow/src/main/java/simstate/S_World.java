package simstate;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;
import logic.MoneyManager;
import world.Map;

public class S_World extends SimState{
	
	public Map map;
	private JFrame jframe = new JFrame();
	private JPanel jpanel = new JPanel();
	private JLabel jlabel = new JLabel();
	
	public S_World()
	{	
		map = new Map(320, 180);
		jframe.setVisible(true);
		jframe.setSize(600,200);
		jframe.setLocation(600,0);
		jlabel.setVisible(true);
		jframe.setLayout(new FlowLayout());
	}
	public void update()
	{
		String earnings = String.valueOf(MoneyManager.earnings);
		jlabel.setText("earnings: "+earnings);
		jpanel.add(jlabel);
		jframe.add(jpanel);

		
		map.update();
	}
	public void render(Screen s)
	{
		map.render(s);
	}
}
