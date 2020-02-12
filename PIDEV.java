/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Entities.Equipement;
import Entities.HistoriqueEquipement;
import Entities.Materiels;
import Entities.Vehicule;
import Services.ServiceHistoriqueEquipement;
import Services.ServiceVehicule;
import Services.ServiceMateriels;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class PIDEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        
        //Facture f = new Facture(Facture.etat.not_payed, 8453, "nnn", "Employe1", 22, Facture.typef.salaire);
        //Facture f2 = new Facture(Facture.etat.not_payed, 544, "nnn", "nnn", 22, Facture.typef.taxe);
        Facture f3 = new Facture(Facture.etat.not_payed, 787, "Client1", "", 22, Facture.typef.vente_produit);
        Facture f4 = new Facture(Facture.etat.not_payed, 222, "nnn", "nnn", 886, Facture.typef.achat_produit);
        
        f3.setPayed();
        f3.setId(102);
        GestionFacture gf = new GestionFacture();
        
        gf.modifierFacture(f3);
        //gf.ajouterFacture(f);
        //gf.ajouterFacture(f2);
        //gf.ajouterFacture(f3);
        //gf.ajouterFacture(f4);
        gf.afficherFacture();
        
        */
       Vehicule v1 = new Vehicule("193tun4146", "noir", Vehicule.type.Vehicule_personnel, "00", "bmw", Equipement.etat.Disponnible);
        Vehicule v2 = new Vehicule("193tun41489", "noir", Vehicule.type.Vehicule_personnel, "00", "marcedes", Equipement.etat.Disponnible);
        Vehicule v3 = new Vehicule("193tun4146", "noir", Vehicule.type.Vehicule_personnel, "00", "bmw", Equipement.etat.En_maintenance);
        ServiceVehicule sv = new ServiceVehicule();
        //sv.ajouterVehicule(v1);
        //sv.ajouterVehicule(v2);
        //sv.modifierVehicule(1, v3);
        //sv.supprimerVehicule(v3);
        //sv.afficherVehicule();
        
        //Vehicule v2 = new Vehicule(15, "bmw", "199 tunis 54587", "noir", Vehicule.type.Vehicule_personnel,"1254", Vehicule.etat.Disponnible);
        //Vehicule v3 = new Vehicule(15, "bmw", "199 tunis 54587", "bleu", Vehicule.type.Vehicule_personnel,"00", Vehicule.etat.Disponnible);
        //ServiceVehicule sv = new ServiceVehicule();
        Materiels m1 = new Materiels(50, "chariot", Equipement.etat.Disponnible);
        Materiels m2 = new Materiels(10, "caisse", Equipement.etat.Vendu);
        Materiels m3 = new Materiels(40, "chariot",  Equipement.etat.Disponnible);
        ServiceMateriels sm = new ServiceMateriels();
        //sm.ajouterMateriels(m2);
        HistoriqueEquipement h1 = new HistoriqueEquipement(new Date(2020-1900, 1, 12), HistoriqueEquipement.Operation.achat,50);
         HistoriqueEquipement h2 = new HistoriqueEquipement(new Date(2020-1900, 1, 12), HistoriqueEquipement.Operation.corbeille,20);
         HistoriqueEquipement h3 = new HistoriqueEquipement(new Date(2020-1900, 1, 2), HistoriqueEquipement.Operation.vente, 0);
         ServiceHistoriqueEquipement sh= new ServiceHistoriqueEquipement();
         sm.supprimerMateriels(6);
          sm.supprimerMateriels(7);
           sm.supprimerMateriels(8);
         

}
}