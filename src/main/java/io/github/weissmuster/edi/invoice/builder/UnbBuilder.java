package io.github.weissmuster.edi.invoice.builder;

import io.github.weissmuster.edi.invoice.model.Unb;
import io.github.weissmuster.edi.invoice.model.field.Datetime;
import io.github.weissmuster.edi.invoice.model.field.Syntax;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class UnbBuilder {

  private static final String DATE_PATTERN = "yyyyMMdd";

  private static final String TIME_PATTERN = "hhmm";

  private Syntax syntax = new Syntax();

  private Unb unb = new Unb();

  public Unb build() {
    withDefaultSyntax();
    return unb;
  }

  public UnbBuilder setAreaOfSupply(String areaOfSupply) {
    unb.setAreaOfSupply(areaOfSupply);
    return this;
  }

  public UnbBuilder setDatetime(Datetime datetime) {
    unb.setDatetime(datetime);
    return this;
  }

  public UnbBuilder setFilename(String filename) {
    unb.setFilename(filename);
    return this;
  }

  public UnbBuilder setIcrn(String icrn) {
    unb.setIcrn(StringUtils.leftPad(icrn, 5, "0"));
    return this;
  }

  public UnbBuilder setReceiverIK(String receiverIK) {
    unb.setReceiverIK(receiverIK);
    return this;
  }

  public UnbBuilder setSenderIK(String senderIK) {
    unb.setSenderIK(senderIK);
    return this;
  }

  public UnbBuilder setTestIndicator(String testIndicator) {
    unb.setTestIndicator(testIndicator);
    return this;
  }

  public UnbBuilder withCurrentDatetime() {

    Datetime datetime = new Datetime();

    Date current = new Date();

    SimpleDateFormat sdfDate = new SimpleDateFormat(DATE_PATTERN);
    SimpleDateFormat sdfTime = new SimpleDateFormat(TIME_PATTERN);

    datetime.setDate(sdfDate.format(current));
    datetime.setTime(sdfTime.format(current));

    unb.setDatetime(datetime);

    return this;
  }

  public UnbBuilder withDefaultDatetime() {

    Datetime datetime = new Datetime();

    Date current = new Date();

    SimpleDateFormat sdfDate = new SimpleDateFormat(DATE_PATTERN);
    SimpleDateFormat sdfTime = new SimpleDateFormat(TIME_PATTERN);

    datetime.setDate(sdfDate.format(current));
    datetime.setTime(sdfTime.format(current));

    unb.setDatetime(datetime);

    return this;
  }

  public UnbBuilder withDefaults() {
    withDefaultSyntax();
    setSenderIK("111111111");
    setReceiverIK("999999999");
    withDefaultDatetime();
    setIcrn("00001");
    setAreaOfSupply("H");
    setFilename("healthInsurance_invoice_example");
    setTestIndicator("0");
    return this;
  }

  public UnbBuilder withDefaultSyntax() {
    syntax.setId("UNOC");
    syntax.setVersion("3");
    unb.setSyntax(syntax);
    return this;
  }
}
