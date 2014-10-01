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
    private int numBoughtWater;
    // int numBuy/SellWater for popup asking how much you want to trade
    private int numFurs;
    private int numBoughtFurs;
    private int numFood;
    private int numBoughtFood;
    private int numOre;
    private int numBoughtOre;
    private int numGames;
    private int numBoughtGames;
    private int numFirearms;
    private int numBoughtFirearms;
    private int numMedicine;
    private int numBoughtMedicine;
    private int numMachines;
    private int numBoughtMachines;
    private int numNarcotics;
    private int numBoughtNarcotics;
    private int numRobots;
    private int numBoughtRobots;
    private String removedGood;
    private int credits;
    private int cost;
    private int totalGoods;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reset();
        tradeList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                removedGood = tradeList.getSelectionModel().getSelectedItem();
                goods.remove(removedGood);
                if(removedGood.equals("Water (Sell)")) {
                    numWater++;
                    totalGoods++;
                    pWaterLabel.setText(numWater + " Units of Water");
                    cost += TradeGood.WATER.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Water (Buy)")) {
                    numBoughtWater--;
                    totalGoods--;
                    cost -= TradeGood.WATER.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if(removedGood.equals("Furs (Sell)")) {
                    numFurs++;
                    totalGoods++;
                    pFursLabel.setText(numFurs + " Units of Furs");
                    cost += TradeGood.FURS.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Furs (Buy)")) {
                    numBoughtFurs--;
                    totalGoods--;
                    cost -= TradeGood.FURS.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if(removedGood.equals("Food (Sell)")) {
                    numFood++;
                    totalGoods++;
                    pFoodLabel.setText(numFood + " Units of Food");
                    cost += TradeGood.FOOD.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Food (Buy)")) {
                    numBoughtFood--;
                    totalGoods--;
                    cost -= TradeGood.FOOD.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if(removedGood.equals("Ore (Sell)")) {
                    numOre++;
                    totalGoods++;
                    pOreLabel.setText(numOre + " Units of Ore");
                    cost += TradeGood.ORE.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Ore (Buy)")) {
                    numBoughtOre--;
                    totalGoods--;
                    cost -= TradeGood.ORE.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if(removedGood.equals("Games (Sell)")) {
                    numGames++;
                    totalGoods++;
                    pGamesLabel.setText(numGames + " Units of Games");
                    cost += TradeGood.GAMES.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Games (Buy)")) {
                    numBoughtGames--;
                    totalGoods--;
                    cost -= TradeGood.GAMES.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if(removedGood.equals("Firearms (Sell)")) {
                    numFirearms++;
                    totalGoods++;
                    pFirearmsLabel.setText(numFirearms + " Units of Firearms");
                    cost += TradeGood.FIREARMS.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Firearms (Buy)")) {
                    numBoughtFirearms--;
                    totalGoods--;
                    cost -= TradeGood.FIREARMS.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if(removedGood.equals("Medicine (Sell)")) {
                    numMedicine++;
                    totalGoods++;
                    pMedicineLabel.setText(numMedicine + " Units of Medicine");
                    cost += TradeGood.MEDICINE.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Medicine (Buy)")) {
                    numBoughtMedicine--;
                    totalGoods--;
                    cost -= TradeGood.MEDICINE.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if(removedGood.equals("Machines (Sell)")) {
                    numMachines++;
                    totalGoods++;
                    pMachinesLabel.setText(numMachines + " Units of Machines");
                    cost += TradeGood.MACHINES.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Machines (Buy)")) {
                    numBoughtMachines--;
                    totalGoods--;
                    cost -= TradeGood.MACHINES.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if(removedGood.equals("Narcotics (Sell)")) {
                    numNarcotics++;
                    totalGoods++;
                    pNarcoticsLabel.setText(numNarcotics + " Units of Narcotics");
                    cost += TradeGood.NARCOTICS.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Narcotics (Buy)")) {
                    numBoughtNarcotics--;
                    totalGoods--;
                    cost -= TradeGood.NARCOTICS.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if(removedGood.equals("Robots (Sell)")) {
                    numRobots++;
                    totalGoods++;
                    pRobotsLabel.setText(numRobots + " Units of Robots");
                    cost += TradeGood.ROBOTS.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } else if (removedGood.equals("Robots (Buy)")) {
                    numBoughtRobots--;
                    totalGoods--;
                    cost -= TradeGood.ROBOTS.getCost();
                    costLabel.setText("Cost of Transaction: " + cost);
                } 
            }
        });
    }

    @FXML
    private void sellWater(MouseEvent event) {
        if (numWater > 0 && pWaterLabel.isDisabled() == false) {
            goods.add("Water (Sell)");
            tradeList.setItems(goods);
            numWater--;
            totalGoods--;
            pWaterLabel.setText(numWater + " Units of Water");
            cost -= TradeGood.WATER.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyWater(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mWaterLabel.isDisabled() == false) {
            goods.add("Water (Buy)");
            tradeList.setItems(goods);
            numBoughtWater++;
            totalGoods++;
            cost += TradeGood.WATER.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellFurs(MouseEvent event) {
        if (numFurs > 0 && pFursLabel.isDisabled() == false) {
            goods.add("Furs (Sell)");
            tradeList.setItems(goods);
            numFurs--;
            totalGoods--;
            pFursLabel.setText(numFurs + " Units of Furs");
            cost -= TradeGood.FURS.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyFurs(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mFursLabel.isDisabled() == false) {
            goods.add("Furs (Buy)");
            tradeList.setItems(goods);
            numBoughtFurs++;
            totalGoods++;
            cost += TradeGood.FURS.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellFood(MouseEvent event) {
        if (numFood > 0 && pFoodLabel.isDisabled() == false) {
            goods.add("Food (Sell)");
            tradeList.setItems(goods);
            numFood--;
            totalGoods--;
            pFoodLabel.setText(numFood + " Units of Food");
            cost -= TradeGood.FOOD.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyFood(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mFoodLabel.isDisabled() == false) {
            goods.add("Food (Buy)");
            tradeList.setItems(goods);
            numBoughtFood++;
            totalGoods++;
            cost += TradeGood.FOOD.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellOre(MouseEvent event) {
        if (numOre > 0 && pOreLabel.isDisabled() == false) {
            goods.add("Ore (Sell)");
            tradeList.setItems(goods);
            numOre--;
            totalGoods--;
            pOreLabel.setText(numOre + " Units of Ore");
            cost -= TradeGood.ORE.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyOre(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mOreLabel.isDisabled() == false) {
            goods.add("Ore (Buy)");
            tradeList.setItems(goods);
            numBoughtOre++;
            totalGoods++;
            cost += TradeGood.ORE.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellGames(MouseEvent event) {
        if (numGames > 0 && pGamesLabel.isDisabled() == false) {
            goods.add("Games (Sell)");
            tradeList.setItems(goods);
            numGames--;
            totalGoods--;
            pGamesLabel.setText(numGames + " Units of Water");
            cost -= TradeGood.GAMES.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyGames(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mGamesLabel.isDisabled() == false) {
            goods.add("Games (Buy)");
            tradeList.setItems(goods);
            numBoughtGames++;
            totalGoods++;
            cost += TradeGood.GAMES.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellFirearms(MouseEvent event) {
        if (numFirearms > 0 && pFirearmsLabel.isDisabled() == false) {
            goods.add("Firearms (Sell)");
            tradeList.setItems(goods);
            numFirearms--;
            totalGoods--;
            pFirearmsLabel.setText(numWater + " Units of Firearms");
            cost -= TradeGood.FIREARMS.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyFirearms(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mFirearmsLabel.isDisabled() == false) {
            goods.add("Firearms (Buy)");
            tradeList.setItems(goods);
            numBoughtFirearms++;
            totalGoods++;
            cost += TradeGood.FIREARMS.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellMedicine(MouseEvent event) {
        if (numMedicine > 0 && pMedicineLabel.isDisabled() == false) {
            goods.add("Medicine (Sell)");
            tradeList.setItems(goods);
            numMedicine--;
            totalGoods--;
            pMedicineLabel.setText(numMedicine + " Units of Medicine");
            cost -= TradeGood.MEDICINE.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyMedicine(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mMedicineLabel.isDisabled() == false) {
            goods.add("Medicine (Buy)");
            tradeList.setItems(goods);
            numBoughtMedicine++;
            totalGoods++;
            cost += TradeGood.MEDICINE.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellMachines(MouseEvent event) {
        if (numMachines > 0 && pMachinesLabel.isDisabled() == false) {
            goods.add("Machines (Sell)");
            tradeList.setItems(goods);
            numMachines--;
            totalGoods--;
            pMachinesLabel.setText(numMachines + " Units of Machines");
            cost -= TradeGood.MACHINES.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyMachines(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mMachinesLabel.isDisabled() == false) {
            goods.add("Machines (Buy)");
            tradeList.setItems(goods);
            numBoughtMachines++;
            totalGoods++;
            cost += TradeGood.MACHINES.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellNarcotics(MouseEvent event) {
        if (numNarcotics > 0 && pNarcoticsLabel.isDisabled() == false) {
            goods.add("Narcotics (Sell)");
            tradeList.setItems(goods);
            numNarcotics--;
            totalGoods--;
            pNarcoticsLabel.setText(numNarcotics + " Units of Narcotics");
            cost -= TradeGood.NARCOTICS.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyNarcotics(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mNarcoticsLabel.isDisabled() == false) {
            goods.add("Narcotics (Buy)");
            tradeList.setItems(goods);
            numBoughtNarcotics++;
            totalGoods++;
            cost += TradeGood.NARCOTICS.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void sellRobots(MouseEvent event) {
        if (numRobots > 0  && pRobotsLabel.isDisabled() == false) {
            goods.add("Robots (Sell)");
            tradeList.setItems(goods);
            numRobots--;
            totalGoods--;
            pRobotsLabel.setText(numRobots + " Units of Robots");
            cost -= TradeGood.ROBOTS.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void buyRobots(MouseEvent event) {
        if (credits > 0 && totalGoods < GameData.getPlayer().getShip().getInventory().getTotalSpace() && mRobotsLabel.isDisabled() == false) {
            goods.add("Robots (Buy)");
            tradeList.setItems(goods);
            numBoughtRobots++;
            totalGoods++;
            cost += TradeGood.ROBOTS.getCost();
            costLabel.setText("Cost of Transaction: " + cost);
        }
    }
    
    @FXML
    private void onTradeAction(ActionEvent event) {
        if (goods.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The trade window is empty.");
        } else if (cost > credits) {
            JOptionPane.showMessageDialog(null, "You don't have enough credits.");
        } else {
            int response = JOptionPane.showConfirmDialog(null, "Trade these goods?");
            if (response == JOptionPane.YES_OPTION) {
                update();
                reset();
            }
        }
    }
    
    @FXML
    private void onCancelAction(ActionEvent event) {
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
            int response = JOptionPane.showConfirmDialog(null, "All goods in the trade window are untraded. Continue?");
            if (response == JOptionPane.YES_OPTION) {
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
            }
        }
    }
    
    private void update() {
        GameData.getPlayer().setCredits(credits - cost);
        GameData.getPlayer().getShip().getInventory().setTotalSpace();
        GameData.getPlayer().getShip().getInventory().setNumWater(numWater + numBoughtWater);
        GameData.getPlayer().getShip().getInventory().setNumFurs(numFurs + numBoughtFurs);
        GameData.getPlayer().getShip().getInventory().setNumFood(numFood + numBoughtFood);
        GameData.getPlayer().getShip().getInventory().setNumOre(numOre + numBoughtOre);
        GameData.getPlayer().getShip().getInventory().setNumGames(numGames + numBoughtGames);
        GameData.getPlayer().getShip().getInventory().setNumFirearms(numFirearms + numBoughtFirearms);
        GameData.getPlayer().getShip().getInventory().setNumMedicine(numMedicine + numBoughtMedicine);
        GameData.getPlayer().getShip().getInventory().setNumMachines(numMachines + numBoughtMachines);
        GameData.getPlayer().getShip().getInventory().setNumNarcotics(numNarcotics + numBoughtNarcotics);
        GameData.getPlayer().getShip().getInventory().setNumRobots(numRobots + numBoughtRobots);
        goods.clear();
    }
    
    private void reset() {
        credits = GameData.getPlayer().getCredits();
        playerCredits.setText("Credits: " + credits);
        cost = 0;
        costLabel.setText("Cost of Transaction: " + cost);
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
        numBoughtWater = 0;
        numBoughtFurs = 0;
        numBoughtFood = 0;
        numBoughtOre = 0;
        numBoughtGames = 0;
        numBoughtFirearms = 0;
        numBoughtMedicine = 0;
        numBoughtMachines = 0;
        numBoughtNarcotics = 0;
        numBoughtRobots = 0;
        totalGoods = numWater + numFurs + numOre + numGames + numFirearms + numMedicine + numMachines + numNarcotics + numRobots;
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.WATER.getMTLU()) {
            pWaterLabel.disableProperty();
        } else {
            pWaterLabel.setText(numWater + " Units of Water");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.WATER.getMTLP()) {
            mWaterLabel.disableProperty();
        } else {
            mWaterLabel.setText("Water @ " + TradeGood.WATER.getCost());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.FURS.getMTLU()) {
            pFursLabel.disableProperty();
        } else {
            pFursLabel.setText(numFurs + " Units of Fur");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.FURS.getMTLP()) {
            mFursLabel.disableProperty();
        } else {
            mFursLabel.setText("Furs @ " + TradeGood.FURS.getCost());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.FOOD.getMTLU()) {
            pFoodLabel.disableProperty();
        } else {
            pFoodLabel.setText(numFood + " Units of Food");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.FOOD.getMTLP()) {
            mFoodLabel.disableProperty();
        } else {
            mFoodLabel.setText("Food @ " + TradeGood.FOOD.getCost());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.ORE.getMTLU()) {
            pOreLabel.disableProperty();
        } else {
            pOreLabel.setText(numOre + " Units of Ore");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.ORE.getMTLP()) {
            mOreLabel.disableProperty();
        } else {
            mOreLabel.setText("Ore @ " + TradeGood.ORE.getCost());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.GAMES.getMTLU()) {
            pGamesLabel.disableProperty();
        } else {
            pGamesLabel.setText(numGames + " Units of Games");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.GAMES.getMTLP()) {
            mGamesLabel.disableProperty();
        } else {
            mGamesLabel.setText("Games @ " + TradeGood.GAMES.getCost());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.FIREARMS.getMTLU()) {
            pFirearmsLabel.disableProperty();
        } else {
            pFirearmsLabel.setText(numFirearms + " Units of Firearms");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.FIREARMS.getMTLP()) {
            mFirearmsLabel.disableProperty();
        } else {
            mFirearmsLabel.setText("Firearms @ " + TradeGood.FIREARMS.getCost());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.MEDICINE.getMTLU()) {
            pMedicineLabel.disableProperty();
        } else {
            pMedicineLabel.setText(numMedicine + " Units of Medicine");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.MEDICINE.getMTLP()) {
            mMedicineLabel.disableProperty();
        } else {
            mMedicineLabel.setText("Medicine @ " + TradeGood.MEDICINE.getCost());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.MACHINES.getMTLU()) {
            pMachinesLabel.disableProperty();
        } else {
            pMachinesLabel.setText(numMachines + " Units of Machines");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.MACHINES.getMTLP()) {
            mMachinesLabel.disableProperty();
        } else {
            mMachinesLabel.setText("Machines @ " + TradeGood.MACHINES.getCost());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.NARCOTICS.getMTLU()) {
            pNarcoticsLabel.disableProperty();
        } else {
            pNarcoticsLabel.setText(numNarcotics + " Units of Narcotics");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.NARCOTICS.getMTLP()) {
            mNarcoticsLabel.disableProperty();
        } else {
            mNarcoticsLabel.setText("Narcotics @ " + TradeGood.NARCOTICS.getCost());
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.ROBOTS.getMTLU()) {
            pRobotsLabel.disableProperty();
        } else {
            pRobotsLabel.setText(numRobots + " Units of Robots");
        }
        
        if(GameData.getPlayer().getCurrentLocation().getTechLevel() < TradeGood.ROBOTS.getMTLP()) {
            mRobotsLabel.disableProperty();
        } else {
            mRobotsLabel.setText("Robots @ " + TradeGood.ROBOTS.getCost());
        }
    }
}
