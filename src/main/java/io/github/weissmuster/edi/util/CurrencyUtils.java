package io.github.weissmuster.edi.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

public class CurrencyUtils {

  private static final String EURO = "€";
  private static final String EURO_ADD = " €";
  private static final NumberFormat NUMBER_FORMAT =
      NumberFormat.getCurrencyInstance(Locale.GERMANY);

  public static String format(BigDecimal amount) {
    return format(amount.doubleValue());
  }

  /**
   * @param amount
   * @return
   */
  public static String format(Double amount) {

    if (amount == null) {
      return null;
    }

    return NUMBER_FORMAT.format(amount);
  }

  /**
   * parse a currency string like: 2,33 € or 2,33 or 2.33 € or 2.33
   *
   * @param value string to parse, maybe null
   * @return null or double value
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

  public static String formatNoEuroSign(Double amount) {
    
    if(amount == null) {
      return null;
    }

    String tmp = NUMBER_FORMAT.format(amount);

    return tmp.substring(0, tmp.length() - 2);
  }

  public static double round(double value, int places) {

    if (places < 0) {
      throw new IllegalArgumentException();
    }

    return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
  }
}
