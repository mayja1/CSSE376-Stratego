package game;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

public class Bomb extends AbstractPiece{
	
	public Bomb() {
		setBackground(Color.GREEN);
		this.rank = rank;
		this.name = "Bomb";
		this.visible = true;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (selected) {
			observer.selectedButtonPressed(location);
		} else {
			//observer.nonSelectedButtonPressed(location);
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
		this.visible = false;
	}

	@Override
	public void show() {
		this.visible = true;
		this.setText("" + name + " " + "(" + rank + ")");
	}
}
