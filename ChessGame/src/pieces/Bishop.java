package pieces;

import utils.Enums.*;
import utils.Vector;
import java.util.List;

public class Bishop extends Piece {
  public Bishop(ChessPieceColors color, Vector position) {
    super(color, position);
  }

  @Override
  public boolean checkMove(Vector destination, Piece existingPiece) {
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
      return "\u2657";
    return "\u265D";
  }

  @Override
  public ChessPieceType getType() {
    return ChessPieceType.BISHOP;
  }

  @Override
  public String toString() {
    return "@Bishop at " + super.toString();
  }
}
