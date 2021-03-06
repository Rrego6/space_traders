/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.GameData;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * FXML Controller Class
 *
 * @author Raoul
 * @version 1.0
 */
public class WelcomeScreenController implements Initializable {

    @FXML
    private void handleControlsButtonAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/view/ControlsScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
            //controller.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleNewGameButtonAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/view/CharacterCreationScreen.fxml"));
            Parent root = fxmlLoader.load();

            //Scene scene = getScene();
            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
            //controller.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLoadGameButtonAction(ActionEvent event) {

        try {
            GameData.loadData();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/view/Orbit.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = GameData.getScene();

            scene.setRoot(root);
            GameData.setScene(scene);
            System.out.println(GameData.getPlayer().getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private Button loadGameBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File f = new File("res/txt/GameDataPlayer.json");
        System.out.println(f.length());
        if (!f.exists()) {
            loadGameBtn.setVisible(false);
        } else if (f.length() < 10) {
            loadGameBtn.setVisible(false);
        } else {
            loadGameBtn.setVisible(true);
        }
    }
}
