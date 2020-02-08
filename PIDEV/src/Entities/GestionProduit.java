/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
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
public class GestionProduit {

    private Connection con = Connexion.getInstance().getCnx();

    public void ajouterProduit(Produit P) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into Produit values('" + P.getRef_produit() + "','" + P.getNom_produit() + "','" + P.getMarque() + "','" + P.getCategorie() + "'," + P.getQuantité_stock() + " , " + P.getQuantité_magasin() + " , " + P.getPrix_vente() + " , " + P.getPrix_achat() + ")";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherProduit() {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("select * from Produit");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Produit [reference : " + rs.getInt(1) + " , nom produit :" + rs.getString(2) + " , marque : " + rs.getString(3) + " , categorie : " + rs.getString(4) + " , quantité stock : " + rs.getInt(5) + " , quantité magasin" + rs.getInt(6) + ", prix vente :" + rs.getInt(7) + " , prix achat :" + rs.getInt(8) + "]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerProduit(int ref) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from Produit where ref_produit = ?");
            pt.setInt(1, ref);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public void modifierProduit(Produit p){
    PreparedStatement pt;
        try {
            pt = con.prepareStatement("update produit set nom_produit = ? , marque = ? , categorie = ? , quantité_stock = ? , quantité_magasin = ? , prix_vente = ? , prix_achat = ?  where ref_produit = ?");
            pt.setString(1,p.getNom_produit());
            pt.setString(2,p.getMarque());
            pt.setString(3,p.getCategorie());
            pt.setInt(4,p.getQuantité_stock());
            pt.setInt(5,p.getQuantité_magasin());
            pt.setFloat(6,p.getPrix_vente());
            pt.setFloat(7,p.getPrix_achat());
            pt.setInt(8,p.getRef_produit());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
