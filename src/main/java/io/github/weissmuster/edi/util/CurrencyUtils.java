package io.github.weissmuster.edi.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

/**
 * Utility class to provide various operations related to currency formatting and parsing
 * specifically for the Euro (€) currency.
 */
public class CurrencyUtils {

  private static final String EURO = "€";
  private static final String EURO_ADD = " €";
  private static final NumberFormat NUMBER_FORMAT =
      NumberFormat.getCurrencyInstance(Locale.GERMANY);

  /**
   * Formats the given BigDecimal amount to its currency representation.
   *
   * @param amount The BigDecimal amount to be formatted.
   * @return The formatted currency string.
   */
  public static String format(BigDecimal amount) {
    return format(amount.doubleValue());
  }

  /**
   * Formats the given double amount to its currency representation.
   *
   * @param amount The double amount to be formatted. Can be null.
   * @return The formatted currency string or null if the provided amount is null.
   */
  public static String format(Double amount) {

    if (amount == null) {
      return null;
    }

    return NUMBER_FORMAT.format(amount);
  }

  /**
   * Parses the provided currency string into its double value representation. Handles various
   * currency formats including "2,33 €", "2,33", "2.33 €", and "2.33".
   *
   * @param value The string representation of the currency amount. Can be null.
   * @return The parsed double value or null if parsing fails or the input string is null/blank.
   */
  public static Double parse(String value) {

    if (StringUtils.isBlank(value)) {
      return null;
    }

    if (!value.contains(EURO)) {
      value += EURO_ADD;
    }

    if (value.contains(".")) {
      value = value.replaceAll("\\.", ",");
    }

    try {
      return NUMBER_FORMAT.parse(value.trim()).doubleValue();
    } catch (final ParseException e) {
      return null;
    }
  }

  /**
   * Formats the given double amount to its currency representation without the Euro sign.
   *
   * @param amount The double amount to be formatted. Can be null.
   * @return The formatted currency string without the Euro sign or null if the provided amount is
   *     null.
   */
  public static String formatNoEuroSign(Double amount) {

    if (amount == null) {
      return null;
    }

    String tmp = NUMBER_FORMAT.format(amount);

    return tmp.substring(0, tmp.length() - 2);
  }

  /**
   * Rounds a given double value to the specified number of decimal places using HALF_UP rounding
   * mode.
   *
   * @param value The double value to be rounded.
   * @param places The number of decimal places to round to.
   * @return The rounded double value.
   * @throws IllegalArgumentException if the provided places is negative.
   */
  public static double round(double value, int places) {

    if (places < 0) {
      throw new IllegalArgumentException();
    }

    return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
  }
}
