/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Vehicule;
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
 * @author USER
 */
public class ServiceVehicule {
  private Connection con = Connexion.getInstance().getCnx();
  
  public void ajouterVehicule (Vehicule v) {        
      try {
          Statement st = con.createStatement();
          String req = "insert into `vehicule` values(" +v.getId()+ ",'"+v.getNom()+"','"+v.getMatricule()+"','"+v.getCouleur()+"','"+v.getUtilisation()+"','"+v.getKM()+"','"+v.getEtat()+"')";
          st.executeUpdate(req);
      } catch (SQLException ex) {
          Logger.getLogger(ServiceVehicule.class.getName()).log(Level.SEVERE, null, ex);
      }
}
  public void afficherVehicule () {
        try {
            PreparedStatement pt =con.prepareStatement("select * from vehicule");
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
                System.out.println("vehicule [id :"+rs.getInt(1)+" , nom : "+rs.getString(2)+" , matricule : "+rs.getString(3)+" , couleur :"+rs.getString(4)+" , utilisation : "+rs.getString(5)+" , KM : "+rs.getString(6)+" , etat : "+rs.getString(7)+"]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void modifierVehicule (int id, Vehicule v){
        try {
            PreparedStatement pt = con.prepareStatement("update vehicule set nom = ?, matricule = ?, couleur = ?, utilisation = ?, KM = ?, etat = ? where id=?");
            pt.setString(1,v.getNom());
            pt.setString(2,v.getMatricule());
            pt.setString(3,v.getCouleur());
            pt.setString(4, v.getUtilisation().toString());
            pt.setString(5, v.getKM());
            pt.setString(6, v.getEtat().toString());
            pt.setInt(7, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void supprimerVehicule (int id) {
        try {
            PreparedStatement pt =con.prepareStatement("delete from vehicule where id = ?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
