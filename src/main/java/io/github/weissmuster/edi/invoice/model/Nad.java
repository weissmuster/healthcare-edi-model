/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package io.github.weissmuster.edi.invoice.model;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    

public class Nad implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private String insuredLastname;
    private String insuredFirstname;
    private String insuredBirthday;
    private String insuredStreedAddress;
    private String insuredPostalcode;
    private String insuredCity;
    private String insuredCountry;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = writer;

        if(insuredLastname != null) {
            nodeWriter.write(delimiters.escape(insuredLastname.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(insuredFirstname != null) {
            nodeWriter.write(delimiters.escape(insuredFirstname.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(insuredBirthday != null) {
            nodeWriter.write(delimiters.escape(insuredBirthday.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(insuredStreedAddress != null) {
            nodeWriter.write(delimiters.escape(insuredStreedAddress.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(insuredPostalcode != null) {
            nodeWriter.write(delimiters.escape(insuredPostalcode.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(insuredCity != null) {
            nodeWriter.write(delimiters.escape(insuredCity.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(insuredCountry != null) {
            nodeWriter.write(delimiters.escape(insuredCountry.toString()));
        }
        writer.write(delimiters.getSegmentDelimiter());
        writer.flush();
    }

    public String getInsuredLastname() {
        return insuredLastname;
    }

    public Nad setInsuredLastname(String insuredLastname) {
        this.insuredLastname = insuredLastname;  return this;
    }

    public String getInsuredFirstname() {
        return insuredFirstname;
    }

    public Nad setInsuredFirstname(String insuredFirstname) {
        this.insuredFirstname = insuredFirstname;  return this;
    }

    public String getInsuredBirthday() {
        return insuredBirthday;
    }

    public Nad setInsuredBirthday(String insuredBirthday) {
        this.insuredBirthday = insuredBirthday;  return this;
    }

    public String getInsuredStreedAddress() {
        return insuredStreedAddress;
    }

    public Nad setInsuredStreedAddress(String insuredStreedAddress) {
        this.insuredStreedAddress = insuredStreedAddress;  return this;
    }

    public String getInsuredPostalcode() {
        return insuredPostalcode;
    }

    public Nad setInsuredPostalcode(String insuredPostalcode) {
        this.insuredPostalcode = insuredPostalcode;  return this;
    }

    public String getInsuredCity() {
        return insuredCity;
    }

    public Nad setInsuredCity(String insuredCity) {
        this.insuredCity = insuredCity;  return this;
    }

    public String getInsuredCountry() {
        return insuredCountry;
    }

    public Nad setInsuredCountry(String insuredCountry) {
        this.insuredCountry = insuredCountry;  return this;
    }
}