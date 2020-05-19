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
import logic.MoneyManager;

public class S_Menu extends SimState{

	public  Sprite s_background = new Sprite(0,0,SpriteSheet.BcSpriteSheet.WIDTH,SpriteSheet.BcSpriteSheet.HEIGHT,SpriteSheet.BcSpriteSheet); 
	
	private JPanel jpanel = new JPanel();
	private JLabel jlabelEco = new JLabel();
	private JLabel jlabelBiz = new JLabel();
	private JLabel jlabelFirst = new JLabel();
	private JLabel jlabelKg = new JLabel();
	private JTextField jtxtfieldEco = new JTextField(30);
	private JTextField jtxtfieldBiz = new JTextField(30);
	private JTextField jtxtfieldFirst = new JTextField(30);
	private JTextField jtxtfieldKg = new JTextField(30);
	
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
				String inputEco = jtxtfieldEco.getText();
				MoneyManager.eTicketsPricePerKm = Integer.parseInt(inputEco);
			}
		});
		jlabelEco.setText("   Price for eco class tickets");
		jlabelEco.setAlignmentX(0);
		jlabelEco.setAlignmentY(0);
		
		jpanel.add(jlabelEco);
		
		// Biznes bilety
		jpanel.add(jtxtfieldBiz);
				
		jtxtfieldBiz.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputBiz = jtxtfieldBiz.getText();
				MoneyManager.bTicketsPricePerKm = Integer.parseInt(inputBiz);
			}
		});
		jlabelBiz.setText("Price for biznes class tickets");
		jlabelBiz.setAlignmentX(0);
		jlabelBiz.setAlignmentY(0);
		
		jpanel.add(jlabelBiz);
		
		// First class bilety
		jpanel.add(jtxtfieldFirst);
						
		jtxtfieldFirst.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputFirst = jtxtfieldFirst.getText();
				MoneyManager.fTicketsPricePerKm = Integer.parseInt(inputFirst);
			}
		});
		jlabelFirst.setText(" Price for first class tickets");
		jlabelFirst.setAlignmentX(0);
		jlabelFirst.setAlignmentY(0);
				
		jpanel.add(jlabelFirst);
		
		// Kg cena
		jpanel.add(jtxtfieldKg);
								
		jtxtfieldKg.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputKg = jtxtfieldKg.getText();
				MoneyManager.priceForKg = Integer.parseInt(inputKg);
			}
		});
		jlabelKg.setText("Price for kg of load");
		jlabelKg.setAlignmentX(0);
		jlabelKg.setAlignmentY(0);
						
		jpanel.add(jlabelKg);
		
		jpanel.add(jbutton);
		jbutton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				StateManager.changeSimState(1);
				jbutton.setVisible(false);
				jtxtfieldEco.setEditable(false);           //Wy³¹czenie labelów gdy nie jest juz potrzebna modyfikacja
				jtxtfieldBiz.setEditable(false);
				jtxtfieldFirst.setEditable(false);
				jtxtfieldKg.setEditable(false);
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
