/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Marque;
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
public class GestionMarque {

    private Connection con = Connexion.getInstance().getCnx();

    public void ajouterMarque(Marque M) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into Categorie values(" + M.getId_marque() + ",'" + M.getNom_marque() + "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionMarque.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * ********SUPPRESSION******
     */
    public void supprimerMarque(int id) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from Marque where id_marque = ?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionMarque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * **************MODIFICATION*************
     */
    public void modifierCategorie(Marque M) {

        PreparedStatement pt;
        try {
            pt = con.prepareStatement("update Marque set nom_marque = ?  where id_marque = ?");
            pt.setString(1, M.getNom_marque());
            pt.setInt(2, M.getId_marque());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionMarque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * **********AFFICHAGE*********
     */
    public void afficherCategorie() {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("select * from Marque");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Marque [Id : " + rs.getInt(1) + " , Nom Marque:" + rs.getString(2) + "]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionMarque.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
