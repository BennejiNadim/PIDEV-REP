/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.Connexion;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wael
 */
public class Facture {

    public enum etat {
        payed,
        not_payed
    }
    private static int idc = 1;
    private int id;
    private Date dateFacturation;
    private etat etatFacture;
    private double montant;
    private String clientLogin;
    private int supplierId;

    public Facture() {
        Connection cnx = Connexion.getInstance().getCnx();
        if (Facture.getIdc() == 1) {
            PreparedStatement pt;
            try {
                pt = cnx.prepareStatement("select MAX(id) from Facture");
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    
                    idc+=rs.getInt(1);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
       
        this.id = idc++;
        
        this.dateFacturation = new Date(System.currentTimeMillis());
        this.etatFacture = etat.not_payed;
        
    }

    public Facture(double montant, String clientLogin) {
        this();
        this.montant = montant;
        this.clientLogin = clientLogin;
    }

    public Facture(double montant, int supplierId) {
        this();
        this.montant = montant;
        this.supplierId = supplierId;
    }

    public static int getIdc() {
        return idc;
    }

    public int getId() {
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

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public void setPayed() {
        this.etatFacture = etat.payed;
    }

    public void setNotPayed() {
        this.etatFacture = etat.not_payed;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

}
