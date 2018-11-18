package game;
import pieces.Piece;

public class LostPiece {
  private int iteration;
  private Piece piece;

  public LostPiece(int iteration, Piece piece) {
    this.iteration = iteration;
    this.piece = piece;
  }

  public int getIteration() {
    return iteration;
  }

  public void setIteration(int iteration) {
    this.iteration = iteration;
  }

  public Piece getPiece() {
    return piece;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  @Override
  public String toString() {
    return piece + " Lost at iteration " + iteration;
  }
}
