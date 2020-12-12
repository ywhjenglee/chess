package ywhjenglee.chess.Pieces;

public class Pawn extends Piece {
    
    public Pawn(boolean pColor, int pX, int pY) {
        super("Pawn", pColor, pX, pY);
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        if (aColor) {
            if (pChessBoard[x][y+1] == null) {
                aLegalMoves[x][y+1] = true;
                if (pChessBoard[x][y+2] == null && !hasMoved) {
                    aLegalMoves[x][y+2] = true;
                }
            }
            if (pChessBoard[x+1][y+1] != null && pChessBoard[x+1][y+1].getColor() != aColor) {
                aLegalMoves[x+1][y+1] = true;
            }
            if (pChessBoard[x-1][y+1] != null && pChessBoard[x-1][y+1].getColor() != aColor) {
                aLegalMoves[x-1][y+1] = true;
            }
        } else {
            if (pChessBoard[x][y-1] == null) {
                aLegalMoves[x][y-1] = true;
                if (pChessBoard[x][y-2] == null && !hasMoved) {
                    aLegalMoves[x][y-2] = true;
                }
            }
            if (pChessBoard[x+1][y-1] != null && pChessBoard[x+1][y-1].getColor() != aColor) {
                aLegalMoves[x+1][y-1] = true;
            }
            if (pChessBoard[x-1][y-1] != null && pChessBoard[x-1][y-1].getColor() != aColor) {
                aLegalMoves[x-1][y-1] = true;
            }
        }
        removeKingInCheck(pChessBoard);
        aLegalMoves[x][y] = true;
    }
}
