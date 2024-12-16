package ChessMain;

public class Board {
	private Piece[][] board;

	public Board() {
		board = new Piece[8][8];
	}

	public void placePiece(Piece piece, int x, int y) {
		board[x][y] = piece;
	}

	public boolean movePiece(int startX, int startY, int endX, int endY) {
		Piece piece = board[startX][startY];
		if (piece != null && piece.isValidMove(endX, endY, board)) {
			board[endX][endY] = piece;
			board[startX][startY] = null;
			piece.setPosition(endX, endY);
			return true;
		}
		return false;
	}

	public Piece getPiece(int x, int y) {
		return board[x][y];
	}
}
