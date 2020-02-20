/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Entities.Reclamation;
import Entities.Reclamation.etat_r;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.EnvoyerMail;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AddreclamationController implements Initializable {

  
    @FXML
    private TextField ref_reclamation_field;
    @FXML
    private TextField client_login_field;
    @FXML
    private Button add_reclamation_button;
    @FXML
    private DatePicker Date_picker;
    @FXML
    private ChoiceBox<String> choix_etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choix_etat.getItems().add("refusée");
        choix_etat.getItems().add("acceptée");
    }    

    @FXML
    private void add_reclamation(ActionEvent event) {
        GestionReclamation GR = new GestionReclamation();
        etat_r etat;
        if(choix_etat.getValue().equals("refusée"))
                {
                   etat = Reclamation.etat_r.refusée;
                }else
                {
                   etat = Reclamation.etat_r.acceptée;
                }
        Reclamation R;
        R = new Reclamation(Integer.parseInt(ref_reclamation_field.getText()),etat,java.sql.Date.valueOf(Date_picker.getValue()),client_login_field.getText());
        GR.ajouterReclamation(R);
        EnvoyerMail mail = new EnvoyerMail();
        mail.envoyer();
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/reclamation.fxml"));
                    Scene scene = new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        } catch (IOException ex) {
            Logger.getLogger(AddreclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
