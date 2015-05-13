package game;

import game.GameBoard.User;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class Obstacle extends AbstractPiece {
	
	public Obstacle() {
		addActionListener(this);
		setBackground(Color.BLACK);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
	public void setOwner(User u) {
		this.owner = null;
	}
	
	@Override
	public User getOwner() {
		return null;
	}
}
