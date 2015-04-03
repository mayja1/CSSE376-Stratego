package game;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Soldier extends AbstractPiece {

	public Soldier(int rank) {
		setBackground(Color.BLUE);
		this.rank = rank;
		addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (selected) {
			observer.selectedButtonPressed(location);
		} else {
			observer.nonSelectedButtonPressed(location);
		}
	}

	@Override
	public boolean compareWith(IPiece piece) {
		if (piece.getClass().equals(ClearPiece.class)) {
			return true;
		}
		return false;
	}
	
	
}
