package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse {

	public static int x,y,pixelX,pixelY;
	public static boolean left_button,left_button_clicked;
	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseClicked(MouseEvent e) {
		mouseMoved(e);
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
		if(e.getButton() == e.BUTTON1) //lewy myszy
		{
			left_button = true;
		}
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
		if(e.getButton() == e.BUTTON1) //lewy myszy
		{
			left_button = false;
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
	}
	
}
