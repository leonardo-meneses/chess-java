package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;

public class KING extends ChessPiece{

	public KING(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "K";
	}

}
