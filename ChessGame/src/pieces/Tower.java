package pieces;

import utils.Enums.*;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;

public class Tower extends Piece {
  public Tower(ChessPieceColors color, Vector position) {
    super(color, position);
  }

  @Override
  public boolean checkMove(Vector destination, Piece existingPiece) {
    Vector diff = destination.add(this.getPosition().multiply(-1));

    if (diff.getI() == 0)
      return true;
    if (diff.getJ() == 0)
      return true;
    return false;
  }

  @Override
  public String getCode() {
    ChessPieceColors color = this.getColor();

    if (color == ChessPieceColors.WHITE)
      return "\u2656";
    return "\u265C";
  }

  @Override
  public ChessPieceType getType() {
    return ChessPieceType.TOWER;
  }

  @Override
  public String toString() {
    return "@Tower at: " + super.toString();
  }
}
