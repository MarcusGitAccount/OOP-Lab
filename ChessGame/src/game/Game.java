package game;

import board.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import pieces.Piece;
import utils.Enums;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private Board board;
  private int turn;
  private int iteration ;
  private List<LostPiece> lostByWhite;
  private List<LostPiece> lostByBlack;

  public Game() {
    turn = iteration = 0;
    board = new Board();
    lostByBlack = new ArrayList<LostPiece>();
    lostByWhite = new ArrayList<LostPiece>();
  }

  private boolean isValidPosition(Vector position) {
    int i = position.getI();
    int j = position.getJ();

    if (i < 0 || j < 0)
      return false;
    if (i >= board.getROWS() || j >= board.getCOLS())
      return false;
    return true;
  }

  public boolean move(Vector source, Vector destination) {
    if (!isValidPosition(source) || !isValidPosition(destination))
      return false;
    if (source.equals(destination))
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

    // the king can not be run over
    if (end != null && end.getType() == Enums.ChessPieceType.KING)
      return false;
    if (!start.checkMove(destination, end))
      return false;

    List<Vector> additionalSteps= start.computeMove(destination);

    for (Vector position: additionalSteps) {
      if (board.retrievePiece(position) != null)
        return false;
    }

    if (end != null) {
      LostPiece lost = new LostPiece(iteration, end);

      if (_turn == 0)
        lostByBlack.add(lost);
      else
        lostByWhite.add(lost);
    }

    iteration++;
    board.setPiece(destination, start);
    board.setPiece(source, null);
    start.incrementMoves();
    return true;
  }

  public boolean move(int x1, int y1, int x2, int y2) {
    return this.move(new Vector(x1, y1), new Vector(x2, y2));
  }

  public boolean move() {
    // the player has decided to do nothing
    turn ^= 1;
    return true;
  }

  public void printBoard() {
    System.out.println("Game iteration: " + iteration);
    System.out.println("Current turn: " + getTurn());
    board.printBoard();
    System.out.println("Lost by white: ");
    printLost(lostByWhite);
    System.out.println("Lost by black: ");
    printLost(lostByBlack);
  }

  public Enums.ChessPieceColors getTurn() {
    if (turn == 0)
      return Enums.ChessPieceColors.WHITE;
    return Enums.ChessPieceColors.BLACK;
  }

  private void printLost(List<LostPiece> lost) {
    for (LostPiece piece: lost)
      System.out.println(piece);
  }

  public static void main(String[] args) {
    Game game = new Game();

    game.move(6, 1, 5, 1);
    game.move(1, 0, 2, 0);
    game.move(5, 1, 4, 1);
    game.move(2, 0, 3, 0);
    game.move(4, 1, 3, 0);
    game.move();
    game.move(3, 0, 2, 0);
    game.move(0, 1, 2, 0);
    game.move(7, 1, 5, 2);
    game.move(2, 0, 3, 2);
    game.move();
    game.move(0, 0, 6, 0);
    game.move(7, 0, 6, 0);
    game.move();
    game.move(6, 0, 0, 0);
    game.move(0, 7, 7, 7);
    game.move(7, 2, 5, 0);
    game.move(0, 2, 1, 1);
    game.move(0, 0, 0, 2);
    game.move(1, 7, 2, 7);
    game.move(5, 0, 3, 2);

    game.printBoard();
  }
}
