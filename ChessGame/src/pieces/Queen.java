package pieces;

import utils.Enums.*;
import utils.Vector;

public class Queen extends Piece {
  public Queen(ChessPieceColors color, Vector position) {
    super(color, position);
  }

  @Override
  public boolean checkMove(Vector destination, Piece existingPiece) {
    Vector diff = destination.add(this.getPosition().multiply(-1));

    if (diff.getI() == 0)
      return true;
    if (diff.getJ() == 0)
      return true;
    if (Math.abs(this.getPosition().getI() - destination.getI()) ==
        Math.abs(this.getPosition().getJ() - destination.getJ())) {
      return true;
    }
    return false;
  }

  @Override
  public String getCode() {
    ChessPieceColors color = this.getColor();

    if (color == ChessPieceColors.WHITE)
      return "\u2655";
    return "\u265B";
  }

  @Override
  public ChessPieceType getType() {
    return ChessPieceType.QUEEN;
  }

  @Override
  public String toString() {
    return "@Queen at: " + super.toString();
  }
}
