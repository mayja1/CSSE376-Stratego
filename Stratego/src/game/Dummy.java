package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;

public class Dummy extends AbstractPiece {
	
	private Point location = new Point();
	private Boolean selected = false;
	private IPieceObserver observer;
	
	public Dummy() {
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
		System.out.println("TEST");
		observer.nonSelectedButtonPressed(location);
		
	}

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setSelected(boolean selected) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIndex(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

}
