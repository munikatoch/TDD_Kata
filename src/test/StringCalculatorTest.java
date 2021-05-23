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
}
