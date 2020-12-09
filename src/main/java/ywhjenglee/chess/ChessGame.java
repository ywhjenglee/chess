package ywhjenglee.chess;

import ywhjenglee.chess.Pieces.Piece;
import ywhjenglee.chess.Pieces.Pawn;
import ywhjenglee.chess.Pieces.Knight;
import ywhjenglee.chess.Pieces.Bishop;
import ywhjenglee.chess.Pieces.Rook;
import ywhjenglee.chess.Pieces.Queen;
import ywhjenglee.chess.Pieces.King;

public class ChessGame {
    
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;
    private static Tile[][] chessBoard;
    private static Piece selectedPiece;
    private static Tile selectedTile;
    private static int turnCount;
    private static boolean whiteTurn;

    public ChessGame() {
        chessBoard = new Tile[12][12];
        selectedPiece = null;
        turnCount = 0;
        whiteTurn = true;
        createTiles();
        setPieces();
    }

    private static void createTiles() {
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 12; i++) {
                chessBoard[i][j] = new Tile(i, j);
            }
        }
    }

    private static void setPieces() {
        for (int i = 2; i < 10; i++) {
            chessBoard[i][3].setPiece(new Pawn(WHITE));
            chessBoard[i][8].setPiece(new Pawn(BLACK));
        }
        chessBoard[2][2].setPiece(new Rook(WHITE));
        chessBoard[3][2].setPiece(new Knight(WHITE));
        chessBoard[4][2].setPiece(new Bishop(WHITE));
        chessBoard[5][2].setPiece(new Queen(WHITE));
        chessBoard[6][2].setPiece(new King(WHITE));
        chessBoard[7][2].setPiece(new Bishop(WHITE));
        chessBoard[8][2].setPiece(new Knight(WHITE));
        chessBoard[9][2].setPiece(new Rook(WHITE));

        chessBoard[2][9].setPiece(new Rook(BLACK));
        chessBoard[3][9].setPiece(new Knight(BLACK));
        chessBoard[4][9].setPiece(new Bishop(BLACK));
        chessBoard[5][9].setPiece(new Queen(BLACK));
        chessBoard[6][9].setPiece(new King(BLACK));
        chessBoard[7][9].setPiece(new Bishop(BLACK));
        chessBoard[8][9].setPiece(new Knight(BLACK));
        chessBoard[9][9].setPiece(new Rook(BLACK));
    }

    public void selectPiece(int x, int y) {
        Piece tempPiece = chessBoard[x][y].getPiece();
        if (tempPiece != null && tempPiece.getColor() == whiteTurn) {
            selectedPiece = chessBoard[x][y].getPiece();
            selectedTile = chessBoard[x][y];
            selectedPiece.generatePossibleMoves(chessBoard, selectedTile);
        }
    }

    public void movePiece(int x, int y) {
        if (selectedPiece != null) {
            boolean[][] legalMoves = selectedPiece.getLegalMoves();
            if (legalMoves[x][y]) {
                if (selectedTile.getTileX() != x && selectedTile.getTileY() != y) {
                    if (chessBoard[x][y].getPiece() != null) {
                        Piece capturedPiece = chessBoard[x][y].getPiece();
                    }
                    chessBoard[x][y].setPiece(selectedPiece);
                    selectedTile.removePiece();
                    whiteTurn = !whiteTurn;
                    turnCount++;
                }
                selectedPiece = null;
            }
        }
    }

    public int getTurnCount() {
        return turnCount;
    }
}
