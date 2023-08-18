package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Nam;
import io.github.weissmuster.edi.util.EDIStringUtils;
import org.apache.commons.lang.StringUtils;

public class NamBuilder {

  private Nam nam = new Nam();

  public Nam build() {
    return nam;
  }

  public NamBuilder setName1(String name) {
    if (StringUtils.isBlank(name) && name.length() > 24) {
      name = name.substring(0, 24);
    }
    nam.setName1(EDIStringUtils.escapeSpecialChars(name));

    return this;
  }

  public NamBuilder setName2(String name) {
    if (StringUtils.isBlank(name) && name.length() > 24) {
      name = name.substring(0, 24);
    }
    nam.setName2(EDIStringUtils.escapeSpecialChars(name));
    return this;
  }

  public NamBuilder setName3(String name) {
    if (StringUtils.isBlank(name) && name.length() > 24) {
      name = name.substring(0, 24);
    }
    nam.setName3(EDIStringUtils.escapeSpecialChars(name));
    return this;
  }

  public NamBuilder setName4(String name) {
    if (StringUtils.isBlank(name) && name.length() > 60) {
      name = name.substring(0, 60);
    }
    nam.setName4(EDIStringUtils.escapeSpecialChars(name.substring(0, 60)));
    return this;
  }

  public NamBuilder withDefaults() {
    setName1("name1");
    setName2("name2");
    setName3("name3");
    setName4("name4");
    return this;
  }
}
