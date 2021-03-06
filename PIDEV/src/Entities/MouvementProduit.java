/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class MouvementProduit {
    public enum src_dest{
        supplier,
        stock,
        magasin,
        client
    
    }

    private int id_mouvement_Produit;
    private int id_produit;
    private int id_facture;
    private src_dest source;
    private src_dest destination;
    private int quantité;
    private java.sql.Date date;

    public MouvementProduit(int id_mouvement_Produit, int id_facture, src_dest source, src_dest destination, int quantité, java.sql.Date date,int id_produit) {
        this.id_mouvement_Produit = id_mouvement_Produit;
        this.id_facture = id_facture;
        this.source = source;
        this.destination = destination;
        this.quantité = quantité;
        this.date = date;
        this.id_produit=id_produit;
    }
    

    public src_dest getSource() {
        return source;
    }

    public src_dest getDestination() {
        return destination;
    }

    public int getQuantité() {
        return quantité;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setSource(src_dest source) {
        this.source = source;
    }

    public void setDestination(src_dest destination) {
        this.destination = destination;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public int getId_mouvement_Produit() {
        return id_mouvement_Produit;
    }

    public int getId_facture() {
        return id_facture;
    }

    public int getId_produit() {
        return id_produit;
    }
    
}
