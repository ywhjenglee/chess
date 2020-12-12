package ywhjenglee.chess.Pieces;

public class Rook extends Piece {
    
    public Rook(boolean pColor, int pX, int pY) {
        super("Rook", pColor, pX, pY);
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        boolean E = false;
        boolean W = false;
        boolean N = false;
        boolean S = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && !E) {
                if (pChessBoard[x+i][y] == null) {
                    aLegalMoves[x+i][y] = true;
                } else {
                    if (pChessBoard[x+i][y].getColor() != aColor) {
                        aLegalMoves[x+i][y] = true;
                    }
                    E = true;
                }
            }
            if (x-i > 1 && !W) {
                if (pChessBoard[x-i][y] == null) {
                    aLegalMoves[x-i][y] = true;
                } else {
                    if (pChessBoard[x-i][y].getColor() != aColor) {
                        aLegalMoves[x-i][y] = true;
                    }
                    W = true;
                }
            }
            if (y+i < 10 && !N) {
                if (pChessBoard[x][y+i] == null) {
                    aLegalMoves[x][y+i] = true;
                } else {
                    if (pChessBoard[x][y+i].getColor() != aColor) {
                        aLegalMoves[x][y+i] = true;
                    }
                    N = true;
                }
            }
            if (y-i > 1 && !S) {
                if (pChessBoard[x][y-i] == null) {
                    aLegalMoves[x][y-i] = true;
                } else {
                    if (pChessBoard[x][y-i].getColor() != aColor) {
                        aLegalMoves[x][y-i] = true;
                    }
                    S = true;
                }
            }
        }
        removeKingInCheck(pChessBoard);
        aLegalMoves[x][y] = true;
    }
}
