package game;

import game.GameBoard.User;

public class TurnObserver implements ITurnObserver {
	
	private Enum<User> turn = User.PLAYER1;
	
	@Override
	public void endTurn() {
		if (turn == User.PLAYER1) {
			turn = User.PLAYER2;
			
		} else {
			turn = User.PLAYER1;
		}		
	}

	@Override
	public boolean isTurn(Enum<User> user) {
		return user.equals(turn);
	}

}
