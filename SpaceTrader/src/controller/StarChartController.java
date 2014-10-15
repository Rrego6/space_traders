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
            GameData.getPlayer().getShip().deductFuel(solarSystem.getDistance());
            GameData.getPlayer().setCurrentLocation(solarSystem);

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
