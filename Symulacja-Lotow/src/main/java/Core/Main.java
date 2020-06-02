package Core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import graphics.Screen;
import logic.MoneyManager;
import world.Map;

public class Main extends Canvas implements Runnable{
	
	private static final String Title = "Symulacja Lotow";
	
	private final int WIDTH = 1024;
	private final int HEIGHT = 576;
	
	private static final int UPDATESPERSEC = 60;
	
	private boolean running = false;
	private JFrame jframe;
	
	private Screen screen;
	private StateManager stateManager;
	
	
	public Main()
	{
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setMinimumSize(new Dimension(WIDTH,HEIGHT));
		setMaximumSize(new Dimension(WIDTH,HEIGHT));
		
		jframe = new JFrame(Title);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jframe.add(this,new BorderLayout().CENTER);
		
		jframe.pack();
		
		jframe.setLocationRelativeTo(null); //Wyœrodkowanie okna
		jframe.setResizable(false);         //Nie mozna zmieniac rozmiaru
		jframe.setVisible(true);            
		
		int i = 20;
		screen = new Screen(16*i,9*i); //320/180
		
		stateManager = new StateManager();
	}

	public static void main(String[] args) {
		
		new Main().start();

	}
	public void start()
	{
		if(running)                
			return;
		running = true;
		
		new Thread(this,"Symulation "+Title).start();  //w¹tek który uruchamia funkcje run()
	}
	public void stop()
	{
		if(!running)                
			return;
		running = false;
	}
	
	//Kontrola FPS i UPS
	private double timer = System.currentTimeMillis();
	private int FPS = 0;
	private int UPS = 0;	
	private double delta;
	private double frametime = 1000000000 / UPDATESPERSEC; 
	private long timeNOW = System.nanoTime();
	private long timeLAST = System.nanoTime();
	
	//podatek pobierany co 1000UPS
	private float podatek = (float)(MoneyManager.earnings*0.4);
	public int PPS = 0;
		
	public void run()
	{
		while(running)
		{
			timeNOW = System.nanoTime(); 
			delta += (timeNOW-timeLAST)/frametime;
			timeLAST = timeNOW;
			
			while(delta>=1)
			{
				update();
				delta -=1;
				UPS++;
				
				PPS++;
			}
			
			render();
			FPS++;
			
			if(System.currentTimeMillis() - timer >=1000)
			{
				timer = System.currentTimeMillis();
				System.out.println("FPS: "+ FPS+" UPS: "+ UPS+"PPS: "+PPS);
				FPS=0;
				UPS=0;
			}
			if(MoneyManager.stopSim==true) //gdy cel zostanie osiagniety zmienia wartosc stopSim na true i konczy symulacje
			{
				break;
			}
			
		}
		stop();
	}
	public void update()
	{
		podatek = (float)(MoneyManager.earnings*0.4);
		if(PPS%1000==0)
		{
			if(MoneyManager.earnings>0)
			{
				System.out.println("PODATEK!");
				MoneyManager.earnings-=podatek;
			}
		}	
		
		stateManager.update();
	}
	public void render()
	{	
		BufferStrategy bs = getBufferStrategy();
		if(bs==null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics grafics = bs.getDrawGraphics();
		
		screen.clear(0x000000);
		stateManager.render(screen);
		
		
		grafics.drawImage(screen.getImage(), 0, 0, WIDTH, HEIGHT, null);
		
		grafics.dispose();
		
		bs.show();
	}
	
}
