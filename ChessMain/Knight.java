package ChessMain;
public class Knight extends Piece {

	public Knight(int x, int y, String color) {
		super(x, y, color);
	}

	@Override
	public boolean isValidMove(int newX, int newY, Piece[][] board) {
		int dx = Math.abs(newX - x);
		int dy = Math.abs(newY - y);

		// Movimiento válido en forma de L
		if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
			// Verificar que no hay una pieza del mismo color en la posición destino
			return board[newX][newY] == null || !board[newX][newY].getColor().equals(color);
		}
		return false;
	}
}
