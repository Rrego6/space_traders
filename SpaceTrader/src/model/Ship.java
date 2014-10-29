/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Noora
 */
public enum Ship {
    FLEA(10000,10, 0, 0, 0, 1, 10000, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 1 ),
    GNAT(14,15, 1, 0, 1, 1, 14, 5, 2, 10000, 50, 28, 100, 0, 0, 0, 1),
    FIREFLY(17,20, 1, 1, 1, 1, 17, 5, 3, 25000, 75, 20, 100, 0, 0, 0, 1),
    MOSQUITO(13,15, 2, 1, 1, 1, 13, 5, 5, 30000, 100, 20, 100, 0, 1, 0, 1),
    BUMBLEBEE(15,25, 1, 2, 2, 2, 15, 5, 7, 60000, 125, 15, 100, 0, 1, 0, 1),
    TRADER(10,10, 0, 0, 0, 1, 10, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 0 ),
    POLICE(10,10, 0, 0, 0, 1, 10, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 0 ),
    FIGHTER(10,10, 0, 0, 0, 1, 10, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 0 ),
    PIRATE(10,10, 0, 0, 0, 1, 10, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 0 );

    
    
    private int cargoBay;
    private int weaponSlot;
    private int shieldSlot;
    private int gadgetSlot;
    private int crew;
    private int fuel;
    private int minTechLevel;
    private int fuelCost;
    private int price;
    private int bounty;
    private int occurance;
    private int hull;
    private int repairCost;
    private int police;
    private int trader;
    private int pirate;
    private int maxfuel;
    
    
    private Inventory cargoHold;
    private int damage;
    
    private Ship(int maxfuel,int cargoBay, int weaponSlot, int shieldSlot, int gadgetSlot, int crew, 
            int fuel,int minTechLevel,int fuelCost, int price, int bounty, int occurance, 
            int hullStrength, int police, int pirate, int trader, int repairCost ){
        
        this.cargoBay = cargoBay ;
        this.weaponSlot = weaponSlot;
        this.shieldSlot = shieldSlot;
        this.gadgetSlot = gadgetSlot;
        this.crew = crew;
        this.fuel = fuel;
        this.minTechLevel = minTechLevel;
        this.fuelCost = fuelCost;
        this.price = price;
        this.bounty = bounty;
        this.occurance = occurance;
        this.hull = hullStrength;
        this.repairCost = repairCost;
        this.trader = trader;
        this.police = police;
        this.pirate = pirate;
        this.maxfuel = maxfuel;
        
        createCargoHold();
    }
    
    public void createCargoHold() {
        cargoHold = new Inventory(cargoBay);
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
    
    public void deductFuel(int cost) {
        fuel -= cost;
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
    
    public int getShields() {
        return this.shieldSlot;
    }
    
    public void setShields(int n) {
        this.shieldSlot = n;
    }
    
    public void setHull(int n) {
        this.hull = n;
    }
    
    public void refillFuel() {
        fuel = maxfuel;
    }
}
