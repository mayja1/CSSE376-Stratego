package game;

import java.awt.Point;

//The GameBoard should implement this class and add itself as an observer to the IPiece
public interface IPieceObserver {

	public void selectedButtonPressed(Point gridLocation);
	public void nonSelectedButtonPressed(Point gridLocation);
}
