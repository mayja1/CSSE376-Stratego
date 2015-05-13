package game;

import java.awt.Point;
import java.util.HashMap;

import game.GameBoard.User;

public class TurnObserver implements ITurnObserver {
	
	private Enum<User> turn = User.PLAYER1;
	private HashMap<User, GameBoard> boardMap;
	
	public TurnObserver() {
		boardMap = new HashMap<User, GameBoard>();
	}
	
	@Override
	public void endTurn(Point p1, Point p2) {
		if (turn == User.PLAYER1) {
			turn = User.PLAYER2;
		} else {
			turn = User.PLAYER1;
		}

		boardMap.get(turn).updateBoard(p1, p2);
	}

	@Override
	public boolean isTurn(Enum<User> user) {
		return user.equals(turn);
	}
	
	public void addBoard(User owner, GameBoard b) {
		boardMap.put(owner, b);
	}

	@Override
	public User endGame(Enum player) {
		return (User) player;
		
	}

}
