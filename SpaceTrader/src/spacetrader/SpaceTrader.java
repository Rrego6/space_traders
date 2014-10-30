/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import controller.WelcomeScreenController;
import helper.CommonHelper;
import helper.GameData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Raoul
 */
public class SpaceTrader extends Application {
    
    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/WelcomeScreen.fxml" ));
        Parent root = fxmlLoader.load();
        WelcomeScreenController controller = (WelcomeScreenController) fxmlLoader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        GameData.setScene(scene);
        GameData.stage = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
