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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import model.Player;

/**
 * FXML Controller class
 *
 * @author Raoul
 * @version 1.0
 */
public class CharacterCreationScreenController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private Label fighterLabel;
    @FXML
    private Label spRemainingLabel;
    @FXML
    private Label pilotLabel;
    @FXML
    private Label traderLabel;
    @FXML
    private Label engineerLabel;
    @FXML
    private Label investorLabel;
    @FXML
    private Rectangle pilotBar, traderBar, investorBar, fighterBar, engineerBar;

    protected int spLeft = 15;
    protected int pilotSP = 0;
    protected int fighterSP = 0;
    protected int traderSP = 0;
    protected int engineerSP = 0;
    protected int investorSP = 0;

    protected String spLeftText;
    protected String pilotSPText;
    protected String fighterSPText;
    protected String traderSPText;
    protected String engineerSPText;
    protected String investorSPText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spLeftText = spRemainingLabel.getText();
        pilotSPText = pilotLabel.getText();
        fighterSPText = fighterLabel.getText();
        traderSPText = traderLabel.getText();
        engineerSPText = engineerLabel.getText();
        investorSPText = investorLabel.getText();

        spRemainingLabel.setText(spLeftText + " " + spLeft);
        pilotLabel.setText(pilotSPText + " " + pilotSP);
        fighterLabel.setText(fighterSPText + " " + fighterSP);
        traderLabel.setText(traderSPText + " " + traderSP);
        engineerLabel.setText(engineerSPText + " " + engineerSP);
        investorLabel.setText(investorSPText + " " + investorSP);
    }

    @FXML
    private void onDecPilotSkill(ActionEvent event) {
        if (pilotSP > 0) {
            pilotLabel.setText(pilotSPText + " " + --pilotSP);
            pilotBar.setWidth(20 * pilotSP);
            spRemainingLabel.setText(spLeftText + " " + ++spLeft);
        }
    }

    @FXML
    private void onIncPilotSkill(ActionEvent event) {
        if (spLeft > 0) {
            pilotLabel.setText(pilotSPText + " " + ++pilotSP);
            spRemainingLabel.setText(spLeftText + " " + --spLeft);
            pilotBar.setWidth(20 * pilotSP);
        }
    }

    @FXML
    private void onDecFighterSkill(ActionEvent event) {
        if (fighterSP > 0) {
            fighterLabel.setText(fighterSPText + " " + --fighterSP);
            fighterBar.setWidth(20 * fighterSP);
            spRemainingLabel.setText(spLeftText + " " + ++spLeft);
        }
    }

    @FXML
    private void onIncFighterSkill(ActionEvent event) {
        if (spLeft > 0) {
            fighterLabel.setText(fighterSPText + " " + ++fighterSP);
            fighterBar.setWidth(20 * fighterSP);
            spRemainingLabel.setText(spLeftText + " " + --spLeft);
        }
    }

    @FXML
    private void onDecTraderSkill(ActionEvent event) {
        if (traderSP > 0) {
            traderLabel.setText(traderSPText + " " + --traderSP);
            traderBar.setWidth(20 * traderSP);
            spRemainingLabel.setText(spLeftText + " " + ++spLeft);
        }
    }

    @FXML
    private void onIncTraderSkill(ActionEvent event) {
        if (spLeft > 0) {
            traderLabel.setText(traderSPText + " " + ++traderSP);
            traderBar.setWidth(20 * traderSP);
            spRemainingLabel.setText(spLeftText + " " + --spLeft);
        }
    }

    @FXML
    private void onDecEngineerSkill(ActionEvent event) {
        if (engineerSP > 0) {
            engineerLabel.setText(engineerSPText + " " + --engineerSP);
            engineerBar.setWidth(20 * engineerSP);
            spRemainingLabel.setText(spLeftText + " " + ++spLeft);
        }
    }

    @FXML
    private void onIncEngineerSkill(ActionEvent event) {
        if (spLeft > 0) {
            engineerLabel.setText(engineerSPText + " " + ++engineerSP);
            engineerBar.setWidth(20 * engineerSP);
            spRemainingLabel.setText(spLeftText + " " + --spLeft);
        }
    }

    @FXML
    private void onDecInvestorSkill(ActionEvent event) {
        if (investorSP > 0) {
            investorLabel.setText(investorSPText + " " + --investorSP);
            investorBar.setWidth(20 * investorSP);
            spRemainingLabel.setText(spLeftText + " " + ++spLeft);
        }
    }

    @FXML
    private void onIncInvestorSkill(ActionEvent event) {
        if (spLeft > 0) {
            investorLabel.setText(investorSPText + " " + ++investorSP);
            investorBar.setWidth(20 * investorSP);
            spRemainingLabel.setText(spLeftText + " " + --spLeft);
        }
    }

    @FXML
    private void onCancelAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vie"
                + "w/WelcomeScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = GameData.getScene();
            scene.setRoot(root);
            GameData.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onAcceptAction(ActionEvent event) {
        if (nameField.getText().isEmpty()) {
            CommonHelper.alertBox(GameData.getStage(), "Name cannot be blank.");
            nameField.requestFocus();
        } else if (spLeft > 0) {
            CommonHelper.alertBox(GameData.getStage(), "Allocate All Stats.");
        } else {
            Player player = new Player(nameField.getText(), pilotSP, fighterSP,
                traderSP, engineerSP, investorSP);
            GameData.setPlayer(player);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                    .getResource("/view/StarChart.fxml"));
                Parent root = fxmlLoader.load();

                Scene scene = GameData.getScene();
                scene.setRoot(root);
                GameData.setScene(scene);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
