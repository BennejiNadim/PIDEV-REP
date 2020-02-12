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
public class Materiels extends Equipement {
   
    private int qte;

    public Materiels(int qte , String nom, etat etat) {
        super(nom, etat);
        this.qte = qte;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Materiels{" + "qte=" + qte + '}';
    }



   
 
}
