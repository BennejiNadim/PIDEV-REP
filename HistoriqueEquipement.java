/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class HistoriqueEquipement {
    public enum Operation {
    achat,
    vente,
    corbeille,
    maintenance;
}
    
 private int id;
 private Date date;
 private Operation op;
 private int qte;

    public HistoriqueEquipement(Date date, Operation op, int qte) {
        this.date = date;
        this.op = op;
        this.qte = qte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Operation getOp() {
        return op;
    }

    public void setOp(Operation op) {
        this.op = op;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "HistoriqueEquipement{" + "id=" + id + ", date=" + date + ", op=" + op + ", qte=" + qte + '}';
    }

 
}
