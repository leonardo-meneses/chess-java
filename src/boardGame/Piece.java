package boardGame;

public class Piece {
	protected Position position;// com protected a classe fica visivel apenas para classes do mesmo pacote e subclasses
	private Board board;
	
	public Piece(Board board) {
		//super();
		this.board = board;
		position = null; // opcional o java ja atribui null.
	}

	protected Board getBoard() {
		return board;
	}
		
}
