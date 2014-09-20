/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class SolarSystem {
    
    private String name;
    private int x;
    private int y;
    private String techLevel;
    private String resource;
    
    private ArrayList<Planet> planets;
    
    public SolarSystem(String name, int x, int y, String techLevel, String resource) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.resource = resource;
    }
    
    //public String getName()
    
    public void setName(String name) {
        this.name = name;
    }
    
    //public int getX()
    
    public void setX(int x) {
        this.x = x;
    }
    
    //public int getY()
    
    public void setY(int y) {
        this.y = y;
    }
    
    //public String getTechLevel()
    
    public void setTechLevel(String techLevel) {
        this.techLevel = techLevel;
    }
    
    //public String getResource()
    
    public void setResource(String resource) {
        this.resource = resource;
    }
    
    public void addPlanet(Planet a) {
        planets.add(a);
    }
    
    public void removePlanet(Planet a) {
        planets.remove(a);
    }
}
