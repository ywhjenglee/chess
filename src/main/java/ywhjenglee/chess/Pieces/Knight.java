package ywhjenglee.chess.Pieces;

public class Knight extends Piece {

    public Knight(boolean pColor, int pX, int pY) {
        super("Knight", pColor, pX, pY);
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        paddedLegalMoves[x+1][y+2] = true;
        paddedLegalMoves[x-1][y+2] = true;
        paddedLegalMoves[x+1][y-2] = true;
        paddedLegalMoves[x-1][y-2] = true;
        paddedLegalMoves[x+2][y+1] = true;
        paddedLegalMoves[x-2][y+1] = true;
        paddedLegalMoves[x+2][y-1] = true;
        paddedLegalMoves[x-2][y-1] = true;
        removeAllyOccupied(paddedChessBoard);
        removeKingWillBeInCheck(paddedChessBoard);
        paddedLegalMoves[x][y] = true;
    }
}
