package game;

import game.GameBoard.User;

public interface ITurnObserver {
	
	public void endTurn();
	
	public boolean isTurn(Enum<User> user);
	
}
