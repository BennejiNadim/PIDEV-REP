/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Entities.Produit;
import Services.GestionProduit;

/**
 *
 * @author ASUS
 */
public class PIDEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Produit p=new Produit("nom_prod","marque","cat",50,60,3,2);
        
        Produit p1=new Produit("nom_prod","marque","cat",50,60,3,2);
        GestionProduit G = new GestionProduit();
      /*  G.ajouterProduit(p);
        G.ajouterProduit(p1);
        G.afficherProduit(); */
        G.supprimerProduit(205);
    }
    
}
