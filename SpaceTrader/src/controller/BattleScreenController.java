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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import model.SolarSystem;
import model.Universe;

/**
 *
 * @author Ivan
 */
public class BattleScreenController implements Initializable {
    
    @FXML
    private Label healthLabel;
    @FXML
    private Label shieldLabel;
    @FXML
    private Label damageLabel;
    @FXML
    private Label enemyHealthLabel;
    @FXML
    private Label enemyShieldLabel;
    @FXML
    private Label enemyDamageLabel;
    @FXML
    private Button attackButton;
    @FXML
    private Button fleeButton;
    @FXML
    private Button surrenderButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        healthLabel.setText("" + GameData.getPlayer().getShip().getHull());
        shieldLabel.setText("" + GameData.getPlayer().getShip().getShields());
        damageLabel.setText("" + GameData.getPlayer().getShip().getDamage());
        enemyHealthLabel.setText("" + GameData.getPlayer().getEncounterPerson().getShip().getHull());
        enemyShieldLabel.setText("" + GameData.getPlayer().getEncounterPerson().getShip().getShields());
        enemyDamageLabel.setText("" + GameData.getPlayer().getEncounterPerson().getShip().getDamage());
    }
    
    @FXML
    private void onAttackAction(ActionEvent event) {
        int damage = GameData.getPlayer().getShip().getDamage() - GameData.getPlayer().getEncounterPerson().getShip().getShields(); 
        if (damage > 0) {
            GameData.getPlayer().getEncounterPerson().getShip().setShields(0);
            GameData.getPlayer().getEncounterPerson().getShip().setHull(GameData.getPlayer().getEncounterPerson().getShip().getHull() - damage);
        } else if (damage == 0) {
            GameData.getPlayer().getEncounterPerson().getShip().setShields(0);
        } else {
            GameData.getPlayer().getEncounterPerson().getShip().setShields(GameData.getPlayer().getEncounterPerson().getShip().getShields() + damage);
        }
        
        enemyHealthLabel.setText("" + GameData.getPlayer().getEncounterPerson().getShip().getHull());
        enemyShieldLabel.setText("" + GameData.getPlayer().getEncounterPerson().getShip().getShields());
    }
    
    @FXML
    private void onFleeAction(ActionEvent event) {
        //If random int is bigger than enemy damage?
        //Display if successful or not
        //Continue to destination
        
        boolean fled = true;
        if (fled) {
            try {
                    FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/Orbit.fxml" ));
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
    
    @FXML
    private void onSurrenderAction(ActionEvent event) {
        //Show you surrendered
        //Lose goods/credits
        GameData.getPlayer().setReputation(GameData.getPlayer().getReputation() - 1);
    }
    
    
    
    //during encounter, create the trader/fighter/police person
    //if fight, set the enemy to that person
    //flee should be based on enemy attack
    //enemy battle logic: mostly attack, surrender if they realize they cant win
    //player should have a victory variable - set to win or lose
    //if win, reputation for pirates goes up
}
