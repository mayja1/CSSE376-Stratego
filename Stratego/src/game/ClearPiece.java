package game;

import game.GameBoard.User;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

public class ClearPiece extends AbstractPiece {
	
	private int index;
	
	public ClearPiece() {
		addActionListener(this);
		setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(selected) {
			observer.selectedButtonPressed(location);
		}
	}

	@Override
	public void setSelected(boolean selected) {
		if(selected) {
			this.setBorder(new LineBorder(Color.RED, 5));
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
	
	@Override
	public void setOwner(User u) {
		this.owner = null;
	}
	
	@Override
	public User getOwner() {
		return null;
	}

}
