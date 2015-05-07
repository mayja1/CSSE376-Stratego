package game;
import game.GameBoard.User;

import javax.swing.JFrame;

public class GameApplet {

	public static void main(String[] args) {
		ITurnObserver observer = new TurnObserver();
		GameBoardFrame player1Frame = new GameBoardFrame(User.PLAYER1, observer);
		GameBoardFrame player2Frame = new GameBoardFrame(User.PLAYER2, observer);
		player1Frame.setObserver(player2Frame);
		player2Frame.setObserver(player1Frame);
		player2Frame.setLocation(player1Frame.getX() + player1Frame.getWidth(), player2Frame.getY());
	}
}
