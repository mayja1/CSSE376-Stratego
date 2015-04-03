package game;

import java.awt.Point;
import java.awt.event.ActionEvent;

public class Obstacle extends AbstractPiece {
	
	private Point location;
	

	@Override
	public void setIndex(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
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
	public void setObserver(IPieceObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocation(Point location) {
		this.location = location;
		
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}

	@Override
	public boolean compareWith(IPiece piece) {
		// TODO Auto-generated method stub
		return false;
	}

}
