/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Ambrose Cheung <cheungambrose30@gmail.com>
 */
public class Ship {
    private int maxFuel;
    private int fuel;
    private int type;
    private int hull;
    private int shields;
    private int shieldSlots;
    private int damage;
    private int weaponSlots;
    private int gadgetSlots;
    private int crew;
    //private Crew[] crewRoster;
    private Inventory cargoHold;
    private int maxCargo;
    private int minTechLevel;
    private int fuelCost;
    private int price;
    private int bounty;
    private int occurrence;
    
    public Ship() {
        maxCargo = 10;
        weaponSlots = 0;
        shieldSlots = 0;
        gadgetSlots = 0;
        crew = 1;
        fuel = 20;
        minTechLevel = 4;
        fuelCost = 1;
        price = 2000;
        bounty = 5;
        hull = 25;
        createCargoHold();
    }
    
    public void createCargoHold() {
        cargoHold = new Inventory(maxCargo);
    }
    
    public void setInventory(Inventory inventory) {
        cargoHold = inventory;
    }
    
    public Inventory getInventory() {
        return cargoHold;
    }
    
    public int getFuel() {
        return fuel;
    }
    
    public void deductFuel() {
        
    }
}
