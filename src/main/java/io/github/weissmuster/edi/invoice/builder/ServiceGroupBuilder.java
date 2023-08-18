package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.field.ServiceGroup;
import org.apache.commons.lang.StringUtils;

/**
 * Leistungserbringergruppe: Datenelementgruppe bestehend aus Abrechnungscode:Tarifkennzeichen.
 *
 * @author twittig
 */
public class ServiceGroupBuilder {

  private ServiceGroup serviceGroup = new ServiceGroup();

  public ServiceGroup build() {
    return serviceGroup;
  }

  /**
   * Abrechnungscode: Siehe Schlüssel Abrechnungscode Anlage 3 Abschnitt 8.1.5.1.
   *
   * <p>61 = Leistungserbringer von Rehabilitationssport 62 = Leistungserbringer von
   * Funktionstraining 63 = Leistungserbringer für ergänzende Rehabilitationsmaßnahmen 64 = - nicht
   * besetzt - 65 = Sonstiger Leistungserbringer 66 = Leistungserbringer von Präventions- und
   * Gesundheits- förderungsmaßnahmen im Rahmen von ambulanten Vorsorgeleistungen 67 = Ambulantes
   * Rehazentrum / Mobile Rehabilitationseinrichtung 68 = Sozialpädiatrische
   * Zentren/Frühförderstellen 69 = Soziotherapeutischer Leistungserbringer 75 = Spezialisierte
   * ambulante Palliativversorgung (SAPV)
   */
  public ServiceGroupBuilder setBillingCode(String billingCode) {
    serviceGroup.setBillingCode(billingCode);
    return this;
  }

  /**
   * Tarifkennzeichen:
   *
   * <p>s.o. Leistungserbrigerschlüssel
   */
  public ServiceGroupBuilder setRateIndicator(String rateIndicator) {
    serviceGroup.setRateIndicator(StringUtils.rightPad(rateIndicator, 5, "0"));
    return this;
  }
}
