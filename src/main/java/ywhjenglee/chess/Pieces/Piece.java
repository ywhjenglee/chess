package ywhjenglee.chess.Pieces;

public abstract class Piece {

    private final String aName;
    protected final boolean aColor;
    protected int x;
    protected int y;
    protected boolean hasMoved;
    protected boolean[][] paddedLegalMoves;
    protected Piece[][] paddedChessBoard;

    protected Piece(String pName, boolean pColor, int pX, int pY) {
        aName = pName;
        aColor = pColor;
        x = pX + 2;
        y = pY + 2;
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
        x = pX + 2;
        y = pY + 2;
    }

    public int getX() {
        return x - 2;
    }

    public int getY() {
        return y - 2;
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        paddedLegalMoves = new boolean[12][12];
        paddedChessBoard = new Piece[12][12];
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                paddedChessBoard[i+2][j+2] = pChessBoard[i][j];
            }
        }
    }

    public boolean[][] getLegalMoves() {
        boolean[][] legalMoves = new boolean[8][8];
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                legalMoves[i][j] = paddedLegalMoves[i+2][j+2];
            }
        }
        return legalMoves;
    }

    protected void removeAllyOccupied(Piece[][] pPaddedChessBoard) {
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (pPaddedChessBoard[i][j] != null) {
                    if (pPaddedChessBoard[i][j].getColor() == aColor) {
                        paddedLegalMoves[i][j] = false;
                    }
                }
            }
        }
    }

    protected void removeKingWillBeInCheck(Piece[][] pPaddedChessBoard) {
        King kingPiece = new King(true, 0, 0);
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (pPaddedChessBoard[i][j] != null && pPaddedChessBoard[i][j].getClass() == King.class) {
                    if (pPaddedChessBoard[i][j].getColor() == aColor) {
                        kingPiece = (King) pPaddedChessBoard[i][j];
                        break;
                    }
                }
            }
        }
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (paddedLegalMoves[i][j]) {
                    Piece[][] tempBoard = pPaddedChessBoard;
                    tempBoard[i][j] = this;
                    tempBoard[x][y] = null;
                    if (kingPiece.isInCheck(tempBoard)) {
                        paddedLegalMoves[i][j] = false;
                    }
                }
            }
        }
    }
}
