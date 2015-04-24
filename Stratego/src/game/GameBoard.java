package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JPanel;

public class GameBoard extends JPanel implements IPieceObserver {

	public static enum User {PLAYER1, PLAYER2};
	private static final Dimension PIECE_SIZE = new Dimension(80, 80);
	protected AbstractPiece[][] pieces;
	protected AbstractPiece selectedPiece;
	private GridBagLayout layout;
	private User owner;

	public GameBoard(User owner) {
		super();
		this.owner = owner;
		pieces = new AbstractPiece[10][10];
		layout = new GridBagLayout();
		this.setLayout(layout);
		instantiateBoard();
	}

	protected void instantiateBoard() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				AbstractPiece button = (AbstractPiece) PieceFactory.createClearPiece();
				addPiece(i, j, button);
				
			}
		}
		for (int i = 0; i < 10; i++) {
			AbstractPiece s = PieceFactory.createLieutenant();
			if (i % 2 == 0) {
				s.setOwner(User.PLAYER1);
			} else {
				s.setOwner(User.PLAYER2);
			}
			if(s.getOwner() != this.owner) {
				s.setBackground(Color.RED);
			}
			this.remove(pieces[i][0]);
			this.addPiece(i, 0, s);
			
		}
		AbstractPiece s = PieceFactory.createScout();
		s.setOwner(User.PLAYER1);
		
		if(s.getOwner() != this.owner) {
			s.setBackground(Color.RED);
		}
		this.remove(pieces[0][0]);
		this.addPiece(0, 0, s);
		
		//Initializing bomb for each player
		for (int i = 0; i < 2; i++) {
			AbstractPiece b = new Bomb();
			Point p = new Point(i + 2, 2);
			if (i % 2 == 0){
				b.setOwner(User.PLAYER1);
			} else {
				b.setOwner(User.PLAYER2);
			}
			if(b.owner != this.owner) {
				b.setBackground(Color.RED);
			}
			this.remove(pieces[i + 2][2]);
			this.addPiece(i+2,  2, b);			
		}	
	}
	public void addPiece(int x, int y,
			AbstractPiece piece) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		piece.setPreferredSize(PIECE_SIZE);
		piece.setLocation(new Point(x, y));
		piece.setObserver(this);
		pieces[x][y] = piece;
		c.gridx = x;
		c.gridy = y;
		this.add(piece, c);
		piece.validate();
	}

	@Override
	public void selectedButtonPressed(Point gridLocation) {
		if(selectedPiece !=null) {
			if(selectedPiece.equals(pieces[gridLocation.x][gridLocation.y])) {
				selectedPiece.setSelected(false);
			} else if (isEnemey(selectedPiece, pieces[gridLocation.x][gridLocation.y])) {
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
		if(nonSelected.getOwner() != this.owner) {
			return;
		}
			this.selectedPiece = nonSelected;
			nonSelected.setSelected(true);
			int x = nonSelected.getLocation().x;
			int y = nonSelected.getLocation().y;
			if (this.selectedPiece.rank == 1) {
				for (int i = 0; i < 10; i++) {
					AbstractPiece piece = pieces[i][y];
					if(i != x && selectedPiece.getOwner() != piece.getOwner()) {
						piece.setSelected(true);
					}	
				}
				
				for (int i = 0; i < 10; i++) {
					AbstractPiece piece = pieces[x][i];
					if(i != y && selectedPiece.getOwner() != piece.getOwner()) {
						piece.setSelected(true);
					}	
				}
			} else {
				if (x < 9) {
					AbstractPiece piece = pieces[x + 1][y];
					if(selectedPiece.getOwner() != piece.getOwner()) {
						piece.setSelected(true);
					}	
				}
				if (x > 0) {
					AbstractPiece piece = pieces[x - 1][y];
					if(selectedPiece.getOwner() != piece.getOwner()) {
						piece.setSelected(true);
					}	
				}
				if (y > 0) {
					AbstractPiece piece = pieces[x][y - 1];
					if(selectedPiece.getOwner() != piece.getOwner()) {
						piece.setSelected(true);
					}	
				}
				if (y < 9) {
					AbstractPiece piece = pieces[x][y + 1];
					if(selectedPiece.getOwner() != piece.getOwner()) {
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
			 if (p1.rank == 3) {
				 swapPieces(p1, p2);
				 removePiece(p2);
				 return p1.getOwner() + "defused a" + p2.getOwner() + "bomb";
			 } else {
				removePiece(p1);
				removePiece(p2);
				return "A bomb has exploded!";
			 }
		} else if (p2 instanceof Flag) {
			swapPieces(p1, p2);
			removePiece(p2);
			return p1.getOwner() + "has defeated" + p2.getOwner();
		} else if ((p1.rank == 0) && (p2.rank == 9)) { //Spy attacking Marshall case
			swapPieces(p1, p2);
			removePiece(p2);
		} else if (p1.rank > p2.rank) {
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
