/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import controller.AlertPopupController;
import controller.YesAndNoPopupController;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import model.MsgEventPair;
import model.SolarSystem;
import model.TradeGood;

/**
 *
 * @author Raoul & Noora & Sarah
 * @version 1.0
 */
public class CommonHelper {

    private static Random rand;

    /**
     * makes an alert box
     *
     * @param primaryStage - the Stage from where the popup is init (current
     * stage)
     * @param msg - String to display
     */
    public static void alertBox(Stage primaryStage, String msg) {
        alertBox(primaryStage, msg, null);
    }

    /**
     * makes an alert box with event
     *
     * @param primaryStage - the Stage from where the popup is init (current
     * stage)
     * @param msg - String to display
     * @param onCloseandOk event that occurs on CloseandOk
     */
    public static void alertBox(Stage primaryStage, String msg,
        EventHandler<ActionEvent> onCloseandOk) {
        FXMLLoader fxmlLoader = new FXMLLoader(CommonHelper.class
            .getResource("/view/AlertPopup.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            AlertPopupController controller
                = (AlertPopupController) fxmlLoader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initStyle(StageStyle.UTILITY);
            dialog.initOwner(primaryStage);
            dialog.setResizable(false);
            dialog.setScene(new Scene(root));
            controller.setLabelText(msg);
            if (onCloseandOk != null) {
                dialog.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        onCloseandOk.handle(new ActionEvent(event
                            .getSource(), event.getTarget()));
                    }
                });
            }
            dialog.setOnCloseRequest(null);
            controller.setButtonAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();
                    if (onCloseandOk != null) {
                        onCloseandOk.handle(event);
                    }
                }
            });
            dialog.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @param primaryStage - the Stage from where the popup is init (current
     * stage)
     * @param msg - String to display
     * @param onYes event that occurs on yes
     * @param onNoClose event that occurs on no or close
     */
    public static void yesAndNoBox(Stage primaryStage, String msg,
        EventHandler<ActionEvent> onYes, EventHandler<ActionEvent> onNoClose) {
        FXMLLoader fxmlLoader = new FXMLLoader(CommonHelper.class
            .getResource("/view/YesAndNoPopup.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            YesAndNoPopupController controller
                = (YesAndNoPopupController) fxmlLoader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initStyle(StageStyle.UTILITY);
            dialog.initOwner(primaryStage);
            dialog.setResizable(false);
            dialog.setScene(new Scene(root));
            controller.setLabelText(msg);
            controller.setNoButtonAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();
                    if (onNoClose != null) {
                        onNoClose.handle(event);
                    }
                }
            });
            controller.setYesButtonAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();
                    if (onYes != null) {
                        onYes.handle(event);
                    }
                }
            });
            dialog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * misc pop up pane
     *
     * @param primaryStage - the Stage from where the popup is init (current
     * stage)
     * @param msg - String to display
     * @param buttonOptions - kinds of buttons
     * @param onClose action for closing
     */
    public void miscOptionPane(Stage primaryStage, String msg,
        MsgEventPair[] buttonOptions, EventHandler<ActionEvent> onClose) {

    }

    /**
     * makes the planets
     *
     * @return planersList: list of the name of the planets from the text file,
     * String.
     */
    public static List<SolarSystem> generatePlanets() {
        List<SolarSystem> planetsList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("res/txt/planets.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split("\"");

                //Randomly Selects if Planet is to be added
                if (CommonHelper.randInt(5) <= 2) {
                    planetsList.add(new SolarSystem(tokens[1]));
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return planetsList;
    }

    /**
     * reads all the goods into an array
     *
     * @return an array list of goods
     */
    public static ArrayList<TradeGood> readAllGoods() {
        ArrayList<TradeGood> goodsList = new ArrayList<>();
        String name;
        int mtlp;
        int mtlu;
        int ttp;
        int basePrice;
        int ipl;
        int var;
        String ie;
        String cr;
        String er;
        int mtl;
        int mth;
        try {
            FileReader fr = new FileReader("res/txt/tradeGoodsInfo.csv");
            Scanner sc = new Scanner(fr);
            int counter = 0;
            System.out.println("file read in");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(",");
                name = tokens[0];
                mtlp = Integer.parseInt(tokens[1]);
                mtlu = Integer.parseInt(tokens[2]);
                ttp = Integer.parseInt(tokens[3]);
                basePrice = Integer.parseInt(tokens[4]);
                ipl = Integer.parseInt(tokens[5]);
                var = Integer.parseInt(tokens[6]);
                ie = tokens[7];
                cr = tokens[8];
                er = tokens[9];
                mtl = Integer.parseInt(tokens[10]);
                mth = Integer.parseInt(tokens[11]);

                counter++;

            }
            sc.close();
            System.out.println("goods list fully created");
        } catch (FileNotFoundException e) {
            System.out.println("file not found exception");
            e.printStackTrace();
        }
        return goodsList;
    }

    //Delegation
    //http://en.wikipedia.org/wiki/Delegation_pattern#Java_examples
    /**
     * Generates a random int
     *
     * @param maxInt the max integer for random ints
     * @return a random int
     */
    public static int randInt(int maxInt) {
        if (rand == null) {
            rand = new Random();
        }
        return rand.nextInt(maxInt);
    }

}
