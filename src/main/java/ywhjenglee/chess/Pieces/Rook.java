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
                if (paddedChessBoard[x+i][y] == null) {
                    paddedLegalMoves[x+i][y] = true;
                } else {
                    if (paddedChessBoard[x+i][y].getColor() != aColor) {
                        paddedLegalMoves[x+i][y] = true;
                    }
                    E = true;
                }
            }
            if (x-i > 1 && !W) {
                if (paddedChessBoard[x-i][y] == null) {
                    paddedLegalMoves[x-i][y] = true;
                } else {
                    if (paddedChessBoard[x-i][y].getColor() != aColor) {
                        paddedLegalMoves[x-i][y] = true;
                    }
                    W = true;
                }
            }
            if (y+i < 10 && !N) {
                if (paddedChessBoard[x][y+i] == null) {
                    paddedLegalMoves[x][y+i] = true;
                } else {
                    if (paddedChessBoard[x][y+i].getColor() != aColor) {
                        paddedLegalMoves[x][y+i] = true;
                    }
                    N = true;
                }
            }
            if (y-i > 1 && !S) {
                if (paddedChessBoard[x][y-i] == null) {
                    paddedLegalMoves[x][y-i] = true;
                } else {
                    if (paddedChessBoard[x][y-i].getColor() != aColor) {
                        paddedLegalMoves[x][y-i] = true;
                    }
                    S = true;
                }
            }
        }
        removeKingInCheck(paddedChessBoard);
        paddedLegalMoves[x][y] = true;
    }
}
