package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Rec;
import io.github.weissmuster.edi.invoice.model.field.InvoiceNumber;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author twittig
 *     <p>REC Das Segment ist je Nachricht einmal zu übermitteln und ist identisch mit dem
 *     REC-Segment der zugehörigen SLLANachricht.
 */
public class RecBuilder {

  private Rec rec = new Rec();

  public Rec build() {
    return rec;
  }

  /** Rechnungsdatum JJJJMMTT */
  public RecBuilder setDate(Date date) {
    DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    rec.setDate(sdf.format(date));
    return this;
  }

  public RecBuilder setInvoiceNumber(InvoiceNumber invoiceNumber) {
    rec.setInvoiceNumber(invoiceNumber);
    return this;
  }

  /**
   * Rechnungsart<br>
   * <br>
   * Siehe Schlüssel Rechnungsart Anlage 3 Abschnitt 8.1.4. Dieser<br>
   * Schlüsselwert muss in der Sammelrechnungs-SLGA und allen zugehörigen<br>
   * SLGA-und SLLANachrichten gleich sein.<br>
   * <br>
   * 0 = Rechnung bereits bezahlt (z.B. durch eine Clearingstelle)<br>
   * 1 = Abrechnung von Leistungserbringer und Zahlung an IK Leistungserbringer<br>
   * 2 = Abrechnung über Abrechnungsstelle (ohne Inkassovollmacht) und Zahlung an IK
   * Leistungserbringer<br>
   * 3 = Abrechnung über Abrechnungsstelle (mit Inkassovollmacht) und Zahlung an IK
   * Abrechnungsstelle <br>
   */
  public RecBuilder setInvoiceType(String invoiceType) {
    rec.setInvoiceType(invoiceType);
    return this;
  }
}
