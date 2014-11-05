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
    private Label cargoLabel;
    @FXML
    private Label navigateLabel;
    @FXML
    private Label autoLabel;
    @FXML
    private Label targetLabel;
    @FXML
    private Label cloakLabel;
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
        //if(GameData.getPlayer().getCurrentLocation().getTechLevel() < 6){
            cloakLabel.setVisible(false);
        //}
        //if(GameData.getPlayer().getCurrentLocation().getTechLevel() < 5){
            targetLabel.setVisible(false);
            autoLabel.setVisible(false);
        //}
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
    private void onCargoAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 50;
        currentItem = cargoLabel.getText();
        gadgetLabel.setText("Shield Selected: " + currentItem);
        infoLabel.setText("Information: Energy shields are cheaper than a reflective shield. Shields protect your hull from damage.");
        priceLabel.setText("Price: " + currentPrice);
        
    }
    @FXML
    private void onNavigateAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 100;
        currentItem = navigateLabel.getText();
        gadgetLabel.setText("Shield Selected: " + currentItem);
        infoLabel.setText("Information: Reflective shields are the best. Shields protect your hull from damage.");
        priceLabel.setText("Price: " + currentPrice);
        
    }
    
    @FXML
    private void onAutoAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 150;
        currentItem = autoLabel.getText();
        gadgetLabel.setText("Gadget Selected: " + currentItem);
        infoLabel.setText("Information: An auto-repair system helps your engineering functions.");
        priceLabel.setText("Price: " + currentPrice);
        
    }
    
    @FXML
    private void onTargetingAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 200;
        currentItem = targetLabel.getText();
        gadgetLabel.setText("Gadget Selected: " + currentItem);
        infoLabel.setText("Information: A targeting system helps you handle your weaponry.");
        priceLabel.setText("Price: " + currentPrice);
        
    }
    
    @FXML
    private void onCloakingAction(MouseEvent event){
        buyButton.setVisible(true);
        currentPrice = 250;
        currentItem = cloakLabel.getText();
        gadgetLabel.setText("Gadget Selected: " + currentItem);
        infoLabel.setText("Information: A cloaking device is perhaps the most interesting gadget a trader can buy. It is very expensive, but it allows you to travel through space undetected, as long as you don't attack.");
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
