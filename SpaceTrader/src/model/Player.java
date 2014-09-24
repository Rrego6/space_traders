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
    String name;
    int pilotSP;
    int fighterSP;
    int traderSP;
    int engineerSP;
    int investorSP;
    
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
    
    public void setName(String name) { //getter method.
        this.name = name;
    }
    
    public String getName() {  //getter method.
        return name;
    }
    
    public int getPilotSP() {  //getter method.
        return pilotSP;
    }
    
    public int getFighterSP() {  //getter method.
        return fighterSP;
    }
        
    public int getTraderSP() {  //getter method.
        return traderSP;
    }  
    
    public int getEngineerSP() {  //getter method.
        return engineerSP;
    } 
    
    public int getInvestorSP() {  //getter method.
        return investorSP;
    }
    
    public void setPilotSP(int no) {  //Setter method.
        this.pilotSP = no;
    }
    
    public void setFighterSP(int no) {  //Setter method.
        this.fighterSP = no;
    }
        
    public void getTraderSP(int no) {  //Setter method.
        this.traderSP = no;
    }  
    
    public void setEngineerSP(int no) {  //Setter method.
        this.engineerSP = no;
    } 
    
    public void setInvestorSP(int no) {  //Setter method.
        this.investorSP = no;
    }
}
