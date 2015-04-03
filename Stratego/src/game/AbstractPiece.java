package game;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class AbstractPiece extends JButton implements IPiece, ActionListener {

	protected Boolean selected = false;
	protected Point location = new Point();
	protected IPieceObserver observer;
	protected int rank;
	protected int boardIndex = 0;

	@Override
	public abstract void actionPerformed(ActionEvent e);

	@Override
	public abstract void setSelected(boolean selected);

	@Override
	public abstract void hide();

	@Override
	public abstract void show();

	@Override
	public abstract boolean compareWith(IPiece piece);

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setObserver(IPieceObserver observer) {
		this.observer = observer;
	}

	@Override
	public void setLocation(Point location) {
		this.location = location;
	
	}

	@Override
	public Point getLocation() {
		return this.location;
	}

	@Override
	public void setIndex(int index) {
		this.boardIndex = index;	
	}

	@Override
	public int getIndex() {
		return boardIndex;
	} 

}
