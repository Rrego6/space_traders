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
import com.google.gson.Gson;
import java.io.*;



/**
 *
 * @author Raoul
 */
public class GameData {
    public static final int GAME_WIDTH = 300;
    public static final int GAME_HEIGHT = 300;
    
    public static final int PLANET_DIAMETER = 8;
    
    private static Player player;
    private static Scene scene;
    private static Stage stage;
    private static Universe universe;
    
    private static String gson;

    public static Scene getScene() {
       return scene;
    }
    public static void setScene(Scene scene) {
        GameData.scene = scene;
    }
    
    public static Stage getStage() {
       return stage;
    }
    public static void setStage(Stage stage) {
        GameData.stage = stage;
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
    
    public static void saveData() {
        
            try {
                PrintWriter out1 = new PrintWriter(new File("res/txt/gameDataPlayer.json"));
                Gson gs = new Gson();
                gson = gs.toJson(player);
                out1.println(gson);
                out1.flush(); 
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            } 
            
            try {
                PrintWriter out1 = new PrintWriter(new File("res/txt/gameDataUniverse.json"));
                Gson gs = new Gson();
                gson = gs.toJson(universe);
                out1.println(gson);
                out1.flush(); 
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            }  
    }
   
    public static void loadData() {    
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("res/txt/GameDataPlayer.json"));
            String json1 = br.readLine();
            Gson gs = new Gson();
            GameData.player = gs.fromJson(json1, Player.class);      
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("res/txt/GameDataUniverse.json"));
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
