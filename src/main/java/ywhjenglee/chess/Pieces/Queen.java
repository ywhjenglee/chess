package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class Queen extends Piece {
    
    public Queen(boolean pColor) {
        super("Queen", pColor);
    }

    public void generatePossibleMoves(Tile[][] pChessBoard, Tile pTile) {
        int x = pTile.getTileX();
        int y = pTile.getTileX();
        legalMoves[x][y] = true;
        boolean E = false;
        boolean W = false;
        boolean N = false;
        boolean S = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && !E) {
                if (pChessBoard[x+i][y].getPiece() == null) {
                    legalMoves[x+i][y] = true;
                } else {
                    if (pChessBoard[x+i][y].getPiece().getColor() != aColor) {
                        legalMoves[x+i][y] = true;
                    }
                    E = true;
                }
            }
            if (x-i > 1 && !W) {
                if (pChessBoard[x-i][y].getPiece() == null) {
                    legalMoves[x-i][y] = true;
                } else {
                    if (pChessBoard[x-i][y].getPiece().getColor() != aColor) {
                        legalMoves[x-i][y] = true;
                    }
                    W = true;
                }
            }
            if (y+i < 10 && !N) {
                if (pChessBoard[x][y+i].getPiece() == null) {
                    legalMoves[x][y+i] = true;
                } else {
                    if (pChessBoard[x][y+i].getPiece().getColor() != aColor) {
                        legalMoves[x][y+i] = true;
                    }
                    N = true;
                }
            }
            if (y-i > 1 && !S) {
                if (pChessBoard[x][y-i].getPiece() == null) {
                    legalMoves[x][y-i] = true;
                } else {
                    if (pChessBoard[x][y-i].getPiece().getColor() != aColor) {
                        legalMoves[x][y-i] = true;
                    }
                    S = true;
                }
            }
        }
        boolean NE = false;
        boolean NW = false;
        boolean SE = false;
        boolean SW = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && y+i < 10 && !NE) {
                if (pChessBoard[x+i][y+i].getPiece() == null) {
                    legalMoves[x+i][y+i] = true;
                } else {
                    if (pChessBoard[x+i][y+i].getPiece().getColor() != aColor) {
                        legalMoves[x+i][y+i] = true;
                    }
                    NE = true;
                }
            }
            if (x-i > 1 && y+i < 10 && !NW) {
                if (pChessBoard[x-i][y+i].getPiece() == null) {
                    legalMoves[x-i][y+i] = true;
                } else {
                    if (pChessBoard[x-i][y+i].getPiece().getColor() != aColor) {
                        legalMoves[x-i][y+i] = true;
                    }
                    NW = true;
                }
            }
            if (x+i < 10 && y-i > 1 && !SE) {
                if (pChessBoard[x+i][y-i].getPiece() == null) {
                    legalMoves[x+i][y-i] = true;
                } else {
                    if (pChessBoard[x+i][y-i].getPiece().getColor() != aColor) {
                        legalMoves[x+i][y-i] = true;
                    }
                    SE = true;
                }
            }
            if (x-i > 1 && y-i > 1 && !SW) {
                if (pChessBoard[x-i][y-i].getPiece() == null) {
                    legalMoves[x-i][y-i] = true;
                } else {
                    if (pChessBoard[x-i][y-i].getPiece().getColor() != aColor) {
                        legalMoves[x-i][y-i] = true;
                    }
                    SW = true;
                }
            }
        }
    }
}
