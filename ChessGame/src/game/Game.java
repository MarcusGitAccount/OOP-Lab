package game;
import board.Board;
import pieces.Piece;
import utils.Enums;
import utils.Vector;

public class Game {
  private Board board;
  private int turn = 0;

  public Game() {
    board = new Board();
  }

  private boolean isValidPostion(Vector position) {
    int i = position.getI();
    int j = position.getJ();

    if (i < 0 || j < 0)
      return false;
    if (i >= board.getROWS() || j >= board.getCOLS())
      return false;
    return true;
  }

  public boolean move(Vector source, Vector destination) {
    if (!isValidPostion(source) || !isValidPostion(destination))
      return false;

    int _turn = turn;
    turn ^= 1;

    Piece start = board.retrievePiece(source);
    Piece end   = board.retrievePiece(destination);

    if (start == null)
      return false;
    if (end != null && start.getColor() == end.getColor())
      return false;

    if (start.getColor() == Enums.ChessPieceColors.WHITE && _turn == 1)
      return false;
    if (start.getColor() == Enums.ChessPieceColors.BLACK && _turn == 0)
      return false;

    if (!start.checkMove(destination, end))
      return false;

    Vector[] additionalSteps= start.computeMove(destination);

    for (Vector position: additionalSteps) {
      if (board.retrievePiece(position) != null)
        return false;
    }

    board.setPiece(destination, start);
    board.setPiece(source, null);
    return true;
  }

  public boolean move(int x1, int y1, int x2, int y2) {
    return this.move(new Vector(x1, y1), new Vector(x2, y2));
  }

  public void printBoard() {
    board.printBoard();
  }

  public static void main(String[] args) {
    Game game = new Game();

    game.move(6, 1, 5, 1);
    game.move(1, 0, 2, 0);
    game.move(5, 1, 4, 1);
    game.move(2, 0, 3, 0);
    game.move(4, 1, 3, 0);

    game.printBoard();
  }
}
