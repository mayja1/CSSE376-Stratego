package game;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class Flag extends AbstractPiece{
	
	public Flag() {
		setBackground(Color.ORANGE); //Will be team's color
		this.rank = rank;
		this.name = "Flag";
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
