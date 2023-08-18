package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Inv;
import org.apache.commons.lang.StringUtils;

/**
 * @author twittig
 *     <p>Information Versicherte: Das Segment enthält die Versichertendaten eines Abrechnungsfalles
 *     (Verordnung), und gilt gleichzeitig als BeginnSegment für einen Abrechnungsfall. Jeder
 *     Abrechnungsfall ist mit einer eindeutigen Belegnummer zu kennzeichnen, die der auf der
 *     Verordnung zu übertragenen Belegnummer (s. § 4 des Richtlinientextes) entsprechen muss.
 */
public class InvBuilder {

  private Inv inv = new Inv();

  public Inv build() {
    return inv;
  }

  /**
   * Belegnummer: Eindeutige Nummer innerhalb der Gesamtrechnung (siehe auch § 4 des
   * Richtlinientextes).
   */
  public InvBuilder setDocumentNumber(Integer documentNumber) {

    if (documentNumber == null) {
      throw new IllegalArgumentException("doctorNumber is null");
    }

    inv.setDocumentNumber(StringUtils.leftPad(String.valueOf(documentNumber), 10, "0"));
    return this;
  }

  /** Freifeld: nicht spezifiziert */
  public InvBuilder setFreeField(String freeField) {
    inv.setFreeField(freeField);
    return this;
  }

  /**
   * Das Segment enthält Angaben über den abzurechnenden Gesamtbruttobetrag eines Abrechnungsfalles
   * (Verordnung) (Summe aller ENF-Beträge ggf. zuzüglich der Mehrwertsteuer).
   */
  public InvBuilder setInsuranceNumber(String insuranceNumber) {
    inv.setInsuranceNumber(insuranceNumber);
    return this;
  }

  /**
   * Versichertenstatus: Anzugeben ist der Versichertenstatus von der Verordnung (alle lesbaren
   * Zeichen werden nacheinander in das Feld geschrieben und ggfs. auf 5 Stellen rechtsbündig mit
   * Nullen ergänzt, z.B. 10000 oder 18000) Sofern nicht bekannt, wird die Anschrift und das
   * Geburtsdatum des Versicherten übermittelt (Segment NAD).
   */
  public InvBuilder setInsuredStatus(Integer insuredStatus) {

    if (insuredStatus == null) {
      throw new IllegalArgumentException("insuredStatus is null");
    }

    inv.setInsuredStatus(StringUtils.rightPad(String.valueOf(insuredStatus), 5, "0"));
    return this;
  }

  /**
   * Kennzeichen Besondere Versorgungsform: Anzugeben ist das Vertragskennzeichen für besondere
   * Versorgungsformen gemäß der vertraglichen Vereinbarungen.
   */
  public InvBuilder setPlateSpecialCareForm(String plateSpecialCareForm) {
    inv.setPlateSpecialCareForm(plateSpecialCareForm);
    return this;
  }
}
