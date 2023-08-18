package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Bes;

/**
 * Betrags-Summen
 *
 * <p>Das Segment enthält Angaben über den abzurechnenden Gesamtbruttobetrag eines Abrechnungsfalles
 * (Verordnung) (Summe aller ENF-Beträge ggf. zuzüglich der Mehrwertsteuer).
 *
 * <p>BES Das Segment ist je Abrechnungsfall einmal zu übermitteln
 *
 * @author twittig
 */
public class BesBuilder {

  private Bes bes = new Bes();

  public Bes build() {
    return bes;
  }

  /**
   * pauschaler Zuzahlungsbetrag
   *
   * <p>Pauschaler Zuzahlungsbetrag je Abrechnungsfall (Verordnungsblatt). 10 Euro maximal, jedoch
   * höchstens die Differenz Gesamtbetrag Brutto abzüglich Gesamtbetrag prozentuale Zuzahlung
   */
  public BesBuilder setAllInAdditionalPayment(String allInAdditionalPayment) {
    bes.setAllInAdditionalPayment(allInAdditionalPayment);
    return this;
  }

  /**
   * Gesamtbetrag gesetzliche Zuzahlung
   *
   * <p>je Abrechnungsfall. Berechnungsregel: Summe (BES.Gesamtbetrag prozentuale Zuzahlung je
   * Abrechnungsfall +BES.PauschalerZuzahlungsbetrag je Abrechnungsfall +(Summe über alle Leistungen
   * (ZUZ.Betrag Gesetzliche Zuzahlung)).
   */
  public BesBuilder setAmountLegalAdditionalPayment(String amountLegalAdditionalPayment) {
    bes.setAmountLegalAdditionalPayment(amountLegalAdditionalPayment);
    return this;
  }

  /**
   * Gesamtbetrag Eigenanteil:
   *
   * <p>Gesamtbetrag Eigenanteil Berechnungsregel: Summe über alle Abrechnungspositionen (ZUZ.Betrag
   * Eigenanteil).
   */
  public BesBuilder setTotalAmountDeductible(String totalAmountDeductible) {
    bes.setTotalAmountDeductible(totalAmountDeductible);
    return this;
  }

  /**
   * Gesamtbetrag prozentuale Zuzahlung:
   *
   * <p>je Abrechnungsfall. Berechnungsregel: Summe über alle Abrechnungspositionen des
   * Abrechnungsfalls von: (ENF.Betrag der Zuzahlung mal ENF.Anzahl/Menge) kaufmännisch gerundet.
   */
  public BesBuilder setTotalAmountLegalAdditionalPayment(String totalAmountLegalAdditionalPayment) {
    bes.setTotalAmountLegalAdditionalPayment(totalAmountLegalAdditionalPayment);
    return this;
  }

  /**
   * Gesamtbetrag Brutto
   *
   * <p>Gesamtbetrag Brutto je Abrechnungsfall (einschl. evtl. Mehrwertsteuer). Berechnungsregel:
   * Summe über alle Abrechnungspositionen des Abrechnungsfalls von: (((ENF.Einzelbetrag der
   * Abrechnungsposition mal ENF.Anzahl/Menge) plus ggf. MWS.Betrag Mehrwertsteuer)) kaufmännisch
   * gerundet).
   */
  public BesBuilder setTotalGrossAmount(String totalGrossAmount) {
    bes.setTotalGrossAmount(totalGrossAmount);
    return this;
  }
}
