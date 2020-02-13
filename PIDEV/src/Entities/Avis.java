/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author user
 */
public class Avis {
      public enum choix_a{
        satisfait,
        non_satisfait,
        content
    }
    private static int idc=1;
    private int id;
    private choix_a choix;
    private String commentaire;

    public Avis() {
        Connection cnx = Connexion.getInstance().getCnx();
        if (Avis.idc == 1) {
            PreparedStatement pt;
            try {
                pt = cnx.prepareStatement("select MAX(ID_avis) from avis");
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    System.out.println("hihi");
                    idc=1+rs.getInt(1);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Avis.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        this.id=idc++;
    }

    public Avis(choix_a choix, String commentaire) {
        
        this();
        this.choix = choix;
        this.commentaire = commentaire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChoix(choix_a choix) {
        this.choix = choix;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public static int getIdc() {
        return idc;
    }

    public int getId() {
        return id;
    }

    public choix_a getChoix() {
        return choix;
    }

    public String getCommentaire() {
        return commentaire;
    }
    
    }
    
    

