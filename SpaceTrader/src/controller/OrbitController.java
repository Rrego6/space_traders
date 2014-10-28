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
    
    @FXML
    private Label playerCredits;
    @FXML
    private Label pWaterLabel;
    @FXML
    private Label pFursLabel;
    @FXML
    private Label pFoodLabel;
    @FXML
    private Label pOreLabel;
    @FXML
    private Label pGamesLabel;
    @FXML
    private Label pFirearmsLabel;
    @FXML
    private Label pMedicineLabel;
    @FXML
    private Label pMachinesLabel;
    @FXML
    private Label pNarcoticsLabel;
    @FXML
    private Label pRobotsLabel;
    @FXML
    private Label fuelContent;
  
    
    private String currentPlanet, currentPlayer;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentPlanet = GameData.getPlayer().getCurrentLocation().getName();
        planetName.setText("Location:  " + currentPlanet);
        currentPlayer = GameData.getPlayer().getName();
        playerName.setText("Name:  " + currentPlayer);
        playerCredits.setText("Credits: " + GameData.getPlayer().getCredits());
        fuelContent.setText("Fuel Content: " + GameData.getPlayer().getShip().getFuel());
        pRobotsLabel.setText(GameData.getPlayer().getShip().getInventory().getNumRobots() + " Units of Robots");
        pNarcoticsLabel.setText(GameData.getPlayer().getShip().getInventory().getNumNarcotics() + " Units of Narcotics");
        pMachinesLabel.setText(GameData.getPlayer().getShip().getInventory().getNumMachines() + " Units of Machines");
        pMedicineLabel.setText(GameData.getPlayer().getShip().getInventory().getNumMedicine() + " Units of Medicine");
        pFirearmsLabel.setText(GameData.getPlayer().getShip().getInventory().getNumFirearms() + " Units of Firearms");
        pOreLabel.setText(GameData.getPlayer().getShip().getInventory().getNumOre() + " Units of Ore");
        pFoodLabel.setText(GameData.getPlayer().getShip().getInventory().getNumFood() + " Units of Food");
        pWaterLabel.setText(GameData.getPlayer().getShip().getInventory().getNumWater() + " Units of Water");
        pFursLabel.setText(GameData.getPlayer().getShip().getInventory().getNumFurs() + " Units of Furs");
        pGamesLabel.setText(GameData.getPlayer().getShip().getInventory().getNumGames() + " Units of Games");
    }    
    
    @FXML
    private void refillFuel(ActionEvent event) {
        GameData.getPlayer().getShip().refillFuel();
        fuelContent.setText("Fuel Content: " + GameData.getPlayer().getShip().getFuel());
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
