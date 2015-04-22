package game;

public class PieceFactory {
	
	public static IPiece createBomb() {
		AbstractPiece bomb = new Bomb();
		bomb.setName("Bomb");
		return bomb;
	}
	
	public static IPiece createFlag() {
		return null;
	}
	
	public static IPiece createSpy() {
		return null;
	}
	
	public static IPiece createMarshall() {
		return null;
	}

}
