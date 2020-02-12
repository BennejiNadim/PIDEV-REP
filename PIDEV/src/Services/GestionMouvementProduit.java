/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.MouvementProduit;
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
 * @author ASUS
 */
public class GestionMouvementProduit {

    private Connection con = Connexion.getInstance().getCnx();

    /**
     * ****************AJOUT****************
     * @param M
     */
    public void ajouterMouvement(MouvementProduit M) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into MouvementProduit values(" + M.getId_mouvement_Produit() + "," + M.getId_facture()
                    + ",'" + M.getSource().toString() + "','" + M.getDestination().toString() + "'," + M.getQuantité() + ",'" + M.getDate() + "',"+M.getId_produit()+")";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionMouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * ******************AFFICHAGE******************
     */
    public void afficherListeMouvement() {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("select * from MouvementProduit");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Mouvement [id_mouvement : " + rs.getInt(1) +",id_produit : "+rs.getInt(7)+" , id_facture :" + rs.getString(2) + " , source : " + rs.getString(3) + " , destination : " + rs.getString(4) + " , quantité: " + rs.getInt(5) + " , Date " + rs.getDate(6) + "]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionMouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * ***********SUPPRESSION********************
     */
    public void supprimerMouvement(int id) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from mouvementProduit where id_mouvement_Produit = ?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionMouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * *************MODIFICATION********************
     */
    public void modifierMouvement(MouvementProduit m) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("update MouvementProduit set source = ? , destination = ? , quantité = ? , date = ? where id_mouvement_Produit = ?");
            pt.setString(1, m.getSource().toString());
            pt.setString(2, m.getDestination().toString());
            pt.setInt(3, m.getQuantité());
            pt.setDate(4, m.getDate());
            pt.setInt(5, m.getId_mouvement_Produit());
        } catch (SQLException ex) {
            Logger.getLogger(GestionMouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
