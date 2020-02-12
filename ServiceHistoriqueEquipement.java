/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.HistoriqueEquipement;
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
public class ServiceHistoriqueEquipement {
     private Connection con = Connexion.getInstance().getCnx();
     public void ajouterHistorique (HistoriqueEquipement h) {      
         try {
             Statement st = con.createStatement();
             String req = "insert into `historiqueequipement` values("+h.getId()+",'"+h.getDate()+"','"+h.getOp()+"','"+h.getQte()+"')";
             st.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(ServiceHistoriqueEquipement.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     public void afficherHistorique () {
         try {
             PreparedStatement pt =con.prepareStatement("select * from `historiqueequipement`");
             ResultSet rs = pt.executeQuery();
             while(rs.next()){
                 System.out.println("historiqueequipement [id :"+rs.getInt(1)+" , date : "+rs.getString(2)+" , op : "+rs.getString(3)+" , qte :"+rs.getInt(4)+"]");
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceHistoriqueEquipement.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
      public void modifierHistorique (int id, HistoriqueEquipement h){
         try {
             PreparedStatement pt = con.prepareStatement("update historiqueequipement set date = ?, op = ?, qte = ? where id=?");
             pt.setString(1,h.getDate().toString());
             pt.setString(2,h.getOp().toString());
             pt.setInt(3, h.getQte());
             pt.setInt(4, id);
             pt.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceHistoriqueEquipement.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
      public void supprimerHistorique (int id) {
         try {
             PreparedStatement pt =con.prepareStatement("delete from historiqueequipement where id = ?");
             pt.setInt(1, id);
             pt.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceHistoriqueEquipement.class.getName()).log(Level.SEVERE, null, ex);
         }
         } 
     }
