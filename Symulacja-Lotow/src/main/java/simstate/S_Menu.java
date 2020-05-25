package simstate;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Core.StateManager;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;
import logic.MoneyManager;

public class S_Menu extends SimState{

	public  Sprite s_background = new Sprite(0,0,SpriteSheet.BcSpriteSheet.WIDTH,SpriteSheet.BcSpriteSheet.HEIGHT,SpriteSheet.BcSpriteSheet); 
	
	//Elementy nalezace do okna parametry
	static JPanel jpanel = new JPanel();
	private JLabel jlabelEco = new JLabel();
	private JLabel jlabelBiz = new JLabel();
	private JLabel jlabelFirst = new JLabel();
	private JLabel jlabelKg = new JLabel();
	private JLabel jlabelGasPrice = new JLabel();
	private JLabel jlabelPeopleConc = new JLabel();
	private JLabel jlabelNrOfPlanesPP = new JLabel();
	private JLabel jlabelNrOfPlanesTP = new JLabel();
	private JLabel jlabelGoal = new JLabel();
	private JTextField jtxtfieldEco = new JTextField(30);
	private JTextField jtxtfieldBiz = new JTextField(30);
	private JTextField jtxtfieldFirst = new JTextField(30);
	private JTextField jtxtfieldKg = new JTextField(30);
	private JTextField jtxtfieldGasPrice = new JTextField(30);
	private JTextField jtxtfieldPeopleConc = new JTextField(30);
	private JTextField jtxtfieldNrOfPlanesPP = new JTextField(30);
	private JTextField jtxtfieldNrOfPlanesTP = new JTextField(30);
	private JTextField jtxtfieldGoal = new JTextField(30);
	
	private JButton jbutton = new JButton("Start");
	
	public S_Menu()
	{
		// obs³uga wejœcia od uzytkownika
		setTitle("Parametry - (Ka¿d¹ wpisan¹ dan¹ zatwierd¿ enterem)");
		setVisible(true);
		setSize(600,400);
		setLayout(new GridLayout(5,2));
		
		// Eco bilety
		add(jtxtfieldEco);
		
		jtxtfieldEco.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputEco = jtxtfieldEco.getText();
				MoneyManager.eTicketsPricePerKm = Float.parseFloat(inputEco);
			}
		});
		jlabelEco.setText("Price for eco class tickets (km)");
		jlabelEco.setAlignmentX(0);
		jlabelEco.setAlignmentY(0);
		
		add(jlabelEco);
		
		// Biznes bilety
		jtxtfieldBiz.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputBiz = jtxtfieldBiz.getText();
				MoneyManager.bTicketsPricePerKm = Float.parseFloat(inputBiz);
			}
		});
		jlabelBiz.setText("Price for biznes class tickets (km)");
		jlabelBiz.setAlignmentX(0);
		jlabelBiz.setAlignmentY(0);
		
		add(jtxtfieldBiz);
		add(jlabelBiz);
		
		// First class bilety
		add(jtxtfieldFirst);
						
		jtxtfieldFirst.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputFirst = jtxtfieldFirst.getText();
				MoneyManager.fTicketsPricePerKm = Float.parseFloat(inputFirst);
			}
		});
		jlabelFirst.setText(" Price for first class tickets (km)");
		jlabelFirst.setAlignmentX(0);
		jlabelFirst.setAlignmentY(0);
				
		add(jlabelFirst);
		
		// Kg cena
		add(jtxtfieldKg);
								
		jtxtfieldKg.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputKg = jtxtfieldKg.getText();
				MoneyManager.priceForKg = Float.parseFloat(inputKg);
			}
		});
		jlabelKg.setText("Price for kg of load (km)          ");
		jlabelKg.setAlignmentX(0);
		jlabelKg.setAlignmentY(0);
						
		add(jlabelKg);
		
		// Gas cena
		add(jtxtfieldGasPrice);
										
		jtxtfieldGasPrice.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputGasPrice = jtxtfieldGasPrice.getText();
				MoneyManager.gasPrice = Float.parseFloat(inputGasPrice);
			}
				});
		jlabelGasPrice.setText("Price for gas (km)                                 ");
		jlabelGasPrice.setAlignmentX(0);
		jlabelGasPrice.setAlignmentY(0);
								
		add(jlabelGasPrice);
		
		// zageszczenie ludnoœci
		add(jtxtfieldPeopleConc);
												
		jtxtfieldPeopleConc.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputPeopleConc = jtxtfieldPeopleConc.getText();
				MoneyManager.concentratinonOfPeople = Integer.parseInt(inputPeopleConc);
			}
		});
		jlabelPeopleConc.setText("Concentration of people (1-low, 2-medium,3-high)");
		jlabelPeopleConc.setAlignmentX(0);
		jlabelPeopleConc.setAlignmentY(0);
										
		add(jlabelPeopleConc);
		
		// ilosc samolowów  pasazerskich
		add(jtxtfieldNrOfPlanesPP);
														
		jtxtfieldNrOfPlanesPP.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputNrOfPlanesPP = jtxtfieldNrOfPlanesPP.getText();
				MoneyManager.nr_of_PassengerPlanes = Integer.parseInt(inputNrOfPlanesPP);
			}
		});
		jlabelNrOfPlanesPP.setText("Number of passenger planes     (0-9)                ");
		jlabelNrOfPlanesPP.setAlignmentX(0);
		jlabelNrOfPlanesPP.setAlignmentY(0);
												
		add(jlabelNrOfPlanesPP);
		
		// ilosc samolowów  transportowych
		add(jtxtfieldNrOfPlanesTP);
														
		jtxtfieldNrOfPlanesTP.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputNrOfPlanesTP = jtxtfieldNrOfPlanesTP.getText();
				MoneyManager.nr_of_TransportPlanes = Integer.parseInt(inputNrOfPlanesTP);
			}
		});
		jlabelNrOfPlanesTP.setText("Number of transport planes     (0-9)                ");
		jlabelNrOfPlanesTP.setAlignmentX(0);
		jlabelNrOfPlanesTP.setAlignmentY(0);
														
		add(jlabelNrOfPlanesTP);
		
		// goal
		add(jtxtfieldGoal);
														
		jtxtfieldGoal.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputGoal = jtxtfieldGoal.getText();
				MoneyManager.goal = Integer.parseInt(inputGoal);
			}
		});
		jlabelGoal.setText("Goal                ");
		jlabelGoal.setAlignmentX(0);
		jlabelGoal.setAlignmentY(0);
														
		add(jlabelGoal);
		
		add(jbutton);
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
				jtxtfieldGasPrice.setEditable(false);
				jtxtfieldPeopleConc.setEditable(false);
				jtxtfieldNrOfPlanesPP.setEditable(false);
				jtxtfieldNrOfPlanesTP.setEditable(false);
				jtxtfieldGoal.setEditable(false);
				
			}
			
		});
		
		pack();
	}
	public void update()
	{
		
	}
	public void render(Screen s)
	{
		s.renderSprite(0, 0, s_background);
	}
	
}
