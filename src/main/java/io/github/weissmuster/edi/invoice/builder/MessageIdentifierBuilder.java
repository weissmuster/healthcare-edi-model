package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.field.MessageIdentifier;

/**
 * Nachrichtenkennung:
 *
 * <p>Bei Nachricht SLGA ist einzutragen: SLGA:09:0:0 Bei Nachricht SLLA ist einzutragen:
 * SLLA:09:0:0
 *
 * @author twittig
 */
public class MessageIdentifierBuilder {

  private final MessageIdentifier messageIdentifier = new MessageIdentifier();

  public MessageIdentifier build() {
    return messageIdentifier;
  }

  /** ist immer 0 (Null) */
  public MessageIdentifierBuilder setAdministrativeOrganisation(String administrativeOrganisation) {
    messageIdentifier.setAdministrativeOrganisation(administrativeOrganisation);
    return this;
  }

  /**
   * Nachr-Typ-Kennung:
   *
   * <p>Genutzt werden die ersten 4 Stellen;
   *
   * <p>einzutragen sind: SLGA oder SLLA.
   */
  public MessageIdentifierBuilder setType(String type) {
    messageIdentifier.setType(type);
    return this;
  }

  /** ist immer 0 (Null) */
  public MessageIdentifierBuilder setTypeReleaseNumber(String typeReleaseNumber) {
    messageIdentifier.setTypeReleaseNumber(typeReleaseNumber);
    return this;
  }

  /**
   * Versionsnummer
   *
   * <p>Genutzt werden die ersten 2 Stellen;
   *
   * <p>einzutragen ist die Nummer der benutzten Version des Nachrichtentypes lt. Abschnitt 5.5
   * dieser Anlage; d.h. Version 09.
   */
  public MessageIdentifierBuilder setVersion(String version) {
    messageIdentifier.setVersion(version);
    return this;
  }

  public MessageIdentifierBuilder withSLGAMessageIdentifier() {
    messageIdentifier.setType("SLGA");
    messageIdentifier.setVersion("17");
    messageIdentifier.setTypeReleaseNumber("0");
    messageIdentifier.setAdministrativeOrganisation("0");
    return this;
  }

  public MessageIdentifierBuilder withSLLAMessageIdentifier() {
    messageIdentifier.setType("SLLA");
    messageIdentifier.setVersion("17");
    messageIdentifier.setTypeReleaseNumber("0");
    messageIdentifier.setAdministrativeOrganisation("0");
    return this;
  }
}
