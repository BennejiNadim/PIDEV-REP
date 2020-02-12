/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ASUS
 */
public class Fournisseur {
    private int id_fournisseur;
    private String nom;
    private int numero;
    private String Email;

    public Fournisseur(int id_fournisseur, String nom, int numero, String Email) {
        this.id_fournisseur = id_fournisseur;
        this.nom = nom;
        this.numero = numero;
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(Email.matches(regex)){
        this.Email = Email;
        }
    }

    public String getEmail() {
        return Email;
    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
