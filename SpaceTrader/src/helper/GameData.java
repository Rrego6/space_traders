/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Planet;
import model.Player;
import model.Universe;

/**
 *
 * @author Raoul
 */
public class GameData {

    /**
     *
     */
    public static final int GAME_WIDTH = 300;

    /**
     *
     */
    public static final int GAME_HEIGHT = 300;
    
    /**
     *
     */
    public static final int PLANET_DIAMETER = 8;
    
    private static Player player;
    private static Scene scene;
    private static Stage stage;
    private static Universe universe;

    /**
     *
     * @return
     */
    public static Scene getScene() {
       return scene;
    }

    /**
     *
     * @param scene
     */
    public static void setScene(Scene scene) {
        GameData.scene = scene;
    }
    
    /**
     *
     * @return
     */
    public static Stage getStage() {
       return stage;
    }

    /**
     *
     * @param stage
     */
    public static void setStage(Stage stage) {
        GameData.stage = stage;
    }
    
    /**
     *
     * @return
     */
    public static Universe getUniverse() {
        return universe;
    }

    /**
     *
     * @param universe
     */
    public static void setUniverse(Universe universe) {
        GameData.universe = universe;
    }

    /**
     *
     * @return
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     *
     * @param player
     */
    public static void setPlayer( Player player ) {
        GameData.player = player;
    }
    
}
