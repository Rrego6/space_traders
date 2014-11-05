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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class BuyShieldScreenController implements Initializable {
@FXML
    private Label gadgetSlotLabel;
    @FXML
    private Button buyButton;
    @FXML
    private Label gadgetLabel;
    @FXML
    private Label infoLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label energyLabel;
    @FXML
    private Label reflectLabel;
    
    @FXML
    private Label creditsLabel;
    
    private String currentItem;
    private int currentPrice;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        infoLabel.setText("Information: ");
        priceLabel.setText("Price: ");
        gadgetLabel.setText("Current Shield: ");
        creditsLabel.setText("Credits available: " + GameData.getPlayer().getCredits());
        buyButton.setVisible(false);
        gadgetSlotLabel.setText("Shield slots available: " + GameData.getPlayer().getShip().getShieldSlot());
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < 4){
            reflectLabel.setVisible(false);
        }
    }
    @FXML
    private void onBackAction(ActionEvent event) {
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
    
    @FXML
    private void onEnergyAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 50;
        currentItem = energyLabel.getText();
        gadgetLabel.setText("Shield Selected: " + currentItem);
        infoLabel.setText("Information: Energy shields are cheaper than a reflective shield. Shields protect your hull from damage.");
        priceLabel.setText("Price: " + currentPrice);
        
    }
    @FXML
    private void onReflectAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 100;
        currentItem = reflectLabel.getText();
        gadgetLabel.setText("Shield Selected: " + currentItem);
        infoLabel.setText("Information: Reflective shields are the best. Shields protect your hull from damage.");
        priceLabel.setText("Price: " + currentPrice);
        
    }
    
    
    
        
    @FXML
    private void onBuyAction(ActionEvent event){
        if (GameData.getPlayer().getShip().getShieldSlot() < 1){
            CommonHelper.alertBox(GameData.getStage(), "  You do not have enough shield slots to buy " + currentItem + ".  ");
 
        }
        else if(GameData.getPlayer().getCredits() < currentPrice){
            CommonHelper.alertBox(GameData.getStage(), "  You do not have enough credits to buy " + currentItem + ".  ");
        }
        else{
            //CommonHelper.alertBox(GameData.getStage(), "  Are you sure you would like to buy " + currentItem + " for " + currentPrice + " credits?  "); 
            //int response = JOptionPane.showConfirmDialog(null, "Are you sure you would like to buy " + currentItem + " for " + currentPrice + " credits?");
            //if (response == JOptionPane.YES_OPTION) {
            CommonHelper.yesAndNoBox(GameData.stage, "  Are you sure you would like to buy " + currentItem + " for " + currentPrice + " credits?  ", 
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) 
                            {
                                GameData.getPlayer().setCredits(GameData.getPlayer().getCredits() - currentPrice);
                                GameData.getPlayer().getShip().subtractShieldSlot();
                                gadgetSlotLabel.setText("Shield slots available: " + GameData.getPlayer().getShip().getShieldSlot());
                                creditsLabel.setText("Credits available: " + GameData.getPlayer().getCredits());
                            }
                        },
                        null
                    );
                //GameData.getPlayer().setCredits(GameData.getPlayer().getCredits() - currentPrice);
                //GameData.getPlayer().getShip().subtractGadgetSlot();
                //gadgetSlotLabel.setText("Gadget slots available: " + GameData.getPlayer().getShip().getGadgetSlot());
                //creditsLabel.setText("Credits available: " + GameData.getPlayer().getCredits());
            //}
        }
    }  
      
    
}
