package game;

import java.awt.Point;
import java.awt.event.ActionEvent;

public class ClearPiece extends AbstractPiece {
	
	private Point location = new Point();
	private Boolean selected = false;
	private IPieceObserver observer;
	
	public ClearPiece() {
		addActionListener(this);
	}

	@Override
	public boolean compareWith(IPiece piece) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setObserver(IPieceObserver observer) {
		this.observer = observer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("TEST");
		
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
	public void setLocation(Point location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

}
