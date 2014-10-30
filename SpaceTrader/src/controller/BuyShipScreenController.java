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
import java.util.EventListener;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Player;
import model.Ship;

/**
 * FXML Controller class
 *
 * @author Raoul
 */
public class BuyShipScreenController implements Initializable {

    @FXML
    private Label fleaLabel;
    @FXML
    private Label gnatLabel;
    @FXML
    private Label fireflyLabel;
    @FXML
    private Label mosquitoLabel;
    
    @FXML
    private Label shipName;
    @FXML
    private Label shipValue;
    
    private Player player;
    private Ship currentShip;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stage stage = GameData.getStage();
        player = GameData.getPlayer();
        currentShip = player.getShip();
        shipName.setText(currentShip.name());
        shipValue.setText(Integer.toUnsignedString( currentShip.getCost() ));
        gnatLabel.setOnMouseClicked(getShipLabelEvent(Ship.GNAT));
        fleaLabel.setOnMouseClicked(getShipLabelEvent(Ship.FLEA));
        fireflyLabel.setOnMouseClicked(getShipLabelEvent(Ship.FIREFLY));
        mosquitoLabel.setOnMouseClicked(getShipLabelEvent(Ship.MOSQUITO));
    }    
    private void buyShip(Ship ship) {
        if(ship.getCost() > player.getCredits()) {
            CommonHelper.alertBox(GameData.getStage(), "Not enough credits!");
        }
        else {
            Ship oldShip = player.getShip();
            player.setCredits(player.getShip().getCost() + player.getCredits());
            ship.setInventory(oldShip.getInventory());
            
            player.setShip(ship);
            player.setCredits(player.getCredits() - ship.getCost());
            shipName.setText(ship.name());
            shipValue.setText(Integer.toUnsignedString(ship.getCost()));
            currentShip = ship;
        }
    }
    
    private EventHandler<MouseEvent> getShipLabelEvent(Ship ship) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Ship selectedShip = ship;
                if(selectedShip == currentShip) {
                    CommonHelper.alertBox(GameData.stage, "Ship Already Owned");
                }
                else {
                    CommonHelper.yesAndNoBox(GameData.stage, "Buy " + selectedShip.name() + "for " + Integer.toString(selectedShip.getCost()), 
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) 
                            {
                                buyShip(selectedShip);
                            }
                        },
                        null
                    );
                }
            }
        
    };
    }
    
    @FXML
    private void onBack(ActionEvent event) {
            try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/ShipyardScreen.fxml" ));
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
