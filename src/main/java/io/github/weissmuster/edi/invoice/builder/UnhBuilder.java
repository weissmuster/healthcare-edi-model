package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Unh;
import io.github.weissmuster.edi.invoice.model.field.MessageIdentifier;
import org.apache.commons.lang.StringUtils;

/**
 * UNH Kopf-Segment einer Nachricht; es dient dazu, eine Nachricht zu eröffnen, zu identifizieren
 * und zu beschreiben. Eine Nachricht besteht aus einer definierten Folge von Segmenten, die einmal
 * oder mehrfach vorkommen können oder nur bei bestimmten Geschäftsvorfällen erforderlich sind.
 *
 * @author twittig
 */
public class UnhBuilder {

  private Unh unh = new Unh();

  public Unh build() {
    return unh;
  }

  public UnhBuilder setMessageIdentifier(MessageIdentifier messageIdentifier) {

    unh.setMessageIdentifier(messageIdentifier);
    return this;
  }

  public UnhBuilder setMessageReferenceNumber(Integer messageReferenceNumber) {

    unh.setMessageReferenceNumber(
        StringUtils.leftPad(String.valueOf(messageReferenceNumber), 5, "0"));

    return this;
  }
}
