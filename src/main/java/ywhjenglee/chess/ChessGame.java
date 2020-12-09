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
    private static Piece[][] chessBoard;

    public ChessGame() {
        chessBoard = new Piece[12][12];
        setupPieces();
    }

    private static void setupPieces() {
        for (int i = 2; i < 10; i++) {
            chessBoard[i][3] = new Pawn(WHITE);
            chessBoard[i][8] = new Pawn(BLACK);
        }
        chessBoard[2][2] = new Rook(WHITE);
        chessBoard[3][2] = new Knight(WHITE);
        chessBoard[4][2] = new Bishop(WHITE);
        chessBoard[5][2] = new Queen(WHITE);
        chessBoard[6][2] = new King(WHITE);
        chessBoard[7][2] = new Bishop(WHITE);
        chessBoard[8][2] = new Knight(WHITE);
        chessBoard[9][2] = new Rook(WHITE);

        chessBoard[2][9] = new Rook(BLACK);
        chessBoard[3][9] = new Knight(BLACK);
        chessBoard[4][9] = new Bishop(BLACK);
        chessBoard[5][9] = new Queen(BLACK);
        chessBoard[6][9] = new King(BLACK);
        chessBoard[7][9] = new Bishop(BLACK);
        chessBoard[8][9] = new Knight(BLACK);
        chessBoard[9][9] = new Rook(BLACK);
    }
}
