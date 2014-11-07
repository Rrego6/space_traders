/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sarah
 * @version 1.0
 */
public class OriginalTradeGood {

    private String name;
    private int mtlp;
    private int mtlu;
    private int ttp;
    private int basePrice;
    private int ipl;
    private int var;
    private String ie;
    private String cr;
    private String er;
    private int mtl;
    private int mth;

    private int quantity;

    /**
     * sets the list of trade goods
     *
     * @param name the name
     * @param mtlp the mtlp
     * @param mtlu the mtly
     * @param ttp the ttp
     * @param basePrice the base price
     * @param ipl the ipl
     * @param var the var
     * @param ie the ie
     * @param cr the cr
     * @param er the er
     * @param mtl the mtl
     * @param mth the mth
     */
    public OriginalTradeGood(String name, int mtlp, int mtlu, int ttp,
        int basePrice, int ipl, int var, String ie, String cr, String er,
        int mtl, int mth) {
        this.name = name;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.basePrice = basePrice;
        this.ipl = ipl;
        this.var = var;
        this.ie = ie;
        this.cr = cr;
        this.er = er;
        this.mtl = mtl;
        this.mth = mth;
    }

    /**
     * gets the cost
     *
     * @return cost the cost
     */
    public int getCost() {
        int cost = (basePrice + (ipl * (ttp - mtlp)) + var);
        return cost;
    }

    /**
     * returns the string of name
     *
     * @return the string of the name
     */
    public String getName() {
        return this.toString();
    }

    /**
     * sets the name
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the quantity
     *
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * adds the int to the trade goods
     *
     * @param a the int to add
     */
    public void add(int a) {
        this.quantity += a;
    }

    /**
     * removes the int from the trade goods
     *
     * @param a the int to remove
     */
    public void remove(int a) {
        this.quantity -= a;
    }

    /**
     * gets the inventory
     *
     * @return the string of the inventory
     */
    @Override
    public String toString() {
        return "{ Name: " + name + " MTLP: " + mtlp + " MTLU: " + mtlu
            + " TTP: " + ttp + " basePrice: " + basePrice + " IPL: " + ipl
            + " VAR: " + var + " IE: " + ie + " CR: " + cr + " ER: " + er
            + " MTL: " + mtl + " MTH: " + mth + " }";
    }
}
