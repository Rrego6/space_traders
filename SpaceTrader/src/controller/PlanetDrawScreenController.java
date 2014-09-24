/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import helper.CommonHelper;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javax.swing.JOptionPane;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import model.Player;
import model.SceneNavigatorController;
import model.SolarSystem;
import model.Universe;
import model.Planet;


/**
 *
 * @author sarah
 */
public class PlanetDrawScreenController extends SceneNavigatorController {
    
    @FXML
    private Canvas canvas;
    
    private Universe universe;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    
        GraphicsContext g2d = canvas.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        for( SolarSystem s : universe.getList() )
        {
            g2d.fillOval(s.getX(),s.getY(), 7,7);
        }
    }
    
    @FXML
    private void handleMouseClick(MouseEvent event) {
        System.out.print(event.getX());
        System.out.println( " " + event.getY());
        for( SolarSystem s : universe.getList() ) {
            if (s.isHit(event.getX(), event.getY())) {
                System.out.println("Planet clicked: " + s.getName());
                JOptionPane.showMessageDialog(null, "You clicked planet " + s.getName() + " at coordinates " + s.getX() + ", " + s.getY());
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        universe = new Universe("Trader Universe");
        universe.addSolarSystem(CommonHelper.getPlanets());
        System.out.println( universe.toString() );
    }    
    
}
