/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package io.github.weissmuster.edi.health.insurance.model;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import io.github.weissmuster.edi.health.insurance.model.field.Syntax;    
import io.github.weissmuster.edi.health.insurance.model.field.Datetime;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    
import java.io.StringWriter;    
import java.util.List;    
import java.util.ArrayList;    
import org.milyn.edisax.util.EDIUtils;    
import org.milyn.edisax.model.internal.DelimiterType;    

public class Unb implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private Syntax syntax;
    private String senderIK;
    private String receiverIK;
    private Datetime datetime;
    private String icrn;
    private String areaOfSupply;
    private String filename;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = new StringWriter();

        List<String> nodeTokens = new ArrayList<String>();

        if(syntax != null) {
            syntax.write(nodeWriter, delimiters);
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(senderIK != null) {
            nodeWriter.write(delimiters.escape(senderIK.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(receiverIK != null) {
            nodeWriter.write(delimiters.escape(receiverIK.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(datetime != null) {
            datetime.write(nodeWriter, delimiters);
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(icrn != null) {
            nodeWriter.write(delimiters.escape(icrn.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(areaOfSupply != null) {
            nodeWriter.write(delimiters.escape(areaOfSupply.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(filename != null) {
            nodeWriter.write(delimiters.escape(filename.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeTokens.add(nodeWriter.toString());
        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
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
}