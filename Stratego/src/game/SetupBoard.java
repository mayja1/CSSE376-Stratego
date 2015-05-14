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
		model.addElement(PieceFactory.createFlag());
		for (int i = 0; i < 6; i++) {
			model.addElement(PieceFactory.createBomb());
		}
		model.addElement(PieceFactory.createSpy());
		for (int i = 0; i < 8; i++) {
			model.addElement(PieceFactory.createScout());
		}
		for (int i = 0; i < 5; i++) {
			model.addElement(PieceFactory.createMiner());
		}
		for (int i = 0; i < 4; i++) {
			model.addElement(PieceFactory.createSergeant());
		}
		for (int i = 0; i < 4; i++) {
			model.addElement(PieceFactory.createLieutenant());
		}
		for (int i = 0; i < 4; i++) {
			model.addElement(PieceFactory.createCaptain());
		}
		for (int i = 0; i < 3; i++) {
			model.addElement(PieceFactory.createMajor());
		}
		for (int i = 0; i < 2; i++) {
			model.addElement(PieceFactory.createColonel());
		}
		model.addElement(PieceFactory.createGeneral());
		model.addElement(PieceFactory.createMarshall());
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
		c.weightx = 0;
		c.weighty = 0;
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
		piece.setOwner(this.owner);
		piece.show();
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
			observer.doneWithMyBoard(pieces);
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
		int x = gridLocation.x;
		int y = gridLocation.y;
		AbstractPiece oldPiece = pieces[x][y];
		this.remove(pieces[x][y]);
		AbstractPiece piece = PieceFactory.createClearPiece();
		piece.setSelected(true);
		addPiece(x, y, piece);
		piece.setBorder(new LineBorder(Color.GRAY, 1));
		model.addElement(oldPiece);
		
		this.validate();
		this.repaint();
	}
	
	public AbstractPiece[][] getPieces() {
		return pieces;
	}
	
	public void setObserver(IBoardObserver obs) {
		this.observer = obs;
	}
}
