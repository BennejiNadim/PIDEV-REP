/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class MouvmentProduit {

    private String source;
    private String destination;
    private int quantité;
    private Date date;

    public MouvmentProduit(String source, String destination, int quantité, Date date) {
        this.source = source;
        this.destination = destination;
        this.quantité = quantité;
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getQuantité() {
        return quantité;
    }

    public Date getDate() {
        return date;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
