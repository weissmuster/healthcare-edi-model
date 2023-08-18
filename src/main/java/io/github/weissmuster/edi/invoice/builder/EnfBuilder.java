package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Enf;
import io.github.weissmuster.edi.invoice.model.field.ServiceGroup;
import io.github.weissmuster.edi.util.CurrencyUtils;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

/**
 * Einzelfallnachweis: Das Segment dient zur Abrechnung der einzelnen Positionen, die für den
 * abzurechnenden Fall angefallen sind. Es ist so oft wiederholbar, wie Abrechnungspositionen
 * vorkommen.
 *
 * <p>ENF Das Segment ist für jede Abrechnungsposition, bezogen auf den Tag der Leistungserbringung,
 * einmal zu übermitteln.
 *
 * @author twittig
 */
public class EnfBuilder {

  private Enf enf = new Enf();

  public Enf build() {
    return enf;
  }

  /**
   * Betrag der Zuzahlung
   *
   * <p>Der Einzelbetrag der prozentualen Zuzahlung bzw. der Zuzahlungsbetrag pro Tag ist zwingend
   * je Abrechnungsposition zu berechnen und anzugeben, sofern dieser vom Versicherten zu entrichten
   * ist.
   *
   * <p>Berechnungsregel: (ENF.Einzelbetrag der Abrechnungsposition plus ggf. MWS.Betrag
   * Mehrwertsteuer*) mal Zuzahlungsprozentsatz Der Betrag Mehrwertsteuer ist auf die einzelne
   * Position mit dem Mengenfaktor 1 herunterzurechnen und kaufmännisch zu runden. (Der ermittelte
   * Betrag ist kaufmännisch zu runden).
   */
  public EnfBuilder setAdditionalPayment(Double additionalPayment) {

    if(additionalPayment == null) {
      throw new IllegalArgumentException("additionalPayment is null");
    }

    enf.setAdditionalPayment(CurrencyUtils.formatNoEuroSign(additionalPayment));
    return this;
  }

  /**
   * Einzelbetrag der Abrechnungsposition
   *
   * <p>Einzelpreis (vereinbarter Preis/Festbetrag) Als Einzelpreis ist immer der Preis einer
   * Abrechnungsposition zu verstehen. Sofern ein Nettopreis zuzüglich MwSt. vereinbart wurde, ist
   * der Nettopreis in ENF anzugeben und das Segment MWS zu füllen. Ist der Einzelpreis inklusive
   * MwSt. vereinbart, ist dieser in ENF anzugeben und kein Segment MWS anzugeben.
   */
  public EnfBuilder setAmount(Double amount) {

    if(amount == null) {
      throw new IllegalArgumentException("amount is null");
    }

    enf.setAmount(StringUtils.leftPad(CurrencyUtils.formatNoEuroSign(amount), 10, "0"));
    return this;
  }

  /**
   * Art der abgegebenen Leistung (Abrechnungspositionsnummer)
   *
   * <p>Siehe Schlüssel Abrechnungspositionsnummer Anlage 3 Abschnitt 8.2.1 bis 8.2.10.
   *
   * <p>http://www.gkv-datenaustausch.de/media/dokumente/leistungserbringer_1/
   * sonstige_leistungserbringer /positionsnummernverzeichnisse/20120712_Sonstige-Leistungen.pdf
   */
  public EnfBuilder setBillingItemNumber(String billingItemNumber) {

    if(billingItemNumber == null) {
      throw new IllegalArgumentException("billingItemNumber is null");
    }

    enf.setBillingItemNumber(billingItemNumber);
    return this;
  }

  /**
   * Datum der Leistungserbringung
   *
   * <p>Tag der Leistungserbringung (JJJJMMTT).
   */
  public EnfBuilder setDateOfServiceProvision(Date dateOfServiceProvision) {

    if(dateOfServiceProvision == null) {
      throw new IllegalArgumentException("dateOfServiceProvision is null");
    }

    DateFormat df = new SimpleDateFormat("yyyyMMdd");
    enf.setDateOfServiceProvision(df.format(dateOfServiceProvision));

    return this;
  }

  /**
   * Identifikationsnummer: Zur Identifikation aller zuzahlungstechnisch zusammengehörenden
   * Abrechnungspositionen ist jeweils die gleiche Identifikationsnummer zu übermitteln. Bei der
   * Abrechnung von zuzahlungsfreien Positionsnummern im Zusammenhang mit zuzahlungspflichtigen
   * Positionsnummern sind die zuzahlungsfreien Positionsnummern mit einer eigenen
   * Identifikationsnummer anzugeben.
   */
  public EnfBuilder setIdentificationNumber(String identificationNumber) {
    enf.setIdentificationNumber(identificationNumber);
    return this;
  }

  /**
   * Anzahl/Menge
   *
   * <p>Anzahl der Abrechnungspositionen z.B. 1 x Massage; 20 Kilometer usw. Es dürfen nur dann
   * Abrechnungspositionen in einem ENF-Segment zusammengefasst werden, wenn sie am selben Tag
   * erbracht worden sind. Andernfalls ist für jeden Tag der Leistungserbringung ein eigenes
   * ENF-Segment zu erstellen.
   */
  public EnfBuilder setQuantity(Integer quantity) {

    if (quantity == null) {
      throw new IllegalArgumentException("quantity is null");
    }

    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMANY);
    decimalFormat.applyPattern("####.00");

    String format = decimalFormat.format(quantity);
    String format2 = StringUtils.leftPad(format, 7, "0");

    enf.setQuantity(String.valueOf(format2));

    return this;
  }

  /**
   * Leistungserbringergruppe: Datenelementgruppe bestehend aus Abrechnungscode:Tarifkennzeichen.
   */
  public EnfBuilder setServiceGroup(ServiceGroup serviceGroup) {
    enf.setServiceGroup(serviceGroup);
    return this;
  }
}
