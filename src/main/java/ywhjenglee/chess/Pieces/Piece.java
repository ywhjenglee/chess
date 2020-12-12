package ywhjenglee.chess.Pieces;

public abstract class Piece {

    private final String aName;
    protected final boolean aColor;
    protected int x;
    protected int y;
    protected boolean hasMoved;
    protected boolean[][] aLegalMoves;

    protected Piece(String pName, boolean pColor, int pX, int pY) {
        aName = pName;
        aColor = pColor;
        x = pX;
        y = pY;
        hasMoved = false;
    }

    public String getName() {
        return String.valueOf(aColor) + aName;
    }

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
        aLegalMoves = new boolean[12][12];
    }

    public boolean[][] getLegalMoves() {
        return aLegalMoves;
    }

    protected void removeAllyOccupied(Piece[][] pChessBoard) {
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (pChessBoard[i][j] != null) {
                    if (pChessBoard[i][j].getColor() == aColor) {
                        aLegalMoves[i][j] = false;
                    }
                }
            }
        }
    }

    protected void removeKingInCheck(Piece[][] pChessBoard) {
        King kingPiece = null;
        if (this.getClass() == King.class) {
            kingPiece = (King) this;
            for (int j = 2; j < 10; j++) {
                for (int i = 2; i < 10; i++) {
                    if (aLegalMoves[i][j]) {
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
                            aLegalMoves[i][j] = false;
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
                    if (aLegalMoves[i][j]) {
                        Piece[][] tempBoard = new Piece[12][12];
                        for (int n = 2; n < 10; n++) {
                            for (int m = 2; m < 10; m++) {
                                tempBoard[m][n] = pChessBoard[m][n];
                            }
                        }
                        tempBoard[i][j] = this;
                        tempBoard[x][y] = null;
                        if (kingPiece.isInCheck(tempBoard)) {
                            aLegalMoves[i][j] = false;
                        }
                        tempBoard[i][j] = null;
                        tempBoard[x][y] = this;
                    }
                }
            }
        }
    }
}
