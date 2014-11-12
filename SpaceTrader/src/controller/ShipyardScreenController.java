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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author Sarah
 * @version 1.0
 */
public class ShipyardScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Action taken when back is clicked.
     *
     * @param event an action event
     */
    @FXML
    private void onBackAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(""
                + "/view/Orbit.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Action taken when buygadeget is clicked.
     *
     * @param event an action event
     */
    @FXML
    private void handleBuyGadgetAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/"
                + "view/BuyGadgetScreen.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Action taken when buyweaponaction is clicked.
     *
     * @param event an action event
     */
    @FXML
    private void onBuyWeaponAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/"
                + "view/BuyWeaponScreen.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Action taken when buyshieldaction is clicked.
     *
     * @param event an action event
     */
    @FXML
    private void onBuyShieldAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/"
                + "view/BuyShieldScreen.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Action taken when refuelaction is clicked.
     *
     * @param event an action event
     */
    @FXML
    private void onRefuelAction(ActionEvent event) {
        GameData.getPlayer().getShip().refillFuel();
        CommonHelper.alertBox(GameData.getStage(), "  Your ship has been refue"
            + "led!  ");

    }

    /**
     * Action taken when buyship is clicked.
     *
     * @param event an action event
     */
    @FXML
    public void onBuyShip(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/"
                + "view/BuyShipScreen.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
