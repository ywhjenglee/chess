package ywhjenglee.chess.Pieces;

public abstract class Piece {

    private final String aName;
    private final boolean aColor;
    private static boolean[][] legalMoves;

    protected Piece(String pName, boolean pColor) {
        aName = pName;
        aColor = pColor;
        legalMoves = new boolean[12][12];
    }

    private static void removeOutOfBounds() {
        for (int i = 0; i < 12; i++) {
            legalMoves[i][0] = false;
            legalMoves[i][1] = false;
            legalMoves[i][10] = false;
            legalMoves[i][11] = false;
        }
    }
}
