package game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GameBoard extends JPanel implements IPieceObserver {

	private HashMap<Point, IPiece> pieces = new HashMap<Point, IPiece>();
	private IPiece dummy = new Dummy();
	private IPiece selectedPiece = dummy;
	private GridLayout layout;

	public GameBoard() {
		super();
		layout = new GridLayout(10, 10);
		this.setLayout(layout);
		int index = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				IPiece button = new ClearPiece();
				button.setLocation(new Point(i, j));
				button.setObserver(this);
				button.setIndex(index);
				pieces.put(new Point(i, j), button);
				this.add((JButton) button, i, j);
				((JButton) button).validate();
				index++;
			}
		}

		for (int i = 3; i < 7; i++) {
			Point p = new Point(9, i);
			IPiece s = new Soldier(i);
			s.setLocation(p);
			s.setObserver(this);
			s.setIndex(index);
			replaceInMap(s);
			this.add((JButton) s, null, index);
			((JButton) s).validate();
			index++;
		}
	}

	@Override
	public void selectedButtonPressed(Point gridLocation) {
		selectedPiece.setSelected(false);
		((JButton) selectedPiece).setBorder(new LineBorder(Color.GRAY, 1));
		selectedPiece = dummy;
	}

	@Override
	public void nonSelectedButtonPressed(Point gridLocation) {

		IPiece nonSelected = pieces.get(gridLocation);

		if (isObject(nonSelected, ClearPiece.class)) {
			System.out.println(nonSelected.getLocation());
		}

		if (isObject(nonSelected, ClearPiece.class) && !isObject(selectedPiece, Dummy.class)) {
			selectedPiece.setSelected(false);
			swapPieces(selectedPiece, nonSelected);
			((JButton) selectedPiece).setBorder(new LineBorder(Color.GRAY, 1));
			selectedPiece = dummy;
		} else if (selectedPiece == dummy
				&& !isObject(nonSelected, ClearPiece.class)) {
			selectedPiece = nonSelected;
			((JButton) selectedPiece)
					.setBorder(new LineBorder(Color.YELLOW, 5));
			selectedPiece.setSelected(true);
		} else {
			// Do nothing
		}
	}

	private void swapPieces(IPiece p1, IPiece p2) {
		pieces.remove(p1.getLocation());
		pieces.remove(p2.getLocation());
		pieces.put(p2.getLocation(), p1);
		pieces.put(p1.getLocation(), p2);
//		this.remove((JButton) p1);
		System.out.println(p2.getLocation());
		System.out.println(p1.getLocation());
//		this.remove((JButton) p2);
//		this.add((JButton) p2, p1.getLocation().x, p1.getLocation().y);
		((JButton) p2).validate();
		this.add((JButton) p1, 0, p2.getLocation().y);
		((JButton) p1).validate();

		validate();
		// System.out.println("SWAP");
	}

	private boolean isObject(IPiece p1, Object obj) {
		return p1.getClass().equals(obj);
	}

	private void replaceInMap(IPiece piece) {
		if (pieces.containsKey(piece.getLocation())) {
			pieces.remove(piece.getLocation());
		}
		pieces.put(piece.getLocation(), piece);
	}
}
