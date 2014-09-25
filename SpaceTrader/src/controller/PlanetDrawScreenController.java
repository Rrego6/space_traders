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
import model.GoodsList;
import model.TradeGood;



/**
 *
 * @author sarah
 */
public class PlanetDrawScreenController extends SceneNavigatorController {
    
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
         
    private Universe universe;
    private GoodsList goodslist;
    
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
    private void onAcceptAction(ActionEvent event) {
        JOptionPane.showMessageDialog( null, "Planet Selected" );
    }
    
    @FXML
    private void onCancelAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/CharacterCreationScreen.fxml" ));
            Parent root = fxmlLoader.load();
            CharacterCreationScreenController controller = (CharacterCreationScreenController) fxmlLoader.getController();

            Scene scene = getScene();
            scene.setRoot(root);
            controller.setScene(scene);
        }
        
        catch( IOException e)
        {
            e.printStackTrace();
        }
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
                planetInfoLabel.setText("Planet Information");
                GraphicsContext g2d = canvas.getGraphicsContext2D();
                g2d.setFill(Color.RED);
                g2d.fillOval(s.getX(),s.getY(), 7,7);
               // JOptionPane.showMessageDialog(null, "You clicked planet " + s.getName() + " at coordinates " + s.getX() + ", " + s.getY());
            }
            else {
                GraphicsContext g2d = canvas.getGraphicsContext2D();
                g2d.setFill(Color.WHITE);
                g2d.fillOval(s.getX(),s.getY(), 7,7);
               
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        universe = new Universe("Trader Universe");
        universe.addSolarSystem(CommonHelper.getPlanets());
        System.out.println( universe.toString() );
        goodslist = new GoodsList("First list");
        System.out.println("new list created");
        goodslist.addTradeGood(CommonHelper.readAllGoods());
        System.out.println(goodslist.toString());
        
        GraphicsContext g2d = canvas.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        for( SolarSystem s : universe.getList() )
        {
            g2d.fillOval(s.getX(),s.getY(), 7,7);
        }
    }    
    
}
