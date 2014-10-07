/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;
import java.util.Random;
/**
*
* @author tonyrafi
*/
public enum TradeGood {
    WATER(0,0,2,30,3,4),
    FURS(0,0,0,250,10,10),
    FOOD(1,0,1,100,5,5),
    ORE(2,2,3,350,20,10),
    GAMES(3,1,6,250,-10,5),
    FIREARMS(3,1,5,1250,-75,100),
    MEDICINE(4,1,6,650,-20,10),
    MACHINES(4,3,5,900,-30,5),
    NARCOTICS(5,0,5,3500,-12,150),
    ROBOTS(6,4,7,5000,-150,100);
    
    private Random varGen = new Random();
    private int mtlp;
    private int mtlu;
    private int ttp;
    private int baseprice;
    private int ipl;
    private int var;
    private int quantity;
    private TradeGood (int mtlp, int mtlu, int ttp, int basePrice, int ipl, int var) {
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.baseprice = basePrice;
        this.ipl = ipl;
        this.var = var;
    }
    /**
     *
     * @return
     */
    public int getCost() {
        int cost = (baseprice + (ipl * (ttp - mtlp)) + var); //by formula (base price) + (the IPL * (Planet Tech Level - MTLP)) + (variance).
        return cost;
    }
    //varGen.nextInt(var)
    
    public int getBasePrice() {
        return baseprice;
    }
    
    public int getMTLU() {
        return mtlu;
    }
     
    public int getttp() {
        return ttp;
    }
      
     public int getbaseprice() {
        return baseprice;
    }  
    
    public int getMTLP() {
        return mtlp;
    }
    
    public int getipl() {
        return ipl;
    }
      
    public int getvar() {
        return var;
    }
}


