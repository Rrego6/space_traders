/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import interfaces.SceneNavigator;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

/**
 *
 * @author Raoul
 */
public abstract class SceneNavigatorController implements Initializable, SceneNavigator
{
    private Scene scene;
    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    @Override
    /*@param:none.
    @return: scene variable value.
    */
    public Scene getScene() {
        return scene;
    }
    
}
