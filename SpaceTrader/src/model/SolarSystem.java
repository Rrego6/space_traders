/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

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
        this.name = name;
        x = numGen.nextInt(150);
        y = numGen.nextInt(100);
        techLevel = numGen.nextInt(8);
        resource = numGen.nextInt(13);
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
    
    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }
    
    //public String getResource()
    
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
}
