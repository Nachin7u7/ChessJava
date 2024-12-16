package ChessMain;
public class Rook extends Piece {

	public Rook(int x, int y, String color) {
		super(x, y, color);
	}

	@Override
	public boolean isValidMove(int newX, int newY, Piece[][] board) {
		// Movimiento válido si está en la misma fila o columna
		if (x == newX || y == newY) {
			// Verificar si el camino está despejado
			int dx = Integer.compare(newX, x); // Dirección del movimiento en X
			int dy = Integer.compare(newY, y); // Dirección del movimiento en Y

			int currX = x + dx;
			int currY = y + dy;
			while (currX != newX || currY != newY) {
				if (board[currX][currY] != null) {
					return false; // Hay una pieza bloqueando
				}
				currX += dx;
				currY += dy;
			}

			// Verificar que no hay una pieza del mismo color en la posición destino
			return board[newX][newY] == null || !board[newX][newY].getColor().equals(color);
		}
		return false;
	}
}
