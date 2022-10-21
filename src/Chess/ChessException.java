package Chess;

import boardGame.BoardExcepition;

public class ChessException extends BoardExcepition{

	private static final long serialVersionUID = 1L;

	public ChessException(String string) {
		super(string);
	}

}
