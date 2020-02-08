/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import static java.sql.JDBCType.NULL;

/**
 *
 * @author ASUS
 */
public class Produit {

    private static int id_p=1000; 
    private int ref_produit;
    private String nom_produit;
    private String marque;
    private String categorie;
    private int quantité_stock;
    private int quantité_magasin;
    private float prix_vente;
    private float prix_achat;

    public Produit(String nom_produit, String marque, String categorie, int quantité_stock, int quantité_magasin, float prix_vente, float prix_achat) {
        this.ref_produit=id_p++;
        this.nom_produit = nom_produit;
        this.marque = marque;
        this.categorie = categorie;
        this.quantité_stock = quantité_stock;
        this.quantité_magasin = quantité_magasin;
        this.prix_vente = prix_vente;
        this.prix_achat = prix_achat;
    }


    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setQuantité_stock(int quantité_stock) {
        this.quantité_stock = quantité_stock;
    }

    public void setQuantité_magasin(int quantité_magasin) {
        this.quantité_magasin = quantité_magasin;
    }

    public void setPrix_vente(float prix_vente) {
        this.prix_vente = prix_vente;
    }

    public void setPrix_achat(float prix_achat) {
        this.prix_achat = prix_achat;
    }

    public int getRef_produit() {
        return ref_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public String getMarque() {
        return marque;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getQuantité_stock() {
        return quantité_stock;
    }

    public int getQuantité_magasin() {
        return quantité_magasin;
    }

    public float getPrix_vente() {
        return prix_vente;
    }

    public float getPrix_achat() {
        return prix_achat;
    }

}
