/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Reclamation;
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
public class GestionReclamation {
private final Connection cnx;

    public GestionReclamation() {
        this.cnx = Connexion.getInstance().getCnx();
    }

    public void ajouterReclamation(Reclamation r) {
        Statement st;
        try {
            st = cnx.createStatement();

            String req = "insert into reclamation values(" + r.getId() + ",'" + r.getDate()+ "','" + r.getEtat()+ "','" + r.getClient_login()+ "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherReclamation() {
        try {
            PreparedStatement pt = cnx.prepareStatement("select * from reclamation");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Reclamation [ id: " + rs.getInt(1) + " date : " + rs.getDate(2) + " Etat: " + rs.getString(3)+ "Client_login: " +rs.getString(4)+ " ]");
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifierReclamation(int id,Reclamation r) {
        PreparedStatement pt;
        try {
            pt = cnx.prepareStatement("update reclamation set Etat = ?, Date = ?, client_login = ?   where ID_reclamation = ?");
            pt.setString(1, r.getEtat().toString());
            pt.setDate(2, r.getDate());
            
            pt.setString(3, r.getClient_login());
            pt.setInt(4, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerReclamation(int id) {
        PreparedStatement pt;
        try {
            pt = cnx.prepareStatement("delete from reclamation where ID_reclamation = ?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
    
}
