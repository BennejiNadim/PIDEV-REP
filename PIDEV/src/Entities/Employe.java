/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Wael
 */
public class Employe extends User {
    private String poste;
    private double salaire;

    public Employe(String poste, double salaire, String login, String nom, String prenom, String mdp, String email, String tel) {
        super(login, nom, prenom, mdp, email, tel);
        this.poste = poste;
        this.salaire = salaire;
    }

    public Employe() {
    }

    public String getPoste() {
        return poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    
    
}
