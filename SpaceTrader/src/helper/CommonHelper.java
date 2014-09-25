/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import model.Planet;
import model.Player;
import model.SolarSystem;
import model.TradeGood;


/**
 *
 * @author Raoul & Noora & Sarah
 */
public class CommonHelper {

    private static Random rand;
    private static Player player;

    /*@param:none.
    @return: list of the name of the planets from the text file, String.
    */ 
    public static List<SolarSystem> getPlanets()
    {
        List<SolarSystem> planetsList = new ArrayList<>();
        try {
            FileReader fr = new FileReader( "res/txt/planets.txt" );
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] tokens = line.split("\"");
                planetsList.add(new SolarSystem( tokens[1]) );
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
                
                goodsList.add(new TradeGood(name, MTLP, MTLU, TTP, basePrice, IPL, VAR, IE, CR, ER, MTL, MTH) );
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
   
    public static int randInt( int maxInt )
    {
        if( rand == null ) { rand = new Random(); }
        return rand.nextInt( maxInt );
    }
    
}
