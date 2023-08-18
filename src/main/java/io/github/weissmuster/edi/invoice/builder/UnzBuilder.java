package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Unz;
import org.apache.commons.lang.StringUtils;

public class UnzBuilder {

  private Unz unz = new Unz();

  public Unz build() {
    return unz;
  }

  public UnzBuilder setIcrn(String icrn) {
    unz.setIcrn(StringUtils.leftPad(icrn, 5, "0"));
    return this;
  }

  public UnzBuilder setNumberOfMessages(Integer numberOfMessages) {

    if (numberOfMessages == null) {
      return this;
    }

    String countOfMessages = StringUtils.leftPad(numberOfMessages.toString(), 6, "0");
    unz.setNumberOfMessages(countOfMessages);
    return this;
  }
}
