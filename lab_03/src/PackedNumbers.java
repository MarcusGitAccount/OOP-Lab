// Using an integer to store other numbers in it using bitwise operations.

public class PackedNumbers {
  public static int pack(int age, int sex, int height) {
    int result = age;

    result = (result << 1) | sex;
    result = (result << 8) | height;
    return result;
  }

  public static void print(int packed) {
    int height, age, sex;

    height = packed & (0xFF);
    packed >>>= 8;
    sex = packed & 1;
    packed >>>= 1;
    age = packed & 0x7F;

    System.out.println(
        age + " " + sex + " " + height
    );
  }
}
