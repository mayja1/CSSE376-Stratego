package game;

import game.GameBoard.User;

public interface IBoardObserver {
	
	public void doneWithMyBoard(AbstractPiece[][] pieces);
	public void opponentDoneWithThisBoard(AbstractPiece[][] completedBoard);
	public User endGame(User player);
}
