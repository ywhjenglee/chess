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
            chessBoard[i][3].setPiece(new Pawn(WHITE, i, 3));
            chessBoard[i][8].setPiece(new Pawn(BLACK, i, 8));
        }
        chessBoard[2][2].setPiece(new Rook(WHITE, 2, 2));
        chessBoard[3][2].setPiece(new Knight(WHITE, 3, 2));
        chessBoard[4][2].setPiece(new Bishop(WHITE, 4, 2));
        chessBoard[5][2].setPiece(new Queen(WHITE, 5, 2));
        chessBoard[6][2].setPiece(new King(WHITE, 6, 2));
        chessBoard[7][2].setPiece(new Bishop(WHITE, 7, 2));
        chessBoard[8][2].setPiece(new Knight(WHITE, 8, 2));
        chessBoard[9][2].setPiece(new Rook(WHITE, 9, 2));

        chessBoard[2][9].setPiece(new Rook(BLACK, 2, 9));
        chessBoard[3][9].setPiece(new Knight(BLACK, 3, 9));
        chessBoard[4][9].setPiece(new Bishop(BLACK, 4, 9));
        chessBoard[5][9].setPiece(new Queen(BLACK, 5, 9));
        chessBoard[6][9].setPiece(new King(BLACK, 6, 9));
        chessBoard[7][9].setPiece(new Bishop(BLACK, 7, 9));
        chessBoard[8][9].setPiece(new Knight(BLACK, 8, 9));
        chessBoard[9][9].setPiece(new Rook(BLACK, 9, 9));
    }

    public void selectPiece(int x, int y) {
        Piece tempPiece = chessBoard[x][y].getPiece();
        if (tempPiece != null && tempPiece.getColor() == whiteTurn) {
            selectedPiece = chessBoard[x][y].getPiece();
            selectedTile = chessBoard[x][y];
            selectedPiece.generatePossibleMoves(chessBoard);
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
                    selectedPiece.setPosition(x, y);
                    selectedPiece.setHasMoved();
                    selectedTile.removePiece();
                    whiteTurn = !whiteTurn;
                    turnCount++;
                }
                selectedPiece = null;
            }
        }
    }

    public void scanCheck() {
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (chessBoard[i][j].getPiece() != null && chessBoard[i][j].getPiece().getClass() == King.class) {

                }
            }
        }
    }

    public int getTurnCount() {
        return turnCount;
    }
}
