package pieces;

import utils.Enums.*;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
  public King(ChessPieceColors color, Vector position) {
    super(color, position);
  }

  @Override
  public boolean checkMove(Vector destination, Piece existingPiece) {
    return true;
  }

  @Override
  public List<Vector> computeMove(Vector destination) {
    return new ArrayList<Vector>();
  }

  @Override
  public String getCode() {
    ChessPieceColors color = this.getColor();

    if (color == ChessPieceColors.WHITE)
      return "\u2654";
    return "\u265A";
  }

  @Override
  public ChessPieceType getType() {
    return ChessPieceType.KING;
  }

  @Override
  public String toString() {
    return "@King at: " + super.toString();
  }
}
