/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.SceneNavigatorController;
import interfaces.SceneNavigator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author Raoul
 */
public class ControlsScreenController extends SceneNavigatorController {

    @FXML
    private void handleBackButtonAction(ActionEvent event )
    {
        try {
        FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/WelcomeScreen.fxml" ));
        Parent root = fxmlLoader.load();
        WelcomeScreenController controller = (WelcomeScreenController) fxmlLoader.getController();

        Scene scene = getScene();
        scene.setRoot(root);
        controller.setScene(scene);
        }
        catch( IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
