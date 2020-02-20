/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Entities.Avis;
import Entities.Avis.choix_a;
import Entities.Facture;
import Entities.Reclamation;
import Entities.Reclamation.etat_r;
import Services.GestionAvis;
import Services.GestionFacture;
import Services.GestionReclamation;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class PIDEV extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* GestionReclamation gr=new GestionReclamation();
        Reclamation r=new Reclamation(etat_r.acceptée, "8967shj");
        Reclamation r1=new Reclamation(etat_r.acceptée, "5262155");
        Reclamation r2=new Reclamation(etat_r.refusée, "5632ghi");
        Reclamation r3=new Reclamation(etat_r.refusée, "252563kilo");
        Reclamation r4=new Reclamation(etat_r.refusée, "8967shj");
        Reclamation rv=new Reclamation(etat_r.refusée, "5262155");
        gr.ajouterReclamation(r);
        gr.ajouterReclamation(r1);
        gr.ajouterReclamation(r2);
        gr.ajouterReclamation(r3);
        gr.afficherReclamation();
        gr.modifierReclamation(1,r4);
        gr.modifierReclamation(2, rv);
       gr.afficherReclamation();
        gr.supprimerReclamation(1);
        gr.supprimerReclamation(2);
        gr.supprimerReclamation(3);
        gr.supprimerReclamation(4);
       gr.afficherReclamation();
        GestionAvis ga=new GestionAvis();
        Avis a=new Avis(choix_a.content, "genial");
        Avis b=new Avis(choix_a.content, "adorable");
        Avis c=new Avis(choix_a.non_satisfait, "je regrette");
        ga.ajouterAvis(a);
        ga.ajouterAvis(b);
        ga.afficherAvis();
        ga.modifierAvis(1, c);
        ga.afficherAvis();
        ga.supprimerAvis(1);
        ga.supprimerAvis(2);
        ga.afficherAvis();*/
       launch(args);
       
        
    }

    @Override
    public void start(Stage PrimaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/reclamationFXML.fxml"));
        Scene scene = new Scene(root);
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
    
}
