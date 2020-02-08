/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Wael
 */
public class Facture {

    enum etat {
        payed,
        not_payed
    }
    private String id;
    private Date dateFacturation;
    private etat etatFacture;
    private double montant;

    public Facture() {
        this.etatFacture = etat.not_payed;
    }

    public Facture(String id, Date dateFacturation, double montant) {
        this.id = id;
        this.dateFacturation = dateFacturation;
        this.etatFacture = etat.not_payed;
        this.montant = montant;
    }

    public String getId() {
        return id;
    }

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public etat getEtatFacture() {
        return etatFacture;
    }

    public double getMontant() {
        return montant;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public void setEtatFacture(etat etatFacture) {
        this.etatFacture = etatFacture;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    
    
    

}
