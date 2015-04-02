package game;

import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements IPieceObserver {

	private HashMap<Point, IPiece> pieces = new HashMap<Point, IPiece>();
	private IPiece selectedPiece = new Soldier(0);
	private GridLayout layout;

	public GameBoard() {
		super();
		layout = new GridLayout(10, 10);
		this.setLayout(layout);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				IPiece button = new ClearPiece();
				button.setLocation(new Point(i, j));
				button.setObserver(this);
				pieces.put(new Point(i, j), button);
				this.add((JButton) button, i, j);
				((JButton) button).validate();
			}
		}

		for (int i = 3; i < 13; i++) {
			Point p = new Point(0, i);
			IPiece s = new Soldier(i);
			s.setLocation(p);
			s.setObserver(this);
			this.add((JButton) s, 0, i);
			pieces.put(new Point(0, i), s);
			((JButton) s).validate();
		}
	}

	@Override
	public void selectedButtonPressed(Point gridLocation) {
		if (pieces.containsKey(gridLocation)) {
			selectedPiece.setSelected(false);
			selectedPiece = null;
		}
	}

	@Override
	public void nonSelectedButtonPressed(Point gridLocation) {
		if (selectedPiece == null) {
			selectedPiece = pieces.get(gridLocation);
			selectedPiece.setSelected(true);
		} else if (pieces.get(gridLocation).compareWith(selectedPiece)) {
			swapPieces(selectedPiece, pieces.get(gridLocation));
		}
	}

	private void swapPieces(IPiece p1, IPiece p2) {
//		pieces.remove(p1.getLocation());
//		pieces.remove(p2.getLocation());
//		pieces.put(p2.getLocation(), p1);
//		pieces.put(p1.getLocation(), p2);
		this.add((JButton) p1, p2.getLocation().x, p2.getLocation().y);
//		((Object) layout).replaceComponent();
		System.out.println("SWAP");
	}
}
