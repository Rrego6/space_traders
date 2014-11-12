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
 * @version 1.0
 */
public class BuyGadgetScreenController implements Initializable {

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
        gadgetLabel.setText("Current Gadget: ");
        creditsLabel.setText("Credits available: " + GameData.getPlayer()
            .getCredits());
        buyButton.setVisible(false);
        gadgetSlotLabel.setText("Gadget slots available: " + GameData
            .getPlayer().getShip().getGadgetSlot());
        if (GameData.getPlayer().getCurrentLocation().getTechLevel() < 6) {
            cloakLabel.setVisible(false);
        }
        if (GameData.getPlayer().getCurrentLocation().getTechLevel() < 5) {
            targetLabel.setVisible(false);
        }
        if (GameData.getPlayer().getCurrentLocation().getTechLevel() < 4) {
            autoLabel.setVisible(false);
        }
    }

    @FXML
    private void onBackAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/"
                + "view/ShipyardScreen.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onCargoAction(MouseEvent event) {
        buyButton.setVisible(true);
        currentPrice = 50;
        currentItem = cargoLabel.getText();
        gadgetLabel.setText("Gadget Selected: " + currentItem);
        infoLabel.setText("Information: For a beginning trader, the most inter"
            + "esting gadget is 5 extra cargo bays. These are fairly cheap"
            + " and allow you to carry more cargo. If there is more than "
            + "one gadget slot on your ship, you may purchase more than on"
            + "e of these.");
        priceLabel.setText("Price: " + currentPrice);

    }

    @FXML
    private void onNavigateAction(MouseEvent event) {
        buyButton.setVisible(true);
        currentPrice = 100;
        currentItem = navigateLabel.getText();
        gadgetLabel.setText("Gadget Selected: " + currentItem);
        infoLabel.setText("Information: A navigating system helps you piloting "
            + "your ship.");
        priceLabel.setText("Price: " + currentPrice);

    }

    @FXML
    private void onAutoAction(MouseEvent event) {
        buyButton.setVisible(true);
        currentPrice = 150;
        currentItem = autoLabel.getText();
        gadgetLabel.setText("Gadget Selected: " + currentItem);
        infoLabel.setText("Information: An auto-repair system helps your engin"
            + "eering functions.");
        priceLabel.setText("Price: " + currentPrice);

    }

    @FXML
    private void onTargetingAction(MouseEvent event) {
        buyButton.setVisible(true);
        currentPrice = 200;
        currentItem = targetLabel.getText();
        gadgetLabel.setText("Gadget Selected: " + currentItem);
        infoLabel.setText("Information: A targeting system helps you handle you"
            + "r weaponry.");
        priceLabel.setText("Price: " + currentPrice);

    }

    @FXML
    private void onCloakingAction(MouseEvent event) {
        buyButton.setVisible(true);
        currentPrice = 250;
        currentItem = cloakLabel.getText();
        gadgetLabel.setText("Gadget Selected: " + currentItem);
        infoLabel.setText("Information: A cloaking device is perhaps the most "
            + "interesting gadget a trader can buy. It is very expensive, "
            + "but it allows you to travel through space undetected, as lo"
            + "ng as you don't attack.");
        priceLabel.setText("Price: " + currentPrice);

    }

    @FXML
    private void onBuyAction(ActionEvent event) {
        if (GameData.getPlayer().getShip().getGadgetSlot() < 1) {
            CommonHelper.alertBox(GameData.getStage(), "  You do not have enou"
                + "gh gadget slots to buy " + currentItem + ".  ");

        } else if (GameData.getPlayer().getCredits() < currentPrice) {
            CommonHelper.alertBox(GameData.getStage(), "  You do not have enoug"
                + "h credits to buy " + currentItem + ".  ");
        } else {

            CommonHelper.yesAndNoBox(GameData.getStage(), "  Are you "
                + "sure you would "
                + "like to buy " + currentItem + " for " + currentPrice
                + " credits?  ",
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        GameData.getPlayer().setCredits(GameData
                            .getPlayer().getCredits()
                            - currentPrice);
                        GameData.getPlayer().getShip()
                        .subtractGadgetSlot();
                        gadgetSlotLabel.setText("Gadget slots availa"
                            + "ble: " + GameData.getPlayer()
                            .getShip().getGadgetSlot());
                        creditsLabel.setText("Credits available: "
                            + GameData.getPlayer().getCredits());
                    }
                },
                null
            );
        }
    }
}
