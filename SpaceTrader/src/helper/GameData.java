/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import model.Universe;

/**
 *
 * @author Raoul
 * @version 1.0
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

    public static final int SHIPYARD_TECHLEVEL = 3;

    public static Player player;
    private static Scene scene;
    private static Stage stage;
    public static Universe universe;

    private static String gson;

    /**
     * gets the current scene
     *
     * @return scene - the current scene
     */
    public static Scene getScene() {
        return scene;
    }

    /**
     * makes a new scene
     *
     * @param scene the new scene
     */
    public static void setScene(Scene scene) {
        GameData.scene = scene;
    }

    /**
     * gets the stage
     *
     * @return stage: the current stage
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * sets the current stage
     *
     * @param stage the stage to set
     */
    public static void setStage(Stage stage) {
        GameData.stage = stage;
        // stage.setResizable(false);
        // stage.initStyle(StageStyle.UNDECORATED);
    }

    /**
     * gets the current universe
     *
     * @return universe the universe
     */
    public static Universe getUniverse() {
        return universe;
    }

    /**
     * sets the universe
     *
     * @param universe the universe
     */
    public static void setUniverse(Universe universe) {
        GameData.universe = universe;
    }

    /**
     * gets the current player
     *
     * @return player the current player
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * sets the current player
     *
     * @param player the current player
     */
    public static void setPlayer(Player player) {
        GameData.player = player;
    }

    /**
     * saves the data
     */
    public static void saveData() {

        try {
            PrintWriter out1 = new PrintWriter(new File("res/txt/ga"
                + "meDataPlayer.json"));
            Gson gs = new Gson();
            player.onSave();
            gson = gs.toJson(player);
            out1.println(gson);
            out1.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            PrintWriter out1 = new PrintWriter(new File("res/txt/gam"
                + "eDataUniverse.json"));
            Gson gs = new Gson();
            gson = gs.toJson(universe);
            out1.println(gson);
            out1.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * loads the data
     */
    public static void loadData() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("res/txt"
                + "/GameDataPlayer.json"));
            String json1 = br.readLine();
            Gson gs = new Gson();
            GameData.player = gs.fromJson(json1, Player.class);
        } catch (FileNotFoundException ex) {
            CommonHelper.alertBox(stage, "No Save found.");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("res/txt/G"
                + "ameDataUniverse.json"));
            String json1 = br.readLine();
            Gson gs = new Gson();
            GameData.universe = gs.fromJson(json1, Universe.class);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
