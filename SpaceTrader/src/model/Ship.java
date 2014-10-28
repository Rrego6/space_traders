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
    protected int maxFuel;
    protected int fuel;
    protected int type;
    protected int hull;
    protected int shields;
    protected int shieldSlots;
    protected int damage;
    protected int weaponSlots;
    protected int gadgetSlots;
    protected int crew;
    //private Crew[] crewRoster;
    protected Inventory cargoHold;
    protected int maxCargo;
    protected int minTechLevel;
    protected int fuelCost;
    protected int price;
    protected int bounty;
    protected int occurrence;
    
    /**
     *
     */
    public Ship() {
        maxCargo = 10;
        weaponSlots = 0;
        shieldSlots = 0;
        gadgetSlots = 0;
        crew = 1;
        fuel = 20;
        maxFuel = 100;
        minTechLevel = 4;
        fuelCost = 1;
        price = 2000;
        bounty = 5;
        hull = 25;
        createCargoHold();
    }
    
    /**
     *
     */
    public void createCargoHold() {
        cargoHold = new Inventory(maxCargo);
    }
    
    /**
     *
     * @param inventory
     */
    public void setInventory(Inventory inventory) {
        cargoHold = inventory;
    }
    
    /**
     *
     * @return
     */
    public Inventory getInventory() {
        return cargoHold;
    }
    
    /**
     *
     * @return
     */
    public int getFuel() {
        return fuel;
    }
    
    /**
     *
     * @param cost
     */
    public void deductFuel(int cost) {
        fuel -= cost;
    }
    
    public void setHull(int n) {
        this.hull = n;
    }
    
    public void refillFuel() {
        fuel = maxFuel;
    }
    
    public int getHull() {
        return this.hull;
    }
    
    public void setDamage(int n) {
        this.damage = n;
    }
    
    public int getDamage() {
        return this.damage;
    }
    
    public void setShields(int n) {
        this.shields = n;
    }
    
    public int getShields() {
        return this.shields;
    }
    
}
