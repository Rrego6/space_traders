/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ambrose Cheung
 * @version 1.0
 */
public class OriginalShip {

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

    /**
     * the original ship
     */
    public OriginalShip() {
        maxCargo = 10;
        weaponSlots = 0;
        shieldSlots = 0;
        gadgetSlots = 0;
        crew = 1;
        fuel = 20;
        maxFuel = 20;
        minTechLevel = 4;
        fuelCost = 1;
        price = 2000;
        bounty = 5;
        hull = 25;
        createCargoHold();
    }

    /**
     * creates the cargo hold
     */
    public void createCargoHold() {
        cargoHold = new Inventory(maxCargo);
    }

    /**
     * sets the inventory
     *
     * @param inventory the inventory of the player
     */
    public void setInventory(Inventory inventory) {
        cargoHold = inventory;
    }

    /**
     * gets the inventory
     *
     * @return the inventory of the player
     */
    public Inventory getInventory() {
        return cargoHold;
    }

    /**
     * gets the fuel
     *
     * @return the fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * takes away the fuel for travel
     *
     * @param cost the cost of fuel for travel
     */
    public void deductFuel(int cost) {
        fuel -= cost;
    }

    /**
     * sets the hull
     *
     * @param n the int for hull
     */
    public void setHull(int n) {
        this.hull = n;
    }

    /**
     * gets the hull
     *
     * @return the hull
     */
    public int getHull() {
        return this.hull;
    }

    /**
     * sets the damage
     *
     * @param n the damage to set
     */
    public void setDamage(int n) {
        this.damage = n;
    }

    /**
     * gets the damage
     *
     * @return the damage
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * sets the shields
     *
     * @param n the shields to set
     */
    public void setShields(int n) {
        this.shields = n;
    }

    /**
     * gets the number of shields
     *
     * @return the number of shields
     */
    public int getShields() {
        return this.shields;
    }

}
