package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Zuv;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Zusatzinfo Verordnung
 *
 * <p>ZUV Das Segment ist/kann je Abrechnungsfall einmal übermittelt werden.
 *
 * @author twittig
 */
public class ZuvBuilder {

  private Zuv zuv = new Zuv();

  public Zuv build() {
    return zuv;
  }

  /**
   * <b>Unfallkennzeichen:</b>
   *
   * <p>Siehe Schlüssel Unfall/Sonstiges Anlage 3 Abschnitt 8.1.2 Die Angabe der Daten auf der
   * Verordnung sind zwingend im Datenaustausch anzugeben bzw. zu übermitteln.
   */
  public ZuvBuilder setAccidentIndicator(String accidentIndicator) {
    zuv.setAccidentIndicator(accidentIndicator);
    return this;
  }

  /**
   * Zuzahlungskennzeichen:
   *
   * <p>Siehe Schlüssel Zuzahlungskennzeichen Anlage 3 Abschnitt 8.1.3.
   *
   * <p>0 = keine gesetzliche Zuzahlung 1 = Zuzahlungsbefreit 2 = keine Zuzahlung trotz
   * schriftlicher Zahlungsaufforderung 3 = Zuzahlungspflichtig 4 = Übergang zuzahlungspflichtig zu
   * zuzahlungsfrei * 5 = Übergang zuzahlungsfrei zu zuzahlungspflichtig **
   */
  public ZuvBuilder setAdditionalPaymentIndicator(String additionalPaymentIndicator) {
    zuv.setAdditionalPaymentIndicator(additionalPaymentIndicator);
    return this;
  }

  /**
   * Kennzeichen BVG/Sonstiges
   *
   * <p>Siehe Schlüssel BVG Anlage 3 Abschnitt 8.1.2.1
   *
   * <p>6 = BVG
   */
  public ZuvBuilder setIndicatorBVG(String indicatorBVG) {
    zuv.setIndicatorBVG(indicatorBVG);
    return this;
  }

  /**
   * Kennzeichen Verordnungsbesonderheiten
   *
   * <p>Siehe Schlüssel Kennzeichen Verordnungsbesonderheiten; Anlage 3 Abschnitt 8.1.11.
   *
   * <p>1 = Verordnung von einem Zahnarzt/Kieferorthopäden 2 = Verordnung im Zusammenhang mit der
   * Schwangerschaft oder der Entbindung
   */
  public ZuvBuilder setIndicatorMedicalPrescriptionFeature(
      String indicatorMedicalPrescriptionFeature) {
    zuv.setIndicatorMedicalPrescriptionFeature(indicatorMedicalPrescriptionFeature);
    return this;
  }

  /**
   * Lebenslange Arztnummer
   *
   * <p>Inhalt des Feldes 'Vertragsarztnummer/Arzt-Nr.' aus der Verordnung ist zwingend anzugeben.
   * Das Auffüllen des Feldes auf 9 Stellen ist unzulässig. Es sind nur die Ziffern 0 - 9 zu
   * verwenden. Ist keine Nummer eingetragen, ist das Feld mit „999999999“ zu übermitteln, sofern
   * keine anderweitigen Regelungen bestehen. Bei Verordnungen durch Zahnärzte ist die Nummer des
   * Zahnarztes einzutragen.
   */
  public ZuvBuilder setMedicalNumber(String medicalNumber) {
    zuv.setMedicalNumber(medicalNumber);
    return this;
  }

  /**
   * Verordnungs-, Ausstell- oder Einsatzdatum
   *
   * <p>JJJJMMTT. Verordnungsdatum aus Verordnung oder Ausstell- oder Einsatzdaten sind zwingend
   * anzugeben, soweit diese vorgesehen oder vereinbart sind.
   */
  public ZuvBuilder setMedicalPrescriptionDate(Date medicalPrescriptionDate) {
    DateFormat df = new SimpleDateFormat("yyyyMMdd");
    zuv.setMedicalPrescriptionDate(df.format(medicalPrescriptionDate));
    return this;
  }

  /**
   * Betriebsstättennummer:
   *
   * <p>Inhalt des Feldes 'Betriebsstättennummer' (ggf. IK des Krankenhauses) aus der Verordnung ist
   * zwingend anzugeben. Ist die Betriebsstättennummer nicht vorhanden, ist 999999999 anzugeben,
   * soweit keine anderweitigen Regelungen bestehen. Es sind nur Ziffern von 0 bis 9 zu verwenden.
   * Dies gilt auch bis zum Zeitpunkt der endgültigen Einführung der Betriebsstättennummer.
   */
  public ZuvBuilder setRegistrationNumber(String registrationNumber) {
    zuv.setRegistrationNumber(registrationNumber);
    return this;
  }
}
