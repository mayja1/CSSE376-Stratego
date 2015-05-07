package game;

public interface IBoardObserver {
	
	public void doneWithMyBoard(AbstractPiece[][] pieces);
	public void opponentDoneWithThisBoard(AbstractPiece[][] completedBoard);
}
