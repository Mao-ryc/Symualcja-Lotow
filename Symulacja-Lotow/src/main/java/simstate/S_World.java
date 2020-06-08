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
	
	private JFrame jframe = new JFrame();
	private JPanel jpanel = new JPanel();
	private JLabel jlabel = new JLabel();
	
	public S_World()
	{	
		/**
		 *  stworzenie mapy
		 */
		map = new Map(320, 180); 
		
		/**
		 * ustawienie okna dla zarobkow
		 */
		jframe.setVisible(true); 
		jframe.setTitle("Earnings");
		jframe.setSize(500,200);
		jframe.setLocation(600,0);
		jlabel.setVisible(true);
		jframe.setLayout(new GridLayout());
	}
	public void update()
	{
		/**
		 * aktualizowanie zarobkow
		 */
		String earnings = String.valueOf(MoneyManager.earnings);
		jlabel.setPreferredSize(new Dimension(300,150));
		jlabel.setText(earnings);
		jpanel.add(jlabel);
		jframe.add(jpanel);
		
		
		/**
		 * Sprawdzanie czy cel osiagniety
		 */
		if(MoneyManager.earnings >MoneyManager.goal)
		{
			jlabel.setText("You earned: "+ MoneyManager.goal);
			MoneyManager.stopSim = true;
		}
		if(MoneyManager.earnings < (-1)*MoneyManager.goal/2)
		{
			jlabel.setText("You are broken!");
			MoneyManager.stopSim = true;
		}
		
	
		map.update();
	}
	public void render(Screen s)
	{
		map.render(s);
	}
}
