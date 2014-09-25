/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import javafx.scene.Scene;
import model.Planet;
import model.Player;
import model.Universe;

/**
 *
 * @author Raoul
 */
public class GameData {
    private static Player player;
    private static Scene scene;
    private static Universe universe;

    public static Scene getScene() {
       return scene;
    }
    public static void setScene(Scene scene) {
        GameData.scene = scene;
    } 
    
    public static Universe getUniverse() {
        return universe;
    }
    public static void setUniverse(Universe universe) {
        GameData.universe = universe;
    }

    public static Player getPlayer() {
        return player;
    }
    public static void setPlayer( Player player ) {
        GameData.player = player;
    }
    
}
