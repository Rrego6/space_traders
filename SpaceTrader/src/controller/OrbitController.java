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
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ambrose Cheung <cheungambrose30@gmail.com>
 */
public class OrbitController implements Initializable {

    @FXML
    private Label playerName;
    @FXML
    private Label planetName;
    
    private String currentPlanet, currentPlayer;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentPlanet = GameData.getPlayer().getCurrentLocation().getName();
        planetName.setText("Location:  " + currentPlanet);
        currentPlayer = GameData.getPlayer().getName();
        playerName.setText("Name:  " + currentPlayer);
    }    
    
    
    
    @FXML
    private void onStarChartAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/StarChart.fxml" ));
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
    
    @FXML
    private void onMarketplaceAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/Marketplace.fxml" ));
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
    
    @FXML
    private void handleSaveGameAction(ActionEvent event) {
        
        try {
            GameData.saveData();
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/WelcomeScreen.fxml" ));
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
}
