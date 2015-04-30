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

	private static final Dimension PIECE_SIZE = new Dimension(90, 90);
	protected AbstractPiece[][] pieces;
	private GridBagLayout layout;
	private User owner;
	private IBoardObserver observer;
	private DefaultComboBoxModel<AbstractPiece> model;

	public SetupBoard(User owner) {
		super();
		this.owner = owner;
		pieces = new AbstractPiece[10][4];
		layout = new GridBagLayout();
		this.setLayout(layout);
		model = new DefaultComboBoxModel<AbstractPiece>();
		instantiateModel(model);
		instantiateBoard();
	}

	protected void instantiateModel(DefaultComboBoxModel<AbstractPiece> model) {
		for (int i = 0; i < 3; i++) {
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
		JPanel panel = new JPanel();
		panel.add(new JLabel("Please make a selection:"));
		JComboBox<AbstractPiece> comboBox = new JComboBox<AbstractPiece>(model);
		panel.add(comboBox);

		showJOptionPane(gridLocation, panel, comboBox);
		if(model.getSize() == 0) {
			observer.isDone(pieces);
		}
		
		this.validate();
		this.repaint();
	}

	protected void showJOptionPane(Point gridLocation, JPanel panel,
			JComboBox<AbstractPiece> comboBox) {
		int result = JOptionPane.showConfirmDialog(null, panel, "Pieces",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		switch (result) {
		case JOptionPane.OK_OPTION:
			if (comboBox.getSelectedIndex() != -1) {
				System.out
						.println("You selected " + comboBox.getSelectedItem());
				AbstractPiece piece = (AbstractPiece) comboBox
						.getSelectedItem();
				piece.setOwner(owner);
				System.out.println(piece.getText());
				this.addPiece(gridLocation.x, gridLocation.y,
						(AbstractPiece) comboBox.getSelectedItem());
				model.removeElement(piece);
				break;
			}
		}
	}

	
	@Override
	public void nonSelectedButtonPressed(Point gridLocation) {
		System.out.println("TEST");
	}
	
	public AbstractPiece[][] getPieces() {
		return pieces;
	}
	
	public void setObserver(IBoardObserver obs) {
		this.observer = obs;
	}
}