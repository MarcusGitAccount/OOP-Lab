package pieces;

import utils.Enums.*;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
  public Pawn(ChessPieceColors color, Vector position) {
    super(color, position);
  }

  @Override
  public boolean checkMove(Vector destination, Piece existingPiece) {
    Vector diff = destination.add(this.getPosition().multiply(-1));

    // check if move is backwards
    if (this.getColor() == ChessPieceColors.WHITE && diff.getI() > 0)
      return false;
    if (this.getColor() == ChessPieceColors.BLACK && diff.getI() < 0)
      return false;

    diff = diff.absComponents();
    int j = diff.getJ();
    if (diff.getI() != 1)
      return false;
    if (j == 0 && existingPiece == null) {
      // a forward move is not blocked
      return true;
    }
    if (j == 1 &&
        existingPiece.getColor() != this.getColor() &&
        existingPiece.getType() != ChessPieceType.KING) {
      // can attack the piece situated diagonally of it and
      // that piece is not the king
      return true;
    }

    return false;
  }

  @Override
  public List<Vector> computeMove(Vector destination) {
    // fot a pawn there are no required extra steps when making a move
    return new ArrayList<Vector>();
  }

  @Override
  public String getCode() {
    ChessPieceColors color = this.getColor();

    if (color == ChessPieceColors.WHITE)
      return "\u2659";
    return "\u265F";
  }

  @Override
  public ChessPieceType getType() {
    return ChessPieceType.PAWN;
  }

  @Override
  public String toString() {
    return "@Pawn at " + super.toString();
  }
}
