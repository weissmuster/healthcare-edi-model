package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Nad;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.weissmuster.edi.util.EDIStringUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Name und Adresse Versicherter: NAD Das Segment ist je Abrechnungsfall einmal zu übermitteln.
 *
 * @author twittig
 */
public class NadBuilder {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

  private Nad nad = new Nad();

  public Nad build() {
    return nad;
  }

  /** Vers.-Geburtsdatum JJJJMMTT */
  public NadBuilder setInsuredBirthday(Date insuredBirthday) {

    if (insuredBirthday == null) {
      throw new IllegalArgumentException("insuredBirthday is null");
    }

    nad.setInsuredBirthday(sdf.format(insuredBirthday));

    return this;
  }

  /**
   * Vers.-Wohnort: Die Anschrift ist zwingend anzugeben, sofern die
   * Versichertennummer/Versichertenstatus nicht bekannt ist.
   */
  public NadBuilder setInsuredCity(String insuredCity) {
    nad.setInsuredCity(StringUtils.abbreviate(EDIStringUtils.escapeSpecialChars(insuredCity), 20));
    return this;
  }

  /**
   * Vers.-Länderkennzeichen: Bei Auslandsanschrift ist das Länderkennzeichen gemäß Anlage 3
   * Schlüssel 8.5 zwingend anzugeben, sofern die Versichertennummer/Versichertenstatus nicht
   * bekannt sind. Anmerkung: die Liste ist zu lang, um das hier zu dokumentieren
   */
  public NadBuilder setInsuredCountry(String insuredCountry) {
    nad.setInsuredCountry(EDIStringUtils.escapeSpecialChars(insuredCountry));
    return this;
  }

  /** Vers.-Vornam */
  public NadBuilder setInsuredFirstname(String insuredFirstname) {
    nad.setInsuredFirstname(
        StringUtils.abbreviate(EDIStringUtils.escapeSpecialChars(insuredFirstname), 25));
    return this;
  }

  /**
   * Vers.-Nachname
   *
   * <p>max 47 chars
   */
  public NadBuilder setInsuredLastname(String insuredLastname) {
    nad.setInsuredLastname(
        StringUtils.abbreviate(EDIStringUtils.escapeSpecialChars(insuredLastname), 40));
    return this;
  }

  /**
   * Vers.-PLZ: Bei Inlandsanschrift ist die gültige, 5-stellige Postleitzahl ohne weitere Zusätze
   * anzugeben, sofern die Versichertennummer/Versichertenstatus nicht bekannt sind.
   */
  public NadBuilder setInsuredPostalcode(String insuredPostalcode) {
    nad.setInsuredPostalcode(insuredPostalcode);
    return this;
  }

  /**
   * Vers.-Straße-/Nr.: Die Anschrift ist zwingend anzugeben, sofern die
   * Versichertennummer/Versichertenstatus nicht bekannt ist.
   */
  public NadBuilder setInsuredStreedAddress(String insuredStreedAddress) {
    nad.setInsuredStreedAddress(
        StringUtils.abbreviate(EDIStringUtils.escapeSpecialChars(insuredStreedAddress), 24));
    return this;
  }
}
