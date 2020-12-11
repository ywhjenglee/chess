package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public abstract class Piece {

    private final String aName;
    protected final boolean aColor;
    protected int x;
    protected int y;
    protected boolean hasMoved;
    protected boolean[][] legalMoves;

    protected Piece(String pName, boolean pColor, int pX, int pY) {
        aName = pName;
        aColor = pColor;
        x = pX;
        y = pY;
        hasMoved = false;
        legalMoves = new boolean[12][12];
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

    public abstract void generatePossibleMoves(Tile[][] pChessBoard);

    public boolean[][] getLegalMoves() {
        return legalMoves;
    }

    protected void removeOutOfBounds() {
        for (int i = 0; i < 12; i++) {
            legalMoves[i][0] = false;
            legalMoves[i][1] = false;
            legalMoves[i][10] = false;
            legalMoves[i][11] = false;
        }
    }

    protected void removeAllyOccupied(Tile[][] pChessBoard) {
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (pChessBoard[i][j].getPiece() != null) {
                    if (pChessBoard[i][j].getPiece().getColor() == aColor) {
                        legalMoves[i][j] = false;
                    }
                }
            }
        }
    }

    protected void removeKingWillBeInCheck(Tile[][] pChessBoard) {
        King kingPiece = new King(true, 0, 0);
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (pChessBoard[i][j].getPiece() != null && pChessBoard[i][j].getPiece().getClass() == King.class) {
                    if (pChessBoard[i][j].getPiece().getColor() == aColor) {
                        kingPiece = (King) pChessBoard[i][j].getPiece();
                        break;
                    }
                }
            }
        }
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (legalMoves[i][j]) {
                    Tile[][] tempBoard = pChessBoard;
                    tempBoard[i][j].setPiece(this);
                    tempBoard[x][y].removePiece();
                    if (kingPiece.isInCheck(tempBoard, kingPiece.x, kingPiece.y)) {
                        legalMoves[i][j] = false;
                    }
                }
            }
        }
    }
}
