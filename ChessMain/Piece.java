package ChessMain;
public abstract class Piece {
	protected int x; // Coordenada X
	protected int y; // Coordenada Y
	protected String color; // "white" o "black"

	public Piece(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public abstract boolean isValidMove(int newX, int newY, Piece[][] board);

	// Métodos comunes
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getColor() {
		return color;
	}
}
