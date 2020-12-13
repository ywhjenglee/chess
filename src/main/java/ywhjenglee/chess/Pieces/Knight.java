package ywhjenglee.chess.Pieces;

public class Knight extends Piece {

    public Knight(boolean pColor, int pX, int pY) {
        super("Knight", pColor, pX, pY);
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        aLegalMoves[x+1][y+2] = 1;
        aLegalMoves[x-1][y+2] = 1;
        aLegalMoves[x+1][y-2] = 1;
        aLegalMoves[x-1][y-2] = 1;
        aLegalMoves[x+2][y+1] = 1;
        aLegalMoves[x-2][y+1] = 1;
        aLegalMoves[x+2][y-1] = 1;
        aLegalMoves[x-2][y-1] = 1;
        removeAllyOccupied(pChessBoard);
        removeKingInCheck(pChessBoard);
        aLegalMoves[x][y] = 1;
    }
}
