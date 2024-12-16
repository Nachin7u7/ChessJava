package ChessMain;
public class King extends Piece {

	public King(int x, int y, String color) {
		super(x, y, color);
	}

	@Override
	public boolean isValidMove(int newX, int newY, Piece[][] board) {
		int dx = Math.abs(newX - x);
		int dy = Math.abs(newY - y);

		// Movimiento válido si se mueve un cuadro en cualquier dirección
		if ((dx <= 1 && dy <= 1) && !(dx == 0 && dy == 0)) {
			// Verificar que no hay una pieza del mismo color en la posición destino
			if (board[newX][newY] == null || !board[newX][newY].getColor().equals(color)) {
				return true;
			}
		}
		return false;
	}
}
