package io.github.weissmuster.edi.util;

import org.apache.commons.lang.StringUtils;

public class EDIStringUtils {

  /** Escaped alle {+:'} mit einem ? for dem eigentlichen Zeichen */
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
