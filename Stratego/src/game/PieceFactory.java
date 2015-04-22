package game;

public class PieceFactory {
	
	public static IPiece createBomb() {
		AbstractPiece bomb = new Bomb();
		bomb.setName("Bomb");
		return bomb;
	}
	
	public static IPiece createFlag() {
		AbstractPiece flag = new Flag();
		flag.setName("Flag");
		return flag;
	}
	
	public static IPiece createSpy() {
		return null;
	}
	
	public static IPiece createMarshall() {
		return null;
	}

}
