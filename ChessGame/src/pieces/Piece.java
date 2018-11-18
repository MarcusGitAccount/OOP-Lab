package pieces;
import utils.Enums.*;
import utils.Vector;
import utils.Enums.ChessPieceColors;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
  private ChessPieceColors color;
  private Vector position;
  private int movesPerformed;

  public Piece(ChessPieceColors color, Vector position) {
    this.color = color;
    this.position = position;
    this.movesPerformed = 0;
  }

  public Piece() {
    this(ChessPieceColors.WHITE, Vector.ORIGIN);
  }

  // @param destination - location
  // @param existingPiece - piece found at the final location where the piece is to be moved
  // @returns a boolean representing if the move is valid or not
  public abstract boolean checkMove(Vector destination, Piece existingPiece);

  // @param destination - location
  // @returns an array of positions that will be passed in the process of moving the piece on the board
  // and need to be empty in order for the move to be valid
  // empty array => no additional checks are required
  public List<Vector> computeMove(Vector destination) {
    // retrieve the extra steps the tower make to reach its destination
    Vector diff = destination.add(this.getPosition().multiply(-1));
    Vector increment = diff.unit();
    Vector start = this.getPosition().add(increment);
    List<Vector> moves = new ArrayList<Vector>();

    while (!start.equals(destination)) {
      moves.add(start);
      start = start.add(increment);
    }

    return moves;
  }

  // @returns the unicode representation of the piece
  public abstract String getCode();

  // @returns the type
  public abstract ChessPieceType getType();

  public void setPosition(Vector position) {
    this.position = position;
  }

  public Vector getPosition() {
    return this.position;
  }

  public ChessPieceColors getColor() {
    return color;
  }

  public void setColor(ChessPieceColors color) {
    this.color = color;
  }

  public int getMovesPerformed() {
    return movesPerformed;
  }

  public void incrementMoves() {
    this.movesPerformed++;
  }

  @Override
  public String toString() {
    return position + " with " + movesPerformed + " moves performed.";
  }
}
