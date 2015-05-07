package game;

import game.GameBoard.User;

public class TurnObserver implements ITurnObserver {
	
	private Enum<User> turn = User.PLAYER1;
	
	@Override
	public void endTurn() {
		// Not implemented	
	}

	@Override
	public boolean isTurn(Enum<User> user) {
		return false;
	}

}
