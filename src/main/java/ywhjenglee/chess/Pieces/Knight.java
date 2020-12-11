package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class Knight extends Piece {

    public Knight(boolean pColor, int pX, int pY) {
        super("Knight", pColor, pX, pY);
    }

    public void generatePossibleMoves(Tile[][] pChessBoard) {
        legalMoves = new boolean[12][12];
        legalMoves[x+1][y+2] = true;
        legalMoves[x-1][y+2] = true;
        legalMoves[x+1][y-2] = true;
        legalMoves[x-1][y-2] = true;
        legalMoves[x+2][y+1] = true;
        legalMoves[x-2][y+1] = true;
        legalMoves[x+2][y-1] = true;
        legalMoves[x-2][y-1] = true;
        removeOutOfBounds();
        removeAllyOccupied(pChessBoard);
        legalMoves[x][y] = true;
    }
}
