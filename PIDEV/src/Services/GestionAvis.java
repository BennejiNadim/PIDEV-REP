/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Avis;
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
 * @author user
 */
public class GestionAvis {
    
private final Connection cnx;

    public GestionAvis() {
        this.cnx = Connexion.getInstance().getCnx();
    }

    public void ajouterAvis(Avis a) {
        Statement st;
        try {
            st = cnx.createStatement();

            String req = "insert into avis values(" + a.getId() + ",'" + a.getChoix()+ "','" + a.getCommentaire()+ "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionAvis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherAvis() {
        try {
            PreparedStatement pt = cnx.prepareStatement("select * from avis");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Avis [ id: " + rs.getInt(1) + " choix : " + rs.getString(2) + " commentaire: " + rs.getString(3)+  " ]");
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionAvis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifierReclamation(int id,Avis a) {
        PreparedStatement pt;
        try {
            pt = cnx.prepareStatement("update avis set choix = ?, commentaire = ?   where ID_avis = ?");
            pt.setString(1, a.getChoix().toString());
            pt.setString(2, a.getCommentaire());
            pt.setInt(3, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAvis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerAvis(int id) {
        PreparedStatement pt;
        try {
            pt = cnx.prepareStatement("delete from avis where ID_avis = ?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
    
}
