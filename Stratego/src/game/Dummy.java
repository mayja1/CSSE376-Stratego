package game;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class Dummy extends AbstractPiece {
	
	public Dummy() {
		addActionListener(this);
		setBackground(Color.GREEN);
	}

	@Override
	public boolean compareWith(IPiece piece) {
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("TEST");
		observer.nonSelectedButtonPressed(location);
		
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

}
