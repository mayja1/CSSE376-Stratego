package game;

import java.awt.Point;

import game.GameBoard.User;

public interface ITurnObserver {
	
	public void endTurn(Point p1, Point p2);
	
	public boolean isTurn(Enum<User> user);

	public void addBoard(User owner, GameBoard gameBoard);
	
	public User endGame(Enum player);
}
