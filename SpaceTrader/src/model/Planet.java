/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ivan
 * @version 1.0
 */
public class Planet {

    private String name;
    private double techLevel;

    /**
     * makes the planets
     *
     * @param name the planets name
     */
    public Planet(String name) {
        this.name = name;
    }

    /**
     * makes one planet
     *
     * @param name the name of the planet
     * @param techLevel the tech level of the planet
     */
    public Planet(String name, int techLevel) {
        this.name = name;
        this.techLevel = techLevel;
    }

    /**
     * maps the sell list
     *
     * @return the list to sell
     */
    public Map sellList() {
        Map<TradeGood, Double> sellMap = new HashMap<>();
        if (techLevel >= (TradeGood.WATER.getMTLU())) {
            double wprice = (TradeGood.WATER.getBasePrice()
                + (TradeGood.WATER.getipl()
                * (techLevel - TradeGood.WATER.getMTLP()))
                + TradeGood.WATER.getVar());
            sellMap.put(TradeGood.WATER, wprice);
        }

        if (techLevel >= (TradeGood.ROBOTS.getMTLU())) {
            double rprice = (TradeGood.ROBOTS.getBasePrice()
                + (TradeGood.ROBOTS.getipl() * (techLevel
                - TradeGood.ROBOTS.getMTLP()))
                + TradeGood.ROBOTS.getVar());
            sellMap.put(TradeGood.ROBOTS, rprice);
        }

        if (techLevel >= (TradeGood.ORE.getMTLU())) {
            double oprice = (TradeGood.ORE.getBasePrice() + (TradeGood.ORE
                .getipl() * (techLevel - TradeGood.ORE.getMTLP()))
                + TradeGood.ORE.getVar());
            sellMap.put(TradeGood.ORE, oprice);
        }

        if (techLevel >= (TradeGood.NARCOTICS.getMTLU())) {
            double nprice = (TradeGood.NARCOTICS.getBasePrice()
                + (TradeGood.NARCOTICS.getipl()
                * (techLevel - TradeGood.NARCOTICS
                .getMTLP())) + TradeGood.NARCOTICS.getVar());
            sellMap.put(TradeGood.NARCOTICS, nprice);
        }

        if (techLevel >= (TradeGood.MEDICINE.getMTLU())) {
            double mprice = (TradeGood.MEDICINE.getBasePrice()
                + (TradeGood.MEDICINE.getipl()
                * (techLevel - TradeGood.MEDICINE.getMTLP()))
                + TradeGood.MEDICINE.getVar());
            sellMap.put(TradeGood.MEDICINE, mprice);
        }

        if (techLevel >= (TradeGood.MACHINES.getMTLU())) {
            double maprice = (TradeGood.MACHINES.getBasePrice()
                + (TradeGood.MACHINES.getipl()
                * (techLevel - TradeGood.MACHINES.getMTLP()))
                + TradeGood.MACHINES.getVar());
            sellMap.put(TradeGood.MACHINES, maprice);
        }

        if (techLevel >= (TradeGood.GAMES.getMTLU())) {
            double gprice = (TradeGood.GAMES.getBasePrice()
                + (TradeGood.GAMES.getipl()
                * (techLevel - TradeGood.GAMES.getMTLP()))
                + TradeGood.GAMES.getVar());
            sellMap.put(TradeGood.GAMES, gprice);
        }

        if (techLevel >= (TradeGood.FURS.getMTLU())) {
            double fprice = (TradeGood.FURS.getBasePrice()
                + (TradeGood.FURS.getipl()
                * (techLevel - TradeGood.FURS.getMTLP()))
                + TradeGood.FURS.getVar());
            sellMap.put(TradeGood.FURS, fprice);
        }

        if (techLevel >= (TradeGood.FOOD.getMTLU())) {
            double foprice = (TradeGood.FOOD.getBasePrice()
                + (TradeGood.FOOD.getipl()
                * (techLevel - TradeGood.FOOD.getMTLP()))
                + TradeGood.FOOD.getVar());
            sellMap.put(TradeGood.FOOD, foprice);
        }

        if (techLevel >= (TradeGood.FIREARMS.getMTLU())) {
            double fiprice = (TradeGood.FIREARMS.getBasePrice()
                + (TradeGood.FIREARMS.getipl()
                * (techLevel - TradeGood.FIREARMS.getMTLP()))
                + TradeGood.FIREARMS.getVar());
            sellMap.put(TradeGood.FIREARMS, fiprice);
        }

        return sellMap;
    }

    /**
     * maps the buy list
     *
     * @return the list to buy
     */
    public Map buyList() {
        Map<TradeGood, Double> buyMap = new HashMap<>();
        if (techLevel >= (TradeGood.WATER.getMTLP())) {
            double wprice2 = (TradeGood.WATER.getBasePrice()
                + (TradeGood.WATER.getipl()
                * (techLevel - TradeGood.WATER.getMTLP()))
                + TradeGood.WATER.getVar());
            buyMap.put(TradeGood.WATER, wprice2);
        }

        if (techLevel >= (TradeGood.ROBOTS.getMTLP())) {
            double rprice2 = (TradeGood.ROBOTS.getBasePrice()
                + (TradeGood.ROBOTS.getipl()
                * (techLevel - TradeGood.ROBOTS.getMTLP()))
                + TradeGood.ROBOTS.getVar());
            buyMap.put(TradeGood.ROBOTS, rprice2);
        }

        if (techLevel >= (TradeGood.ORE.getMTLP())) {
            double oprice2 = (TradeGood.ORE.getBasePrice()
                + (TradeGood.ORE.getipl()
                * (techLevel - TradeGood.ORE.getMTLP()))
                + TradeGood.ORE.getVar());
            buyMap.put(TradeGood.ORE, oprice2);
        }

        if (techLevel >= (TradeGood.NARCOTICS.getMTLP())) {
            double nprice2 = (TradeGood.NARCOTICS.getBasePrice()
                + (TradeGood.NARCOTICS.getipl()
                * (techLevel - TradeGood.NARCOTICS.getMTLP()))
                + TradeGood.NARCOTICS.getVar());
            buyMap.put(TradeGood.NARCOTICS, nprice2);
        }

        if (techLevel >= (TradeGood.MEDICINE.getMTLP())) {
            double mprice2 = (TradeGood.MEDICINE.getBasePrice()
                + (TradeGood.MEDICINE.getipl()
                * (techLevel - TradeGood.MEDICINE.getMTLP()))
                + TradeGood.MEDICINE.getVar());
            buyMap.put(TradeGood.MEDICINE, mprice2);
        }

        if (techLevel >= (TradeGood.MACHINES.getMTLP())) {
            double maprice2 = (TradeGood.MACHINES.getBasePrice()
                + (TradeGood.MACHINES.getipl()
                * (techLevel - TradeGood.MACHINES.getMTLP()))
                + TradeGood.MACHINES.getVar());
            buyMap.put(TradeGood.MACHINES, maprice2);
        }

        if (techLevel >= (TradeGood.GAMES.getMTLP())) {
            double gprice2 = (TradeGood.GAMES.getBasePrice()
                + (TradeGood.GAMES.getipl()
                * (techLevel - TradeGood.GAMES.getMTLP()))
                + TradeGood.GAMES.getVar());
            buyMap.put(TradeGood.GAMES, gprice2);
        }

        if (techLevel >= (TradeGood.FURS.getMTLP())) {
            double fprice2 = (TradeGood.FURS.getBasePrice()
                + (TradeGood.FURS.getipl()
                * (techLevel - TradeGood.FURS.getMTLP()))
                + TradeGood.FURS.getVar());
            buyMap.put(TradeGood.FURS, fprice2);
        }

        if (techLevel >= (TradeGood.FOOD.getMTLP())) {
            double foprice2 = (TradeGood.FOOD.getBasePrice()
                + (TradeGood.FOOD.getipl()
                * (techLevel - TradeGood.FOOD.getMTLP()))
                + TradeGood.FOOD.getVar());
            buyMap.put(TradeGood.FOOD, foprice2);
        }

        if (techLevel >= (TradeGood.FIREARMS.getMTLP())) {
            double fiprice2 = (TradeGood.FIREARMS.getBasePrice()
                + (TradeGood.FIREARMS.getipl()
                * (techLevel - TradeGood.FIREARMS.getMTLP()))
                + TradeGood.FIREARMS.getVar());
            buyMap.put(TradeGood.FIREARMS, fiprice2);
        }

        return buyMap;
    }

    /**
     * set the name
     *
     * @param name the name to set
     */
    public void setName(String name) { //setter mathod.
        this.name = name;
    }

    /**
     * returns the name of the planet
     *
     * @return name the name of the planet
     */
    public String getName() {  //getter method.
        return name;
    }

}
