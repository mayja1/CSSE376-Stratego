package game;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class AbstractPiece extends JButton implements IPiece, ActionListener {

	@Override
	public abstract void actionPerformed(ActionEvent e);

	@Override
	public abstract boolean isSelected();

	@Override
	public abstract void setSelected(boolean selected);

	@Override
	public abstract void hide();

	@Override
	public abstract void show();

	@Override
	public abstract void setObserver(IPieceObserver observer);

	@Override
	public abstract void setLocation(Point location);

	@Override
	public abstract Point getLocation();

	@Override
	public abstract boolean compareWith(IPiece piece); 

}
