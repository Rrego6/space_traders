/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import controller.AlertPopupController;
import controller.WelcomeScreenController;
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
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.SolarSystem;
import model.TradeGood;


/**
 *
 * @author Raoul & Noora & Sarah
 */
public class CommonHelper {

    private static Random rand;
    
    /**
     * 
     * @param msg - Text to display
     */
    public static void alertBox(Stage primaryStage, String msg) {
        FXMLLoader fxmlLoader =  new FXMLLoader( CommonHelper.class.getResource( "/view/AlertPopup.fxml" ));
        Parent root;
        try {
            root = fxmlLoader.load();
            AlertPopupController controller = (AlertPopupController) fxmlLoader.getController();
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(primaryStage);
            dialog.setScene(new Scene(root));
            controller.setLabelText(msg);
            controller.setButtonAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();
                }
            });
            dialog.show();   
        } catch(IOException e ) {
            e.printStackTrace();
            System.exit(1);
        }        
    }
    /*@param:none.
    @return: list of the name of the planets from the text file, String.
    */ 

    /**
     *
     * @return
     */
     
    public static List<SolarSystem> generatePlanets()
    {
        List<SolarSystem> planetsList = new ArrayList<>();
        try {
            FileReader fr = new FileReader( "res/txt/planets.txt" );
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] tokens = line.split("\"");
                
                //Randomly Selects if Planet is to be added
                if( CommonHelper.randInt(5) <=2 ) {
                    planetsList.add( new SolarSystem( tokens[1]) );
                }
            }
            sc.close();
        }
        catch( FileNotFoundException e )
        {
            e.printStackTrace();
        }
      return planetsList;
   }
    
    /*@param:none.
    @return: list of the goods and their traits
    */ 

    /**
     *
     * @return
     */
     
    public static ArrayList<TradeGood> readAllGoods()
    {
        ArrayList<TradeGood> goodsList = new ArrayList<>();
        String name;
        int MTLP;
        int MTLU;
        int TTP;
        int basePrice;
        int IPL;
        int VAR;
        String IE;
        String CR;
        String ER;
        int MTL;
        int MTH;
        try {
            FileReader fr = new FileReader( "res/txt/tradeGoodsInfo.csv" );
            Scanner sc = new Scanner(fr);
            int counter = 0;
            System.out.println("file read in");
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] tokens = line.split(",");
                name = tokens[0];
                MTLP = Integer.parseInt(tokens[1]);
                MTLU = Integer.parseInt(tokens[2]);
                TTP = Integer.parseInt(tokens[3]);
                basePrice = Integer.parseInt(tokens[4]);
                IPL = Integer.parseInt(tokens[5]);
                VAR = Integer.parseInt(tokens[6]);
                IE = tokens[7];
                CR = tokens[8];
                ER = tokens[9];
                MTL = Integer.parseInt(tokens[10]);
                MTH = Integer.parseInt(tokens[11]);
                
                //goodsList.add(new TradeGood(name, MTLP, MTLU, TTP, basePrice, IPL, VAR, IE, CR, ER, MTL, MTH) );
                counter++;
                
            }
            sc.close();
            System.out.println("goods list fully created");
        }
        catch( FileNotFoundException e )
        {
            System.out.println("file not found exception");
            e.printStackTrace();
        }
      return goodsList;
   }
   
    /**
     *
     * @param maxInt
     * @return
     */
    public static int randInt( int maxInt )
    {
        if( rand == null ) { rand = new Random(); }
        return rand.nextInt( maxInt );
    }
    
    
    
}
