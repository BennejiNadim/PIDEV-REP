package Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Connexion {
 private static String url="jdbc:mysql://localhost:3306/Agora";
 private static String usr="root";
 private static String mdp="";
 private static Connection cnx;
 private static Connexion cbd;
 public Connection getCnx(){
 return cnx;
 }
 private Connexion () {
     try {
         cnx=DriverManager.getConnection(url, usr, mdp);
         System.out.println("cnx etablit");
     } catch (SQLException ex) {
         System.out.println("cnx échoué");;
     }
 }
 public static Connexion getInstance(){
 if(cbd==null){
 cbd = new Connexion();
 }
 return cbd;
 }
    
}
