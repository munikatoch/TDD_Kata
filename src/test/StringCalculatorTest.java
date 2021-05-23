package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kata.StringCalculator;

public class StringCalculatorTest {

  private StringCalculator calculator;

  @Before
  public void initialize() {
    this.calculator = new StringCalculator();
  }

  @Test
  public void addNumberWhenInputStringIsEmpty() {
    String input = "";
    int actual = this.calculator.add(input);
    int expected = 0;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasOnlyOneSingleDigitNumber() {
    String input = "9";
    int actual = this.calculator.add(input);
    int expected = 9;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasOnlyOneDoubleDigitNumber() {
    String input = "32";
    int actual = this.calculator.add(input);
    int expected = 32;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasTwoNumbers() {
    String input = "32, 10";
    int actual = this.calculator.add(input);
    int expected = 42;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasMoreThanTwoNumbers() {
    String input = "32, 10, 5";
    int actual = this.calculator.add(input);
    int expected = 47;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasTwoNumbersWithNewLineCharacter() {
    String input = "32, 10\n 5";
    int actual = this.calculator.add(input);
    int expected = 47;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasCustomSingleCharDelimiter() {
    String input = "//;\n4;23";
    int actual = this.calculator.add(input);
    int expected = 27;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasCustomMultiCharDelimiter() {
    String input = "//;;\n4;;23;;4";
    int actual = this.calculator.add(input);
    int expected = 31;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasCustomSpecialCharDelimiter() {
    String input = "//.\n4.23.4";
    int actual = this.calculator.add(input);
    int expected = 31;
    Assert.assertEquals(expected, actual);
  }
}
