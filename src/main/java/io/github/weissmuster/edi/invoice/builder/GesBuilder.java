package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Ges;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Rechnungssummen (Status)
 *
 * <p>GES Das Segment muss je Nachricht mindestens zweimal und kann höchstens neunmal vorkommen. Es
 * ist stets ein GES-Segment für den Summenstatus 00 zuerst zu übermitteln. Diese Summe ergibt sich
 * aus der Addition der nachfolgend anzugebenden Betragssummen des jeweiligen Versichertenstatus
 * (SLGA). Die Betragssumme des Versichertenstatus (SLGA) entspricht den Summen der Abrechnungsfälle
 * (SLLA), die diesen Status beinhalten.
 *
 * @author twittig
 */
public class GesBuilder {

  private Ges ges = new Ges();

  public Ges build() {
    return ges;
  }

  /**
   * Gesamtbetrag Zuzahlung und/oder Eigenanteil
   *
   * <p>Summe der gesetzlichen Zuzahlungen und/oder der Eigenanteile der Abrechnungsfälle aus BES
   * Berechnungsregel: Summe aller Abrechnungsfälle(BES.Gesambetrag gesetzliche Zuzahlung +
   * BES.Gesamtbetrag Eigenanteil).
   */
  public GesBuilder setAdditionalPayment(String additionalPayment) {
    ges.setAdditionalPayment(additionalPayment);
    return this;
  }

  /**
   * Status
   *
   * <p>Siehe Schlüssel Summenstatus Anlage 3 Abschnitt 8.1.6
   *
   * <p>1. und 2. Stelle 00 = Gesamtsumme aller Status 11 = Mitglieder 31 = Angehörige 51 = Rentner
   * 99 = nicht zuzuordnende Status
   */
  public GesBuilder setStatus(String status) {
    ges.setStatus(status);
    return this;
  }

  /**
   * Gesamtbruttobetrag
   *
   * <p>Summe der Gesamtbruttobeträge der Abrechnungsfälle (inklusive gesetzlicher Zuzahlungsbeträge
   * oder Eigenanteil sowie ggf. Mehrwertsteuer) aus BES
   */
  public GesBuilder setTotalGrossAmount(Double totalGrossAmount) {

    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMANY);
    decimalFormat.applyPattern("#.00");

    String format = decimalFormat.format(totalGrossAmount);

    //        ges.setTotalGrossAmount( StringUtils.leftPad( format, 13, "0" ) );
    ges.setTotalGrossAmount(format);
    return this;
  }

  /**
   * Gesamtrechnungsbetrag
   *
   * <p>Gesamtrechnungsbetrag (ggf. inklusive Mehrwertsteuer) Berechnungsregel:
   * GES.Gesamtbruttobetrag minus GES.Gesamtbetrag Zuzahlung und/oder Eigenanteil.
   */
  public GesBuilder setTotalInvoiceAmount(Double totalInvoiceAmount) {

    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMANY);
    decimalFormat.applyPattern("#.00");

    String format = decimalFormat.format(totalInvoiceAmount);

    //        ges.setTotalInvoiceAmount( StringUtils.leftPad( format, 13, "0" ) );
    ges.setTotalInvoiceAmount(format);
    return this;
  }

  public GesBuilder withDefaults() {
    setStatus("00");
    setTotalGrossAmount(Double.valueOf("999.0"));
    setTotalInvoiceAmount(Double.valueOf("999.0"));
    setAdditionalPayment("666,00");
    return this;
  }
}
