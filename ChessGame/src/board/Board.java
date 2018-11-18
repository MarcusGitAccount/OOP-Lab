package board;
import pieces.*;
import utils.Enums.ChessPieceColors;
import utils.Vector;

import java.util.List;

public class Board {
  private final int COLS = 8;
  private final int ROWS = 8;
  private Piece[][] board;


  public Board() {
    board = new Piece[ROWS][COLS];
    initBoard();
  }

  private void initBoard() {
    // set up pawns
    for (int i = 0; i < COLS; i++) {
      board[1][i] = new Pawn(ChessPieceColors.BLACK, new Vector(1, i));
      board[6][i] = new Pawn(ChessPieceColors.WHITE, new Vector(6, i));
    }

    // set up knights
    board[0][1] = new Knight(ChessPieceColors.BLACK, new Vector(0, 1));
    board[0][6] = new Knight(ChessPieceColors.BLACK, new Vector(0, 6));

    board[7][1] = new Knight(ChessPieceColors.WHITE, new Vector(7, 1));
    board[7][6] = new Knight(ChessPieceColors.WHITE, new Vector(7, 6));

    // set up towers
    board[0][0] = new Tower(ChessPieceColors.BLACK, new Vector(0, 0));
    board[0][7] = new Tower(ChessPieceColors.BLACK, new Vector(0, 7));

    board[7][0] = new Tower(ChessPieceColors.WHITE, new Vector(7, 0));
    board[7][7] = new Tower(ChessPieceColors.WHITE, new Vector(7, 7));

    // set up Bishops
    board[0][2] = new Bishop(ChessPieceColors.BLACK, new Vector(0, 2));
    board[0][5] = new Bishop(ChessPieceColors.BLACK, new Vector(0, 5));

    board[7][2] = new Bishop(ChessPieceColors.WHITE, new Vector(7, 2));
    board[7][5] = new Bishop(ChessPieceColors.WHITE, new Vector(7, 5));
  }

  public void printBoard() {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if (board[i][j] == null)
          System.out.print("__");
        else
          System.out.print(board[i][j].getCode());
      }
      System.out.println();
    }
  }

  public Piece getPiece(int i, int j) {
    return board[i][j];
  }

  public Piece retrievePiece(Vector position) {
    return board[position.getI()][position.getJ()];
  }

  public void setPiece(Vector position, Piece piece) {
    if (piece != null)
      piece.setPosition(position);
    board[position.getI()][position.getJ()] = piece;
  }

  public int getCOLS() {
    return COLS;
  }

  public int getROWS() {
    return ROWS;
  }
}
