/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import helper.CommonHelper;
import helper.GameData;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class ShipyardScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //@FXML
   // private ListView<String> actionsListView;
   // private ObservableList actions = FXCollections.observableArrayList();
    
    
    @FXML
    private void onBackAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/Orbit.fxml" ));
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
    private void handleBuyGadgetAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/BuyGadgetScreen.fxml" ));
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
    private void onBuyWeaponAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/BuyWeaponScreen.fxml" ));
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
    private void onBuyShieldAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/BuyShieldScreen.fxml" ));
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
    private void onRefuelAction(ActionEvent event){
        GameData.getPlayer().getShip().refillFuel();
        CommonHelper.alertBox(GameData.getStage(), "  Your ship has been refueled!  ");
       // actions.add("Ship Refueled (current fuel: " + GameData.getPlayer().getShip().getFuel() + ")");
        //actionsListView.setItems(actions);
        //fuelContent.setText("Fuel Content: " + GameData.getPlayer().getShip().getFuel());   
    }
    
    @FXML
    public void onBuyShip(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/BuyShipScreen.fxml" ));
            Parent root = fxmlLoader.load();
        
            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
 }
