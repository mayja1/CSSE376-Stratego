package game;

import game.GameBoard.User;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SetupBoard extends JPanel implements IPieceObserver {

	private static final Dimension PIECE_SIZE = new Dimension(80, 80);
	protected AbstractPiece[][] pieces;
	private GridBagLayout layout;
	private User owner;
	private DefaultComboBoxModel<AbstractPiece> model;

	public SetupBoard(User owner) {
		super();
		this.owner = owner;
		pieces = new AbstractPiece[10][4];
		layout = new GridBagLayout();
		this.setLayout(layout);
		model = new DefaultComboBoxModel<>();
		instantiateModel(model);
		instantiateBoard();
	}

	protected void instantiateModel(DefaultComboBoxModel<AbstractPiece> model) {
		for (int i = 0; i < 8; i++) {
			model.addElement(PieceFactory.createScout());
		}
	}

	protected void instantiateBoard() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				AbstractPiece button = (AbstractPiece) PieceFactory
						.createClearPiece();
				button.setSelected(true);
				button.setBorder(new LineBorder(Color.GRAY, 1));
				addPiece(j, i, button);
			}
		}
	}

	public void addPiece(int x, int y, AbstractPiece piece) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		piece.setPreferredSize(PIECE_SIZE);
		piece.setLocation(new Point(x, y));
		piece.setObserver(this);
		if (pieces[x][y] != null) {
			this.remove(pieces[x][y]);
		}
		pieces[x][y] = piece;
		c.gridx = x;
		c.gridy = y;
		this.add(piece, c);
		System.out.println("Added piece: " + piece);
		piece.validate();
	}

	@Override
	public void selectedButtonPressed(Point gridLocation) {
		// this is a clear piece is pressed
		
	}

	@Override
	public void nonSelectedButtonPressed(Point gridLocation) {
		//piece selected
	}
	
	public AbstractPiece[][] getPieces() {
		return pieces;
	}
}
