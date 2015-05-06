package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Soldier extends AbstractPiece {
	
	public Soldier(int rank, String name) {
		setBackground(Color.GREEN);
		this.rank = rank;
		this.name = name;
		this.visible = true;
		addActionListener(this);
	}

	public Soldier(int rank) {
		setBackground(Color.GREEN);
		this.rank = rank;
		addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (selected) {
			observer.selectedButtonPressed(location);
		} else {
			observer.nonSelectedButtonPressed(location);
		}
	}
	
}
