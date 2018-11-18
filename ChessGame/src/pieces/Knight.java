package pieces;

import utils.Enums.*;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
  private static final Vector[] directions = new Vector[]{
      new Vector(-2, -1), new Vector(-2, 1),
      new Vector(-1, -2), new Vector(-1, 2),
      new Vector(1, -2),  new Vector(1, 2),
      new Vector(2, -1),  new Vector(2, 1)
  };

  public Knight(ChessPieceColors color, Vector position) {
    super(color, position);
  }

  @Override
  public boolean checkMove(Vector destination, Piece existingPiece) {
    for (Vector direction: directions) {
      if (this.getPosition().add(direction).equals(destination))
        return true;
    }

    return false;
  }

  @Override
  public List<Vector> computeMove(Vector destination) {
    return new ArrayList<Vector>();
  }

  @Override
  public String getCode() {
    ChessPieceColors color = this.getColor();

    if (color == ChessPieceColors.WHITE)
      return "\u2658";
    return "\u265E";
  }

  @Override
  public ChessPieceType getType() {
    return ChessPieceType.KNIGHT;
  }

  @Override
  public String toString() {
    return "@Knight at " + super.toString();
  }
}
