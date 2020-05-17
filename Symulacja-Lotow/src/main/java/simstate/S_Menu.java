package simstate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.math3.analysis.function.Add;

import Core.StateManager;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class S_Menu extends SimState{

	public  Sprite s_background = new Sprite(0,0,SpriteSheet.BcSpriteSheet.WIDTH,SpriteSheet.BcSpriteSheet.HEIGHT,SpriteSheet.BcSpriteSheet); 
	
	private JPanel jpanel = new JPanel();
	private JLabel jlabelEco = new JLabel();
	private JTextField jtxtfieldEco = new JTextField(30);
	
	private JButton jbutton = new JButton("Start");
	
	public S_Menu()
	{
		// obs³uga wejœcia od uzytkownika
		setTitle("Parametry");
		setVisible(true);
		setSize(600,200);
		
		// Eco bilety
		jpanel.add(jtxtfieldEco);
		
		jtxtfieldEco.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String input = jtxtfieldEco.getText();
			}
		});
		jlabelEco.setText("Price for eco tickets");
		
		jpanel.add(jlabelEco);
		
		jpanel.add(jbutton);
		jbutton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				StateManager.changeSimState(1);
				jbutton.setVisible(false);
			}
		});
		
		add(jpanel);
		
	}
	public void update()
	{
		
	}
	public void render(Screen s)
	{
		s.renderSprite(0, 0, s_background);
	}
	
}
