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
    
    }
    
    @FXML
    private void onAttackAction(ActionEvent event) {
        
    }
    
    @FXML
    private void onFleeAction(ActionEvent event) {
        
    }
    
    @FXML
    private void onSurrenderAction(ActionEvent event) {
        
    }
    
}
