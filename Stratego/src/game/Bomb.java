package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;

public class Bomb extends AbstractPiece{
	
	public Bomb() {
		setBackground(Color.BLACK);
		this.rank = rank;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
}
