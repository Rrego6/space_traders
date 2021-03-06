/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helper.CommonHelper;
import java.util.Random;

/**
 *
 * @author Noora
 * @version 1.0
 */
public enum TradeGood {

    WATER(0, 0, 2, 30, 3, 4),
    FURS(0, 0, 0, 250, 10, 10),
    FOOD(1, 0, 1, 100, 5, 5),
    ORE(2, 2, 3, 350, 20, 10),
    GAMES(3, 1, 6, 250, -10, 5),
    FIREARMS(3, 1, 5, 1250, -75, 100),
    MEDICINE(4, 1, 6, 650, -20, 10),
    MACHINES(4, 3, 5, 900, -30, 5),
    NARCOTICS(5, 0, 5, 3500, -12, 150),
    ROBOTS(6, 4, 7, 5000, -150, 100);

    private Random varGen = new Random();
    private int mtlp;
    private int mtlu;
    private int ttp;
    private int baseprice;
    private int ipl;
    private int var;
    private int quantity;

    /**
     * makes a trade good
     *
     * @param mtlp the mtlp
     * @param mtlu the mtlu
     * @param ttp the ttp
     * @param basePrice the base price
     * @param ipl the ipl
     * @param var the var
     */
    private TradeGood(int mtlp, int mtlu, int ttp, int basePrice, int ipl,
        int var) {
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.baseprice = basePrice;
        this.ipl = ipl;
        this.var = var;
    }

    /**
     * gets the cost
     *
     * @return the cost
     */
    public int getCost() {
        return baseprice + (ipl * (ttp - mtlp)) + CommonHelper.randInt(var);
    }

    /**
     * gets the cost
     *
     * @param techLevel the tech level
     * @return the cost
     */
    public int getCost(int techLevel) {
        return baseprice + ipl * (techLevel - mtlp) + CommonHelper.randInt(var);
    }

    /**
     * gets the base price
     *
     * @return the base price
     */
    public int getBasePrice() {
        return baseprice;
    }

    /**
     * gets the mtlu
     *
     * @return the mtlu
     */
    public int getMTLU() {
        return mtlu;
    }

    /**
     * gets the ttp
     *
     * @return the ttp
     */
    public int getttp() {
        return ttp;
    }

    /**
     * gets the mtlp
     *
     * @return the mtlp
     */
    public int getMTLP() {
        return mtlp;
    }

    /**
     * gets the base price
     *
     * @return the base price
     */
    public int getbaseprice() {
        return baseprice;
    }

    /**
     * gets the ipl
     *
     * @return the ipl
     */
    public int getipl() {
        return ipl;
    }

    /**
     * gets the var
     *
     * @return the var
     */
    public int getVar() {
        return var;
    }

}
