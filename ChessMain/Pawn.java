package ChessMain;

public class Pawn extends Piece {

	public Pawn(int x, int y, String color) {
		super(x, y, color);
	}

	@Override
	public boolean isValidMove(int newX, int newY, Piece[][] board) {
		int direction = color.equals("white") ? -1 : 1; // Blancas se mueven hacia arriba, negras hacia abajo
		int startRow = color.equals("white") ? 6 : 1;

		// Movimiento normal de un cuadro
		if (newX == x + direction && newY == y && board[newX][newY] == null) {
			return true;
		}

		// Movimiento inicial de dos cuadros
		if (x == startRow && newX == x + 2 * direction && newY == y && board[x + direction][y] == null
				&& board[newX][newY] == null) {
			return true;
		}

		// Movimiento de captura diagonal
		if (newX == x + direction && Math.abs(newY - y) == 1 && board[newX][newY] != null
				&& !board[newX][newY].getColor().equals(color)) {
			return true;
		}

		return false;
	}
}
