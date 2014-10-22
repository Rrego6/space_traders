/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.ControlsScreenController;
import controller.CharacterCreationScreenController;
import model.Player;
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
import javafx.scene.control.Button;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

/**
 *
 * @author Raoul
 */
public class WelcomeScreenController implements Initializable {
    
    @FXML
    private void handleControlsButtonAction(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource("/view/ControlsScreen.fxml"));
            Parent root = fxmlLoader.load();
            //ControlsScreenController controller = (ControlsScreenController) fxmlLoader.getController();
            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
            //controller.setScene(scene);
            
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleNewGameButtonAction(ActionEvent event )
    {
        try
        {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource("/view/CharacterCreationScreen.fxml"));
            Parent root = fxmlLoader.load();
            
            //CharacterCreationScreenController controller = (CharacterCreationScreenController) fxmlLoader.getController();
            //Scene scene = getScene();
            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
            //controller.setScene(scene);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleLoadGameButtonAction(ActionEvent event) {
        
        try
        {
            GameData.loadData();
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource("/view/Orbit.fxml"));
            Parent root = fxmlLoader.load();
           
            Scene scene = GameData.getScene();
            
            scene.setRoot(root);
            GameData.setScene(scene);
            System.out.println(GameData.getPlayer().getName());
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
}
