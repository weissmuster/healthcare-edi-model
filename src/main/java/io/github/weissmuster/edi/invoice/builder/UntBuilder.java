package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Unt;
import org.apache.commons.lang.StringUtils;

public class UntBuilder {

  private Unt unt = new Unt();

  public Unt build() {
    return unt;
  }

  public UntBuilder setMessageReferenceNumber(Integer messageReferenceNumber) {

    if (messageReferenceNumber == null) {
      throw new IllegalArgumentException("messageReferenceNumber is null");
    }

    unt.setMessageReferenceNumber(
        StringUtils.leftPad(String.valueOf(messageReferenceNumber), 5, "0"));
    return this;
  }

  public UntBuilder setNumberOfUnits(Integer numberOfUnits) {

    if (numberOfUnits == null) {
      throw new IllegalArgumentException("numberOfUnits is null");
    }

    unt.setNumberOfUnits(StringUtils.leftPad(String.valueOf(numberOfUnits), 6, "0"));
    return this;
  }

  public UntBuilder withDefaults() {
    setNumberOfUnits(1);
    setMessageReferenceNumber(1);
    return this;
  }
}
