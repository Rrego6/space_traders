/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Raoul
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
    
    /*@param: name, name of the player as a String.
    *@param: pilotSP, int number of pilots.
    @param: fighterSP, int number of fighters
    @param: traderSP, int number os traders.
    @param: engineerSP, int number of engineers.
    @param: investorSP, int number of investors.
    *@return: player object
    */
    public Player(String name, int pilotSP, int fighterSP, int traderSP, int engineerSP, int investorSP )
    {
        this.name = name;
        //this.ship = new OriginalShip();
        this.ship = Ship.GNAT; //added from the enum ship class
        this.pilotSP = pilotSP;
        this.fighterSP = fighterSP;
        this.traderSP = traderSP;
        this.engineerSP = engineerSP;
        this.investorSP = investorSP;
        this.credits = 100000;
        this.traderRep = 100;
        this.pirateRep = 50;
        this.policeRep = 100;
    }
    
    public static Player genTrader() {
        //give him items, weapons, ship, etc
        Player trader = new Player("Trader", 0, 0, 0, 0, 0);
        trader.setTraderSP(((int) Math.random() * 5) + 10);
        trader.setFighterSP(15 - trader.getTraderSP());
        trader.setCredits(((int) Math.random() * 1000) + 1000);
        trader.setShip(Ship.TRADER);
        return trader;
    }
    
    public static Player genFighter() {
        //give him items, weapons, ship, etc
        Player fighter = new Player("Fighter", 0, 0, 0, 0, 0);
        fighter.setFighterSP(((int) Math.random() * 5) + 10);
        fighter.setPilotSP(15 - fighter.getFighterSP());
        fighter.setCredits(((int) Math.random() * 1000) + 1000);
        fighter.setShip(Ship.FIGHTER);
        return fighter;
    }
    
    @Override
    public String toString()
    {
        return "{name: " + name + ", pilotSP: " + pilotSP + ", fighterSP: " + fighterSP + ", traderSP: " + traderSP + ", engineerSP: " + engineerSP + ", investorSP: " + investorSP + "}";
    }
    
    /*@param:name, name of the player String
    @return: sets the name variable.
    */
    public void setName(String name) { //getter method.
        this.name = name;
    }
    /*@param:none.
    @return: name variable value.
    */
        //trader.setShip(new OriginalShip());
        //trader.setShip(Ship.TRADER);
    public String getName() {  //getter method.
        return name;
    }
    /*@param:none.
    @return: pilotSP variable value int.
    */
        //fighter.setShip(Ship.FIGHTER);
    public int getPilotSP() {  //getter method.
        return pilotSP;
    }
    /*@param:none.
    @return: fighterSP value int.
    */
    public int getFighterSP() {  //getter method.
        return fighterSP;
    }
     /*@param:none.
    @return: traderSP value int.
    */   
    public int getTraderSP() {  //getter method.
        return traderSP;
    }  
    /*@param:none.
    @return: engineerSP value int.
    */
    public int getEngineerSP() {  //getter method.
        return engineerSP;
    } 
    /*@param:none.
    @return: investorSP value int.
    */
    public int getInvestorSP() {  //getter method.
        return investorSP;
    }
    /*@param:number of pilotSP int.
    @return: sets the pilotSP variable.
    */
    public void setPilotSP(int no) {  //Setter method.
        this.pilotSP = no;
    }
    /*@param:number of fighterSP int.
    @return: sets the fighter variable.
    */
    public void setFighterSP(int no) {  //Setter method.
        this.fighterSP = no;
    }
    /*@param:number of traderSP int.
    @return: sets the traderSP variable.
    */    
    public void setTraderSP(int no) {  //Setter method.
        this.traderSP = no;
    }  
    /*@param:number of engineerSP int.
    @return: sets the engineerSP variable.
    */
    public void setEngineerSP(int no) {  //Setter method.
        this.engineerSP = no;
    } 
    /*@param:number of investorSP int.
    @return: sets the investorSP variable.
    */
    public void setInvestorSP(int no) {  //Setter method.
        this.investorSP = no;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    public Ship getShip() {
        return ship;
    }
    
    public void setCurrentLocation(SolarSystem solarSystem) {
        this.currentLocation = solarSystem;
    }
    
    public SolarSystem getCurrentLocation() {
        return currentLocation;
    }
    
    public boolean encounter() {
        double chance = (Math.random() * 99) + 1;
        if (chance > 50) {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @return int 1 = Trader, 2 = Pirate, 3 = Police
     */
    public int encounterType() {
        return ((int)(Math.random() * 3)) + 1;
    }
    
    public int getTraderRep() {
        return this.traderRep;
    }
    
    public int getPirateRep() {
        return this.pirateRep;
    }
    
    public int getPoliceRep() {
        return this.policeRep;
    }
    
    public void setTraderRep(int n) {
        this.traderRep = n;
    }
    
    public void setPirateRep(int n) {
        this.pirateRep = n;
    }
    
    public void setPoliceRep(int n) {
        this.policeRep = n;
    }
    
    public void setEncounterPerson(Player p) {
        this.encounterPerson = p;
    }
    
    public Player getEncounterPerson() {
        return this.encounterPerson;
    }
    
    /*public void setShip(OriginalShip ship) {
        this.ship = ship;
    }*/
    
    public void onSave() {
        encounterPerson = null;
    }
}
