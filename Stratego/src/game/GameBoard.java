package game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements IPieceObserver {

	private HashMap<Point, IPiece> pieces = new HashMap<Point, IPiece>();
	private IPiece selectedPiece = new Soldier(0);

	public GameBoard() {
		super();
		GridLayout layout = new GridLayout(10, 10);
		this.setLayout(layout);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton button = new ClearPiece();
				button.setLocation(new Point(i, j));
				button.setBackground(Color.GREEN);
				this.add(button, i, j);
				button.validate();
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
		System.out.println("SWAP");
	}
}
