/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Wael
 */
public class Transaction {

    public enum typeTr {
        in,
        out
    }
    private static int idc=1;
    private int id;
    private int idFacture;
    private typeTr type;
    private String description;
    private Date date;
    private Double monton;

    public Transaction() {
        this.id=idc++;
    }

    public Transaction(int idFacture, typeTr type, String description, Date date, Double monton) {
        this.id=idc++;
        this.idFacture = idFacture;
        this.type = type;
        this.description = description;
        this.date = date;
        this.monton = monton;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public static int getIdc() {
        return idc;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    

    public int getId() {
        return id;
    }

    public typeTr getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Double getMonton() {
        return monton;
    }


    public void setType(typeTr type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMonton(Double monton) {
        this.monton = monton;
    }

}
