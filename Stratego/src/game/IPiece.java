package game;

import java.awt.Point;

public interface IPiece {
	public boolean isSelected();
	public void setSelected(boolean selected);
	public void hide();
	public void show();
	public void setObserver(IPieceObserver observer);
	public void setLocation(Point location);
	public void getLocation(Point location);
	/**
	 * Method called by the piece when it is pressed
	 */
	public void processPress();
}
