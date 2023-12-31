/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package io.github.weissmuster.edi.invoice.model;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import io.github.weissmuster.edi.invoice.model.field.ServiceGroup;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    

public class Enf implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private String identificationNumber;
    private ServiceGroup serviceGroup;
    private String billingItemNumber;
    private String quantity;
    private String amount;
    private String dateOfServiceProvision;
    private String additionalPayment;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = writer;

        if(identificationNumber != null) {
            nodeWriter.write(delimiters.escape(identificationNumber.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(serviceGroup != null) {
            serviceGroup.write(nodeWriter, delimiters);
        }
        nodeWriter.write(delimiters.getField());
        if(billingItemNumber != null) {
            nodeWriter.write(delimiters.escape(billingItemNumber.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(quantity != null) {
            nodeWriter.write(delimiters.escape(quantity.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(amount != null) {
            nodeWriter.write(delimiters.escape(amount.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(dateOfServiceProvision != null) {
            nodeWriter.write(delimiters.escape(dateOfServiceProvision.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(additionalPayment != null) {
            nodeWriter.write(delimiters.escape(additionalPayment.toString()));
        }
        writer.write(delimiters.getSegmentDelimiter());
        writer.flush();
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public Enf setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;  return this;
    }

    public ServiceGroup getServiceGroup() {
        return serviceGroup;
    }

    public Enf setServiceGroup(ServiceGroup serviceGroup) {
        this.serviceGroup = serviceGroup;  return this;
    }

    public String getBillingItemNumber() {
        return billingItemNumber;
    }

    public Enf setBillingItemNumber(String billingItemNumber) {
        this.billingItemNumber = billingItemNumber;  return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public Enf setQuantity(String quantity) {
        this.quantity = quantity;  return this;
    }

    public String getAmount() {
        return amount;
    }

    public Enf setAmount(String amount) {
        this.amount = amount;  return this;
    }

    public String getDateOfServiceProvision() {
        return dateOfServiceProvision;
    }

    public Enf setDateOfServiceProvision(String dateOfServiceProvision) {
        this.dateOfServiceProvision = dateOfServiceProvision;  return this;
    }

    public String getAdditionalPayment() {
        return additionalPayment;
    }

    public Enf setAdditionalPayment(String additionalPayment) {
        this.additionalPayment = additionalPayment;  return this;
    }
}