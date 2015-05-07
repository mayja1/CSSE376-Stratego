package game;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

public class Flag extends AbstractPiece{
	
	public Flag() {
		setBackground(Color.ORANGE); //Will be team's color
		this.rank = rank;
		this.name = "Flag";
		addActionListener(this);
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
	public void setSelected(boolean selected) {
		if (selected) {
			this.setBorder(new LineBorder(Color.YELLOW, 5));
		} else {
			this.setBorder(new LineBorder(Color.GRAY, 1));
		}
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
