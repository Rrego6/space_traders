/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sarah
 */

public class OriginalTradeGood {
    private String name;
    private int MTLP;
    private int MTLU;
    private int TTP;
    private int basePrice;
    private int IPL;
    private int VAR;
    private String IE;
    private String CR;
    private String ER;
    private int MTL;
    private int MTH;
    
    private int quantity;
    
    public OriginalTradeGood(String name, int MTLP, int MTLU, int TTP, int basePrice, int IPL, int VAR, String IE, String CR, String ER, int MTL, int MTH){
        this.name = name;
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.TTP = TTP;
        this.basePrice = basePrice;
        this.IPL = IPL;
        this.VAR = VAR;
        this.IE = IE;
        this.CR = CR;
        this.ER = ER;
        this.MTL = MTL;
        this.MTH = MTH;   
    }
    public int getCost() {
        int cost = (basePrice + (IPL * (TTP - MTLP)) + VAR); //by formula  (base price) + (the IPL * (Planet Tech Level - MTLP)) + (variance).
        return cost;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void add(int a) {
        this.quantity += a;
    }
    
    public void remove(int a) {
        this.quantity -= a;
    }
    
    @Override
    public String toString()
    {
        return "{ Name: " + name + " MTLP: " + MTLP + " MTLU: " + MTLU + " TTP: " + TTP + " basePrice: " + basePrice + " IPL: " + IPL + " VAR: " + VAR + " IE: " + IE + " CR: " + CR +  " ER: "+ ER + " MTL: " + MTL +  " MTH: " + MTH + " }";
    }
}
