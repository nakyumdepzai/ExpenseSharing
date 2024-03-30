/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.Model;

/**
 *
 * @author nakyumdepzaii
 */
public class personDTO {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private String name;
    private boolean admin;
    private double diff;
    private double mem;
    private double cung;
    private double flex;

    public personDTO() {
    }

    public personDTO(String name) {
        this.name = name;
    }

    public personDTO(String name, boolean admin, double diff, double mem, double cung, double flex) {
        this.name = name;
        this.admin = admin;
        this.diff = diff;
        this.mem = mem;
        this.cung = cung;
        this.flex = flex;
    }

    public personDTO(String name, double flex) {
        this.name = name;
        this.flex = flex;
    }
    
    

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public double getDiff() {
        return diff;
    }

    public double getMem() {
        return mem;
    }

    public double getCung() {
        return cung;
    }

    public double getFlex() {
        return flex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public void setMem(double mem) {
        this.mem = mem;
    }

    public void setCung(double cung) {
        this.cung = cung;
    }

    public void setFlex(double flex) {
        this.flex = flex;
    }
}
