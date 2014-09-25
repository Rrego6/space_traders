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
        this.pilotSP = pilotSP;
        this.fighterSP = fighterSP;
        this.traderSP = traderSP;
        this.engineerSP = engineerSP;
        this.investorSP = investorSP;
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
    public String getName() {  //getter method.
        return name;
    }
    /*@param:none.
    @return: pilotSP variable value int.
    */
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
    public void getTraderSP(int no) {  //Setter method.
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
    
}
