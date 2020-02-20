/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Entities.Avis;
import Entities.MouvementProduit;
import Entities.Reclamation;
import Entities.Reclamation.etat_r;
import Services.GestionProduit;
import Services.GestionReclamation;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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

/**
 * FXML Controller class
 *
 * @author user
 */
public class UpdatereclamationController implements Initializable {

    
    @FXML
    private TextField ref_reclamation_field;
    @FXML
    private TextField client_login_field;
    @FXML
    private Button update_reclamation_button;
    @FXML
    private DatePicker Date_picker;
    @FXML
    private ChoiceBox<String> choix_etat;
    public static Reclamation r;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choix_etat.getItems().add("refusée");
        choix_etat.getItems().add("acceptée");
    }    

    @FXML
    private void UpdateReclamation(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ReclamationFXML.fxml"));
         ReclamationFXMLController Rc = loader.getController();
         Parent root;
         newprod();
         GestionReclamation Gr = new GestionReclamation();
         Gr.modifierReclamation(r.getId(), r);
         try {
            root = loader.load();
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdatereclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void setFields(Reclamation r) {
        ref_reclamation_field.setText(String.valueOf(r.getId()));
        client_login_field.setText(String.valueOf(r.getClient_login()));
        Date_picker.setValue(r.getDate().toLocalDate());
        choix_etat.setValue(r.getEtat().toString());      
        this.r = r;
    }
    private void newprod() {
        etat_r etat;
                if(choix_etat.getValue().equals("refusée"))
                {
                     etat = Reclamation.etat_r.refusée;
                }else
                {
                   etat = Reclamation.etat_r.acceptée;
                }
        r.setId(Integer.parseInt(ref_reclamation_field.getText()));
        r.setDate(java.sql.Date.valueOf(Date_picker.getValue()));
        r.setClient_login(client_login_field.getText());
        r.setEtat(etat);
    }

    void setFields(Avis A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
