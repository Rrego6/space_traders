/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author tonyrafi
 */
public enum TradeGood {
    WATER("WATER",0,0,2,30,3,4,30,50),
    FURS("FURS",0,0,0,250,10,10,230,280),
    FOOD("FOOD",1,0,1,100,5,5,90,160),
    ORE("ORE",2,2,3,350,20,10,350,420),
    GAMES("GAMES",3,1,6,250,-10,5,160,270),
    FIREARMS("FIREARMS",3,1,5,1250,-75,100,600,1100),
    MEDICINE("MEDICINE",4,1,6,650,-20,10,400,700),
    MACHINES("MACHINES",4,3,5,900,-30,5,600,800),
    NARCOTICS("NAROCTICS",5,0,5,3500,-12,150,2000,3000),
    ROBOTS("ROBOTS",6,4,7,5000,-150,100,3500,5000);
    
    private int mtlp;
    private int mtlu;
    private int ttp;
    private int baseprice;
    private int ipl;
    private int var;
    private int mtl;
    private int mth;
    private String name;
    
    
    private TradeGood (String name, int mtlp, int mtlu, int ttp, int basePrice, int ipl, int var, int mtl, int mth) {
        this.name = name;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.baseprice = basePrice;
        this.ipl = ipl;
        this.var = var;
        this.mtl = mtl;
        this.mth = mth;

    }
    
    /**
     * 
     * @return 
     */
    public int getCost() {
        int cost = (baseprice + (ipl * (ttp - mtlp)) + var); //by formula  (base price) + (the IPL * (Planet Tech Level - MTLP)) + (variance).
        return cost;
    }
    
    public int getmtlp() {
        return mtlp;
    }
    
    public int getmtlu() {
        return mtlu;
    }
     
    public int getttp() {
        return ttp;
    }
      
     public int getbaseprice() {
        return baseprice;
    }  
    
    public int getipl() {
        return ipl;
    }
      
    public int getvar() {
        return var;
    }
    
    public int getmtl() {
        return mtl;
    }
    
    public int getmth() {
        return mth;
    }
    
    public String getName() {
        return name;
    }
}
