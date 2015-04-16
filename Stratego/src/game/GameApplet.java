package game;
import game.GameBoard.User;

import javax.swing.JFrame;

public class GameApplet {

	public static void main(String[] args) {
		JFrame player1Frame = new GameBoardFrame(User.PLAYER1);
		JFrame player2Frame = new GameBoardFrame(User.PLAYER2);
		player2Frame.setLocation(player1Frame.getX() + player1Frame.getWidth(), player2Frame.getY());
	}
}
