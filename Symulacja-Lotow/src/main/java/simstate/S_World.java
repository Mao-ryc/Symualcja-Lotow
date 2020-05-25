package simstate;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graphics.Screen;
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
		jframe.setTitle("Earnings");
		jframe.setSize(500,200);
		jframe.setLocation(600,0);
		jlabel.setVisible(true);
		jframe.setLayout(new GridLayout());
	}
	public void update()
	{
		String earnings = String.valueOf(MoneyManager.earnings);
		jlabel.setPreferredSize(new Dimension(300,150));
		jlabel.setText(earnings);
		jpanel.add(jlabel);
		jframe.add(jpanel);
		
		if(MoneyManager.earnings >MoneyManager.goal)
		{
			jlabel.setText("You earned: "+ MoneyManager.goal);
			MoneyManager.stopSim = true;
		}
	
		map.update();
	}
	public void render(Screen s)
	{
		map.render(s);
	}
}
