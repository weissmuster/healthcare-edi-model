/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package io.github.weissmuster.edi.invoice.model;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import java.util.List;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    

public class Sllas implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private Inv inv;
    private Nad nad;
    private List<Enf> enf;
    private Zuv zuv;
    private Bes bes;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = writer;

        if(inv != null) {
            nodeWriter.write("INV");
            nodeWriter.write(delimiters.getField());
            inv.write(nodeWriter, delimiters);
        }
        if(nad != null) {
            nodeWriter.write("NAD");
            nodeWriter.write(delimiters.getField());
            nad.write(nodeWriter, delimiters);
        }
        if(enf != null && !enf.isEmpty()) {
            for(Enf enfInst : enf) {
                nodeWriter.write("ENF");
                nodeWriter.write(delimiters.getField());
                enfInst.write(nodeWriter, delimiters);
            }
        }
        if(zuv != null) {
            nodeWriter.write("ZUV");
            nodeWriter.write(delimiters.getField());
            zuv.write(nodeWriter, delimiters);
        }
        if(bes != null) {
            nodeWriter.write("BES");
            nodeWriter.write(delimiters.getField());
            bes.write(nodeWriter, delimiters);
        }
    }

    public Inv getInv() {
        return inv;
    }

    public Sllas setInv(Inv inv) {
        this.inv = inv;  return this;
    }

    public Nad getNad() {
        return nad;
    }

    public Sllas setNad(Nad nad) {
        this.nad = nad;  return this;
    }

    public List<Enf> getEnf() {
        return enf;
    }

    public Sllas setEnf(List<Enf> enf) {
        this.enf = enf;  return this;
    }

    public Zuv getZuv() {
        return zuv;
    }

    public Sllas setZuv(Zuv zuv) {
        this.zuv = zuv;  return this;
    }

    public Bes getBes() {
        return bes;
    }

    public Sllas setBes(Bes bes) {
        this.bes = bes;  return this;
    }
}