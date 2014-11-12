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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.Inventory;
import model.TradeGood;
import view.TradeLabel;

/**
 * FXML TradeScreenController Class
 *
 * @author Ivan
 * @version 1.0
 */
public class TradeScreenController implements Initializable {

    @FXML
    private ListView<TradeLabel> inventoryListView;
    @FXML
    private ListView<TradeLabel> marketplaceListView;
    @FXML
    private Label currentCreditsLabel;
    @FXML
    private Label totalCostLabel;
    @FXML
    private Button confirmButton;
    @FXML
    private Button backButton;

    private final ObservableList goodList = FXCollections.observableArrayList();
    private String currentCreditsText;
    private String totalCostText;
    private TradeLabel playerWaterLabel;
    private TradeLabel playerFursLabel;
    private TradeLabel playerFoodLabel;
    private TradeLabel playerOreLabel;
    private TradeLabel playerGamesLabel;
    private TradeLabel playerFirearmsLabel;
    private TradeLabel playerMedicineLabel;
    private TradeLabel playerNarcoticsLabel;
    private TradeLabel playerRobotsLabel;
    private TradeLabel playerMachinesLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentCreditsLabel.setText(GameData.getPlayer().toString());

        Inventory playerInventory = GameData.getPlayer().getShip()
            .getInventory();
        Inventory planetInventory = new Inventory(100);

        initInventoryListView(playerInventory);

    }

    private void initInventoryListView(Inventory playerInventory) {
        if (playerInventory.getNumWater() > 0) {
            playerWaterLabel = new TradeLabel(TradeGood.WATER,
                playerInventory.getNumWater(), true);
            goodList.add(playerWaterLabel);
        }
        if (playerInventory.getNumFurs() > 0) {
            playerFursLabel = new TradeLabel(TradeGood.FURS,
                playerInventory.getNumFurs(), true);
            goodList.add(playerFursLabel);
        }
        if (playerInventory.getNumFood() > 0) {
            playerFoodLabel = new TradeLabel(TradeGood.FOOD,
                playerInventory.getNumFood(), true);
            goodList.add(playerFoodLabel);
        }
        if (playerInventory.getNumOre() > 0) {
            playerOreLabel = new TradeLabel(TradeGood.ORE,
                playerInventory.getNumOre(), true);
            goodList.add(playerOreLabel);
        }
        if (playerInventory.getNumGames() > 0) {
            playerGamesLabel = new TradeLabel(TradeGood.GAMES,
                playerInventory.getNumGames(), true);
            goodList.add(playerGamesLabel);
        }
        if (playerInventory.getNumFirearms() > 0) {
            playerFirearmsLabel = new TradeLabel(TradeGood.FIREARMS,
                playerInventory.getNumFirearms(), true);
            goodList.add(playerFirearmsLabel);
        }
        //machine medicine narcotics robots
        if (playerInventory.getNumMedicine() > 0) {
            playerMedicineLabel = new TradeLabel(TradeGood.MEDICINE,
                playerInventory.getNumMedicine(), true);
            goodList.add(playerMedicineLabel);
        }
        if (playerInventory.getNumMachines() > 0) {
            playerMachinesLabel = new TradeLabel(TradeGood.MACHINES,
                playerInventory.getNumMachines(), true);
            goodList.add(playerMachinesLabel);
        }
        if (playerInventory.getNumNarcotics() > 0) {
            playerNarcoticsLabel = new TradeLabel(TradeGood.NARCOTICS,
                playerInventory.getNumNarcotics(), true);
            goodList.add(playerNarcoticsLabel);
        }
        if (playerInventory.getNumRobots() > 0) {
            playerRobotsLabel = new TradeLabel(TradeGood.ROBOTS,
                playerInventory.getNumRobots(), true);
            goodList.add(playerRobotsLabel);
        }

        inventoryListView.setItems(goodList);
        inventoryListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TradeLabel selectedLabel = inventoryListView
                    .getSelectionModel().getSelectedItem();
                if (selectedLabel == null) {
                    return;
                }
                TradeGood good = selectedLabel.getTradeGood();
                //goodList.remove(good);
            }
        });
    }

    @FXML
    private void onAcceptAction(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Trade Confirmed");
    }

    @FXML
    private void onCancelAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/view/PlanetDrawScreen.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
