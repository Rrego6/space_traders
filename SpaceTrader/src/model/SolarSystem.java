/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import helper.CommonHelper;
import helper.GameData;
import java.awt.Point;
import java.util.ArrayList;


/*FIXME: FIX X AND Y COORDINATES*/

/**
 * The X and Y coordinates of this class correspond to the top left corner.
 * 
 * @author Ivan
 */
public class SolarSystem {
    
    private static ArrayList<Point> points = new ArrayList<>();
    
    private String name;
    private Point coord;
    private int techLevel;
    private int resource;
    
    private ArrayList<Planet> planets;
    
    public SolarSystem(String name, Point coord, int techLevel, int resource) {
        this.name = name;
        this.coord = coord;
        this.techLevel = techLevel;
        this.resource = resource;
    }
    
    public SolarSystem(String name) {
        this(
                name,
                genPoint(),
                CommonHelper.randInt(8),
                CommonHelper.randInt(13)
        );
        planets = new ArrayList<>();
        planets.add( new Planet( name ) );
    }
    
    
    /**
     * Generate unique point
     * @return a unique Point
     */
    private static Point genPoint() {
        Point genPoint = new Point( CommonHelper.randInt( GameData.GAME_WIDTH ),
                CommonHelper.randInt( GameData.GAME_HEIGHT ));

        while( isNearOtherPoints( genPoint ) ){
            genPoint = new Point( CommonHelper.randInt( GameData.GAME_WIDTH ),
                CommonHelper.randInt( GameData.GAME_HEIGHT ));
        }

        return genPoint;
    }
    
    /**
     * Checks if currentPoint is near any other planets
     * @param genPoint
     * @return 
     */
    private static boolean isNearOtherPoints(Point genPoint)
    {
        for(Point p : points) {
            if( p.distance(genPoint) < GameData.PLANET_SIZE + 2 ) {
                return true;
            }
        }
        return false;
    }
    
    /*@param:name of the soalrsystem, String.
    @return: none,sets the name variable.
    */
    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(Point p) { this.coord = p; }   
    public Point getPoint() { return coord; }
    public int getX() { return coord.x; }
    public int getY() { return coord.y; };
    public Point getCenterPoint() {
        return new Point( (int) (coord.x + GameData.PLANET_SIZE / Math.sqrt(2)),
            (int) (coord.y + GameData.PLANET_SIZE / Math.sqrt(2)) ); }
            
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
    
    public String getLocation(){
        return "(" + coord.x + ", " + coord.y + ")";
    }
    /*@param:double of px and py.
    @return: boolean,if the planet is hited.
    */ 
    public boolean isHit(double px, double py) {
        return coord.distance(new Point((int)px, (int)py)) < GameData.PLANET_SIZE;
    }
    
    @Override
    public String toString()
    {
        return "{ Name: " + name + ", Location: (" + coord.x + "," + coord.y +
                "), Tech Level: " + techLevel + ", Resources: " + resource + "}";
    }
}
