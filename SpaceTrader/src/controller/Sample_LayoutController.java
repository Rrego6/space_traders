/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import helper.GameData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import model.TradeGood;

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
    private ListView tradeList;
    private ObservableList goods = FXCollections.observableArrayList();
    private int numWater;
    // int numBuy/SellWater for popup asking how much you want to trade
    private int numFurs;
    private int numFood;
    private int numOre;
    private int numGames;
    private int numFirearms;
    private int numMedicine;
    private int numMachines;
    private int numNarcotics;
    private int numRobots;
    private int credits;
    private int cost;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        credits = GameData.getPlayer().getCredits();
        playerCredits.setText(playerCredits.getText() + credits);
        numWater = GameData.getPlayer().getShip().getInventory().getNumWater();
        numFurs = GameData.getPlayer().getShip().getInventory().getNumFurs();
        numFood = GameData.getPlayer().getShip().getInventory().getNumFood();
        numOre = GameData.getPlayer().getShip().getInventory().getNumOre();
        numGames = GameData.getPlayer().getShip().getInventory().getNumGames();
        numFirearms = GameData.getPlayer().getShip().getInventory().getNumFirearms();
        numMedicine = GameData.getPlayer().getShip().getInventory().getNumMedicine();
        numMachines = GameData.getPlayer().getShip().getInventory().getNumMachines();
        numNarcotics = GameData.getPlayer().getShip().getInventory().getNumNarcotics();
        numRobots = GameData.getPlayer().getShip().getInventory().getNumRobots();
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.WATER.getMTLU()) {
            pWaterLabel.disableProperty();
        } else {
            pWaterLabel.setText(numWater + " " + pWaterLabel.getText());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.WATER.getMTLP()) {
            mWaterLabel.disableProperty();
        } else {
            mWaterLabel.setText(mWaterLabel.getText() + " @ " + TradeGood.WATER.getCost());
        }
    }

    @FXML
    private void sellWater(MouseEvent event) {
        if (numWater > 0) {
            goods.add("Water (Sell)");
            tradeList.setItems(goods);
            numWater--;
        }
        if (goods.contains("Water (Sell)")) {
            goods.remove("Water (Sell)");
            numWater++;
        }
    }
    
    @FXML
    private void buyWater(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyWater(MouseEvent event) {
        
    }
    
    @FXML
    private void sellFurs(MouseEvent event) {
        
    }
    
    @FXML
    private void removeSellFurs(MouseEvent event) {
        
    }
    
    @FXML
    private void buyFurs(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyFurs(MouseEvent event) {
        
    }
    
    @FXML
    private void sellFood(MouseEvent event) {
        
    }
    
    @FXML
    private void removeSellFood(MouseEvent event) {
        
    }
    
    @FXML
    private void buyFood(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyFood(MouseEvent event) {
        
    }
    
    @FXML
    private void sellOre(MouseEvent event) {
        
    }
    
    @FXML
    private void removeSellOre(MouseEvent event) {
        
    }
    
    @FXML
    private void buyOre(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyOre(MouseEvent event) {
        
    }
    
    @FXML
    private void sellGames(MouseEvent event) {
        
    }
    
    @FXML
    private void removeSellGames(MouseEvent event) {
        
    }
    
    @FXML
    private void buyGames(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyGames(MouseEvent event) {
        
    }
    
    @FXML
    private void sellFirearms(MouseEvent event) {
        
    }
    
    @FXML
    private void removeSellFirearms(MouseEvent event) {
        
    }
    
    @FXML
    private void buyFirearms(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyFirearms(MouseEvent event) {
        
    }
    
    @FXML
    private void sellMedicine(MouseEvent event) {
        
    }
    
    @FXML
    private void removeSellMedicine(MouseEvent event) {
        
    }
    
    @FXML
    private void buyMedicine(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyMedicine(MouseEvent event) {
        
    }
    
    @FXML
    private void sellMachines(MouseEvent event) {
        
    }
    
    @FXML
    private void removeSellMachines(MouseEvent event) {
        
    }
    
    @FXML
    private void buyMachines(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyMachines(MouseEvent event) {
        
    }
    
    @FXML
    private void sellNarcotics(MouseEvent event) {
        
    }
    
    @FXML
    private void removeSellNarcotics(MouseEvent event) {
        
    }
    
    @FXML
    private void buyNarcotics(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyNarcotics(MouseEvent event) {
        
    }
    
    @FXML
    private void sellRobots(MouseEvent event) {
        
    }
    
    @FXML
    private void removeSellRobots(MouseEvent event) {
        
    }
    
    @FXML
    private void buyRobots(MouseEvent event) {
        
    }
    
    @FXML
    private void removeBuyRobots(MouseEvent event) {
        
    }
    
    @FXML
    private void onTradeAction(MouseEvent event) {
        update();
    }
    
    @FXML
    private void onCancelAction(MouseEvent event) {
        
    }
    
    private void update() {
        
    }
}
