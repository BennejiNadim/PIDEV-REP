/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Transaction;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wael
 */
public class GestionTransaction {
    private final Connection cnx;

    public GestionTransaction() {
        this.cnx = Connexion.getInstance().getCnx();
    }

    public void ajouterTransaction(Transaction t) {
        Statement st;
        try {
            st = cnx.createStatement();

            String req = "insert into Transaction values(" + t.getId() + ",'" + t.getDate()+ "','" + t.getMonton()+ "','"+ t.getEtatTransaction()+ "','"  + t.getDescription()+ "','" + t.getIdFacture()+ "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherTransaction() {
        try {
            PreparedStatement pt = cnx.prepareStatement("select * from Transaction");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Transaction [ id: " + rs.getInt(1) + " date : " + rs.getDate(2) + " Monton: " + rs.getDouble(3)+ " Etat: " + rs.getString(4) + " Description: " + rs.getString(5)+ " Id Facture : " + rs.getInt(6) + "]");
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifierTransaction(int id,Transaction t) {
        PreparedStatement pt;
        try {
            pt = cnx.prepareStatement("update Transaction set etatTransaction = ?, date = ?, montant = ?, description = ?   where id = ?");
            pt.setString(1, t.getEtatTransaction().toString());
            pt.setDate(2, t.getDate());
            
            pt.setDouble(3, t.getMonton());
            pt.setInt(5, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerTransaction(int id) {
        PreparedStatement pt;
        try {
            pt = cnx.prepareStatement("delete from Transaction where id = ?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

