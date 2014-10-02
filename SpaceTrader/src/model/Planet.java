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
        if (techLevel >= (TradeGood.WATER.getmtlu())) {
            double wprice = (TradeGood.WATER.getbaseprice() + (TradeGood.WATER.getipl() * (techLevel - TradeGood.WATER.getmtlp())) + TradeGood.WATER.getvar());
            sellMap.put(TradeGood.WATER, wprice);
        }
        
        if (techLevel >= (TradeGood.ROBOTS.getmtlu())) {
            double rprice = (TradeGood.ROBOTS.getbaseprice() + (TradeGood.ROBOTS.getipl() * (techLevel - TradeGood.ROBOTS.getmtlp())) + TradeGood.ROBOTS.getvar());
            sellMap.put(TradeGood.ROBOTS, rprice);
        }
        
        if (techLevel >= (TradeGood.ORE.getmtlu())) {
            double oprice = (TradeGood.ORE.getbaseprice() + (TradeGood.ORE.getipl() * (techLevel - TradeGood.ORE.getmtlp())) + TradeGood.ORE.getvar());
            sellMap.put(TradeGood.ORE, oprice);
        }
        
        if (techLevel >= (TradeGood.NARCOTICS.getmtlu())) {
            double nprice = (TradeGood.NARCOTICS.getbaseprice() + (TradeGood.NARCOTICS.getipl() * (techLevel - TradeGood.NARCOTICS.getmtlp())) + TradeGood.NARCOTICS.getvar());
            sellMap.put(TradeGood.NARCOTICS, nprice);
        }
        
        if (techLevel >= (TradeGood.MEDICINE.getmtlu())) {
            double mprice = (TradeGood.MEDICINE.getbaseprice() + (TradeGood.MEDICINE.getipl() * (techLevel - TradeGood.MEDICINE.getmtlp())) + TradeGood.MEDICINE.getvar());
            sellMap.put(TradeGood.MEDICINE, mprice);
        }
        
        if (techLevel >= (TradeGood.MACHINES.getmtlu())) {
            double maprice = (TradeGood.MACHINES.getbaseprice() + (TradeGood.MACHINES.getipl() * (techLevel - TradeGood.MACHINES.getmtlp())) + TradeGood.MACHINES.getvar());
            sellMap.put(TradeGood.MACHINES, maprice);
        }
        
        if (techLevel >= (TradeGood.GAMES.getmtlu())) {
            double gprice = (TradeGood.GAMES.getbaseprice() + (TradeGood.GAMES.getipl() * (techLevel - TradeGood.GAMES.getmtlp())) + TradeGood.GAMES.getvar());
            sellMap.put(TradeGood.GAMES, gprice);
        }
        
        if (techLevel >= (TradeGood.FURS.getmtlu())) {
            double fprice = (TradeGood.FURS.getbaseprice() + (TradeGood.FURS.getipl() * (techLevel - TradeGood.FURS.getmtlp())) + TradeGood.FURS.getvar());
            sellMap.put(TradeGood.FURS, fprice);
        }
        
        if (techLevel >= (TradeGood.FOOD.getmtlu())) {
            double foprice = (TradeGood.FOOD.getbaseprice() + (TradeGood.FOOD.getipl() * (techLevel - TradeGood.FOOD.getmtlp())) + TradeGood.FOOD.getvar());
            sellMap.put(TradeGood.FOOD, foprice);
        }
        
        if (techLevel >= (TradeGood.FIREARMS.getmtlu())) {
            double fiprice = (TradeGood.FIREARMS.getbaseprice() + (TradeGood.FIREARMS.getipl() * (techLevel - TradeGood.FIREARMS.getmtlp())) + TradeGood.FIREARMS.getvar());
            sellMap.put(TradeGood.FIREARMS, fiprice);
        }
        
        return sellMap;
    }
    
    public Map buyList() {
        Map<TradeGood, Double> buyMap = new HashMap<>();
        if (techLevel >= (TradeGood.WATER.getmtlp())) {
            double wprice2 = (TradeGood.WATER.getbaseprice() + (TradeGood.WATER.getipl() * (techLevel - TradeGood.WATER.getmtlp())) + TradeGood.WATER.getvar());
            buyMap.put(TradeGood.WATER, wprice2);
        }
        
        if (techLevel >= (TradeGood.ROBOTS.getmtlp())) {
            double rprice2 = (TradeGood.ROBOTS.getbaseprice() + (TradeGood.ROBOTS.getipl() * (techLevel - TradeGood.ROBOTS.getmtlp())) + TradeGood.ROBOTS.getvar());
            buyMap.put(TradeGood.ROBOTS, rprice2);
        }
        
        if (techLevel >= (TradeGood.ORE.getmtlp())) {
            double oprice2 = (TradeGood.ORE.getbaseprice() + (TradeGood.ORE.getipl() * (techLevel - TradeGood.ORE.getmtlp())) + TradeGood.ORE.getvar());
            buyMap.put(TradeGood.ORE, oprice2);
        }
        
        if (techLevel >= (TradeGood.NARCOTICS.getmtlp())) {
            double nprice2 = (TradeGood.NARCOTICS.getbaseprice() + (TradeGood.NARCOTICS.getipl() * (techLevel - TradeGood.NARCOTICS.getmtlp())) + TradeGood.NARCOTICS.getvar());
            buyMap.put(TradeGood.NARCOTICS, nprice2);
        }
        
        if (techLevel >= (TradeGood.MEDICINE.getmtlp())) {
            double mprice2 = (TradeGood.MEDICINE.getbaseprice() + (TradeGood.MEDICINE.getipl() * (techLevel - TradeGood.MEDICINE.getmtlp())) + TradeGood.MEDICINE.getvar());
            buyMap.put(TradeGood.MEDICINE, mprice2);
        }
        
        if (techLevel >= (TradeGood.MACHINES.getmtlp())) {
            double maprice2 = (TradeGood.MACHINES.getbaseprice() + (TradeGood.MACHINES.getipl() * (techLevel - TradeGood.MACHINES.getmtlp())) + TradeGood.MACHINES.getvar());
            buyMap.put(TradeGood.MACHINES, maprice2);
        }
        
        if (techLevel >= (TradeGood.GAMES.getmtlp())) {
            double gprice2 = (TradeGood.GAMES.getbaseprice() + (TradeGood.GAMES.getipl() * (techLevel - TradeGood.GAMES.getmtlp())) + TradeGood.GAMES.getvar());
            buyMap.put(TradeGood.GAMES, gprice2);
        }
        
        if (techLevel >= (TradeGood.FURS.getmtlp())) {
            double fprice2 = (TradeGood.FURS.getbaseprice() + (TradeGood.FURS.getipl() * (techLevel - TradeGood.FURS.getmtlp())) + TradeGood.FURS.getvar());
            buyMap.put(TradeGood.FURS, fprice2);
        }
        
        if (techLevel >= (TradeGood.FOOD.getmtlp())) {
            double foprice2 = (TradeGood.FOOD.getbaseprice() + (TradeGood.FOOD.getipl() * (techLevel - TradeGood.FOOD.getmtlp())) + TradeGood.FOOD.getvar());
            buyMap.put(TradeGood.FOOD, foprice2);
        }
        
        if (techLevel >= (TradeGood.FIREARMS.getmtlp())) {
            double fiprice2 = (TradeGood.FIREARMS.getbaseprice() + (TradeGood.FIREARMS.getipl() * (techLevel - TradeGood.FIREARMS.getmtlp())) + TradeGood.FIREARMS.getvar());
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
