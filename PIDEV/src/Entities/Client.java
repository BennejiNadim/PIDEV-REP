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
public class Client extends User {
    private String carteFidelite;

    public Client(String carteFidelite, String login, String nom, String prenom, String mdp, String email, String tel) {
        super(login, nom, prenom, mdp, email, tel);
        this.carteFidelite = carteFidelite;
    }

    public Client() {
    }

    public String getCarteFidelite() {
        return carteFidelite;
    }

    public void setCarteFidelite(String carteFidelite) {
        this.carteFidelite = carteFidelite;
    }
    
    
}
