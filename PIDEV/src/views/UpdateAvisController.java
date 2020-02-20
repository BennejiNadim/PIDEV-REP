/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Entities.Avis;
import Services.GestionAvis;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class UpdateAvisController implements Initializable {
    Avis a;
    @FXML
    private TextField ref_avis;
    @FXML
    private TextField Commentaire_field;
    @FXML
    private ChoiceBox<String> choix_etat;
    @FXML
    private Label ref_produit;
    @FXML
    private Label marque;
    @FXML
    private Label categorie;
    @FXML
    private Button update_Avis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       choix_etat.getItems().add("content");
        choix_etat.getItems().add("satisfait");
        choix_etat.getItems().add("non_satisfait");
    }    

    void setFields(Avis a) {
        ref_avis.setText("1");
        choix_etat.setValue(a.getChoix().toString());
        Commentaire_field.setText(a.getCommentaire());      
        this.a = a;
    }

    @FXML
    private void UpdateAvis(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/avisFXML.fxml"));
         AvisFXMLController Ac = loader.getController();
         Parent root;
         newprod();
         GestionAvis Av = new GestionAvis();
         Av.modifierAvis(a.getId(),a);
         try {
            root = loader.load();
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateAvisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void newprod() {
        Avis.choix_a avis;
        if(choix_etat.getValue().equals("content"))
                {
                   avis=Avis.choix_a.content;
                }else if(choix_etat.getValue().equals("satisfait"))
                {
                   avis= Avis.choix_a.satisfait;
                }
        else 
                {
                   avis= Avis.choix_a.non_satisfait;
                }
        a.setChoix(avis);
        a.setId(1);
        a.setCommentaire(Commentaire_field.getText());
    }
}
