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
public class Vehicule  extends Equipement {
    public enum type {
        Vehicule_personnel,
        Vehicule_livraison
    }
     
    private String matricule;
    private String couleur;
    private type utilisation;
    private String KM;

    public Vehicule(String matricule, String couleur, type utilisation, String KM, String nom, etat etat) {
        super(nom, etat);
        this.matricule = matricule;
        this.couleur = couleur;
        this.utilisation = utilisation;
        this.KM = KM;
    }
    
    public String getMatricule() {
        return matricule;
    }

    public String getCouleur() {
        return couleur;
    }

    public type getUtilisation() {
        return utilisation;
    }
    

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setUtilisation(type utilisation) {
        this.utilisation = utilisation;
    }

    public void setKM(String KM) {
        this.KM = KM;
    }

    public String getKM() {
        return KM;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "matricule=" + matricule + ", couleur=" + couleur + ", utilisation=" + utilisation + ", KM=" + KM + '}';
    }
 
  

  
    
    
    
    
}
