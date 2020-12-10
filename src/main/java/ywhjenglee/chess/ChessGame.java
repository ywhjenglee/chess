package ywhjenglee.chess;

import ywhjenglee.chess.Pieces.Piece;
import ywhjenglee.chess.Pieces.Pawn;
import ywhjenglee.chess.Pieces.Knight;
import ywhjenglee.chess.Pieces.Bishop;
import ywhjenglee.chess.Pieces.Rook;
import ywhjenglee.chess.Pieces.Queen;
import ywhjenglee.chess.Pieces.King;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ChessGame {
    
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;
    private static Tile[][] chessBoard;
    private static Piece selectedPiece;
    private static Tile selectedTile;
    private static int turnCount;
    private static boolean whiteTurn;
    private static List<Piece> whitesCaptures;
    private static List<Piece> blacksCaptures;

    public ChessGame() {
        chessBoard = new Tile[12][12];
        selectedPiece = null;
        turnCount = 0;
        whiteTurn = true;
        whitesCaptures = new ArrayList<>();
        blacksCaptures = new ArrayList<>();
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

    public void selectPiece(int pX, int pY) {
        Piece tempPiece = chessBoard[pX][pY].getPiece();
        if (tempPiece != null && tempPiece.getColor() == whiteTurn) {
            selectedPiece = chessBoard[pX][pY].getPiece();
            selectedTile = chessBoard[pX][pY];
            selectedPiece.generatePossibleMoves(chessBoard);
        }
    }

    public void movePiece(int pX, int pY) {
        if (selectedPiece != null) {
            boolean[][] legalMoves = selectedPiece.getLegalMoves();
            if (legalMoves[pX][pY]) {
                if (selectedTile.getTileX() != pX && selectedTile.getTileY() != pY) {
                    if (chessBoard[pX][pY].getPiece() != null) {
                        if (whiteTurn) {
                            whitesCaptures.add(chessBoard[pX][pY].getPiece());
                        } else {
                            blacksCaptures.add(chessBoard[pX][pY].getPiece());
                        }
                    }
                    chessBoard[pX][pY].setPiece(selectedPiece);
                    selectedPiece.setPosition(pX, pY);
                    selectedPiece.setHasMoved();
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

    public List<Piece> getWhitesCaptures() {
        return Collections.unmodifiableList(whitesCaptures);
    }

    public List<Piece> getBlacksCaptures() {
        return Collections.unmodifiableList(blacksCaptures);
    }
}
