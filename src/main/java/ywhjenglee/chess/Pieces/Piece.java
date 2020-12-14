package ywhjenglee.chess.Pieces;

public abstract class Piece {

    protected final boolean aColor;
    protected int x;
    protected int y;
    protected boolean hasMoved;
    protected int[][] aLegalMoves;
    /*
    0 = cantMove
    1 = canMoveTo
    2 = capture
    3 = pawnDouble
    4 = enPassantCapture
    5 = castleQueen
    6 = castleKing
    7 = initialPosition
    */

    protected Piece(boolean pColor, int pX, int pY) {
        aColor = pColor;
        x = pX;
        y = pY;
        hasMoved = false;
    }

    public abstract String getName();

    public boolean getColor() {
        return aColor;
    }

    public void setHasMoved() {
        hasMoved = true;
    }

    public void setPosition(int pX, int pY) {
        x = pX;
        y = pY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        aLegalMoves = new int[12][12];
    }

    public int[][] getLegalMoves() {
        return aLegalMoves;
    }

    protected void removeKingInCheck(Piece[][] pChessBoard) {
        King kingPiece = null;
        if (this.getClass() == King.class) {
            kingPiece = (King) this;
            for (int j = 2; j < 10; j++) {
                for (int i = 2; i < 10; i++) {
                    if (aLegalMoves[i][j] > 0 && aLegalMoves[i][j] < 5) {
                        Piece[][] tempBoard = new Piece[12][12];
                        for (int n = 2; n < 10; n++) {
                            for (int m = 2; m < 10; m++) {
                                tempBoard[m][n] = pChessBoard[m][n];
                            }
                        }
                        tempBoard[i][j] = this;
                        tempBoard[x][y] = null;
                        int tempX = kingPiece.getX();
                        int tempY = kingPiece.getY();
                        kingPiece.setPosition(i, j);
                        if (kingPiece.isInCheck(tempBoard)) {
                            aLegalMoves[i][j] = 0;
                        }
                        tempBoard[i][j] = null;
                        tempBoard[x][y] = this;
                        kingPiece.setPosition(tempX, tempY);
                    }
                }
            }
        } else {
            for (int j = 2; j < 10; j++) {
                for (int i = 2; i < 10; i++) {
                    if (pChessBoard[i][j] != null && pChessBoard[i][j].getClass() == King.class) {
                        if (pChessBoard[i][j].getColor() == aColor) {
                            kingPiece = (King) pChessBoard[i][j];
                            break;
                        }
                    }
                }
            }
            for (int j = 2; j < 10; j++) {
                for (int i = 2; i < 10; i++) {
                    if (aLegalMoves[i][j] > 0) {
                        Piece[][] tempBoard = new Piece[12][12];
                        for (int n = 2; n < 10; n++) {
                            for (int m = 2; m < 10; m++) {
                                tempBoard[m][n] = pChessBoard[m][n];
                            }
                        }
                        tempBoard[i][j] = this;
                        tempBoard[x][y] = null;
                        if (kingPiece.isInCheck(tempBoard)) {
                            aLegalMoves[i][j] = 0;
                        }
                        tempBoard[i][j] = null;
                        tempBoard[x][y] = this;
                    }
                }
            }
        }
    }
}
