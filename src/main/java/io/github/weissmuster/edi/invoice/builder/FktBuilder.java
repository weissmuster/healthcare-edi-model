package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Fkt;
import org.apache.commons.lang.StringUtils;

/**
 * @author twittig
 *     <p>Das Segment (FKT) enthält Informationen über die zu verarbeitende Rechnung, den
 *     Rechnungssteller (Leistungserbringer oder Abrechnungsstelle) und das IK der Krankenkasse von
 *     der Krankenversichertenkarte bzw. von der ärztlichen Verordnung.
 *     <p>FKT Das Segment ist je Nachricht einmal zu übermitteln.
 */
public class FktBuilder {

  private Fkt fkt = new Fkt();

  /** @return */
  public Fkt build() {
    return fkt;
  }

  /**
   * IK des Rechnungsstellers/ Leistungserbringers
   *
   * <p>Es ist das IK des Leistungserbringers anzugeben – mit folgender Ausnahme: Erfolgt die
   * Abrechnung über eine Abrechnungsstelle mit Inkassovollmacht, so ist in der Sammelrechnungs-SLGA
   * das IK der Abrechnungsstelle anzugeben.
   */
  public FktBuilder setBillerIK(String billerIK) {
    fkt.setBillerIK(billerIK);
    return this;
  }

  /**
   * Sammelrechnung
   *
   * <p>Feld ist nur anzugeben und mit „J“ zu füllen, wenn es sich um eine Sammelrechnung handelt.
   *
   * @return {@link FktBuilder}
   */
  public FktBuilder setCollectiveInvoice(Boolean collectiveInvoice) {
    fkt.setCollectiveInvoice(collectiveInvoice == Boolean.TRUE ? "J" : StringUtils.EMPTY);
    return this;
  }

  /**
   * IK der Krankenkasse von der KVKarte bzw. der ärztlichen Verordnung ist zwingend anzugeben,
   * außer es handelt sich um eine Sammelrechnung-SLGA. Bei allen SLGA Nachrichten als
   * Gesamtrechnung ist diese Angabe identisch mit SLLA.FKT.IK der Krankenkasse der zugehörigen
   * SLLA-Nachricht.
   */
  public FktBuilder setHealthInsuranceIK(String healthInsuranceIK) {
    fkt.setHealthInsuranceIK(healthInsuranceIK);
    return this;
  }

  /**
   * Verarbeitungskennzeichen
   *
   * <p>sollte idealerweise default 01 = Abrechnung ohne Besonderheiten sein
   */
  public FktBuilder setProcessingFlag(String processingFlag) {
    fkt.setProcessingFlag(processingFlag);
    return this;
  }

  /**
   * IK des Kostenträgers
   *
   * <p>Einzutragen ist das IK des Kostenträgers auf den das IK der KV-Karte in der
   * Kostenträgerdatei verweist; diese Angabe ist identisch mit dem IK des Kostenträgers im
   * FKT-Segment der zugehörigen SLLA-Nachricht.
   */
  public FktBuilder setReceiverIK(String receiverIK) {
    fkt.setReceiverIK(receiverIK);
    return this;
  }

  /**
   * IK Absender der Datei
   *
   * <p>Einzutragen ist das IK des Absenders der Datei. Diese Angabe ist identisch mit UNB.Absender.
   */
  public FktBuilder setSenderIK(String senderIK) {
    fkt.setSenderIK(senderIK);
    return this;
  }

  public FktBuilder withDefaults() {
    setProcessingFlag("01");
    setCollectiveInvoice(Boolean.TRUE);
    setSenderIK("000000001");
    setHealthInsuranceIK("000000001");
    setBillerIK("000000001");
    setReceiverIK("000000001");
    return this;
  }
}
