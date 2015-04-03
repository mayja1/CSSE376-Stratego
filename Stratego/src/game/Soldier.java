package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Soldier extends AbstractPiece {

	private Boolean selected = false;
	private Point location = new Point();
	private IPieceObserver observer;
	private int rank;
	private int boardIndex = 0;

	public Soldier(int rank) {
		setBackground(Color.BLUE);
		this.rank = rank;
		addActionListener(this);
	}

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setSelected(boolean selected) {
		this.selected = selected;
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
	public void actionPerformed(ActionEvent e) {
		if (selected) {
			observer.selectedButtonPressed(location);
		} else {
			observer.nonSelectedButtonPressed(location);
		}
	}

	@Override
	public boolean compareWith(IPiece piece) {
		if (piece.getClass().equals(ClearPiece.class)) {
			return true;
		}
		return false;
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
