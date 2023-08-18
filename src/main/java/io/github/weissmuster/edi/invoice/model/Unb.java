/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package io.github.weissmuster.edi.invoice.model;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import io.github.weissmuster.edi.invoice.model.field.Syntax;    
import io.github.weissmuster.edi.invoice.model.field.Datetime;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    

public class Unb implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private Syntax syntax;
    private String senderIK;
    private String receiverIK;
    private Datetime datetime;
    private String icrn;
    private String areaOfSupply;
    private String filename;
    private String testIndicator;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = writer;

        if(syntax != null) {
            syntax.write(nodeWriter, delimiters);
        }
        nodeWriter.write(delimiters.getField());
        if(senderIK != null) {
            nodeWriter.write(delimiters.escape(senderIK.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(receiverIK != null) {
            nodeWriter.write(delimiters.escape(receiverIK.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(datetime != null) {
            datetime.write(nodeWriter, delimiters);
        }
        nodeWriter.write(delimiters.getField());
        if(icrn != null) {
            nodeWriter.write(delimiters.escape(icrn.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(areaOfSupply != null) {
            nodeWriter.write(delimiters.escape(areaOfSupply.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(filename != null) {
            nodeWriter.write(delimiters.escape(filename.toString()));
        }
        nodeWriter.write(delimiters.getField());
        if(testIndicator != null) {
            nodeWriter.write(delimiters.escape(testIndicator.toString()));
        }
        writer.write(delimiters.getSegmentDelimiter());
        writer.flush();
    }

    public Syntax getSyntax() {
        return syntax;
    }

    public Unb setSyntax(Syntax syntax) {
        this.syntax = syntax;  return this;
    }

    public String getSenderIK() {
        return senderIK;
    }

    public Unb setSenderIK(String senderIK) {
        this.senderIK = senderIK;  return this;
    }

    public String getReceiverIK() {
        return receiverIK;
    }

    public Unb setReceiverIK(String receiverIK) {
        this.receiverIK = receiverIK;  return this;
    }

    public Datetime getDatetime() {
        return datetime;
    }

    public Unb setDatetime(Datetime datetime) {
        this.datetime = datetime;  return this;
    }

    public String getIcrn() {
        return icrn;
    }

    public Unb setIcrn(String icrn) {
        this.icrn = icrn;  return this;
    }

    public String getAreaOfSupply() {
        return areaOfSupply;
    }

    public Unb setAreaOfSupply(String areaOfSupply) {
        this.areaOfSupply = areaOfSupply;  return this;
    }

    public String getFilename() {
        return filename;
    }

    public Unb setFilename(String filename) {
        this.filename = filename;  return this;
    }

    public String getTestIndicator() {
        return testIndicator;
    }

    public Unb setTestIndicator(String testIndicator) {
        this.testIndicator = testIndicator;  return this;
    }
}