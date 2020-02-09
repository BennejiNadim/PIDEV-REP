/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Facture;
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
public class GestionFacture {

    private final Connection cnx;

    public GestionFacture() {
        this.cnx = Connexion.getInstance().getCnx();
    }

    public void ajouterFacture(Facture f) {
        Statement st;
        try {
            st = cnx.createStatement();

            String req = "insert into Facture values(" + f.getId() + ",'" + f.getDateFacturation() + "','" + f.getEtatFacture() + "','" + f.getMontant() + "','" + f.getClientLogin() + "','" + f.getSupplierId() + "','" + f.getEmployeLogin() + "','" + f.getTypeFacture() + "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionFacture.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherFacture() {
        try {
            PreparedStatement pt = cnx.prepareStatement("select * from Facture");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {

                if (rs.getString(8).startsWith("achat")) {
                    System.out.println("Facture [ id: " + rs.getInt(1) + " dateFacturation: " + rs.getDate(2) + " etatFacture: " + rs.getString(3) + " Monton: " + rs.getDouble(4) + " Supplier: " + rs.getInt(6) + " Type: " + rs.getString(8) + "]");
                } else if (rs.getString(8).startsWith("vente")) {
                    System.out.println("Facture [ id: " + rs.getInt(1) + " dateFacturation: " + rs.getDate(2) + " etatFacture: " + rs.getString(3) + " Monton: " + rs.getDouble(4) + " Client: " + rs.getString(5) + " Type: " + rs.getString(8) + "]");
                } else if (rs.getString(8).equals("salaire")) {
                    System.out.println("Facture [ id: " + rs.getInt(1) + " dateFacturation: " + rs.getDate(2) + " etatFacture: " + rs.getString(3) + " Monton: " + rs.getDouble(4) + " Employe: " + rs.getString(7) + " Type: " + rs.getString(8) + "]");
                } else {
                    System.out.println("Facture [ id: " + rs.getInt(1) + " dateFacturation: " + rs.getDate(2) + " etatFacture: " + rs.getString(3) + " Monton: " + rs.getDouble(4) + " Type: " + rs.getString(8) + "]");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionFacture.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifierFacture(int id, Facture f) {
        PreparedStatement pt;
        try {
            pt = cnx.prepareStatement("update Facture set dateFacturation = ?, etatFacture = ?, montant = ?  where id = ?");
            pt.setDate(1, f.getDateFacturation());
            pt.setString(2, f.getEtatFacture().toString());
            pt.setDouble(3, f.getMontant());
            pt.setInt(4, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionFacture.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerFacture(int id) {
        PreparedStatement pt;
        try {
            pt = cnx.prepareStatement("delete from Facture where id = ?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
