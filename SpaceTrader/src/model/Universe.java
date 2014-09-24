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
    
    public Universe(String name) {
        this.name = name;
        solarsystems = new ArrayList<>();
    }
    
    public void addSolarSystem( List<SolarSystem> list )
    {
        solarsystems.addAll( list );
    }
    public void addSolarSystem(SolarSystem a) {
        solarsystems.add(a);
    }
    
    public void removeSolarSystem(SolarSystem a) {
        solarsystems.remove(a);
    }
    
    public void setName(String name) { //setter mathod. 
        this.name = name;
    }
    
    public String getName() {  //getter method.
        return name;
    }
    
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
