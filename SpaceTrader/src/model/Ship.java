/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Noora
 * @version 1.0
 */
public enum Ship {

    FLEA(10000, 10, 0, 0, 0, 1, 10000, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 1, 100),
    GNAT(14, 15, 1, 0, 1, 1, 14, 5, 2, 10000, 50, 28, 100, 0, 0, 0, 1, 200),
    FIREFLY(17, 20, 1, 1, 1, 1, 17, 5, 3, 25000, 75, 20, 100, 0, 0, 0, 1, 300),
    MOSQUITO(13, 15, 2, 1, 1, 1, 13, 5, 5, 30000, 100, 20, 100, 0, 1, 0, 1,
        400),
    BUMBLEBEE(15, 25, 1, 2, 2, 2, 15, 5, 7, 60000, 125, 15, 100, 0, 1, 0, 1,
        500),
    TRADER(10, 10, 0, 0, 0, 1, 10, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 0, 600),
    POLICE(10, 10, 0, 0, 0, 1, 10, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 0, 700),
    FIGHTER(10, 10, 0, 0, 0, 1, 10, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 0, 800),
    PIRATE(10, 10, 0, 0, 0, 1, 10, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 0, 900);

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
    private int shipCost;

    private Inventory cargoHold;
    private int damage;

    /**
     * makes the ship
     *
     * @param maxfuel the max fuel
     * @param cargoBay the cargo bay
     * @param weaponSlot the weapon slot
     * @param shiledSlot the shield slot
     * @param gadgetSlot the gadget slot
     * @param crew the crew
     * @param fuel the fuel
     * @param minTechLevel the min tech level
     * @param fuelCost the cost of fuel
     * @param price the price
     * @param bounty the bounty
     * @param occurance the occurance
     * @param hullStrength the hull strength
     * @param police the police
     * @param pirate the pirate
     * @param trader the trader
     * @param repairCost the cost of repair
     * @param shipCost the cost of the ship
     */
    private Ship(int maxfuel, int cargoBay, int weaponSlot, int shieldSlot,
        int gadgetSlot, int crew,
        int fuel, int minTechLevel, int fuelCost, int price, int bounty,
        int occurance,
        int hullStrength, int police, int pirate, int trader, int repairCost,
        int shipCost) {

        this.cargoBay = cargoBay;
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
        this.shipCost = shipCost;

        createCargoHold();
    }

    /**
     * makes the cargo hold
     */
    public void createCargoHold() {
        cargoHold = new Inventory(cargoBay);
    }

    /**
     * sets the inventory
     *
     * @param inventory the inventory
     */
    public void setInventory(Inventory inventory) {
        cargoHold = inventory;
    }

    /**
     * gets the inventory
     *
     * @return cargo hold
     */
    public Inventory getInventory() {
        return cargoHold;
    }

    /**
     * gets the gadget slot
     *
     * @return the gadget slot
     */
    public int getGadgetSlot() {
        return gadgetSlot;
    }

    /**
     * adds the gadget slot
     */
    public void addGadgetSlot() {
        gadgetSlot++;
    }

    /**
     * subtracts the gadget slot
     */
    public void subtractGadgetSlot() {
        if (!(gadgetSlot == 0)) {
            gadgetSlot--;
        }
    }

    /**
     * gets the weapon slot
     *
     * @return the weapon slot
     */
    public int getWeaponSlot() {
        return weaponSlot;
    }

    /**
     * adds the weapon slot
     */
    public void addWeaponSlot() {
        weaponSlot++;
    }

    /**
     * subtracts the weapon slot
     */
    public void subtractWeaponSlot() {
        if (!(weaponSlot == 0)) {
            weaponSlot--;
        }
    }

    /**
     * gets the shield slot
     *
     * @return the shield slot
     */
    public int getShieldSlot() {
        return shieldSlot;
    }

    /**
     * adds the shield slot
     */
    public void addShieldSlot() {
        shieldSlot++;
    }

    /**
     * subtracts the shield slot
     */
    public void subtractShieldSlot() {
        if (!(shieldSlot == 0)) {
            shieldSlot--;
        }
    }

    /**
     * gets the fuel
     *
     * @return fuel amount
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * deducts the fuel
     *
     * @param cost the cost of fuel
     */
    public void deductFuel(int cost) {
        fuel -= cost;
    }

    /**
     * gets the hull
     *
     * @return the hull int
     */
    public int getHull() {
        return this.hull;
    }

    /**
     * sets the damage
     *
     * @param n the damage amount
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
     * gets the shields
     *
     * @return the shield
     */
    public int getShields() {
        return this.shieldSlot;
    }

    /**
     * sets the shields
     *
     * @param n the shields amount
     */
    public void setShields(int n) {
        this.shieldSlot = n;
    }

    /**
     * sets the hull
     *
     * @param n the hull amount
     */
    public void setHull(int n) {
        this.hull = n;
    }

    /**
     * refuels ship
     */
    public void refillFuel() {
        fuel = maxfuel;
    }

    /**
     * gets the cost
     *
     * @return the cost of ship
     */
    public int getCost() {
        return shipCost;
    }
}
