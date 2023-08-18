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

public class Nam implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private String number;
    private String name1;
    private String name2;
    private String name3;
    private String name4;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = new StringWriter();

        List<String> nodeTokens = new ArrayList<String>();

        if(number != null) {
            nodeWriter.write(delimiters.escape(number.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(name1 != null) {
            nodeWriter.write(delimiters.escape(name1.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(name2 != null) {
            nodeWriter.write(delimiters.escape(name2.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(name3 != null) {
            nodeWriter.write(delimiters.escape(name3.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getField());
        if(name4 != null) {
            nodeWriter.write(delimiters.escape(name4.toString()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeTokens.add(nodeWriter.toString());
        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegmentDelimiter());
        writer.flush();
    }

    public String getNumber() {
        return number;
    }

    public Nam setNumber(String number) {
        this.number = number;  return this;
    }

    public String getName1() {
        return name1;
    }

    public Nam setName1(String name1) {
        this.name1 = name1;  return this;
    }

    public String getName2() {
        return name2;
    }

    public Nam setName2(String name2) {
        this.name2 = name2;  return this;
    }

    public String getName3() {
        return name3;
    }

    public Nam setName3(String name3) {
        this.name3 = name3;  return this;
    }

    public String getName4() {
        return name4;
    }

    public Nam setName4(String name4) {
        this.name4 = name4;  return this;
    }
}