package game;
import game.GameBoard.User;

import javax.swing.JFrame;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
public class GameApplet {

	public static void main(String[] args) {
		ITurnObserver observer = new TurnObserver();
		GameBoardFrame player1Frame = new GameBoardFrame(User.PLAYER1, observer);
		GameBoardFrame player2Frame = new GameBoardFrame(User.PLAYER2, observer);
		player1Frame.setObserver(player2Frame);
		player2Frame.setObserver(player1Frame);
		player2Frame.setLocation(player1Frame.getX() + player1Frame.getWidth(), player2Frame.getY());
		try {
			autoInitialization();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	private static void autoInitialization() throws AWTException {
		int delay = 60;
		Robot r = new Robot();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int count = 0;
		for(int x = 50; x < screensize.width; x+=50) {
			for(int y = 50; y < screensize.height; y+=50) {
				if(r.getPixelColor(x, y).equals(Color.WHITE)) {
					r.mouseMove(x, y);
					r.delay(delay);
					r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					r.delay(delay);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					r.delay(delay);
					count++;
					if(count >=80) {
						return;
					}
				}
			}
		}
	}
	
	public static void endGame() {
		
	}
	
}
