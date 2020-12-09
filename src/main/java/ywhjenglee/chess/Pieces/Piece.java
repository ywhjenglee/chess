package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public abstract class Piece {

    private final String aName;
    private final boolean aColor;
    protected static boolean[][] legalMoves;

    protected Piece(String pName, boolean pColor) {
        aName = pName;
        aColor = pColor;
        legalMoves = new boolean[12][12];
    }

    public String getName() {
        return aName;
    }

    public boolean getColor() {
        return aColor;
    }

    public abstract void generatePossibleMoves(Tile[][] pChessBoard, Tile pTile);

    public boolean[][] getLegalMoves() {
        removeOutOfBounds();
        return legalMoves;
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
