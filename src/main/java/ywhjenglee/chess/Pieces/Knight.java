package ywhjenglee.chess.Pieces;

public class Knight extends Piece {

    public Knight(boolean pColor, int pX, int pY) {
        super(pColor, pX, pY);
    }

    public String getName() {
        if (aColor) {
            return "♘";
        } else {
            return "♞";
        }
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        if (pChessBoard[x+1][y+2] == null) {
            aLegalMoves[x+1][y+2] = 1;
        } else {
            if (pChessBoard[x+1][y+2].getColor() != aColor) {
                aLegalMoves[x+1][y+2] = 2;
            }
        }
        if (pChessBoard[x-1][y+2] == null) {
            aLegalMoves[x-1][y+2] = 1;
        } else {
            if (pChessBoard[x-1][y+2].getColor() != aColor) {
                aLegalMoves[x-1][y+2] = 2;
            }
        }
        if (pChessBoard[x+1][y-2] == null) {
            aLegalMoves[x+1][y-2] = 1;
        } else {
            if (pChessBoard[x+1][y-2].getColor() != aColor) {
                aLegalMoves[x+1][y-2] = 2;
            }
        }
        if (pChessBoard[x-1][y-2] == null) {
            aLegalMoves[x-1][y-2] = 1;
        } else {
            if (pChessBoard[x-1][y-2].getColor() != aColor) {
                aLegalMoves[x-1][y-2] = 2;
            }
        }
        if (pChessBoard[x+2][y+1] == null) {
            aLegalMoves[x+2][y+1] = 1;
        } else {
            if (pChessBoard[x+2][y+1].getColor() != aColor) {
                aLegalMoves[x+2][y+1] = 2;
            }
        }
        if (pChessBoard[x-2][y+1] == null) {
            aLegalMoves[x-2][y+1] = 1;
        } else {
            if (pChessBoard[x-2][y+1].getColor() != aColor) {
                aLegalMoves[x-2][y+1] = 2;
            }
        }
        if (pChessBoard[x+2][y-1] == null) {
            aLegalMoves[x+2][y-1] = 1;
        } else {
            if (pChessBoard[x+2][y-1].getColor() != aColor) {
                aLegalMoves[x+2][y-1] = 2;
            }
        }
        if (pChessBoard[x-2][y-1] == null) {
            aLegalMoves[x-2][y-1] = 1;
        } else {
            if (pChessBoard[x-2][y-1].getColor() != aColor) {
                aLegalMoves[x-2][y-1] = 2;
            }
        }
        removeKingInCheck(pChessBoard);
        aLegalMoves[x][y] = 1;
    }
}
