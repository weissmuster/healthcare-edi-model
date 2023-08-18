/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package io.github.weissmuster.edi.health.insurance.model;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    

public class Dfu implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private String number;
    private String transmissionProtocol;
    private String userIdentification;
    private String transmissionFrom;
    private String transmissionTo;
    private String transmissionDays;
    private String communicationChannel;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = writer;

        if(number != null) {
            nodeWriter.write(delimiters.escape(number.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(transmissionProtocol != null) {
            nodeWriter.write(delimiters.escape(transmissionProtocol.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(userIdentification != null) {
            nodeWriter.write(delimiters.escape(userIdentification.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(transmissionFrom != null) {
            nodeWriter.write(delimiters.escape(transmissionFrom.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(transmissionTo != null) {
            nodeWriter.write(delimiters.escape(transmissionTo.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(transmissionDays != null) {
            nodeWriter.write(delimiters.escape(transmissionDays.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(communicationChannel != null) {
            nodeWriter.write(delimiters.escape(communicationChannel.toString()));
        }
        writer.write(delimiters.getSegmentDelimiter());
        writer.flush();
    }

    public String getNumber() {
        return number;
    }

    public Dfu setNumber(String number) {
        this.number = number;  return this;
    }

    public String getTransmissionProtocol() {
        return transmissionProtocol;
    }

    public Dfu setTransmissionProtocol(String transmissionProtocol) {
        this.transmissionProtocol = transmissionProtocol;  return this;
    }

    public String getUserIdentification() {
        return userIdentification;
    }

    public Dfu setUserIdentification(String userIdentification) {
        this.userIdentification = userIdentification;  return this;
    }

    public String getTransmissionFrom() {
        return transmissionFrom;
    }

    public Dfu setTransmissionFrom(String transmissionFrom) {
        this.transmissionFrom = transmissionFrom;  return this;
    }

    public String getTransmissionTo() {
        return transmissionTo;
    }

    public Dfu setTransmissionTo(String transmissionTo) {
        this.transmissionTo = transmissionTo;  return this;
    }

    public String getTransmissionDays() {
        return transmissionDays;
    }

    public Dfu setTransmissionDays(String transmissionDays) {
        this.transmissionDays = transmissionDays;  return this;
    }

    public String getCommunicationChannel() {
        return communicationChannel;
    }

    public Dfu setCommunicationChannel(String communicationChannel) {
        this.communicationChannel = communicationChannel;  return this;
    }
}