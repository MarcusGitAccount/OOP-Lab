package board;
import pieces.*;
import utils.Enums.ChessPieceColors;
import utils.Vector;

public class Board {
  private final int COLS = 8;
  private final int ROWS = 8;
  private Piece[][] board;

  public Board() {
    board = new Piece[ROWS][COLS];
    initBoard();
  }

  private void initBoard() {
    for (int i = 0; i < COLS; i++) {
      board[1][i] = new Pawn(ChessPieceColors.BLACK, new Vector(1, i));
      board[6][i] = new Pawn(ChessPieceColors.WHITE, new Vector(6, i));
    }
  }

  public void printBoard() {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if (board[i][j] == null)
          System.out.print(" ");
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
