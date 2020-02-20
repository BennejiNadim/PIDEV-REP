/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
 * @author user
 */
public class Reclamation {
    public enum etat_r{
        acceptée,
        refusée
    }
    private static int idc=1;
    private int id;
    private etat_r etat;
    private Date date;
    private String client_login;

    public Reclamation() {
         Connection cnx = Connexion.getInstance().getCnx();
        if (Reclamation.idc == 1) {
            PreparedStatement pt;
            try {
                pt = cnx.prepareStatement("select MAX(ID_reclamation) from reclamation");
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    
                    idc=1+rs.getInt(1);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        this.id=idc++;
        this.date = new Date(System.currentTimeMillis());

    }

    public Reclamation(int id, etat_r etat, Date date, String client_login) {
        this.id = id;
        this.etat = etat;
        this.date = date;
        this.client_login = client_login;
    }

    public Reclamation(etat_r etat, String client_login) {
        this();
        this.etat = etat;
        this.client_login =client_login;
        
    }

    public void setClient_login(String client_login) {
        this.client_login = client_login;
    }

    public String getClient_login() {
        return client_login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEtat(etat_r etat) {
        this.etat = etat;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static int getIdc() {
        return idc;
    }

    public int getId() {
        return id;
    }

    public etat_r getEtat() {
        return etat;
    }

    public Date getDate() {
        return date;
    }
    
}

