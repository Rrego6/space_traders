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
public class GoodsList {
    private String name;
    private ArrayList<TradeGood> tradeGoods;
    
    public GoodsList(String name) {
        this.name = name;
        tradeGoods = new ArrayList<>();
    }
    
    public void addTradeGood( List<TradeGood> list )
    {
        tradeGoods.addAll( list );
        
        System.out.println("trade goods all added");
    }
    public void addTradeGood(TradeGood a) {
        tradeGoods.add(a);
    }
   
    public void removeTradeGood(SolarSystem a) {
        tradeGoods.remove(a);
    }
    
    public void setName(String name) { //setter mathod. 
        this.name = name;
    }
    /*@param:none.
    @return: name variable value.
    */ 
    public String getName() {  //getter method.
        return name;
    }
    
    public ArrayList<TradeGood> getList() {  //getter method.
        return tradeGoods;
    }
    
    @Override
    public String toString()
    {
        String string = new String();
        for( TradeGood tradeGood : tradeGoods )
        {
            string += (tradeGood.toString() + "\n" );
        }
        return "GoodsList: " + name + " " + string;
    }
}
