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
  public void add_numbers_when_input_string_is_empty() {
    String input = "";
    int actual = this.calculator.add(input);
    int expected = 0;
    Assert.assertEquals(expected, actual);
  }
}