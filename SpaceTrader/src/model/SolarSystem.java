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
    
    /*@param:name of the soalrsystem, String.
    @return: none,sets the name variable.
    */
    public void setName(String name) {
        this.name = name;
    }
    /*@param:x value, int.
    @return: none,sets the x variable.
    */    
    public void setX(int x) {
        this.x = x;
    }
    /*@param:y value, int.
    @return: none,sets the y variable.
    */     
    public void setY(int y) {
        this.y = y;
    }
    /*@param:techLevel value, int.
    @return: none,sets the techLevel variable.
    */     
    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }
    /*@param:resource value, int.
    @return: none,sets the resource variable.
    */ 
    public void setResource(int resource) {
        this.resource = resource;
    }
    /*@param:planet object.
    @return: none,adds the planet object to the planets list.
    */ 
    public void addPlanet(Planet a) {
        planets.add(a);
    }
    /*@param:planet object.
    @return: none,removes the planet object from the planets list.
    */ 
    public void removePlanet(Planet a) {
        planets.remove(a);
    }
    /*@param:none.
    @return: name variable value.
    */ 
    public String getName() {  //getter method
        return name;
    }
    /*@param:none.
    @return: techLevel variable value.
    */ 
    public int getTechLevel() { //getter method
        return techLevel;
    }
    /*@param:none.
    @return: resource variable value.
    */ 
    public int getResource() { //getter method
        return resource;
    }
    /*@param:none.
    @return: x variable value.
    */ 
    public int getX() { //getter method
        return x;
    }
    /*@param:none.
    @return: y variable value.
    */ 
    public int getY(){ //getter method
        return y;
    }
    /*@param:double of px and py.
    @return: boolean,if the planet is hited.
    */ 
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
