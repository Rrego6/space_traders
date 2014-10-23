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
 * FXML Controller class
 *
 * @author Raoul
 */
public class AlertPopupController implements Initializable {
    @FXML
    private AnchorPane body;
    @FXML
    private Label label;
    @FXML
    private Button button;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setLabelText(String s) {
        label.setText(s);
        label.autosize();
    }
    
    public void setButtonText(String s) {
        button.setText(s);
        button.autosize();
    }
    
    public void setButtonAction( EventHandler<ActionEvent> event) {
        button.setOnAction(event);
    }
}
