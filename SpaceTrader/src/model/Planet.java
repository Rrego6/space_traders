/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.util.*;

/**
 *
 * @author Ivan
 */
public class Planet {
    
    private String name;
    private double techLevel;
    
    public Planet(String name) {
        this.name = name;
    }
    
    public Planet(String name, int techLevel) {
        this.name = name;
        this.techLevel = techLevel;
    }
    
    public Map sellList() {
        Map<TradeGood, Double> sellMap = new HashMap<>();
        if (techLevel >= (TradeGood.WATER.getMTLU())) {
            double wprice = (TradeGood.WATER.getBasePrice() + (TradeGood.WATER.getipl() * (techLevel - TradeGood.WATER.getMTLP())) + TradeGood.WATER.getvar());
            sellMap.put(TradeGood.WATER, wprice);
        }
        
        if (techLevel >= (TradeGood.ROBOTS.getMTLU())) {
            double rprice = (TradeGood.ROBOTS.getBasePrice() + (TradeGood.ROBOTS.getipl() * (techLevel - TradeGood.ROBOTS.getMTLP())) + TradeGood.ROBOTS.getvar());
            sellMap.put(TradeGood.ROBOTS, rprice);
        }
        
        if (techLevel >= (TradeGood.ORE.getMTLU())) {
            double oprice = (TradeGood.ORE.getBasePrice() + (TradeGood.ORE.getipl() * (techLevel - TradeGood.ORE.getMTLP())) + TradeGood.ORE.getvar());
            sellMap.put(TradeGood.ORE, oprice);
        }
        
        if (techLevel >= (TradeGood.NARCOTICS.getMTLU())) {
            double nprice = (TradeGood.NARCOTICS.getBasePrice() + (TradeGood.NARCOTICS.getipl() * (techLevel - TradeGood.NARCOTICS.getMTLP())) + TradeGood.NARCOTICS.getvar());
            sellMap.put(TradeGood.NARCOTICS, nprice);
        }
        
        if (techLevel >= (TradeGood.MEDICINE.getMTLU())) {
            double mprice = (TradeGood.MEDICINE.getBasePrice() + (TradeGood.MEDICINE.getipl() * (techLevel - TradeGood.MEDICINE.getMTLP())) + TradeGood.MEDICINE.getvar());
            sellMap.put(TradeGood.MEDICINE, mprice);
        }
        
        if (techLevel >= (TradeGood.MACHINES.getMTLU())) {
            double maprice = (TradeGood.MACHINES.getBasePrice() + (TradeGood.MACHINES.getipl() * (techLevel - TradeGood.MACHINES.getMTLP())) + TradeGood.MACHINES.getvar());
            sellMap.put(TradeGood.MACHINES, maprice);
        }
        
        if (techLevel >= (TradeGood.GAMES.getMTLU())) {
            double gprice = (TradeGood.GAMES.getBasePrice() + (TradeGood.GAMES.getipl() * (techLevel - TradeGood.GAMES.getMTLP())) + TradeGood.GAMES.getvar());
            sellMap.put(TradeGood.GAMES, gprice);
        }
        
        if (techLevel >= (TradeGood.FURS.getMTLU())) {
            double fprice = (TradeGood.FURS.getBasePrice() + (TradeGood.FURS.getipl() * (techLevel - TradeGood.FURS.getMTLP())) + TradeGood.FURS.getvar());
            sellMap.put(TradeGood.FURS, fprice);
        }
        
        if (techLevel >= (TradeGood.FOOD.getMTLU())) {
            double foprice = (TradeGood.FOOD.getBasePrice() + (TradeGood.FOOD.getipl() * (techLevel - TradeGood.FOOD.getMTLP())) + TradeGood.FOOD.getvar());
            sellMap.put(TradeGood.FOOD, foprice);
        }
        
        if (techLevel >= (TradeGood.FIREARMS.getMTLU())) {
            double fiprice = (TradeGood.FIREARMS.getBasePrice() + (TradeGood.FIREARMS.getipl() * (techLevel - TradeGood.FIREARMS.getMTLP())) + TradeGood.FIREARMS.getvar());
            sellMap.put(TradeGood.FIREARMS, fiprice);
        }
        
        return sellMap;
    }
    
    public Map buyList() {
        Map<TradeGood, Double> buyMap = new HashMap<>();
        if (techLevel >= (TradeGood.WATER.getMTLP())) {
            double wprice2 = (TradeGood.WATER.getBasePrice() + (TradeGood.WATER.getipl() * (techLevel - TradeGood.WATER.getMTLP())) + TradeGood.WATER.getvar());
            buyMap.put(TradeGood.WATER, wprice2);
        }
        
        if (techLevel >= (TradeGood.ROBOTS.getMTLP())) {
            double rprice2 = (TradeGood.ROBOTS.getBasePrice() + (TradeGood.ROBOTS.getipl() * (techLevel - TradeGood.ROBOTS.getMTLP())) + TradeGood.ROBOTS.getvar());
            buyMap.put(TradeGood.ROBOTS, rprice2);
        }
        
        if (techLevel >= (TradeGood.ORE.getMTLP())) {
            double oprice2 = (TradeGood.ORE.getBasePrice() + (TradeGood.ORE.getipl() * (techLevel - TradeGood.ORE.getMTLP())) + TradeGood.ORE.getvar());
            buyMap.put(TradeGood.ORE, oprice2);
        }
        
        if (techLevel >= (TradeGood.NARCOTICS.getMTLP())) {
            double nprice2 = (TradeGood.NARCOTICS.getBasePrice() + (TradeGood.NARCOTICS.getipl() * (techLevel - TradeGood.NARCOTICS.getMTLP())) + TradeGood.NARCOTICS.getvar());
            buyMap.put(TradeGood.NARCOTICS, nprice2);
        }
        
        if (techLevel >= (TradeGood.MEDICINE.getMTLP())) {
            double mprice2 = (TradeGood.MEDICINE.getBasePrice() + (TradeGood.MEDICINE.getipl() * (techLevel - TradeGood.MEDICINE.getMTLP())) + TradeGood.MEDICINE.getvar());
            buyMap.put(TradeGood.MEDICINE, mprice2);
        }
        
        if (techLevel >= (TradeGood.MACHINES.getMTLP())) {
            double maprice2 = (TradeGood.MACHINES.getBasePrice() + (TradeGood.MACHINES.getipl() * (techLevel - TradeGood.MACHINES.getMTLP())) + TradeGood.MACHINES.getvar());
            buyMap.put(TradeGood.MACHINES, maprice2);
        }
        
        if (techLevel >= (TradeGood.GAMES.getMTLP())) {
            double gprice2 = (TradeGood.GAMES.getBasePrice() + (TradeGood.GAMES.getipl() * (techLevel - TradeGood.GAMES.getMTLP())) + TradeGood.GAMES.getvar());
            buyMap.put(TradeGood.GAMES, gprice2);
        }
        
        if (techLevel >= (TradeGood.FURS.getMTLP())) {
            double fprice2 = (TradeGood.FURS.getBasePrice() + (TradeGood.FURS.getipl() * (techLevel - TradeGood.FURS.getMTLP())) + TradeGood.FURS.getvar());
            buyMap.put(TradeGood.FURS, fprice2);
        }
        
        if (techLevel >= (TradeGood.FOOD.getMTLP())) {
            double foprice2 = (TradeGood.FOOD.getBasePrice() + (TradeGood.FOOD.getipl() * (techLevel - TradeGood.FOOD.getMTLP())) + TradeGood.FOOD.getvar());
            buyMap.put(TradeGood.FOOD, foprice2);
        }
        
        if (techLevel >= (TradeGood.FIREARMS.getMTLP())) {
            double fiprice2 = (TradeGood.FIREARMS.getBasePrice() + (TradeGood.FIREARMS.getipl() * (techLevel - TradeGood.FIREARMS.getMTLP())) + TradeGood.FIREARMS.getvar());
            buyMap.put(TradeGood.FIREARMS, fiprice2);
        }
        
        return buyMap;
    }
    /*@param:name of the planet, String.
    @return: none,sets the name variable.
    */
    public void setName(String name) { //setter mathod. 
        this.name = name;
    }
    /*@param:none.
    @return: name of the planet, String.
    */
    public String getName() {  //getter method.
        return name;
    }
    
    
}
