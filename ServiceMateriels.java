/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Materiels;
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
public class ServiceMateriels {
     private Connection con = Connexion.getInstance().getCnx();
     public void ajouterMateriels (Materiels m) {      
         try {
             Statement st = con.createStatement();
             String req = "insert into `materiels` values(" +m.getId()+ ",'"+m.getNom()+"','"+m.getQte()+"','"+m.getEtat()+"')";
             st.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(ServiceMateriels.class.getName()).log(Level.SEVERE, null, ex);
         }
}
      public void afficherMateriels () {
         try {
             PreparedStatement pt =con.prepareStatement("select * from `materiels`");
             ResultSet rs = pt.executeQuery();
             
             while(rs.next()){
                 System.out.println("materiels [id :"+rs.getInt(1)+" , nom : "+rs.getString(2)+" , qte : "+rs.getInt(3)+" , etat :"+rs.getString(4)+"]");
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceMateriels.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
       public void modifierMateriels (int ref, Materiels m){
        
         try {
             PreparedStatement pt = con.prepareStatement("update materiels set nom = ?, qte = ?, etat = ? where id=?");
             pt.setString(1,m.getNom());
             pt.setInt(2,m.getQte());
             pt.setString(3, m.getEtat().toString());
             pt.setInt(4, ref);
             pt.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceMateriels.class.getName()).log(Level.SEVERE, null, ex);
         }
             }
       
       public void supprimerMateriels(int id) {
        
         try {
             PreparedStatement pt =con.prepareStatement("delete from materiels where id = ?");
             pt.setInt(1, id);
             pt.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceMateriels.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
}
     

