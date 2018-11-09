package lottery;

public class Lottery {
  public static final int TICKET_PRICE = 10;
  public static final String TICKET_NAME = "Lotto 6 din 49";

  private int numbersPlayed;
  private int numbersToChoose;

  private long lastNumbersExtracted;
  private int prize;

  public Lottery(int numbersToChoose, int numbersPlayed) {
    this.numbersToChoose = numbersToChoose;
    this.numbersPlayed   = numbersPlayed;
    this.lastNumbersExtracted = 0;
  }

  public Lottery() {
    this(6, 49);
  }

  public void extractNumbers() {
    int[] result = new int[6];
    int index = 0;
    long used = 0;

    while (index < this.numbersToChoose) {
      int rand = Utils.randomInt(0, this.numbersPlayed);
      long mask = 1 << rand;

      if (Utils.getBit(used, rand) == false) {
        index++;
        used |= mask;
      }
    }

    this.lastNumbersExtracted = used;
  }

  public Ticket sellTicket() {
    return new Ticket(TICKET_NAME, TICKET_PRICE, numbersPlayed, numbersToChoose);
  }

  public boolean checkTicket(Ticket ticket) {
    return ticket.getNumbers() == this.lastNumbersExtracted;
  }

  public void createGame(int prize) {
    this.lastNumbersExtracted = 0;
    this.prize = prize;
  }
}
