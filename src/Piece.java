public class Piece {
    public static final int WHITE = 0;
    public static final int BLACK = 1;

    public static final int PIECE_KING = 0;
    public static final int PIECE_QUEEN = 1;
    public static final int PIECE_ROOK = 2;
    public static final int PIECE_BISHOP = 3;
    public static final int PIECE_KNIGHT = 4;
    public static final int PIECE_PAWN = 5;

    private int color;
    private int type;

    public Piece(int color, int type) {
        this.color = color;
        this.type = type;
    }

    public int getColor() {
        return color;
    }

    public int getType() {
        return type;
    }
}
