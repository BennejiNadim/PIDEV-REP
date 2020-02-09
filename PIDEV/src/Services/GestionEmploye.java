/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Employe;
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
public class GestionEmploye {

    private final Connection cnx;
    GestionClient gc = new GestionClient();

    public GestionEmploye() {
        this.cnx = Connexion.getInstance().getCnx();
    }

    public void ajouterEmploye(Employe e) {
        Statement st;
        gc.ajouterClient(e);
        try {
            st = cnx.createStatement();
            String req = "insert into employe values( '" + e.getLogin() + "'," + e.getSalaire() + ",'" + e.getPoste() + "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherEmploye() {
        try {
            PreparedStatement pt = cnx.prepareStatement("select * from user,employe where user.login=employe.login");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Employe [ Login: " + rs.getString(1) + " Nom: " + rs.getString(2) + " Prenom: " + rs.getString(3) + " Mot de passe: " + rs.getString(4) + " Email: " + rs.getString(5) + " Numero Tel: " + rs.getString(6) + " salaire: " + rs.getDouble(8) + " poste: " + rs.getDouble(9) + "]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifierEmploye(String login, Employe e) {
        PreparedStatement pt;
        gc.modifierClient(login, e);
        try {
            pt = cnx.prepareStatement("update employe set salaire = ?, poste = ?, where login = ?");
            pt.setDouble(1, e.getSalaire());
            pt.setString(2, e.getPoste());
            pt.setString(3, login);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerEmploye(String login) {
        PreparedStatement pt;
        gc.supprimerClient(login);
        try {
            pt = cnx.prepareStatement("delete from employe where login = ?");
            pt.setString(1, login);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
