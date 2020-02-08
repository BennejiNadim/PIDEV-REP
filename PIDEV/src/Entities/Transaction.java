/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.Facture.etat;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wael
 */
public class Transaction {
    
    private static int idc=100;
    private int id;
    private int idFacture;
    private etat etatTransaction;
    private Date date;
    private Double monton;
    private String description;

    public Transaction() {
        
        Connection cnx = Connexion.getInstance().getCnx();
        if (Facture.getIdc() == 100) {
            PreparedStatement pt;
            try {
                pt = cnx.prepareStatement("select MAX(id) from Transaction");
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    
                    idc=1+rs.getInt(1);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        this.id=idc++;
        this.etatTransaction=etat.not_payed;
    }

    public Transaction(int idFacture,etat etatTransaction, String description, Date date, Double monton) {
        this();
        this.etatTransaction=etatTransaction;
        this.idFacture = idFacture;
        this.description = description;
        this.date = date;
        this.monton = monton;
    }

    public etat getEtatTransaction() {
        return etatTransaction;
    }
    
    public void setPayed() {
        this.etatTransaction = etat.payed;
    }

    public void setNotPayed() {
        this.etatTransaction = etat.not_payed;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public static int getIdc() {
        return idc;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    

    public int getId() {
        return id;
    }



    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Double getMonton() {
        return monton;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMonton(Double monton) {
        this.monton = monton;
    }

}
