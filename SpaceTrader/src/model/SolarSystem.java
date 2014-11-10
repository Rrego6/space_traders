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
import java.lang.Math;


/*FIXME: FIX X AND Y COORDINATES*/

/**
 * The X and Y coordinates of this class correspond to the top left corner.
 * 
 * @author Ivan
 */
public class SolarSystem {
    
    private static ArrayList<Point> points = new ArrayList<>();
    
    private String name;
    private Point coordTopLeft;
    private Point coordCenter;

    private int techLevel;
    private int resource;
    private int politics;
    
    private ArrayList<Planet> planets;
    
    public SolarSystem(String name, Point coord, int techLevel, int resource, int politics) {
        this.name = name;
        this.coordTopLeft = coord;
        this.techLevel = techLevel;
        this.resource = resource;
        this.coordCenter = new Point(
                (int)(coord.getX() + (.5) * GameData.PLANET_DIAMETER),
                (int)(coord.getY() + (.5) * GameData.PLANET_DIAMETER)
        );
        this.politics = politics;
    }
    
    public SolarSystem(String name) {
        this(
                name,
                genPoint(),
                CommonHelper.randInt(8),
                CommonHelper.randInt(13),
                CommonHelper.randInt(5)
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

        points.add(genPoint);
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
            if( p.distance(genPoint) < GameData.PLANET_DIAMETER + 2 ) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param name of the soalarsystem, String.
    */
    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(Point p) { this.coordTopLeft = p; }   
    public Point getPoint() { return coordTopLeft; }
    public int getX() { return coordTopLeft.x; }
    public int getY() { return coordTopLeft.y; };
    public Point getCenterPoint() {
        return new Point( (int) (coordTopLeft.x + GameData.PLANET_DIAMETER / Math.sqrt(2)),
            (int) (coordTopLeft.y + GameData.PLANET_DIAMETER / Math.sqrt(2)) ); }
            
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
    
    public void setPolitics(int politics) {
        this.politics = politics;
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
    
    public int getPolitics() {
        return politics;
    }
    
    public String getLocation(){
        return "(" + coordTopLeft.x + ", " + coordTopLeft.y + ")";
    }
    /**
     * @param:double of px and py.
     * @return: boolean,if the planet is hit.
    */ 
    public boolean isHit(double px, double py) {
        return coordCenter.distance(new Point((int)px, (int)py)) < GameData.PLANET_DIAMETER/2;
    }
    
    public int getDistance() {
        int xDist = Math.abs(GameData.getPlayer().getCurrentLocation().getX() - coordTopLeft.x);
        int yDist = Math.abs(GameData.getPlayer().getCurrentLocation().getY() - coordTopLeft.y);
        return (int) Math.round(Math.sqrt(xDist*xDist+yDist*yDist)/5);
    }
    
    @Override
    public String toString()
    {
        return "{ Name: " + name + ", Location: (" + coordTopLeft.x + "," + coordTopLeft.y +
                "), Tech Level: " + techLevel + ", Resources: " + resource + "}";
    }
}

