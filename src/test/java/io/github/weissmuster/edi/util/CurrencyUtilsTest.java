package io.github.weissmuster.edi.util;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CurrencyUtilsTest {

  @Test
  public void testFormatBigDecimal() {
    BigDecimal amount = new BigDecimal("1234.56");
    String result = CurrencyUtils.format(amount);
    assertEquals("1.234,56 €", result);
  }

  @Test
  public void testFormatDouble() {
    Double amount = 1234.56;
    String result = CurrencyUtils.format(amount);
    assertEquals("1.234,56 €", result);
  }

  @Test
  public void testFormatNullDouble() {
    Double amount = null;
    String result = CurrencyUtils.format(amount);
    assertNull(result);
  }

  // TODO adjust implementation
  @Ignore
  @Test
  public void testParseValidCurrency() {
    String value = "1.234,56 €";
    Double result = CurrencyUtils.parse(value);
    assertEquals(1234.56, result, 0.001);
  }

  @Test
  public void testParseInvalidCurrency() {
    String value = "invalid";
    Double result = CurrencyUtils.parse(value);
    assertNull(result);
  }

  @Test
  public void testParseNullCurrency() {
    String value = null;
    Double result = CurrencyUtils.parse(value);
    assertNull(result);
  }

  // TODO adjust the implementation
  @Ignore
  @Test
  public void testFormatNoEuroSign() {
    Double amount = 1234.56;
    String result = CurrencyUtils.formatNoEuroSign(amount);
    assertEquals("1.234,56", result);
  }

  @Test
  public void testFormatNoEuroSignNullValue() {
    Double amount = null;
    String result = CurrencyUtils.formatNoEuroSign(amount);
    assertNull(result);
  }

  @Test
  public void testRound() {
    double value = 1234.5678;
    double result = CurrencyUtils.round(value, 2);
    assertEquals(1234.57, result, 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRoundNegativePlaces() {
    double value = 1234.5678;
    CurrencyUtils.round(value, -1);
  }
}
