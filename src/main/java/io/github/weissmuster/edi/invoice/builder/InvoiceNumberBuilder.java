package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.field.InvoiceNumber;
import org.apache.commons.lang.StringUtils;

public class InvoiceNumberBuilder {

  private InvoiceNumber invoiceNumber = new InvoiceNumber();

  public InvoiceNumber build() {
    return invoiceNumber;
  }

  /**
   * Sammel-Rechnungsnummer
   *
   * <p>Die Einzel-Rechnungsnummer ist zusätzlich zur SammelRechnungsnummer anzugeben, wenn eine
   * SLGA-Nachricht als Sammelrechnung zusätzlich in der Nutzdatendatei übermittelt wird, ansonsten
   * wird lediglich das Datenelement SammelRechnungsnummer gefüllt und die Einzel-Rechnungsnummer
   * auf „0“ gesetzt (zum Beispiel 00234567:0
   */
  public InvoiceNumberBuilder setCollectiveInvoiceNumber(Integer collectiveInvoiceNumber) {

    if(collectiveInvoiceNumber == null) {
      throw new IllegalArgumentException("collectiveInvoiceNumber is null");
    }

    invoiceNumber.setCollectiveInvoiceNumber(String.valueOf(collectiveInvoiceNumber));

    return this;
  }

  /**
   * Rechnungsnummer
   *
   * <p>Datenelementgruppe bestehend aus Sammel-Rechnungsnummer:EinzelRechnungsnummer. Einzutragen
   * ist die eindeutige Rechnungsnummer, die der Rechnungssteller vergibt. Eine Rechnungsnummer ist
   * eindeutig, wenn sie über alle Rechnungsjahre hinweg - ohne Kombination mit anderen
   * identifizierenden Schlüsseln oder Merkmalen (z. B. IK des Leistungserbringers, Rechnungsdatum)
   * – für eine Krankenkasse nur einer einzigen Rechnung zugeordnet werden kann. Diese
   * Rechnungsnummer ist vollständig und unverändert auf die Urbelege zu übernehmen (siehe
   * Richtlinien § 4 Abs.1 und § 3 des Richtlinientextes). Außer bei der Sammelrechnung-SLGA muss
   * diese Angabe übereinstimmen mit SLLA.REC.Rechnungsnummer der zugehörigen SLLA-Nachricht. Die
   * Rechnungsnummer im Datensatz muss identisch sein mit der Rechnungsnummer auf dem Begleitzettel
   * (vgl. Anlage 4). Sonderzeichen (einschließlich Leerzeichen) sind nicht zugelassen, ausgenommen
   * sind der Bindestrich „-„ und der Schrägstrich „/“ als Gliederungszeichen. Aufeinanderfolgende
   * Gliederungszeichen sind unzulässig. Die Rechnungsnummer darf nicht mit einem Gliederungszeichen
   * beginnen bzw. enden.
   */
  public InvoiceNumberBuilder setInvoiceNumber(String invoiceNumber) {

    this.invoiceNumber.setInvoiceNumber(StringUtils.leftPad(invoiceNumber, 14, "0"));
    return this;
  }
}
