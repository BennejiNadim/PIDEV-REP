/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Categorie;
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
/**
 * *********AJOUT********
 */
public class GestionCategorie {

    private Connection con = Connexion.getInstance().getCnx();

    public void ajouterCategorie(Categorie C) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into Categorie values(" + C.getId_catg() + ",'" + C.getLib_catg() + "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * ********SUPPRESSION******
     */
    public void supprimerCategorie(int id) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from Categorie where id_catg = ?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * **************MODIFICATION*************
     */
    public void modifierCategorie(Categorie C) {

        PreparedStatement pt;
        try {
            pt = con.prepareStatement("update categorie set lib_catg = ?  where id_catg = ?");
            pt.setString(1, C.getLib_catg());
            pt.setInt(2, C.getId_catg());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * **********AFFICHAGE*********
     */
    public void afficherCategorie() {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("select * from Categorie");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Categorie [Id : " + rs.getInt(1) + " , libelé :" + rs.getString(2) + "]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
