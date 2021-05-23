package kata;

public class StringCalculator {

  public int add(String numbers) {
    if (numbers == null || numbers.length() == 0) {
      return 0;
    }
    String[] number = splitNumbers(numbers);
    return getSum(number);
  }

  private int getSum(String[] numbers) {
    int sum = 0;
    for (String number : numbers) {
      int numberInInt = converToInt(number);
      sum += numberInInt;
    }
    return sum;
  }

  private int converToInt(String number) {
    int intNumber = 0;
    int i;
    for (i = 0; i < number.length(); i++) {
      char currentChar = number.charAt(i);
      if (currentChar != ' ') {
        intNumber = intNumber * 10 + (currentChar - '0');
      }
    }
    return intNumber;
  }

  private String[] splitNumbers(String numbers) {
    return numbers.split(",|\n");
  }
}
