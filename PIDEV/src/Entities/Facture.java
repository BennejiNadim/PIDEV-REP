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
    public enum typef {
        vente_produit,
        achat_produit,
        vente_materiel,
        achat_materiel,
        taxe,
        salaire,
        in,
        out
    }
    private static int idc = 100;
    
    
    private int id;
    private Date dateFacturation;
    private etat etatFacture;
    private double montant;
    private String clientLogin;
    private String EmployeLogin;
    private int supplierId;
    private typef typeFacture;

    public Facture() {
        Connection cnx = Connexion.getInstance().getCnx();
        if (Facture.getIdc() == 100) {
            PreparedStatement pt;
            try {
                pt = cnx.prepareStatement("select MAX(id) from Facture");
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    
                    idc=1+rs.getInt(1);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
       
        this.id = idc++;
        this.dateFacturation = new Date(System.currentTimeMillis());
        this.etatFacture = etat.not_payed;
        
    }

    public Facture(etat etatFacture, double montant, String clientLogin, String EmployeLogin, int supplierId, typef typeFacture) {
        
        this();
        if(etatFacture==etat.payed){
            //create new transaction with dateFacturation
        }
        this.montant = montant;
        this.typeFacture = typeFacture;
        if(null!=typeFacture)
            switch (typeFacture) {
            case salaire:
                this.EmployeLogin = EmployeLogin;
                break;
            case vente_materiel:
            case vente_produit:
                this.clientLogin = clientLogin;
                break;
            case achat_materiel:
            case achat_produit:
                this.supplierId = supplierId;
                break;
            default:
                break;
        }
    }

    public String getEmployeLogin() {
        return EmployeLogin;
    }

    public typef getTypeFacture() {
        return typeFacture;
    }

    public void setEmployeLogin(String EmployeLogin) {
        this.EmployeLogin = EmployeLogin;
    }

    public void setTypeFacture(typef typeFacture) {
        this.typeFacture = typeFacture;
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

    public void setId(int id) {
        this.id = id;
    }
    

}
