/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Entities.Avis;
import Entities.Reclamation;
import Services.GestionAvis;
import Services.GestionReclamation;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AddavisController implements Initializable {

    
    @FXML
    private TextField Commentaire_field;
    
    @FXML
    private Button add_reclamation_button;
    
    @FXML
    private ChoiceBox<String> choix_etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choix_etat.getItems().add("content");
        choix_etat.getItems().add("satisfait");
        choix_etat.getItems().add("non_satisfait");
    }    

    @FXML
    private void add_avis(ActionEvent event) {
        GestionAvis GA = new GestionAvis();
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
        Avis A = new Avis(1,avis,Commentaire_field.getText());
        System.out.println(A);
        GA.ajouterAvis(A);
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/avisFXML.fxml"));
                    Scene scene = new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        } catch (IOException ex) {
            Logger.getLogger(AddavisController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
