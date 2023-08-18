package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.InvoiceMessage;
import io.github.weissmuster.edi.invoice.model.Unb;
import io.github.weissmuster.edi.invoice.model.Unhs;
import io.github.weissmuster.edi.invoice.model.Unz;
import java.util.List;

public class InvoiceMessageBuilder {

  private InvoiceMessage invoiceMessage = new InvoiceMessage();

  public InvoiceMessage build() {
    return invoiceMessage;
  }

  public InvoiceMessageBuilder setUnb(Unb unb) {
    invoiceMessage.setUnb(unb);
    return this;
  }

  public InvoiceMessageBuilder setUnhs(List<Unhs> items) {
    invoiceMessage.setUnhs(items);
    return this;
  }

  public InvoiceMessageBuilder setUnz(Unz unz) {
    invoiceMessage.setUnz(unz);
    return this;
  }
}
