/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Universe {
    
    private String name;
    private ArrayList<SolarSystem> solarsystems;
    
    /**
     *
     * @param name
     */
    public Universe(String name) {
        this.name = name;
        solarsystems = new ArrayList<>();
    }
    /*@param:List of solarSystems.
    @return: none. add the list of solarSystems to the universe.
    */ 

    /**
     *
     * @param list
     */
     
    public void addSolarSystem( List<SolarSystem> list )
    {
        solarsystems.addAll( list );
        
    /*@param:solarSystem object.
    @return: none. add a solarSystems to the list of solarSystem.
    */     
    }

    /**
     *
     * @param a
     */
    public void addSolarSystem(SolarSystem a) {
        solarsystems.add(a);
    }
    /*@param: solarSystem object.
    @return: none. remove the solarSystem object from the solarSystem list.
    */ 

    /**
     *
     * @param a
     */
     
    public void removeSolarSystem(SolarSystem a) {
        solarsystems.remove(a);
    }
    /*@param:name of the universe, String.
    @return: none. set the name variable.
    */ 

    /**
     *
     * @param name
     */
     
    public void setName(String name) { //setter mathod. 
        this.name = name;
    }
    /*@param:none.
    @return: name variable value.
    */ 

    /**
     *
     * @return
     */
     
    public String getName() {  //getter method.
        return name;
    }
    /*@param:none.
    @return: solarSystem valriable value.
    */ 

    /**
     *
     * @return
     */
     
    public ArrayList<SolarSystem> getList() {  //getter method.
        return solarsystems;
    }
    
    @Override
    public String toString()
    {
        String string = new String();
        for( SolarSystem solarSystem : solarsystems )
        {
            string += (solarSystem + "," );
        }
        return "Universe: " + name + " " +string;
    }
}
