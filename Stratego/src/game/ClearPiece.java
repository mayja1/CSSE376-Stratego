package game;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class ClearPiece extends AbstractPiece {
	
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
	public void actionPerformed(ActionEvent arg0) {
		observer.nonSelectedButtonPressed(location);
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

}
