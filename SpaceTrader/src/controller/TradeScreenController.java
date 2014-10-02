/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import helper.GameData;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JOptionPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML TradeScreenController Class
 * 
 * @author Ivan
 */
public class TradeScreenController implements Initializable {
    
    @FXML
    private ListView inventoryListView;
    @FXML
    private ListView marketplaceListView;
    @FXML
    private Label currentCreditsLabel;
    @FXML
    private Label totalCostLabel;
    @FXML
    private Button confirmButton;
    @FXML
    private Button backButton;

    private String currentCreditsText;
    private String totalCostText;
    
    @FXML
    private void onAcceptAction(ActionEvent event) {
        JOptionPane.showMessageDialog( null, "Trade Confirmed" );
    }
    
    @FXML
    private void onCancelAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/PlanetDrawScreen.fxml" ));
            Parent root = fxmlLoader.load();
            
            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        }
        
        catch( IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentCreditsLabel.setText("500");
    }
    
    
    
}
