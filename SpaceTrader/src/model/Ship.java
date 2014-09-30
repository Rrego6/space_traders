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
public abstract class Ship {
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
    
    public void createCargoHold() {
        cargoHold = new Inventory("Cargo Hold", maxCargo);
    }
    
    public void setInventory(Inventory inventory) {
        cargoHold = inventory;
    }
    
    public Inventory getInventory() {
        return cargoHold;
    }
}
