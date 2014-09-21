/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;


/**
 *
 * @author Raoul & Noora
 */
import java.io.*;
import java.util.*;
public class CommonHelper {

   public static List scanner() throws IOException {
      FileReader fr = new FileReader("planets.txt");
      Scanner sc = new Scanner(fr);
      List<String> planetsList = new ArrayList<>();
      while (sc.hasNextLine()){
         String line = sc.nextLine();
         String[] tokens = line.split("\"");
         planetsList.add(tokens[1]);
      }
      sc.close();
      return planetsList;
   }
    
}
