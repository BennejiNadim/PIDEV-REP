/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author USER
 */
public class Equipement {
 public enum etat {
       Disponnible,
       En_panne,
       Vendu,
       En_maintenance
    }
 private int id;
 private String nom;
 private etat etat;

    public Equipement(String nom, etat etat) {
        this.nom = nom;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public etat getEtat() {
        return etat;
    }

    public void setEtat(etat etat) {
        this.etat = etat;
    }
 
}
