package ywhjenglee.chess.Pieces;

public class Pawn extends Piece {
    
    public Pawn(boolean pColor, int pX, int pY) {
        super("Pawn", pColor, pX, pY);
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        if (aColor) {
            if (paddedChessBoard[x][y+1] == null) {
                paddedLegalMoves[x][y+1] = true;
                if (paddedChessBoard[x][y+2] == null && !hasMoved) {
                    paddedLegalMoves[x][y+2] = true;
                }
            }
            if (paddedChessBoard[x+1][y+1] != null && paddedChessBoard[x+1][y+1].getColor() != aColor) {
                paddedLegalMoves[x+1][y+1] = true;
            }
            if (paddedChessBoard[x-1][y+1] != null && paddedChessBoard[x-1][y+1].getColor() != aColor) {
                paddedLegalMoves[x-1][y+1] = true;
            }
        } else {
            if (paddedChessBoard[x][y-1] == null) {
                paddedLegalMoves[x][y-1] = true;
                if (paddedChessBoard[x][y-2] == null && !hasMoved) {
                    paddedLegalMoves[x][y-2] = true;
                }
            }
            if (paddedChessBoard[x+1][y-1] != null && paddedChessBoard[x+1][y-1].getColor() != aColor) {
                paddedLegalMoves[x+1][y-1] = true;
            }
            if (paddedChessBoard[x-1][y-1] != null && paddedChessBoard[x-1][y-1].getColor() != aColor) {
                paddedLegalMoves[x-1][y-1] = true;
            }
        }
        removeKingInCheck(paddedChessBoard);
        paddedLegalMoves[x][y] = true;
    }
}
