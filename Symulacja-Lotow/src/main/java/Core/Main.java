package Core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;
import input.Mouse;

public class Main extends Canvas implements Runnable{
	
	private static final String Title = "Symulacja Lotow";
	
	private final int WIDTH = 1024;
	private final int HEIGHT = 576;
	
	private boolean running = false;
	private JFrame jframe;
	
	private Screen screen;
	private Mouse mouse;
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
		screen = new Screen(16*i,9*i);
		
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
		jframe.dispose();           //Wyczyszczenie okienka
		System.exit(0);
	}
	
	public void run()
	{
		while(running)
		{
			update();
			render();
		}
		stop();
	}
	public void update()
	{
		System.out.println("UPDATING");
		stateManager.update();
	}
	public void render()
	{
		System.out.println("RENDERING");
		
		BufferStrategy bs = getBufferStrategy();
		if(bs==null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics grafics = bs.getDrawGraphics();
		
		grafics.setColor(Color.BLACK);
		grafics.fillRect(0, 0, WIDTH, HEIGHT);
		
		screen.clear(0x000000);
		stateManager.render(screen);
		
		
		grafics.drawImage(screen.getImage(), 0, 0, WIDTH, HEIGHT, null);
		
		grafics.dispose();
		
		bs.show();
	}
	
}
