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
public class BuyWeaponScreenController implements Initializable {

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
    private Label pulseLabel;
    @FXML
    private Label navigateLabel;
    @FXML
    private Label autoLabel;
    
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
        gadgetLabel.setText("Current Weapon: ");
        
        creditsLabel.setText("Credits available: " + GameData.getPlayer().getCredits());
        buyButton.setVisible(false);
        gadgetSlotLabel.setText("Weapon slots available: " + GameData.getPlayer().getShip().getWeaponSlot());
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < 5){
            autoLabel.setVisible(false);
        }
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < 4){
            navigateLabel.setVisible(false);
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
    private void onPulseAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 50;
        currentItem = pulseLabel.getText();
        gadgetLabel.setText("Weapon Selected: " + currentItem);
        infoLabel.setText("Information: Two pulse lasers often do more damage than one beam laser, and are cheaper overall.");
        priceLabel.setText("Price: " + currentPrice);
        
    }
    @FXML
    private void onNavigateAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 100;
        currentItem = navigateLabel.getText();
        gadgetLabel.setText("Weapon Selected: " + currentItem);
        infoLabel.setText("Information: Two pulse lasers often do more damage than one beam laser.");
        priceLabel.setText("Price: " + currentPrice);
        
    }
    
    @FXML
    private void onAutoAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 150;
        currentItem = autoLabel.getText();
        gadgetLabel.setText("Weapon Selected: " + currentItem);
        infoLabel.setText("Information: Military lasers are the best, but also the most expensive. If you have more than one weapon slot on your ship, it is probably wise to first fill them all before you start to buy better lasers.");
        priceLabel.setText("Price: " + currentPrice);
        
    }
    
    
    
    @FXML
    private void onBuyAction(ActionEvent event){
        if (GameData.getPlayer().getShip().getWeaponSlot() < 1){
            CommonHelper.alertBox(GameData.getStage(), "  You do not have enough weapon slots to buy " + currentItem + ".  ");
 
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
                                GameData.getPlayer().getShip().subtractWeaponSlot();
                                gadgetSlotLabel.setText("Weapon slots available: " + GameData.getPlayer().getShip().getWeaponSlot());
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
