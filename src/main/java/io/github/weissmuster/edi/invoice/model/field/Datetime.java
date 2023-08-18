/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package io.github.weissmuster.edi.invoice.model.field;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    

public class Datetime implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private String date;
    private String time;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = writer;

        if(date != null) {
            nodeWriter.write(delimiters.escape(date.toString()));
        }
        nodeWriter.write(delimiters.getComponent());
        if(time != null) {
            nodeWriter.write(delimiters.escape(time.toString()));
        }
    }

    public String getDate() {
        return date;
    }

    public Datetime setDate(String date) {
        this.date = date;  return this;
    }

    public String getTime() {
        return time;
    }

    public Datetime setTime(String time) {
        this.time = time;  return this;
    }
}