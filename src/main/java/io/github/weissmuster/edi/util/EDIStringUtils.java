package io.github.weissmuster.edi.util;

import org.apache.commons.lang.StringUtils;

/**
 * Utility class for string manipulations.
 *
 * @author Thomas Wittig
 */
public class EDIStringUtils {

  /**
   * Escapes special characters in the given string with a preceding '?'. The following characters
   * are escaped:
   *
   * <ul>
   *   <li>' (single quote) becomes ?'
   *   <li>: becomes ?:
   *   <li>, becomes ?,
   *   <li>+ becomes ?+
   * </ul>
   *
   * Additionally, accented characters are replaced as follows:
   *
   * <ul>
   *   <li>é becomes e
   *   <li>è becomes e
   * </ul>
   *
   * If the input string is null or empty, an empty string is returned.
   *
   * @param str the input string to be escaped.
   * @return the escaped string. If the input string is blank, returns an empty string.
   */
  public static String escapeSpecialChars(String str) {

    if (StringUtils.isBlank(str)) {
      return StringUtils.EMPTY;
    }

    str = str.replaceAll("'", "?'");
    str = str.replaceAll(":", "?:");
    str = str.replaceAll(",", "?,");
    str = str.replaceAll("\\+", "?+");
    str = str.replaceAll("é", "e");
    str = str.replaceAll("è", "e");

    return str;
  }
}
