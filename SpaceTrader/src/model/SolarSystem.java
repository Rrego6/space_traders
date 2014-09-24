/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import helper.CommonHelper;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ivan
 */
public class SolarSystem {
    
    private Random numGen = new Random();
    private String name;
    private int x;
    private int y;
    private int techLevel;
    private int resource;
    
    private ArrayList<Planet> planets;
    
    public SolarSystem(String name, int x, int y, int techLevel, int resource) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.resource = resource;
    }
    
    public SolarSystem(String name) {
        this(
                name,
                CommonHelper.randInt(30)*10,
                CommonHelper.randInt(30)*10,
                CommonHelper.randInt(8),
                CommonHelper.randInt(13)
        );
        planets = new ArrayList<>();
        planets.add( new Planet( name ) );
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
        
    public void setX(int x) {
        this.x = x;
    }
        
    public void setY(int y) {
        this.y = y;
    }
        
    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }
    
    public void setResource(int resource) {
        this.resource = resource;
    }
    
    public void addPlanet(Planet a) {
        planets.add(a);
    }
    
    public void removePlanet(Planet a) {
        planets.remove(a);
    }
    
    public String getName() {  //getter method
        return name;
    }
    
    public int getTechLevel() { //getter method
        return techLevel;
    }
    
    public int getResource() { //getter method
        return resource;
    }
    
    public int getX() { //getter method
        return x;
    }
    
    public int getY(){ //getter method
        return y;
    }
    
    public boolean isHit(double px, double py) {
        if (px >= x && px <= x + 5)
            if (py >= y && py <= y + 5)
                return true;
        return false;
    }
    
    @Override
    public String toString()
    {
        return "{ Name: " + name + ", Location: (" + x + "," + y +
                "), Tech Level: " + techLevel + ", Resources: " + resource + "}";
    }
}
