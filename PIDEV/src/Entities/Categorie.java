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
public class Categorie {

    private int id_catg;
    private String lib_catg;

    public Categorie(int id_catg, String lib_catg) {
        this.id_catg = id_catg;
        this.lib_catg = lib_catg;
    }

    public int getId_catg() {
        return id_catg;
    }

    public String getLib_catg() {
        return lib_catg;
    }

    public void setId_catg(int id_catg) {
        this.id_catg = id_catg;
    }

    public void setLib_catg(String lib_catg) {
        this.lib_catg = lib_catg;
    }

}
