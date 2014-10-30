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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.Ship;

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
    @FXML
    private ListView<String> actionsListView;
    private ObservableList actions = FXCollections.observableArrayList();
    private String selection;    
    
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
    private void onRefuelAction(ActionEvent event){
        GameData.getPlayer().getShip().refillFuel();
        actions.add("Ship Refueled (current fuel: " + GameData.getPlayer().getShip().getFuel() + ")");
        actionsListView.setItems(actions);
        //fuelContent.setText("Fuel Content: " + GameData.getPlayer().getShip().getFuel());   
    }
    
    @FXML
    private void onShowShipAction(ActionEvent event){
        actions.clear();
        actions.add("Flea");
        actions.add("Gnat");
        actions.add("Firefly");
        actions.add("Mosquito");
        actions.add("Bumblebee");
        actionsListView.setItems(actions);
        
        actionsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                selection = actionsListView.getSelectionModel().getSelectedItem();
            }
        });
    }
    
    @FXML
    private void onBuyShipAction(ActionEvent event){
        Ship s = null;
        if(selection.equals("Flea")) {
            s = Ship.FLEA;
        } else if (selection.equals("Gnat")) {
            s = Ship.GNAT;
        } else if (selection.equals("Firefly")) {
            s = Ship.FIREFLY;
        } else if (selection.equals("Mosquito")) {
            s = Ship.MOSQUITO;
        } else if (selection.equals("Bumblebee")) {
            s = Ship.BUMBLEBEE;
        }
        
        if(s == null) {
            CommonHelper.alertBox(GameData.stage, "Select a ship.");
        } else if (GameData.getPlayer().getCredits() < s.getPrice()) {
            CommonHelper.alertBox(GameData.stage, "You don't have enough credits.");
        } else {
            s.getInventory().addNumGoodsList(GameData.getPlayer().getShip().getInventory().getNumGoodsList());
            GameData.getPlayer().setShip(s);
            CommonHelper.alertBox(GameData.stage, "Enjoy your new " + GameData.getPlayer().getShip());
        }
    }
}
