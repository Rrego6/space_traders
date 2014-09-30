/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import helper.GameData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ambrose Cheung <cheungambrose30@gmail.com>
 */
public class Sample_LayoutController implements Initializable {

    @FXML
    private Label costLabel;
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
    private Label mWaterLabel;
    @FXML
    private Label mFursLabel;
    @FXML
    private Label mFoodLabel;
    @FXML
    private Label mOreLabel;
    @FXML
    private Label mGamesLabel;
    @FXML
    private Label mFirearmsLabel;
    @FXML
    private Label mMedicineLabel;
    @FXML
    private Label mMachinesLabel;
    @FXML
    private Label mNarcoticsLabel;
    @FXML
    private Label mRobotsLabel;
    @FXML
    private VBox buyWindow;
    @FXML
    private VBox sellWindow;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerCredits.setText(playerCredits.getText() + GameData.getPlayer().getCredits());
        
        if(GameData.getPlayer().getShip().getInventory().getNumWater() < 1) {
            pWaterLabel.disableProperty();
        } else {
            pWaterLabel.setText(pWaterLabel.getText() + GameData.getPlayer().getShip().getInventory().getNumWater());
        }
        //all the other player goods
        
        if(GameData.getPlayer().getLocation().getNumWater() < 1) {
            mWaterLabel.disableProperty();
        } else {
            mWaterLabel.setText(mWaterLabel.getText() + GameData.getPlayer().getLocation().getNumWater());
        }
        //all the other player goods
    }
    
    private void sellWater(ActionEvent event) {
        
    }
    
    @FXML
    private void onTradeAction(ActionEvent event) {
        JOptionPane.showMessageDialog( null, "Trade Complete" );
    }
    
    @FXML
    private void onCancelAction(ActionEvent event) {
        
    }
}
