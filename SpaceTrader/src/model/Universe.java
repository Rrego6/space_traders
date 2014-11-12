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
 * @version 1.0
 */
public class Universe {

    private String name;
    private ArrayList<SolarSystem> solarsystems;

    /**
     * makes the universe
     *
     * @param name the name of the universe
     */
    public Universe(String name) {
        this.name = name;
        solarsystems = new ArrayList<>();
    }

    /**
     * adds the solar system
     *
     * @param list the list
     */
    public void addSolarSystem(List<SolarSystem> list) {
        solarsystems.addAll(list);

    }

    /**
     * adds the solar system
     *
     * @param a a solar system
     */
    public void addSolarSystem(SolarSystem a) {
        solarsystems.add(a);
    }

    /**
     * removes the solar system
     *
     * @param a solar system to remove
     */
    public void removeSolarSystem(SolarSystem a) {
        solarsystems.remove(a);
    }

    /**
     * sets the name
     *
     * @param name the name
     */
    public void setName(String name) { //setter mathod.
        this.name = name;
    }

    /**
     * gets the name
     *
     * @return name
     */
    public String getName() {  //getter method.
        return name;
    }

    /**
     * returns the solar system
     *
     * @return the solar system
     */
    public ArrayList<SolarSystem> getList() {  //getter method.
        return solarsystems;
    }

    /**
     * gets the string
     *
     * @return the string
     */
    @Override
    public String toString() {
        String string = new String();
        for (SolarSystem solarSystem : solarsystems) {
            string += (solarSystem + ",");
        }
        return "Universe: " + name + " " + string;
    }
}
