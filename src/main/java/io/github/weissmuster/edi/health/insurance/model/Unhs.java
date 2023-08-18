/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package io.github.weissmuster.edi.health.insurance.model;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import java.util.List;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    

public class Unhs implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private Unh unh;
    private Idk idk;
    private Vdt vdt;
    private Fkt fkt;
    private List<Vkg> vkg;
    private List<ContactPersons> contactPersons;
    private List<Asp> asp;
    private List<Transmissions> transmissions;
    private Unt unt;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = writer;

        if(unh != null) {
            nodeWriter.write("UNH");
            nodeWriter.write(delimiters.getField());
            unh.write(nodeWriter, delimiters);
        }
        if(idk != null) {
            nodeWriter.write("IDK");
            nodeWriter.write(delimiters.getField());
            idk.write(nodeWriter, delimiters);
        }
        if(vdt != null) {
            nodeWriter.write("VDT");
            nodeWriter.write(delimiters.getField());
            vdt.write(nodeWriter, delimiters);
        }
        if(fkt != null) {
            nodeWriter.write("FKT");
            nodeWriter.write(delimiters.getField());
            fkt.write(nodeWriter, delimiters);
        }
        if(vkg != null && !vkg.isEmpty()) {
            for(Vkg vkgInst : vkg) {
                nodeWriter.write("VKG");
                nodeWriter.write(delimiters.getField());
                vkgInst.write(nodeWriter, delimiters);
            }
        }
        if(contactPersons != null && !contactPersons.isEmpty()) {
            for(ContactPersons contactPersonsInst : contactPersons) {
                contactPersonsInst.write(nodeWriter, delimiters);
            }
        }
        if(asp != null && !asp.isEmpty()) {
            for(Asp aspInst : asp) {
                nodeWriter.write("ASP");
                nodeWriter.write(delimiters.getField());
                aspInst.write(nodeWriter, delimiters);
            }
        }
        if(transmissions != null && !transmissions.isEmpty()) {
            for(Transmissions transmissionsInst : transmissions) {
                transmissionsInst.write(nodeWriter, delimiters);
            }
        }
        if(unt != null) {
            nodeWriter.write("UNT");
            nodeWriter.write(delimiters.getField());
            unt.write(nodeWriter, delimiters);
        }
    }

    public Unh getUnh() {
        return unh;
    }

    public Unhs setUnh(Unh unh) {
        this.unh = unh;  return this;
    }

    public Idk getIdk() {
        return idk;
    }

    public Unhs setIdk(Idk idk) {
        this.idk = idk;  return this;
    }

    public Vdt getVdt() {
        return vdt;
    }

    public Unhs setVdt(Vdt vdt) {
        this.vdt = vdt;  return this;
    }

    public Fkt getFkt() {
        return fkt;
    }

    public Unhs setFkt(Fkt fkt) {
        this.fkt = fkt;  return this;
    }

    public List<Vkg> getVkg() {
        return vkg;
    }

    public Unhs setVkg(List<Vkg> vkg) {
        this.vkg = vkg;  return this;
    }

    public List<ContactPersons> getContactPersons() {
        return contactPersons;
    }

    public Unhs setContactPersons(List<ContactPersons> contactPersons) {
        this.contactPersons = contactPersons;  return this;
    }

    public List<Asp> getAsp() {
        return asp;
    }

    public Unhs setAsp(List<Asp> asp) {
        this.asp = asp;  return this;
    }

    public List<Transmissions> getTransmissions() {
        return transmissions;
    }

    public Unhs setTransmissions(List<Transmissions> transmissions) {
        this.transmissions = transmissions;  return this;
    }

    public Unt getUnt() {
        return unt;
    }

    public Unhs setUnt(Unt unt) {
        this.unt = unt;  return this;
    }
}