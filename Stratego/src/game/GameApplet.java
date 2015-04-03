package game;
import javax.swing.JFrame;

public class GameApplet {

	public static void main(String[] args) {
		JFrame player1Frame = new GameBoardFrame();
		JFrame player2Frame = new GameBoardFrame();
		player2Frame.setLocation(player1Frame.getX() + player1Frame.getWidth(), player2Frame.getY());
	}
}
