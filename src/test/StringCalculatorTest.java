package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Exception.NegativeNotAllowedException;
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
    int actual = 0;
    try {
      actual = this.calculator.add(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 0;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasOnlyOneSingleDigitNumber() {
    String input = "9";
    int actual = 0;
    try {
      actual = this.calculator.add(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 9;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasOnlyOneDoubleDigitNumber() {
    String input = "32";
    int actual = 0;
    try {
      actual = this.calculator.add(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 32;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasTwoNumbers() {
    String input = "32, 10";
    int actual = 0;
    try {
      actual = this.calculator.add(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 42;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasMoreThanTwoNumbers() {
    String input = "32, 10, 5";
    int actual = 0;
    try {
      actual = this.calculator.add(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 47;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasTwoNumbersWithNewLineCharacter() {
    String input = "32, 10\n 5";
    int actual = 0;
    try {
      actual = this.calculator.add(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 47;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasCustomSingleCharDelimiter() {
    String input = "//;\n4;23";
    int actual = 0;
    try {
      actual = this.calculator.add(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 27;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasCustomMultiCharDelimiter() {
    String input = "//;;\n4;;23;;4";
    int actual = 0;
    try {
      actual = this.calculator.add(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 31;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void addNumberWhenInputStringHasCustomSpecialCharDelimiter() {
    String input = "//.\n4.23.4";
    int actual = 0;
    try {
      actual = this.calculator.add(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 31;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void throwExceptionWhenInputStringHasOneNegativeNumber() {
    try {
      String input = "-32, 10";
      this.calculator.add(input);
    } catch (NegativeNotAllowedException e) {
      String expected = "Negatives not allowed : -32";
      String actual = e.getMessage();
      Assert.assertEquals(expected, actual);
    }
  }

  @Test
  public void throwExceptionWhenInputStringHasMultipleNegativeNumber() {
    try {
      String input = "-32, 10, -5, -24";
      this.calculator.add(input);
    } catch (NegativeNotAllowedException e) {
      String expected = "Negatives not allowed : -32, -5, -24";
      String actual = e.getMessage();
      Assert.assertEquals(expected, actual);
    }
  }

  @Test
  public void getCountOfMethodInvokedWhenItIsNotInvoked() {
    int actual = this.calculator.getCalledCount();
    int expected = 0;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getCountOfMethodInvokedWhenInvokedOnce() {
    String input = "";
    int actual = 0;
    try {
      this.calculator.add(input);
      actual = this.calculator.getCalledCount();
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 1;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getCountOfMethodInvokedWhenInvokedMoreThanOnce() {
    String input = "";
    int actual = 0;
    try {
      this.calculator.add(input);
      input = "//.\n4.23.4";
      this.calculator.add(input);
      input = "32, 10\n 5";
      this.calculator.add(input);
      actual = this.calculator.getCalledCount();
    } catch (Exception e) {
      e.printStackTrace();
    }
    int expected = 3;
    Assert.assertEquals(expected, actual);
  }
}
