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
import model.SolarSystem;


/**
 *
 * @author Raoul & Noora
 */
public class CommonHelper {

    public static Random rand;
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
    
    public static int randInt( int maxInt )
    {
        if( rand == null ) { rand = new Random(); }
        return rand.nextInt( maxInt );
    }
    
}
