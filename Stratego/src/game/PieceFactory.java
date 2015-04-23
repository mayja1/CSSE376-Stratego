package game;

public class PieceFactory {
	
	public static IPiece createBomb() {
		AbstractPiece bomb = new Bomb();
		bomb.setName("Bomb");
		return bomb;
	}
	
	public static IPiece createClearPiece() {
		return new ClearPiece();
	}
	
	public static IPiece createFlag() {
		AbstractPiece flag = new Flag();
		flag.setName("Flag");
		return flag;
	}
	
	public static IPiece createSpy() {
		AbstractPiece spy = new Soldier(0);
		spy.setName("Spy");
		return spy;
	}
	
	public static IPiece createMarshall() {
		AbstractPiece soldier = new Soldier(9);
		soldier.setName("Marshall");
		return soldier;
	}
	
	public static IPiece createGeneral() {
		AbstractPiece soldier = new Soldier(8);
		soldier.setName("General");
		return soldier;
	}
	
	public static IPiece createColonel() {
		AbstractPiece soldier = new Soldier(7);
		soldier.setName("Colonel");
		return soldier;
	}
	
	public static IPiece createMajor() {
		AbstractPiece soldier = new Soldier(6);
		soldier.setName("Major");
		return soldier;
	}

	public static AbstractPiece createCaptain() {
		AbstractPiece soldier = new Soldier(5);
		soldier.setName("Captain");
		return soldier;
	}

	public static AbstractPiece createLieutenant() {
		AbstractPiece soldier = new Soldier(4);
		soldier.setName("Lieut");
		return soldier;
	}

	public static AbstractPiece createSergeant() {
		AbstractPiece soldier = new Soldier(3);
		soldier.setName("Sergeant");
		return soldier;
	}

	public static AbstractPiece createMiner() {
		AbstractPiece soldier = new Soldier(2);
		soldier.setName("Miner");
		return soldier;
	}

	public static AbstractPiece createScout() {
		AbstractPiece soldier = new Soldier(1);
		soldier.setName("Scout");
		return soldier;
	}

}
