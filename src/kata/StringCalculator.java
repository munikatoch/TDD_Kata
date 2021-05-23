package kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import Exception.NegativeNotAllowedException;

public class StringCalculator {

  public int add(String numbers) throws NegativeNotAllowedException {
    if (numbers == null || numbers.length() == 0) {
      return 0;
    }
    String[] number = splitNumbers(numbers);
    List<Integer> positiveNumbers = filterNegative(number);
    return addPositiveNumbers(positiveNumbers);
  }

  private List<Integer> filterNegative(String[] numbers) throws NegativeNotAllowedException {
    List<Integer> positiveNumbers = new ArrayList<>();
    List<Integer> negativeNumbers = new ArrayList<>();
    for (String number : numbers) {
      int numberInInt = Integer.parseInt(number.trim());
      if (numberInInt < 0) {
        negativeNumbers.add(numberInInt);
      } else {
        positiveNumbers.add(numberInInt);
      }
    }
    if (negativeNumbers.size() > 0) {
      String message = getExceptionMessage(negativeNumbers);
      throw new NegativeNotAllowedException(message);
    }
    return positiveNumbers;
  }

  private String getExceptionMessage(List<Integer> negativeNumbers) {
    StringBuilder sb = new StringBuilder();
    sb.append("Negatives not allowed : ");
    int i;
    sb.append(negativeNumbers.get(0));
    for (i = 1; i < negativeNumbers.size(); i++) {
      sb.append(", " + negativeNumbers.get(i));
    }
    return sb.toString();
  }

  private int addPositiveNumbers(List<Integer> numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }

  private String[] splitNumbers(String numbers) {
    if (numbers.startsWith("//")) {
      return customDelimiter(numbers);
    }
    return numbers.split(",|\n");
  }

  private String[] customDelimiter(String numbers) {
    int newLineCharIndex = numbers.indexOf("\n");
    String delimiter = numbers.substring(2, newLineCharIndex);
    String newNumbers = numbers.substring(newLineCharIndex + 1);
    return newNumbers.split(Pattern.quote(delimiter));
  }
}
