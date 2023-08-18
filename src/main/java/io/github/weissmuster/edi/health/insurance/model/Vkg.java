/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package io.github.weissmuster.edi.health.insurance.model;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    
import java.io.StringWriter;    
import java.util.List;    
import java.util.ArrayList;    
import org.milyn.edisax.util.EDIUtils;    
import org.milyn.edisax.model.internal.DelimiterType;    

public class Vkg implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private String typeOfLink;
    private String ikOfLinkPartner;
    private String serviceProviderGroup;
    private String ikOfAccountingService;
    private String typeOfDataDelivery;
    private String typeOfTransmissionMedium;
    private String countyOfServiceProvider;
    private String kvOfServiceProvider;
    private String rateIndicator;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = new StringWriter();

        List<String> nodeTokens = new ArrayList<String>();

        if(typeOfLink != null) {
            nodeWriter.write(delimiters.escape(typeOfLink.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(ikOfLinkPartner != null) {
            nodeWriter.write(delimiters.escape(ikOfLinkPartner.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(serviceProviderGroup != null) {
            nodeWriter.write(delimiters.escape(serviceProviderGroup.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(ikOfAccountingService != null) {
            nodeWriter.write(delimiters.escape(ikOfAccountingService.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(typeOfDataDelivery != null) {
            nodeWriter.write(delimiters.escape(typeOfDataDelivery.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(typeOfTransmissionMedium != null) {
            nodeWriter.write(delimiters.escape(typeOfTransmissionMedium.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(countyOfServiceProvider != null) {
            nodeWriter.write(delimiters.escape(countyOfServiceProvider.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(kvOfServiceProvider != null) {
            nodeWriter.write(delimiters.escape(kvOfServiceProvider.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(rateIndicator != null) {
            nodeWriter.write(delimiters.escape(rateIndicator.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeTokens.add(nodeWriter.toString());
        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegmentDelimiter());
        writer.flush();
    }

    public String getTypeOfLink() {
        return typeOfLink;
    }

    public Vkg setTypeOfLink(String typeOfLink) {
        this.typeOfLink = typeOfLink;  return this;
    }

    public String getIkOfLinkPartner() {
        return ikOfLinkPartner;
    }

    public Vkg setIkOfLinkPartner(String ikOfLinkPartner) {
        this.ikOfLinkPartner = ikOfLinkPartner;  return this;
    }

    public String getServiceProviderGroup() {
        return serviceProviderGroup;
    }

    public Vkg setServiceProviderGroup(String serviceProviderGroup) {
        this.serviceProviderGroup = serviceProviderGroup;  return this;
    }

    public String getIkOfAccountingService() {
        return ikOfAccountingService;
    }

    public Vkg setIkOfAccountingService(String ikOfAccountingService) {
        this.ikOfAccountingService = ikOfAccountingService;  return this;
    }

    public String getTypeOfDataDelivery() {
        return typeOfDataDelivery;
    }

    public Vkg setTypeOfDataDelivery(String typeOfDataDelivery) {
        this.typeOfDataDelivery = typeOfDataDelivery;  return this;
    }

    public String getTypeOfTransmissionMedium() {
        return typeOfTransmissionMedium;
    }

    public Vkg setTypeOfTransmissionMedium(String typeOfTransmissionMedium) {
        this.typeOfTransmissionMedium = typeOfTransmissionMedium;  return this;
    }

    public String getCountyOfServiceProvider() {
        return countyOfServiceProvider;
    }

    public Vkg setCountyOfServiceProvider(String countyOfServiceProvider) {
        this.countyOfServiceProvider = countyOfServiceProvider;  return this;
    }

    public String getKvOfServiceProvider() {
        return kvOfServiceProvider;
    }

    public Vkg setKvOfServiceProvider(String kvOfServiceProvider) {
        this.kvOfServiceProvider = kvOfServiceProvider;  return this;
    }

    public String getRateIndicator() {
        return rateIndicator;
    }

    public Vkg setRateIndicator(String rateIndicator) {
        this.rateIndicator = rateIndicator;  return this;
    }
}