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

/**
 * The X and Y coordinates of this class correspond to the top left corner.
 *
 * @author Ivan
 * @version 1.0
 */
public class SolarSystem {

    private static ArrayList<Point> points = new ArrayList<>();

    private String name;
    private Point coordTopLeft;
    private Point coordCenter;

    private int techLevel;
    private int resource;

    private ArrayList<Planet> planets;

    /**
     * makes the solar system
     *
     * @param name the name
     * @param coord the coordinates
     * @param techLevel the tech level
     * @param resource the resources
     */
    public SolarSystem(String name, Point coord, int techLevel, int resource) {
        this.name = name;
        this.coordTopLeft = coord;
        this.techLevel = techLevel;
        this.resource = resource;
        this.coordCenter = new Point(
            (int) (coord.getX() + (.5) * GameData.PLANET_DIAMETER),
            (int) (coord.getY() + (.5) * GameData.PLANET_DIAMETER)
        );
    }

    /**
     * makes a solar system
     *
     * @param name the name of the solar system
     */
    public SolarSystem(String name) {
        this(
            name,
            genPoint(),
            CommonHelper.randInt(8),
            CommonHelper.randInt(13)
        );
        planets = new ArrayList<>();
        planets.add(new Planet(name));
    }

    /**
     * Generate unique point
     *
     * @return a unique Point
     */
    private static Point genPoint() {
        Point genPoint = new Point(CommonHelper.randInt(GameData.GAME_WIDTH),
            CommonHelper.randInt(GameData.GAME_HEIGHT));

        while (isNearOtherPoints(genPoint)) {
            genPoint = new Point(CommonHelper.randInt(GameData.GAME_WIDTH),
                CommonHelper.randInt(GameData.GAME_HEIGHT));
        }

        points.add(genPoint);
        return genPoint;
    }

    /**
     * Checks if currentPoint is near any other planets
     *
     * @param genPoint the generation point
     * @return a boolean for point being unique
     */
    private static boolean isNearOtherPoints(Point genPoint) {
        for (Point p : points) {
            if (p.distance(genPoint) < GameData.PLANET_DIAMETER + 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * sets the name
     *
     * @param name of the soalarsystem, String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the point
     *
     * @param p point of solar system
     */
    public void setPoint(Point p) {
        this.coordTopLeft = p;
    }

    /**
     * gets the point
     *
     * @return the point
     */
    public Point getPoint() {
        return coordTopLeft;
    }

    /**
     * gets the x
     *
     * @return the x
     */
    public int getX() {
        return coordTopLeft.x;
    }

    /**
     * gets the y
     *
     * @return the y
     */
    public int getY() {
        return coordTopLeft.y;
    }

    /**
     * gets the center
     *
     * @return the center
     */
    public Point getCenterPoint() {
        return new Point((int) (coordTopLeft.x
            + GameData.PLANET_DIAMETER / Math.sqrt(2)),
            (int) (coordTopLeft.y + GameData.PLANET_DIAMETER / Math.sqrt(2)));
    }

    /**
     * sets the tech level
     *
     * @param techLevel value, int
     */
    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * sets the resource
     *
     * @param resource value, int.
     */
    public void setResource(int resource) {
        this.resource = resource;
    }

    /**
     * adds a planet
     *
     * @param a object
     */
    public void addPlanet(Planet a) {
        planets.add(a);
    }

    /**
     * removes a planet
     *
     * @param a object.
     */
    public void removePlanet(Planet a) {
        planets.remove(a);
    }

    /**
     * gets the name
     *
     * @return the name
     */
    public String getName() {  //getter method
        return name;
    }

    /**
     * gets the tech level
     *
     * @return the tech level
     */
    public int getTechLevel() { //getter method
        return techLevel;
    }

    /**
     * gets the resource
     *
     * @return the resource
     */
    public int getResource() { //getter method
        return resource;
    }

    /**
     * gets the location
     *
     * @return the location
     */
    public String getLocation() {
        return "(" + coordTopLeft.x + ", " + coordTopLeft.y + ")";
    }

    /**
     * checks if hit
     *
     * @param px the point x
     * @param py the point y
     * @return boolean,if the planet is hit.
     */
    public boolean isHit(double px, double py) {
        return coordCenter.distance(new Point((int) px, (int) py))
            < GameData.PLANET_DIAMETER / 2;
    }

    /**
     * gets the distance
     *
     * @return the distance
     */
    public int getDistance() {
        int xDist = Math.abs(GameData.getPlayer().getCurrentLocation().getX()
            - coordTopLeft.x);
        int yDist = Math.abs(GameData.getPlayer().getCurrentLocation().getY()
            - coordTopLeft.y);
        return (int) Math.round(Math.sqrt(xDist * xDist + yDist * yDist) / 5);
    }

    /**
     * gets the string
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "{ Name: " + name + ", Location: (" + coordTopLeft.x + ","
            + coordTopLeft.y
            + "), Tech Level: " + techLevel + ", Resources: " + resource + "}";
    }
}
