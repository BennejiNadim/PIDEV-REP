/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Entities.Avis;
import Services.GestionAvis;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AvisFXMLController implements Initializable {
    private Connection con = Connexion.getInstance().getCnx();
    private ObservableList<Avis> Oblist = FXCollections.observableArrayList();
    private Avis A;
    
    @FXML
    private Button add_product_btn;
    @FXML
    private Button update;
    @FXML
    private Button remove;
    @FXML
    private TableView<Avis> table_reclamation;
    @FXML
    private TableColumn<Avis, Integer> ref_id;
    @FXML
    private TableColumn<Avis, String> choix;
    @FXML
    private TableColumn<Avis, String> commentaire;
    @FXML
    private TableColumn<?, ?> action;
    @FXML
    private TextField filter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            reclamation_table();
        } catch (SQLException ex) {
            Logger.getLogger(AvisFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void reclamation_table() throws SQLException {
        PreparedStatement pt;
        try { 
            pt = con.prepareStatement("select * from avis");
            ResultSet rs = pt.executeQuery();
            Avis.choix_a avis;
            while (rs.next()) {
                if(rs.getString("choix").equals("content"))
                {
                   avis=Avis.choix_a.content;
                }else if(rs.getString("choix").equals("satisfait"))
                {
                   avis= Avis.choix_a.satisfait;
                }
                else 
                {
                   avis= Avis.choix_a.non_satisfait;
                }
                Oblist.add(new Avis(rs.getInt("id_avis"),avis,rs.getString("commentaire")));
            }
            ref_id.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("ID_Avis"));
            choix.setCellValueFactory(new PropertyValueFactory<Avis,String>("choix"));
            commentaire.setCellValueFactory(new PropertyValueFactory<Avis,String>("commentaire"));
            FilteredList<Avis> filteredData = new FilteredList<>(Oblist, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filter.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(aff -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (aff.getChoix().name().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
				else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Avis> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table_reclamation.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table_reclamation.setItems(sortedData);
            
    }catch (SQLException ex) {
     }
    }

    @FXML
    private void getSelection(MouseEvent event) {
       A = table_reclamation.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void add_avis(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/Addavis.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AvisFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void update_avis(ActionEvent event) {
        try {   
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/UpdateAvis.fxml"));
            Parent root = loader.load();
            UpdateAvisController uac = loader.getController();
            uac.setFields(A);
            Scene scene = new Scene(root);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AvisFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void remove_avis(ActionEvent event) throws SQLException {
        GestionAvis GR = new GestionAvis();
        GR.supprimerAvis(A.getId());
        reclamation_table();
    }
     
    
}
