package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;

public class ClearPiece extends AbstractPiece {
	
	private Point location = new Point();
	private Boolean selected = false;
	private IPieceObserver observer;
	private int index;
	
	public ClearPiece() {
		addActionListener(this);
		setBackground(Color.GREEN);
	}

	@Override
	public boolean compareWith(IPiece piece) {
		return true;
	}

	@Override
	public void setObserver(IPieceObserver observer) {
		this.observer = observer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		observer.nonSelectedButtonPressed(location);
	}

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setSelected(boolean selected) {
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocation(Point location) {
		this.location = location;
		
	}

	@Override
	public Point getLocation() {
		return location;
	}

	@Override
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

}
