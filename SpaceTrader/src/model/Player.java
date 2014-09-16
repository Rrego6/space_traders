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
    
}
