/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Entities.Produit;
import Entities.Reclamation;
import Entities.Reclamation.etat_r;
import Services.GestionReclamation;
import Utils.Connexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReclamationFXMLController implements Initializable {
    private Connection con = Connexion.getInstance().getCnx();
    private ObservableList<Reclamation> Oblist = FXCollections.observableArrayList();
    private Reclamation R;
    
    @FXML
    private Button add_product_btn;
    @FXML
    private Button update;
    @FXML
    private Button remove;
    @FXML
    private TableColumn<Reclamation, String> reference_reclamation;
    @FXML
    private TableColumn<Reclamation, Date> Date;
    @FXML
    private TableColumn<Reclamation, String> Etat;
    @FXML
    private TableColumn<Reclamation, String> Client_Login;
    @FXML
    private TableView<Reclamation> table_reclamation;
    @FXML
    private TableColumn<?, ?> action;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            reclamation_table();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void reclamation_table() throws SQLException {
        PreparedStatement pt;
        etat_r etat;
        try {
            
            pt = con.prepareStatement("select * from reclamation");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                if(rs.getString("Etat").equals("refusée"))
                {
                     etat = etat_r.refusée;
                }else
                {
                   etat = etat_r.acceptée;
                }
                Oblist.add(new Reclamation(rs.getInt("ID_reclamation"),etat,rs.getDate("Date"),rs.getString("client_login")));
            }
            reference_reclamation.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("ID_reclamation"));
            Date.setCellValueFactory(new PropertyValueFactory<Reclamation,Date>("Date"));
            Etat.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("Etat"));
            Client_Login.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("client_login"));
            table_reclamation.setItems(Oblist);

    }catch (SQLException ex) {
     }
    }
      
    @FXML
    private void add_reclamation(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/Addreclamation.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(ReclamationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void update_reclamation(ActionEvent event) {
        
        try {   
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Updatereclamation.fxml"));
            Parent root = loader.load();
            UpdatereclamationController urc = loader.getController();
            urc.setFields(R);
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(ReclamationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void remove_reclamation(ActionEvent event) {
        GestionReclamation GR = new GestionReclamation();
        GR.supprimerReclamation(R.getId());
    }

    @FXML
    private void getSelection(MouseEvent event) {
       R = table_reclamation.getSelectionModel().getSelectedItem();
    }
    
    
}
