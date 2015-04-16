package game;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements IPieceObserver {

	public static enum User {PLAYER1, PLAYER2};
	private static final Dimension PIECE_SIZE = new Dimension(80, 80);
	private AbstractPiece[][] pieces;
	private AbstractPiece selectedPiece;
	private GridBagLayout layout;

	public GameBoard() {
		super();
		pieces = new AbstractPiece[10][10];
		layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		this.setLayout(layout);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				AbstractPiece button = new ClearPiece();
				button.setPreferredSize(PIECE_SIZE);
				button.setLocation(new Point(i, j));
				button.setObserver(this);
				pieces[i][j] = button;
				c.gridx = i;
				c.gridy = j;
				this.add(button, c);
				button.validate();
				
			}
		}
		for (int i = 0; i < 10; i++) {
			Point p = new Point(i, 0);
			AbstractPiece s = new Soldier(i);
			if (i % 2 == 0) {
				s.setOwner(User.PLAYER1);
			} else {
				s.setOwner(User.PLAYER2);
			}
			s.setPreferredSize(PIECE_SIZE);
			s.setLocation(p);
			s.setObserver(this);
			this.remove(pieces[i][0]);
			pieces[i][0] = s;
			c.gridx = i;
			c.gridy = 0;
			this.add(s, c);
			s.validate();
		}
		
		//Initializing bomb for each player
		for (int i = 0; i < 2; i++) {
			AbstractPiece b = new Bomb();
			Point p = new Point(i + 2, 2);
			if (i % 2 == 0){
				b.setOwner(User.PLAYER1);
			} else {
				b.setOwner(User.PLAYER2);
			}
			b.setPreferredSize(PIECE_SIZE);
			b.setLocation(p);
			b.setObserver(this);
			this.remove(pieces[i + 2][2]);
			pieces[i + 2][2] = b;
			c.gridx = i + 2;
			c.gridy = 2;
			this.add(b, c);
			b.validate();
		}		
	}

	@Override
	public void selectedButtonPressed(Point gridLocation) {
		if(selectedPiece !=null) {
			if(selectedPiece.equals(pieces[gridLocation.x][gridLocation.y])) {
				selectedPiece.setSelected(false);
			} else if (isEnemey(selectedPiece, pieces[gridLocation.x][gridLocation.y])) {
				System.out.println("Test");
				attack(selectedPiece, pieces[gridLocation.x][gridLocation.y]);
			} else {
				swapPieces(selectedPiece, pieces[gridLocation.x][gridLocation.y]);
			}
		}
		for(AbstractPiece[] pRow: pieces) {
			for(AbstractPiece p: pRow) {
			p.setSelected(false);
			}
		}
		selectedPiece = null;
	}

	private boolean isEnemey(AbstractPiece p1, AbstractPiece p2) {
		return !(p1.getOwner().equals(p2.getOwner())) && p2.getOwner() != null;
	}

	@Override
	public void nonSelectedButtonPressed(Point gridLocation) {
		for(AbstractPiece[] pRow: pieces) {
			for(AbstractPiece p: pRow) {
			p.setSelected(false);
			}
		}
		AbstractPiece nonSelected = pieces[gridLocation.x][gridLocation.y];
		if (!(nonSelected instanceof Bomb)) {
			this.selectedPiece = nonSelected;
			nonSelected.setSelected(true);
			int x = nonSelected.getLocation().x;
			int y = nonSelected.getLocation().y;
			if (x < 9) {
				AbstractPiece piece = pieces[x + 1][y];
				if(piece instanceof ClearPiece || selectedPiece.getOwner() != piece.getOwner()) {
					piece.setSelected(true);
				}	
			}
			if (x > 0) {
				AbstractPiece piece = pieces[x - 1][y];
				if(piece instanceof ClearPiece || selectedPiece.getOwner() != piece.getOwner()) {
					piece.setSelected(true);
				}	
			}
			if (y > 0) {
				AbstractPiece piece = pieces[x][y - 1];
				if(piece instanceof ClearPiece || selectedPiece.getOwner() != piece.getOwner()) {
					piece.setSelected(true);
				}	
			}
			if (y < 9) {
				AbstractPiece piece = pieces[x][y + 1];
				if(piece instanceof ClearPiece || selectedPiece.getOwner() != piece.getOwner()) {
					piece.setSelected(true);
				}	
			}
		}
	}

	private void swapPieces(AbstractPiece p1, AbstractPiece p2) {
		Point point1 = p1.getLocation();
		Point point2 = p2.getLocation();
		this.remove(p1);
		this.remove(p2);
		p1.setLocation(point2);
		p2.setLocation(point1);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = point1.x;
		c.gridy = point1.y;
		pieces[point1.x][point1.y] = p2;
		this.add(p2, c);
		c.gridx = point2.x;
		c.gridy = point2.y;
		pieces[point2.x][point2.y] = p1;
		this.add(p1, c);
		validate();
		repaint();
	}
	
	public String attack(AbstractPiece p1, AbstractPiece p2) {
		if (p2 instanceof Bomb) {
			removePiece(p1);
			removePiece(p2);
			return "A bomb has exploded!";
		}
		else if (p1.rank > p2.rank) {
			swapPieces(p1, p2);
			removePiece(p2);
			return p1.getOwner() + " beat " + p2.getOwner();
		} else if (p1.rank < p2.rank) {
			removePiece(p1);
			return p2.getOwner() + " beat " + p1.getOwner();
		} else if (p1.rank == p2.rank) {
			removePiece(p1);
			removePiece(p2);
			return p1.getOwner() + " tied " + p2.getOwner();
		}
		return "Error: case not handled";
	}
	
	private void removePiece(AbstractPiece p) {
		AbstractPiece clear = new ClearPiece();
		clear.setLocation(p.getLocation());
		clear.setPreferredSize(PIECE_SIZE);
		clear.setObserver(this);
		Point point1 = p.getLocation();
		this.remove(p);
		p.setLocation(null);
		clear.setLocation(point1);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = point1.x;
		c.gridy = point1.y;
		pieces[point1.x][point1.y] = clear;
		this.add(clear, c);
		validate();
		repaint();
	}
}
