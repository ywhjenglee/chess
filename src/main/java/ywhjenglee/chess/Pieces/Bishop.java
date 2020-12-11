package ywhjenglee.chess.Pieces;

public class Bishop extends Piece {

    public Bishop(boolean pColor, int pX, int pY) {
        super("Bishop", pColor, pX, pY);
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        boolean NE = false;
        boolean NW = false;
        boolean SE = false;
        boolean SW = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && y+i < 10 && !NE) {
                if (paddedChessBoard[x+i][y+i] == null) {
                    paddedLegalMoves[x+i][y+i] = true;
                } else {
                    if (paddedChessBoard[x+i][y+i].getColor() != aColor) {
                        paddedLegalMoves[x+i][y+i] = true;
                    }
                    NE = true;
                }
            }
            if (x-i > 1 && y+i < 10 && !NW) {
                if (paddedChessBoard[x-i][y+i] == null) {
                    paddedLegalMoves[x-i][y+i] = true;
                } else {
                    if (paddedChessBoard[x-i][y+i].getColor() != aColor) {
                        paddedLegalMoves[x-i][y+i] = true;
                    }
                    NW = true;
                }
            }
            if (x+i < 10 && y-i > 1 && !SE) {
                if (paddedChessBoard[x+i][y-i] == null) {
                    paddedLegalMoves[x+i][y-i] = true;
                } else {
                    if (paddedChessBoard[x+i][y-i].getColor() != aColor) {
                        paddedLegalMoves[x+i][y-i] = true;
                    }
                    SE = true;
                }
            }
            if (x-i > 1 && y-i > 1 && !SW) {
                if (paddedChessBoard[x-i][y-i] == null) {
                    paddedLegalMoves[x-i][y-i] = true;
                } else {
                    if (paddedChessBoard[x-i][y-i].getColor() != aColor) {
                        paddedLegalMoves[x-i][y-i] = true;
                    }
                    SW = true;
                }
            }
        }
        paddedLegalMoves[x][y] = true;
    }
}
