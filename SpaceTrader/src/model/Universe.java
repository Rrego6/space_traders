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
public class Universe {
    
    private String name;
    private ArrayList<SolarSystem> solarsystems;
    
    public Universe(String name) {
        this.name = name;
    }
    
    public void addSolarSystem(SolarSystem a) {
        solarsystems.add(a);
    }
    
    public void removeSolarSystem(SolarSystem a) {
        solarsystems.remove(a);
    }
}
