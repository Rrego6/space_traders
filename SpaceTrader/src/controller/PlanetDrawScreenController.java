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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import model.Inventory;
import model.SolarSystem;
import model.Universe;

/**
 * FXML Controller Class
 *
 * @author sarah
 * @version 1.0
 */
public class PlanetDrawScreenController implements Initializable {

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

    private SolarSystem solarSystem;
    private Universe universe;
    private Inventory inventory;

    @FXML
    private void onAcceptAction(ActionEvent event) {
        GameData.getPlayer().setCurrentLocation(solarSystem);
        if (GameData.getPlayer().getCurrentLocation() == null) {
            JOptionPane.showMessageDialog(null, "Select a starting"
                + " planet first.");
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                    .getResource("/view/Orbit.fxml"));
                Parent root = fxmlLoader.load();

                Scene scene = GameData.getScene();
                scene.setRoot(root);
                GameData.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void onCancelAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/view/CharacterCreationScreen.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        System.out.print(event.getX());
        System.out.println(" " + event.getY());

        double x = event.getX();
        double y = event.getY();
        handlePlanetClick(x, y);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        universe = new Universe("Trader Universe");
        universe.addSolarSystem(CommonHelper.generatePlanets());
        GameData.setUniverse(universe);
        nameLabel.setText("Name: " + GameData.getPlayer()
            .getCurrentLocation().getName());
        locationLabel.setText("Location: " + GameData.getPlayer()
            .getCurrentLocation().getLocation());
        techLabel.setText("Tech Level: " + GameData.getPlayer()
            .getCurrentLocation().getTechLevel());
        resourcesLabel.setText("Resources: " + GameData.getPlayer()
            .getCurrentLocation().getResource());

        GraphicsContext g2d = canvas.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        for (SolarSystem s : universe.getList()) {
            g2d.fillOval(s.getX(), s.getY(), GameData.PLANET_DIAMETER,
                GameData.PLANET_DIAMETER);
        }
        GameData.getPlayer().setCurrentLocation(universe.getList()
            .get(CommonHelper.randInt(universe.getList().size())));
        CommonHelper.alertBox(GameData.getStage(), "Location Selected: "
            + GameData.getPlayer().getCurrentLocation().getName());
        handlePlanetClick(GameData.getPlayer().getCurrentLocation()
            .getX(), GameData.getPlayer().getCurrentLocation().getY());
    }

    private void handlePlanetClick(double x, double y) {
        nameLabel.setText("Name: ");
        locationLabel.setText("Location: ");
        techLabel.setText("Tech Level: ");
        resourcesLabel.setText("Resources: ");
        planetInfoLabel.setText("Planet Information");
        for (SolarSystem s : universe.getList()) {
            if (s.isHit(x, y)) {
                nameLabel.setText("Name: " + s.getName());
                locationLabel.setText("Location: " + s.getLocation());
                techLabel.setText("Tech Level: " + s.getTechLevel());
                resourcesLabel.setText("Resources: " + s.getResource());
                planetInfoLabel.setText("Planet Information");
                GraphicsContext g2d = canvas.getGraphicsContext2D();
                g2d.setFill(Color.RED);
                g2d.fillOval(s.getX(), s.getY(), GameData.PLANET_DIAMETER,
                    GameData.PLANET_DIAMETER);
                solarSystem = s;
            } else {
                GraphicsContext g2d = canvas.getGraphicsContext2D();
                g2d.setFill(Color.WHITE);
                g2d.fillOval(s.getX(), s.getY(), GameData.PLANET_DIAMETER,
                    GameData.PLANET_DIAMETER);

            }
        }
    }

}
