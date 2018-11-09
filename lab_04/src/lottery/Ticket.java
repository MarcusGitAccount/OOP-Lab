package lottery;
import java.util.Date;

public class Ticket {
  private int numbersPlayed;
  private int numbersToChoose;

  private String name;
  private boolean isCompleted;
  private long numbers;
  private int price;
  private Date acquisitionDate;

  public Ticket(String name, int price, int numbersPlayed, int numbersToChoose) {
    this.name  = name;
    this.price = price;
    this.numbersPlayed = numbersPlayed;

    acquisitionDate = new Date();
    isCompleted = false;
    numbers = 0L;
  }

  public void setNumbers(int numbers) {
    if (!this.isCompleted) {
      this.isCompleted = true;
      this.numbers = numbers;
    }
  }

  public long getNumbers() {
    return this.numbers;
  }

  public int[] getNumbersUnpacked() {
    int index = 0;
    int[] result = new int[6];

    for (int bit = 0; bit < 64 && index < this.numbersToChoose; bit++) {
      if (Utils.getBit(this.numbers, bit) == true) {
        result[index] = bit + 1;
        index++;
      }
    }

    return result;
  }
}
