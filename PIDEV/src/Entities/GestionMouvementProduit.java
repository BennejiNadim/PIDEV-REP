/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.MouvementProduit;
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
public class GestionMouvementProduit {
    private Connection con = Connexion.getInstance().getCnx();

    public void ajouterMouvement(MouvementProduit M) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into MouvementProduit values("+M.getId_mouvement_Produit()+","+M.getId_facture()+
                    ","+M.getSource()+","+M.getDestination()+","+M.getQuantité()+","+M.getDate()+")";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionMouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherListeMouvement() {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("select * from MouvementProduit");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Mouvement [id_mouvement : " + rs.getInt(1) + " , id_facture :" + rs.getString(2) + " , source : " + rs.getString(3) + " , destination : " + rs.getString(4) + " , quantité: " + rs.getInt(5) + " , Date "+rs.getDate(6)+ "]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionMouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerProduit(int id) {
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
