/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Raoul
 * @version 1.0
 */
public class Player {

    private String name;
    private int pilotSP;
    private int fighterSP;
    private int traderSP;
    private int engineerSP;
    private int investorSP;
    private int credits;
    private SolarSystem currentLocation;
    //private OriginalShip ship;
    private Ship ship;
    private int traderRep;
    private int pirateRep;
    private int policeRep;
    private Player encounterPerson;

    /**
     * makes the player
     *
     * @param name name of the player as a String.
     * @param pilotSP int number of pilots.
     * @param fighterSP int number of fighters
     * @param traderSP int number os traders.
     * @param engineerSP int number of engineers.
     * @param investorSP int number of investors.
     */
    public Player(String name, int pilotSP, int fighterSP, int traderSP,
        int engineerSP, int investorSP) {
        this.name = name;
        //this.ship = new OriginalShip();
        this.ship = Ship.GNAT; //added from the enum ship class
        this.pilotSP = pilotSP;
        this.fighterSP = fighterSP;
        this.traderSP = traderSP;
        this.engineerSP = engineerSP;
        this.investorSP = investorSP;
        this.credits = 1000;
        this.traderRep = 100;
        this.pirateRep = 50;
        this.policeRep = 100;
    }

    /**
     * generates the trader
     *
     * @return the trader
     */
    public static Player genTrader() {
        //give him items, weapons, ship, etc
        Player trader = new Player("Trader", 0, 0, 0, 0, 0);
        trader.setTraderSP(((int) Math.random() * 5) + 10);
        trader.setFighterSP(15 - trader.getTraderSP());
        trader.setCredits(((int) Math.random() * 1000) + 1000);
        //trader.setShip(new OriginalShip());
        trader.setShip(Ship.TRADER);
        return trader;
    }

    /**
     * generates the fighter
     *
     * @return the fighter
     */
    public static Player genFighter() {
        //give him items, weapons, ship, etc
        Player fighter = new Player("Fighter", 0, 0, 0, 0, 0);
        fighter.setFighterSP(((int) Math.random() * 5) + 10);
        fighter.setPilotSP(15 - fighter.getFighterSP());
        fighter.setCredits(((int) Math.random() * 1000) + 1000);
        fighter.setShip(Ship.FIGHTER);
        return fighter;
    }

    /**
     * makes the string of the player
     *
     * @return the players traits
     */
    @Override
    public String toString() {
        return "{name: " + name + ", pilotSP: " + pilotSP + ", fighterSP: "
            + fighterSP + ", traderSP: " + traderSP + ", engineerSP: "
            + engineerSP + ", investorSP: " + investorSP + "}";
    }

    /**
     * sets the name of the player
     *
     * @param name name of the player String
     */
    public void setName(String name) { //getter method.
        this.name = name;
    }

    /**
     * the name of the string getter
     *
     * @return name variable value.
     */
    public String getName() {  //getter method.
        return name;
    }

    /**
     * gets the pilot points
     *
     * @return the pilot points
     */
    public int getPilotSP() {  //getter method.
        return pilotSP;
    }

    /**
     * gets the fighter points
     *
     * @return the fighters points
     */
    public int getFighterSP() {  //getter method.
        return fighterSP;
    }

    /**
     * gets the trader points
     *
     * @return the trader points
     */
    public int getTraderSP() {  //getter method.
        return traderSP;
    }

    /**
     * gets the engineer points
     *
     * @return the engineer points
     */
    public int getEngineerSP() {  //getter method.
        return engineerSP;
    }

    /**
     * gets the investor points
     *
     * @return the investor points
     */
    public int getInvestorSP() {  //getter method.
        return investorSP;
    }

    /**
     * sets the pilot points
     *
     * @param no the pilot points
     */
    public void setPilotSP(int no) {  //Setter method.
        this.pilotSP = no;
    }

    /**
     * sets the fighter points
     *
     * @param no the fighter points
     */
    public void setFighterSP(int no) {  //Setter method.
        this.fighterSP = no;
    }

    /**
     * sets the trader points
     *
     * @param no the trader points
     */
    public void setTraderSP(int no) {  //Setter method.
        this.traderSP = no;
    }

    /**
     * sets the engineer points
     *
     * @param no the engineer points
     */
    public void setEngineerSP(int no) {  //Setter method.
        this.engineerSP = no;
    }

    /**
     * sets the investor points
     *
     * @param no the investor points
     */
    public void setInvestorSP(int no) {  //Setter method.
        this.investorSP = no;
    }

    /**
     * sets the credit points
     *
     * @param credits the credit points
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * gets the credit points
     *
     * @return the credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * sets the ship
     *
     * @param ship the players ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * gets the players ship
     *
     * @return the ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * sets the current location
     *
     * @param solarSystem the solar system to travel to
     */
    public void setCurrentLocation(SolarSystem solarSystem) {
        this.currentLocation = solarSystem;
    }

    /**
     * gets the current location
     *
     * @return currentLocation
     */
    public SolarSystem getCurrentLocation() {
        return currentLocation;
    }

    /**
     * checks to see if there is an encounter
     *
     * @return boolean encounter true or false
     */
    public boolean encounter() {
        double chance = (Math.random() * 99) + 1;
        if (chance > 50) {
            return true;
        }
        return false;
    }

    /**
     * makes the type of encounter
     *
     * @return the type of encounter
     */
    public int encounterType() {
        return ((int) (Math.random() * 3)) + 1;
    }

    /**
     * gets the trader rep
     *
     * @return the trader rep
     */
    public int getTraderRep() {
        return this.traderRep;
    }

    /**
     * gets the pirate rep
     *
     * @return the pirate rep
     */
    public int getPirateRep() {
        return this.pirateRep;
    }

    /**
     * gets the police rep
     *
     * @return the police rep
     */
    public int getPoliceRep() {
        return this.policeRep;
    }

    /**
     * sets the trader rep
     *
     * @param n the trader rep
     */
    public void setTraderRep(int n) {
        this.traderRep = n;
    }

    /**
     * sets the pirate rep
     *
     * @param n the pirate rep
     */
    public void setPirateRep(int n) {
        this.pirateRep = n;
    }

    /**
     * sets the police rep
     *
     * @param n the police rep
     */
    public void setPoliceRep(int n) {
        this.policeRep = n;
    }

    /**
     * sets the encounter person
     *
     * @param p the encounter person
     */
    public void setEncounterPerson(Player p) {
        this.encounterPerson = p;
    }

    /**
     * gets the encounter person
     *
     * @return the encounter person
     */
    public Player getEncounterPerson() {
        return this.encounterPerson;
    }

    /**
     * makes person null on save
     */
    public void onSave() {
        encounterPerson = null;
    }
}
