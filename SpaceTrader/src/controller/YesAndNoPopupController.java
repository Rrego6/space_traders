/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller Class
 *
 * @author Raoul
 * @version 1.0
 */
public class YesAndNoPopupController implements Initializable {

    @FXML
    private AnchorPane body;
    @FXML
    private Label label;
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * sets text label.
     *
     * @param s input string
     */
    public void setLabelText(String s) {
        label.setText(s);
        label.autosize();
    }

    /**
     * action taken when yes button clicked.
     *
     * @param event input string
     */
    public void setYesButtonAction(EventHandler<ActionEvent> event) {
        yesButton.setOnAction(event);
    }

    /**
     * action taken when no button clicked.
     *
     * @param event input string
     */
    public void setNoButtonAction(EventHandler<ActionEvent> event) {
        noButton.setOnAction(event);
    }
}
