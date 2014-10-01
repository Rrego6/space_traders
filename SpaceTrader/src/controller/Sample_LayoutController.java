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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private ListView<String> tradeList;
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
        costLabel.setText(costLabel.getText() + cost);
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
        tradeList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                goods.remove(tradeList.getSelectionModel().getSelectedItem());
            }
        });
        
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
            pWaterLabel.setText(numWater + " Units of Water");
            cost -= TradeGood.WATER.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
            
            //tradeList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            //    @Override
            //    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            //    
            //    }
            //});
        }
    }
    
    @FXML
    private void buyWater(MouseEvent event) {
        if (credits > 0) {
            goods.add("Water (Buy)");
            tradeList.setItems(goods);
            cost += TradeGood.WATER.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellFurs(MouseEvent event) {
        
    }
    
    @FXML
    private void buyFurs(MouseEvent event) {
        
    }
    
    @FXML
    private void sellFood(MouseEvent event) {
        
    }
    
    @FXML
    private void buyFood(MouseEvent event) {
        
    }
    
    @FXML
    private void sellOre(MouseEvent event) {
        
    }
    
    @FXML
    private void buyOre(MouseEvent event) {
        
    }
    
    @FXML
    private void sellGames(MouseEvent event) {
        
    }
    
    @FXML
    private void buyGames(MouseEvent event) {
        
    }
    
    @FXML
    private void sellFirearms(MouseEvent event) {
        
    }
    
    @FXML
    private void buyFirearms(MouseEvent event) {
        
    }
    
    @FXML
    private void sellMedicine(MouseEvent event) {
        
    }
    
    @FXML
    private void buyMedicine(MouseEvent event) {
        
    }
    
    @FXML
    private void sellMachines(MouseEvent event) {
        
    }
    
    @FXML
    private void buyMachines(MouseEvent event) {
        
    }
    
    @FXML
    private void sellNarcotics(MouseEvent event) {
        
    }
    
    @FXML
    private void buyNarcotics(MouseEvent event) {
        
    }
    
    @FXML
    private void sellRobots(MouseEvent event) {
        
    }
    
    @FXML
    private void buyRobots(MouseEvent event) {
        
    }
    
    @FXML
    private void onTradeAction(MouseEvent event) {
        update();
    }
    
    @FXML
    private void onCancelAction(MouseEvent event) {
        if (goods.isEmpty()) {
            try {
                FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/PlanetDrawScreen.fxml" ));
                Parent root = fxmlLoader.load();
                Scene scene = GameData.getScene();
                scene.setRoot(root);
                GameData.setScene(scene);
            }
            catch( IOException e)
            {
                e.printStackTrace();
            }
        } else {
            
        }
    }
    
    private void update() {
        
    }
}
