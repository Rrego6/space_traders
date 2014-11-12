/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import helper.CommonHelper;
import helper.GameData;
import java.awt.Button;
import java.awt.Point;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.sql.CommonDataSource;
import model.Planet;
import model.Player;
import model.SolarSystem;
import model.Universe;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests the method handleMouseClick
 * @author Raoul
 */
public class StarChartControllerTest extends Application {
    static StarChartController testedController;
    static Method testedMethod;
    static SolarSystem testedSystem;
    static Label testedLabel;
    static Field testedField;
    
    static MouseEvent trueMouseEvent;
    static MouseEvent falseMouseEvent;
                       
    
    @Before
    public void setUp() {
        GameData.player = new Player("Tester", 3, 3, 3, 3, 3);
        GameData.universe = new Universe( "TestVerse" );
        List<SolarSystem> system = CommonHelper.generatePlanets();
        testedSystem = system.get(0);
        GameData.player.setCurrentLocation(system.get(0));
        
        GameData.universe.addSolarSystem( system );
    }
        public void start(Stage stage) throws Exception {
            FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource( "/view/StarChart.fxml" ));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            }
            catch(IOException e ) {
                e.printStackTrace();
            }
            testedController = (StarChartController) fxmlLoader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            
            //First Assertion
            assertEquals(testedSystem, GameData.getPlayer().getCurrentLocation());
            
            //New tested System
            testedSystem = GameData.getUniverse().getList().get(1);

            try {
                testedMethod = testedController.getClass().getDeclaredMethod( "handleMouseClick", MouseEvent.class );
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(StarChartControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(StarChartControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //makes private methods visible
            testedMethod.setAccessible(true);

            Point truePoint = testedSystem.getPoint();
            Point falsePoint = SolarSystem.genPoint();

            trueMouseEvent =
                    new MouseEvent(null, truePoint.x, truePoint.y, 0, 0, MouseButton.NONE, 0, true, true, true, true, true, true, true, true, true, true, null);
            
            falseMouseEvent =
                    new MouseEvent(null, truePoint.x, truePoint.y, 0, 0, MouseButton.NONE, 0, true, true, true, true, true, true, true, true, true, true, null);


            try {
                testedMethod.invoke(testedController, trueMouseEvent);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            }
        
//            assertEquals(testedSystem, testedController.getSelectedSystem());
            
            try {
                testedMethod.invoke(testedController, falseMouseEvent);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(StarChartControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(StarChartControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(StarChartControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertThat(testedSystem, is(not(testedController.getSelectedSystem())));
        Platform.exit();
    }

    @Test
    public void testInitialize() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        launch(null);
    }
    
}
