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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import model.SolarSystem;
import model.Universe;

/**
 * FXML Controller class
 *
 * @author Ambrose Cheung <cheungambrose30@gmail.com>
 */
public class StarChartController implements Initializable {

    @FXML
    private Canvas canvas;
    @FXML
    private Label nameLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label techLabel;
    @FXML
    private Label resourcesLabel;
    @FXML
    private Label planetInfoLabel;
    @FXML
    private Label distanceLabel;
    @FXML
    private Label fuelLabel;
    private Universe universe;
    private SolarSystem solarSystem;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        universe = GameData.getUniverse();
        GraphicsContext g2d = canvas.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        for( SolarSystem s : universe.getList() )
        {
            if(s.equals(GameData.getPlayer().getCurrentLocation())) {
                g2d.setFill(Color.GREEN);
                g2d.fillOval(s.getX(),s.getY(), GameData.PLANET_DIAMETER, GameData.PLANET_DIAMETER );
                g2d.setFill(Color.WHITE);
            } else {
                g2d.fillOval(s.getX(),s.getY(), GameData.PLANET_DIAMETER, GameData.PLANET_DIAMETER );
            }
        }
        fuelLabel.setText("Fuel in Ship: " + GameData.getPlayer().getShip().getFuel());
    }    
    
    @FXML
    private void handleMouseClick(MouseEvent event) {
        System.out.print(event.getX());
        System.out.println( " " + event.getY());
        
        nameLabel.setText("Name: ");
        locationLabel.setText("Location: ");
        techLabel.setText("Tech Level: ");
        resourcesLabel.setText("Resources: ");
        planetInfoLabel.setText("Planet Information");
        for( SolarSystem s : universe.getList() ) {
            if (s.isHit(event.getX(), event.getY())) {
                nameLabel.setText("Name: " + s.getName());
                locationLabel.setText("Location: " + s.getLocation());
                techLabel.setText("Tech Level: " + s.getTechLevel());
                resourcesLabel.setText("Resources: " + s.getResource());
                distanceLabel.setText("Distance: " + s.getDistance() + " parsecs");
                planetInfoLabel.setText("Planet Information");
                GraphicsContext g2d = canvas.getGraphicsContext2D();
                g2d.setFill(Color.RED);
                g2d.fillOval(s.getX(),s.getY(), GameData.PLANET_DIAMETER, GameData.PLANET_DIAMETER);
                solarSystem = s;
               // JOptionPane.showMessageDialog(null, "You clicked planet " + s.getName() + " at coordinates " + s.getX() + ", " + s.getY());
            }
            else {
                GraphicsContext g2d = canvas.getGraphicsContext2D();
                if(s.equals(GameData.getPlayer().getCurrentLocation())) {
                    g2d.setFill(Color.GREEN);
                    g2d.fillOval(s.getX(),s.getY(), GameData.PLANET_DIAMETER, GameData.PLANET_DIAMETER );
                } else {
                    g2d.setFill(Color.WHITE);
                    g2d.fillOval(s.getX(),s.getY(), GameData.PLANET_DIAMETER, GameData.PLANET_DIAMETER );
                }
            }
        }
    }
    
    @FXML
    private void onTravelAction(ActionEvent event) {
        if(solarSystem != null) {}
        else if ( solarSystem.getDistance() > GameData.getPlayer().getShip().getFuel()) {
            JOptionPane.showMessageDialog(null, "You don't have enough fuel!");
        } else {
            
            //ADD CHANCE FOR ENCOUNTER HERE
            if (GameData.getPlayer().encounter()) {
                int encounterType = GameData.getPlayer().encounterType();
                if (encounterType == 1) {
                    //Generate Trader
                    //Pop-up that shows there is a trader/trader wants to trade with you
                    //Attack or trade him
                    //If fight, battle window, if trade, trade window, else continue to destination
                    
                    int chanceOfFleeing = ((int)(Math.random() * 99)) + 1;
                    if (chanceOfFleeing > GameData.getPlayer().getReputation()) {
                        JOptionPane.showMessageDialog(null, "A trader has appeared, but he has already fled!");
                    } else {
                        Object[] options = {"Trade", "Fight", "Continue"};
                        int n = JOptionPane.showOptionDialog(null,
                        "A trader has appeared! What would you like to do?",
                        "Encounter!",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[2]);
                        
                        //check n, and go to trade/battle window accordingly
                    }
                        
                } else if (encounterType == 2) {
                    //Generate Pirate
                    //Pop-up that shows a Pirate is attacking with a button that lets you move on
                    //Battle window
                    
                    int chanceOfFighting = ((int)(Math.random() * 99)) + 1;
                    if (chanceOfFighting < GameData.getPlayer().getReputation()) {
                        Object[] options = {"Fight", "Continue"};
                        int n = JOptionPane.showOptionDialog(null,
                        "A pirate has appeared! What would you like to do?",
                        "Encounter!",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
                    } else {
                        JOptionPane.showMessageDialog(null, "A pirate has appeared! Prepare to fight!");
                        
                        //proceed to battle window
                    }
                  
                } else {
                    //Generate Police
                    //Flee, see if police wants to inspect you, attack, 
                    
                    int chanceOfInspection = ((int)(Math.random() * 99)) + 1;
                    if (chanceOfInspection < GameData.getPlayer().getReputation()) {
                        Object[] options = {"Fight", "Continue"};
                        int n = JOptionPane.showOptionDialog(null,
                        "The police has appeared! What would you like to do?",
                        "Encounter!",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
                        
                        //bring up battle window if needed
                        
                    } else {
                        Object[] options = {"Allow Inspection", "Bribe", "Fight"};
                        int n = JOptionPane.showOptionDialog(null,
                            "The police has appeared! They want to inspect your goods! What would you like to do?",
                            "Encounter!",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                        
                        //proceed to battle window if prompted, otherwise bring up input dialogs for bribe
                    }
                }
            }
            
            GameData.getPlayer().getShip().deductFuel(solarSystem.getDistance());
            GameData.getPlayer().setCurrentLocation(solarSystem);
            //GameData.getPlayer().getShip().getInventory().getTradeGood

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
    private void onCancelAction(ActionEvent event) {
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
